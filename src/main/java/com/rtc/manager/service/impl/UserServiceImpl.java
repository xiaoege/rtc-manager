package com.rtc.manager.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rtc.manager.dao.RtcUserCommentMapper;
import com.rtc.manager.dao.RtcUserFavouriteMapper;
import com.rtc.manager.dao.RtcUserMapper;
import com.rtc.manager.entity.RtcUser;
import com.rtc.manager.entity.RtcUserComment;
import com.rtc.manager.entity.RtcUserFavourite;
import com.rtc.manager.entity.dto.*;
import com.rtc.manager.service.UserService;
import com.rtc.manager.util.CommonUtils;
import com.rtc.manager.util.ElasticsearchUtils;
import com.rtc.manager.util.SmsUtils;
import com.rtc.manager.util.UserUtils;
import com.rtc.manager.vo.ResultData;
import com.rtc.manager.vo.RtcUserVO;
import com.rtc.manager.vo.UserCommentVO;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author ChenHang
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RtcUserMapper rtcUserMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Autowired
    private RtcUserFavouriteMapper rtcUserFavouriteMapper;

    @Autowired
    private RtcUserCommentMapper rtcUserCommentMapper;

    @Value("${rtc.portrait}")
    private String PORTRAIT;

    @Value(("${rtc.commitLength}"))
    private Integer COMMIT_LENGTH;

    @Value("${rtc.verificationCodeTTL}")
    private Long verificationCodeTTL;

    @Value("${rtc.loginTokenTTL}")
    private Long loginTokenTTL;

    @Value("${rtc.img-type}")
    private List<String> imgType;

    private final RestHighLevelClient client = ElasticsearchUtils.getClient();

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private static final JavaMailSenderImpl JAVA_MAIL_SENDER;

    private static final String CODE_702 = "验证码发送次数过多，请稍后再试";
    private static final String CODE_703 = "验证码发送失败";
    private static final String CODE_705 = "数据有误";
    private static final String CODE_707 = "验证码错误";
    private static final String CODE_708 = "翻译失败";

    private static final String EMAIL_CODE_850 = "邮箱格式错误";
    private static final String EMAIL_CODE_851 = "邮箱已注册";
    private static final String EMAIL_CODE_852 = "该邮箱尚未发送验证码";
    private static final String EMAIL_CODE_853 = "邮箱验证失败";
    private static final String EMAIL_CODE_854 = "邮箱注册失败";
    private static final String EMAIL_CODE_855 = "邮箱不能与原来相同";
    private static final String EMAIL_CODE_856 = "该邮箱尚未注册";

    private static final String PHONE_CODE_800 = "手机号格式错误";
    private static final String PHONE_CODE_801 = "手机号已注册";
    private static final String PHONE_CODE_803 = "国家代码与手机号不符";
    private static final String PHONE_CODE_804 = "该手机号尚未发送验证码";
    private static final String PHONE_CODE_805 = "该手机号尚未注册";
    private static final String PHONE_CODE_807 = "新手机号不能和原来一样";


    @Value("${rtc.mail.redisEmailLimt}")
    private Integer redisEmailLimt;

    @Value("${rtc.portraitURI}")
    private String PORTRAIT_URI;

    @Value("${rtc.comment-stars}")
    private List<BigDecimal> commentStars;

    @Autowired
    private ElasticsearchUtils elasticsearchUtils;

    static {
        JAVA_MAIL_SENDER = new JavaMailSenderImpl();
        JAVA_MAIL_SENDER.setHost("smtp.sina.com");
        JAVA_MAIL_SENDER.setUsername("c237113730@sina.com");
        JAVA_MAIL_SENDER.setPassword("88a169c98a5fd127");
        JAVA_MAIL_SENDER.setDefaultEncoding("UTF-8");

    }


    /**
     * 校验邮箱是否注册，发送验证码
     *
     * @param email
     * @return
     */
    @Override
    public ResultData checkEmailRegistered(String email) {
        // 正则判断是否是邮箱
        if (!UserUtils.checkEmailRegex(email)) {
            return ResultData.FAIL(email, 850, EMAIL_CODE_850);
        }
        // 检验是否注册过
        if (rtcUserMapper.checkEmaillRegistered(email) != null) {
            return ResultData.FAIL(email, 851, EMAIL_CODE_851);
        }

        // 验证码
        String verificationCode = UserUtils.getVerificationCode();

        // 验证，15分钟内最多发5次，一个验证码有效期15分钟
        if (checkVerificationCodeRedis(email, verificationCode)) {
            // 发送邮件验证码
            try {
                UserUtils.sendEmailVerificationCode(email, verificationCode);
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("发送验证码失败:{}", e);
                return ResultData.FAIL(null, 703, CODE_703);
            }
            return ResultData.SUCCESS(email, "验证码已发送");
        }

        return ResultData.FAIL(email, 702, CODE_702);
    }

    /**
     * 邮箱注册
     *
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultData emailRegister(HttpServletRequest request, String user) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
//        RtcUserDTO rtcUserDTO = objectMapper.readValue(user, RtcUserDTO.class);
        EmailRegisterDTO emailRegisterDTO = objectMapper.readValue(user, EmailRegisterDTO.class);

        if (emailRegisterDTO == null || emailRegisterDTO.getPassword() == null ||
                !emailRegisterDTO.getPassword().equals(emailRegisterDTO.getRetypePassword())) {
            return ResultData.FAIL(user, 705, CODE_705);
        }
        RtcUser rtcUser = new RtcUser();
        BeanUtils.copyProperties(emailRegisterDTO, rtcUser);

        String email = rtcUser.getEmail();

        // 邮箱格式错误
        if (!UserUtils.checkEmailRegex(email)) {
            return ResultData.FAIL(user, 850, EMAIL_CODE_850);
            // 邮箱已注册
        } else if (rtcUserMapper.checkEmaillRegistered(email) != null) {
            return ResultData.FAIL(user, 851, EMAIL_CODE_851);
            // 没发过验证码
        } else if (!stringRedisTemplate.hasKey(email)) {
            return ResultData.FAIL(user, 852, EMAIL_CODE_852);
        }
        // 校验密码格式
        String password = rtcUser.getPassword();
        if (!UserUtils.checkPasswordFormat(password)) {
            return ResultData.FAIL(user, 903, "密码格式错误");
        }
        String verificationCodeRedis = stringRedisTemplate.opsForValue().get(email);
        if (emailRegisterDTO.getVerificationCode().equals(verificationCodeRedis)) {
            String uuid = UUID.randomUUID().toString();
            rtcUser.setUuid(uuid);
            // todo
            rtcUser.setNickname(email);
            rtcUser.setPassword(UserUtils.hexBCryptPassword(password));
            rtcUserMapper.insertSelective(rtcUser);
            // 注册成功后删除验证码
            stringRedisTemplate.delete(email);
            // 注册完自动登录，返回token
            UserDetails userDetails = userDetailService.loadUserByUsername(email);
            if (userDetails != null) {
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            RtcUserDTO rtcUserDTO = rtcUserMapper.selectByPhoneOrAccount(uuid);
//            String token = UserUtils.getToken(rtcUserDTO.getUuid());
//            stringRedisTemplate.opsForValue().set(token, rtcUserDTO.getUuid(), loginTokenTTL, TimeUnit.DAYS);
            String token = UserUtils.getJWT(rtcUserDTO.getUuid());
            Map map = new HashMap();
            map.put("account", email);
            map.put("Authorization", "Bearer " + token);
            return ResultData.SUCCESS(map, "注册成功");
        }


        return ResultData.FAIL(user, 707, CODE_707);
    }

    /**
     * 校验手机，发送验证码
     *
     * @param phone
     * @param countryCode
     * @return
     */
    @Override
    public ResultData verificationCodeRegistered(String phone, String countryCode) {
        // todo 手机号格式验证
        if (phone == null || countryCode == null) {
            return ResultData.FAIL(phone, 800, PHONE_CODE_800);
        }
        if (!UserUtils.checkPhoneFormat(phone)) {
            return ResultData.FAIL(phone, 800, PHONE_CODE_800);
        }

        // 手机号已注册
        if (rtcUserMapper.checkPhoneRegistered(phone) != null) {
            return ResultData.FAIL(phone, 801, PHONE_CODE_801);
        }

        // 校验验证码次数
        String verificationCode = UserUtils.getVerificationCode();
        if (!checkVerificationCodeRedis(phone, verificationCode)) {
            return ResultData.FAIL(phone, 702, CODE_702);
        }

        // 发送验证码
        try {
            SmsUtils.sendSms(phone, verificationCode);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("发送验证码失败:{}", e);
            return ResultData.FAIL(null, 703, CODE_703);
        }

        return ResultData.SUCCESS(phone, "验证码发送成功");
    }

    /**
     * 手机注册
     *
     * @param user
     * @param request
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultData phoneRegister(String user, HttpServletRequest request) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        PhoneRegisterDTO phoneRegisterDTO = objectMapper.readValue(user, PhoneRegisterDTO.class);
        String failUser = objectMapper.writeValueAsString(user);
        // 数据格式错误
        if (phoneRegisterDTO == null) {
            return ResultData.FAIL(user, 705, CODE_705);
        }

        String phone = phoneRegisterDTO.getPhone();
        String countryCode = phoneRegisterDTO.getCountryCode();
        String verificationCode = phoneRegisterDTO.getVerificationCode();
        String password = phoneRegisterDTO.getPassword();
        String retypePassword = phoneRegisterDTO.getRetypePassword();
        // 数据格式错误
        if (phone == null || verificationCode == null || password == null || retypePassword == null || !password.equals(retypePassword)) {
            return ResultData.FAIL(user, 705, CODE_705);
        }

        // todo 手机号格式验证
        if (phone == null || countryCode == null) {
            return ResultData.FAIL(phone, 800, PHONE_CODE_800);
        }
        if (!UserUtils.checkPhoneFormat(phone)) {
            return ResultData.FAIL(phone, 800, PHONE_CODE_800);
        }


        // 密码格式验证
        if (!UserUtils.checkPasswordFormat(password)) {
            return ResultData.FAIL(user, 903, "密码格式错误");
        }

        // 验证手机号是否注册
        if (rtcUserMapper.checkPhoneRegistered(phone) != null) {
            return ResultData.FAIL(user, 801, PHONE_CODE_801);
        }
        // 该手机号还没发验证码
        if (!stringRedisTemplate.hasKey(phone)) {
            return ResultData.FAIL(user, 804, PHONE_CODE_804);
        }
        // 校验验证码
        if (!verificationCode.equals(stringRedisTemplate.opsForValue().get(phone))) {
            return ResultData.FAIL(user, 707, CODE_707);
        }
        // 注册
        RtcUser rtcUser = new RtcUser();
        BeanUtils.copyProperties(phoneRegisterDTO, rtcUser);
//        Map<String, String> passwordMap = UserUtils.haxPasswork(password);
//        rtcUser.setPassword(passwordMap.get("password"));
        rtcUser.setPassword(UserUtils.hexBCryptPassword(rtcUser.getPassword()));

//        rtcUser.setSalt(passwordMap.get("salt"));
        rtcUser.setPhone(phone);
        rtcUser.setNickname(phone);
        String uuid = UUID.randomUUID().toString();
        rtcUser.setUuid(uuid);
        rtcUserMapper.insertSelective(rtcUser);
        // 注册成功后删除验证码
        stringRedisTemplate.delete(phone);
        // 注册完自动登录，返回token
        UserDetails userDetails = userDetailService.loadUserByUsername(uuid);
        if (userDetails != null) {
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        RtcUserDTO rtcUserDTO = rtcUserMapper.selectByPhoneOrAccount(uuid);
//        String token = UserUtils.getToken(rtcUserDTO.getUuid());
//        stringRedisTemplate.opsForValue().set(token, rtcUserDTO.getUuid(), loginTokenTTL, TimeUnit.DAYS);
        String token = UserUtils.getJWT(rtcUserDTO.getUuid());
        Map map = new HashMap();
        map.put("account", phone);
        map.put("Authorization", "Bearer " + token);
        return ResultData.SUCCESS(map, "注册成功");
    }

    /**
     * 修改用户基本信息，成功后返回该用户的最新信息 + 新昵称/旧昵称的token
     *
     * @param user
     * @param request
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultData updateUser(String user, HttpServletRequest request) throws Exception {
        logger.info("updateUser():{}", user);
        ObjectMapper objectMapper = new ObjectMapper();
        RtcUser rtcUser = objectMapper.readValue(user, RtcUser.class);
        String nickname = rtcUser.getNickname();
        String portrait = rtcUser.getPortrait();

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        RtcUserVO rtcUserVO = rtcUserMapper.selectByPhoneOrAccount2RtcUserVO(userDetails.getUsername());
        String oldNickname = rtcUserVO.getNickname();

        String oldPortrait = rtcUserVO.getPortrait();

        if (nickname != null) {
            // 验证昵称格式
            if (!UserUtils.checkNicknameFormat(nickname)) {
                return ResultData.FAIL(user, 901, "昵称格式错误");
            }
            // 检验昵称是否存在
            if (!nickname.equals(oldNickname) && rtcUserMapper.checkNicknameRegistered(nickname) != null) {
                return ResultData.FAIL(user, 902, "昵称已存在");
            }
        }

        rtcUser.setId(rtcUserVO.getId());
        rtcUser.setPassword(null);
        rtcUser.setPhone(null);
        rtcUser.setCountryCode(null);
        rtcUserMapper.updateByPrimaryKeySelective(rtcUser);

        RtcUserVO vo = rtcUserMapper.selectByPhoneOrAccount2RtcUserVO(nickname == null ? oldNickname : nickname);
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        ArrayList<SimpleGrantedAuthority> authoritieList = new ArrayList(authorities);
        SimpleGrantedAuthority simpleGrantedAuthority = authoritieList.get(0);
        Map map = new HashMap();
        map.put("user", vo);
        map.put("role", simpleGrantedAuthority.getAuthority());
        map.put("account", nickname == null ? oldNickname : nickname);

        return ResultData.SUCCESS(map);
    }

    /**
     * 修改密码
     *
     * @param oldPassword
     * @param newPassword
     * @param retypePassword
     * @return 修改密码后生成新的JWT，废弃原JWT
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultData updatePassword(String user, HttpServletRequest request) {
        logger.info("updatePassword():{}", user);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = null;
        try {
            map = objectMapper.readValue(user, HashMap.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResultData.FAIL(user, 400, "数据有误");
        }
        String oldPassword = map.get("oldPassword");
        String newPassword = map.get("newPassword");
        String retypePassword = map.get("retypePassword");
        if (newPassword == null || retypePassword == null || !newPassword.equals(retypePassword)) {
            return ResultData.FAIL("请检查密码", 400, "请检查密码");
        }
        // 校验密码格式
        if (!UserUtils.checkPasswordFormat(newPassword)) {
            return ResultData.FAIL(user, 903, "密码格式错误");
        }
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!new BCryptPasswordEncoder().matches(oldPassword, userDetails.getPassword())) {
            return ResultData.FAIL(user, 1004, "原始密码错误");
        }
        RtcUserDTO rtcUserDTO = rtcUserMapper.selectByPhoneOrAccount(userDetails.getUsername());
        RtcUser rtcUser = new RtcUser();
        rtcUser.setId(rtcUserDTO.getId());
        rtcUser.setPassword(UserUtils.hexBCryptPassword(newPassword));
        rtcUserMapper.updateByPrimaryKeySelective(rtcUser);
        // 修改密码后生成新的JWT，废弃原JWT
        String bearer = "Bearer ";
        stringRedisTemplate.opsForSet().add("jwt-blacklist", request.getHeader("Authorization").substring(bearer.length()));
        return ResultData.SUCCESS(bearer + UserUtils.getJWT(rtcUserDTO.getUuid()));
    }

    /**
     * 忘记密码，通过手机号发送验证码
     *
     * @param phone
     * @param countryCode
     */
    @Override
    public ResultData sendPhoneVerificationCode(String phone, String countryCode) {
        // todo 手机号格式校验
        if (phone == null || countryCode == null) {
            return ResultData.FAIL(null, 400, "数据有误");
        }
        // 该手机号尚未注册
        if (rtcUserMapper.checkPhoneRegistered(phone) == null) {
            return ResultData.FAIL(null, 805, PHONE_CODE_805);
        }
        RtcUserDTO rtcUserDTO = rtcUserMapper.selectByPhoneOrAccount(phone);
        if (!countryCode.equals(rtcUserDTO.getCountryCode())) {
            return ResultData.FAIL(null, 803, PHONE_CODE_803);
        }

        // 校验验证码次数
        String verificationCode = UserUtils.getVerificationCode();
        if (!checkVerificationCodeRedis(phone, verificationCode)) {
            return ResultData.FAIL(phone, 702, CODE_702);
        }

        // 发送验证码
        try {
            SmsUtils.sendSms(phone, verificationCode);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("发送验证码失败:{}", e);
            return ResultData.FAIL(null, 703, CODE_703);
        }

        return ResultData.SUCCESS(null, "发送验证码成功");
    }

    /**
     * 检验手机号相对应的验证码
     *
     * @param phone
     * @param countryCode
     * @param verificationCode
     * @return
     */
    @Override
    public ResultData checkVerificationCode(String phone, String countryCode, String verificationCode) {
        // todo 手机号格式校验
        if (phone == null || countryCode == null) {
            return ResultData.FAIL(null, 400, "数据有误");
        }
        // 该手机号尚未注册
        if (rtcUserMapper.checkPhoneRegistered(phone) == null) {
            return ResultData.FAIL(null, 805, PHONE_CODE_805);
        }
        RtcUserDTO rtcUserDTO = rtcUserMapper.selectByPhoneOrAccount(phone);
        if (!countryCode.equals(rtcUserDTO.getCountryCode())) {
            return ResultData.FAIL(null, 803, PHONE_CODE_803);
        }
        // 该手机号尚未发送验证码
        if (!stringRedisTemplate.hasKey(phone)) {
            return ResultData.FAIL(null, 804, PHONE_CODE_804);
        }
        // 校验验证码
        if (stringRedisTemplate.opsForValue().get(phone).equals(verificationCode)) {
            // 验证码只能使用一次
//            stringRedisTemplate.delete(phone);
            return ResultData.SUCCESS(null, 200, "校验验证码成功");
        }
        return ResultData.FAIL(null, 807, "校验验证码失败");
    }

    /**
     * 查询用户信息，从header里读取用户账号
     *
     * @param request
     * @return
     */
    @Override
    public ResultData getUserInformation(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        String bearer = "Bearer ";
        if (authHeader != null && authHeader.startsWith(bearer)) {
            String jwt = authHeader.substring(bearer.length());
            String userId = UserUtils.verifyJWT(jwt);
            UserDetails userDetails = userDetailService.loadUserByUsername(userId);
            RtcUserVO rtcUserVO = rtcUserMapper.selectByPhoneOrAccount2RtcUserVO(userId);
            UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Collection<? extends GrantedAuthority> authorities = principal.getAuthorities();
            ArrayList<SimpleGrantedAuthority> authoritieList = new ArrayList(authorities);
            SimpleGrantedAuthority simpleGrantedAuthority = authoritieList.get(0);
            Map map = new HashMap();
            map.put("role", simpleGrantedAuthority.getAuthority());
            map.put("user", rtcUserVO);
            // todo 获得绑定第三方信息
            return ResultData.SUCCESS(map);
        }
        return ResultData.FAIL("查询失败", 400);

    }

    /**
     * 忘记密码-修改密码
     *
     * @param user
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultData forgetPassword(String user) {
        logger.info("forgetPassword():{}", user);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = new HashMap();
        try {
            map = objectMapper.readValue(user, HashMap.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResultData.FAIL(user, 400, "数据有误");
        }
        String password = map.get("password");
        String retypePassword = map.get("retypePassword");
        String verificationCode = map.get("verificationCode");
        if (password == null || retypePassword == null || !password.equals(retypePassword) || verificationCode == null) {
            return ResultData.FAIL(user, 400, "数据有误");
        }
        // 未登录的操作需提供账号
        String phone = map.get("phone");
        String countryCode = map.get("countryCode");
        if (phone == null || countryCode == null) {
            return ResultData.FAIL(user, 400, "数据有误");
        }
        if (!UserUtils.checkPasswordFormat(password)) {
            return ResultData.FAIL(user, 903, "密码格式错误");
        }
        // 该手机号尚未发送验证码
        if (!stringRedisTemplate.hasKey(phone)) {
            return ResultData.FAIL(null, 804, PHONE_CODE_804);
        }
        // 校验验证码
        if (!stringRedisTemplate.opsForValue().get(phone).equals(verificationCode)) {
            return ResultData.SUCCESS(null, 707, "验证码错误");
        }
        RtcUserDTO rtcUserDTO = rtcUserMapper.selectByPhoneOrAccount(phone);
        if (new BCryptPasswordEncoder().matches(password, rtcUserDTO.getPassword())) {
            return ResultData.FAIL(user, 904, "新密码不能和原密码相同");
        }
        RtcUser rtcUser = new RtcUser();
        rtcUser.setId(rtcUserDTO.getId());
        rtcUser.setPassword(UserUtils.hexBCryptPassword(password));
        rtcUserMapper.updateByPrimaryKeySelective(rtcUser);
        // 验证码只能使用一次
        stringRedisTemplate.delete(phone);
        return ResultData.SUCCESS(null);
    }

    /**
     * 更换手机号
     *
     * @param user
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultData changePhone(String user) {
        logger.info("changePhone():{}", user);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = new HashMap();
        try {
            map = objectMapper.readValue(user, HashMap.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResultData.FAIL(user, 400, "数据有误");
        }
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        RtcUserDTO rtcUserDTO = rtcUserMapper.selectByPhoneOrAccount(userDetails.getUsername());

        String oldPhone = rtcUserDTO.getPhone();
        String newPhone = map.get("phone");
        String countryCode = map.get("countryCode");
        String verificationCode = map.get("verificationCode");
        // todo 手机号格式校验
        if (newPhone == null || countryCode == null || verificationCode == null) {
            return ResultData.FAIL(user, 400, "数据有误");
        }
        if (oldPhone != null && oldPhone.equals(newPhone)) {
            return ResultData.FAIL(user, 807, PHONE_CODE_807);
        }

        if (rtcUserMapper.checkPhoneRegistered(newPhone) != null) {
            return ResultData.FAIL(user, 801, PHONE_CODE_801);
        }

        // 手机尚未发送验证码
        if (!stringRedisTemplate.hasKey(newPhone)) {
            return ResultData.FAIL(user, 804, PHONE_CODE_804);
        }
        // 验证码错误
        if (!stringRedisTemplate.opsForValue().get(newPhone).equals(verificationCode)) {
            return ResultData.FAIL(user, 707, "验证码错误");
        }

        RtcUser rtcUser = new RtcUser();
        rtcUser.setId(rtcUserDTO.getId());
        rtcUser.setPhone(newPhone);
        rtcUserMapper.updateByPrimaryKeySelective(rtcUser);

        // 验证码只能使用一次
        stringRedisTemplate.delete(newPhone);
        return ResultData.SUCCESS(null, "修改手机号成功");
    }

    /**
     * 更换手机号-通过手机号发送验证码
     *
     * @param phone       要更换的新手机号
     * @param countryCode
     * @return
     */
    @Override
    public ResultData send4ChangePhone(String phone, String countryCode) {
        // todo 手机号格式校验
        if (phone == null || countryCode == null) {
            return ResultData.FAIL(null, 400, "数据有误");
        }
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        RtcUserDTO rtcUserDTO = rtcUserMapper.selectByPhoneOrAccount(userDetails.getUsername());
        String oldPhone = rtcUserDTO.getPhone();
        if (phone.equals(oldPhone)) {
            return ResultData.FAIL(null, 807, PHONE_CODE_807);
        }
        // 该手机号已注册
        if (rtcUserMapper.checkPhoneRegistered(phone) != null) {
            return ResultData.FAIL(null, 801, PHONE_CODE_801);
        }

        // 校验验证码次数
        String verificationCode = UserUtils.getVerificationCode();
        if (!checkVerificationCodeRedis(phone, verificationCode)) {
            return ResultData.FAIL(phone, 702, CODE_702);
        }
        // 发送验证码
        try {
            SmsUtils.sendSms(phone, verificationCode);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("发送验证码失败:{}", e);
            return ResultData.FAIL(null, 703, CODE_703);
        }

        return ResultData.SUCCESS(null, 200, "发送验证码成功");
    }


    /**
     * 上传头像,保存在临时文件夹
     *
     * @param file
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultData uploadPortrait(MultipartFile file) throws Exception {
        logger.info("uploadPortrait():{}", file);
        String name = file.getName();
        String originalFilename = file.getOriginalFilename();
        String suffString = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        if (!imgType.contains(suffString)) {
            return ResultData.FAIL(null, 905, "头像文件格式错误");
        }

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        RtcUserDTO rtcUserDTO = rtcUserMapper.selectByPhoneOrAccount(userDetails.getUsername());
        String uuid = rtcUserDTO.getUuid();
        // 头像文件夹路径
        File portraitPath = new File(PORTRAIT);
        String filePath = PORTRAIT + "/" + uuid;
        String tempPath = PORTRAIT + "/temp/" + uuid;
        File portrait = new File(filePath);
        File temp = new File(tempPath);
        if (!portraitPath.exists()) {
            return ResultData.FAIL(null, 500, "文件服务器错误");
        }
        if (!portrait.exists()) {
            portrait.mkdir();
        }
        temp.mkdirs();

        File portraitFile = File.createTempFile(LocalDate.now() + "-", "." + suffString, temp);
        file.transferTo(portraitFile);

        // 删除原来头像文件，把临时头像文件夹里的文件放进头像文件夹，然后删除临时文件夹头像
        String oldPortrait = rtcUserDTO.getPortrait();
        File tempFilePath = new File(PORTRAIT + "/temp/" + uuid);
        if (tempFilePath.exists() && tempFilePath.listFiles() != null && tempFilePath.listFiles().length > 0) {
            File tempFile = tempFilePath.listFiles()[0];
            if (oldPortrait != null && new File(PORTRAIT + "/" + uuid) != null) {
                File[] oldFiles = new File(PORTRAIT + "/" + uuid).listFiles();
                for (File oldFile : oldFiles) {
                    oldFile.delete();
                }
            } else {
                new File(PORTRAIT + "/" + uuid).mkdirs();
            }
            String portraitFilePath = PORTRAIT + "/" + uuid + "/" + tempFile.getName();
            String portraitURI = PORTRAIT_URI + "/" + uuid + "/" + tempFile.getName();
            BufferedInputStream in = null;
            try {
                in = new BufferedInputStream(new FileInputStream(tempFile));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return ResultData.FAIL(null, 906, "请重新上传头像");
            }
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(portraitFilePath));
            byte[] bytes = new byte[1024 * 2];
            while (in.read(bytes) > 0) {
                out.write(bytes);
            }
            out.flush();
            out.close();
            in.close();
            // 删除临时头像
            for (File localTempFile : tempFilePath.listFiles()) {
                localTempFile.delete();
            }
            tempFilePath.delete();
            RtcUser rtcUser = new RtcUser();
            rtcUser.setId(rtcUserDTO.getId());
            rtcUser.setPortrait(portraitURI);
            if (rtcUserMapper.updateByPrimaryKeySelective(rtcUser) > 0) {
                return ResultData.SUCCESS(null, 200, "上传头像成功");
            }
        }

        return ResultData.FAIL(null, 500, "上传头像失败");
    }

    /**
     * 添加到收藏夹/从收藏夹移除
     *
     * @param body
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultData modifyFavourite(String body) {
        logger.info("modifyFavourite(String body):{}", body);
        // 防止重复提交

        ObjectMapper objectMapper = new ObjectMapper();
        RtcUserFavourite rtcUserFavourite = new RtcUserFavourite();
        try {
            rtcUserFavourite = objectMapper.readValue(body, RtcUserFavourite.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResultData.FAIL(null, 400, "数据有误");
        }
        String enterpriseId = rtcUserFavourite.getEnterpriseId();
        if (StringUtils.isEmpty(enterpriseId) || StringUtils.isEmpty(rtcUserFavourite.getNation())
                || StringUtils.isEmpty(rtcUserFavourite.geteType())) {
            return ResultData.FAIL(null, 400, "数据有误");
        }

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        RtcUserDTO rtcUserDTO = rtcUserMapper.selectByPhoneOrAccount(userDetails.getUsername());
        // 判断添加还是移除
        Integer favouriteId = rtcUserMapper.checkFavourite(rtcUserDTO.getUuid(), enterpriseId);
        if (favouriteId != null) {
            rtcUserFavouriteMapper.deleteByPrimaryKey(favouriteId);
            return ResultData.SUCCESS(0, "移除收藏成功");
        }

        rtcUserFavourite.setUserId(rtcUserDTO.getUuid());
        rtcUserFavouriteMapper.insertSelective(rtcUserFavourite);

        return ResultData.SUCCESS(1, "添加收藏成功");
    }

    /**
     * 查看收藏夹列表
     *
     * @param sort
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ResultData listFavourite(String sort, int pageNum, int pageSize) throws IOException {
        logger.info("listFavourite(String sort, int pageNum, int pageSize):{}, {}, {}", sort, pageNum, pageSize);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        RtcUserDTO rtcUserDTO = rtcUserMapper.selectByPhoneOrAccount(userDetails.getUsername());
        String uuid = rtcUserDTO.getUuid();
        PageHelper.startPage(pageNum, pageSize);
        List<RtcUserFavourite> favouriteList = rtcUserFavouriteMapper.selectFavourite(uuid, sort);
        PageHelper.clearPage();
        String[] esIndices = elasticsearchUtils.getEsIndices();
        SearchRequest searchRequest = new SearchRequest(esIndices);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        List<UserCommentVO> voList = new ArrayList();
        PageInfo<RtcUserFavourite> pageInfo = new PageInfo<>(favouriteList);
        Map resultMap = new HashMap();
        resultMap.put("total", pageInfo.getTotal());
        resultMap.put("pageNum", pageInfo.getPageNum());
        resultMap.put("pageSize", pageInfo.getPageSize());
        resultMap.put("list", voList);


        if (!ObjectUtils.isEmpty(favouriteList)) {
            ObjectMapper objectMapper = new ObjectMapper();
            for (int i = 0; i < favouriteList.size(); i++) {
                RtcUserFavourite rtcUserFavourite = favouriteList.get(i);
                MatchPhraseQueryBuilder matchPhraseQueryBuilder = new MatchPhraseQueryBuilder("enterprise_id", rtcUserFavourite.getEnterpriseId());
                searchSourceBuilder.query(matchPhraseQueryBuilder);
                searchRequest.source(searchSourceBuilder);
                SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
                if (searchResponse != null) {
                    SearchHit[] hits = searchResponse.getHits().getHits();
                    if (!ObjectUtils.isEmpty(hits)) {
                        UserCommentVO userCommentVO = objectMapper.readValue(hits[0].getSourceAsString(), UserCommentVO.class);
                        CommonUtils.setLogoNameAndColor(userCommentVO);
                        userCommentVO.setPid(rtcUserFavourite.getId());
                        userCommentVO.setGmtCreate(rtcUserFavourite.getGmtCreate());
                        userCommentVO.setEstablishmentDate(CommonUtils.dateFormat(userCommentVO.getEstablishmentDate()));
                        voList.add(userCommentVO);
                    }
                }
            }
        }
        if ("e_name".equals(sort)) {
            if (!ObjectUtils.isEmpty(voList)) {
                List<String> eNameList = new ArrayList();
                List<UserCommentVO> eNameVOList = new ArrayList<>();
                for (int i = 0; i < voList.size(); i++) {
                    UserCommentVO vo = voList.get(i);
                    eNameList.add(vo.geteName());
                }
                Collections.sort(eNameList);
                for (int i = 0; i < eNameList.size(); i++) {
                    for (int j = 0; j < voList.size(); j++) {
                        if (eNameList.get(i).equals(voList.get(j).geteName())) {
                            eNameVOList.add(voList.get(j));
                        }
                    }
                }
                resultMap.put("list", eNameVOList);
                return ResultData.SUCCESS(resultMap);
            }
        }


        return ResultData.SUCCESS(resultMap);
    }

    /**
     * 我的收藏-移除收藏
     *
     * @param body
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultData removeFavourite(String body) {
        logger.info("removeFavourite(String body):{}", body);
        ObjectMapper objectMapper = new ObjectMapper();
        Integer[] pidArray;
        try {
            RemoveFavouriteDTO removeFavouriteDTO = objectMapper.readValue(body, RemoveFavouriteDTO.class);
            pidArray = removeFavouriteDTO.getPidArray();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResultData.FAIL(null, 400, "数据有误");
        }
        if (!ObjectUtils.isEmpty(pidArray)) {
            if (rtcUserFavouriteMapper.deleteFavourites(pidArray) > 0) {
                return ResultData.SUCCESS(200, "移除收藏成功");
            }
        }

        return ResultData.SUCCESS(500, "移除收藏失败");
    }

    /**
     * 新增评论
     *
     * @param body
     * @return
     */
    @Override
    public ResultData saveComment(String body) {
        logger.info("saveComment(String body):{}", body);
        ObjectMapper objectMapper = new ObjectMapper();
        String comment;
        UserCommentDTO commentDTO;
        try {
            commentDTO = objectMapper.readValue(body, UserCommentDTO.class);
            comment = commentDTO.getComment();
            BigDecimal stars = commentDTO.getStars();
            if (!commentStars.contains(stars)) {
                return ResultData.FAIL(null, 400, "数据有误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultData.FAIL(null, 400, "数据有误");
        }
        if (!ObjectUtils.isEmpty(comment) && comment.length() < COMMIT_LENGTH) {
            RtcUserComment rtcUserComment = new RtcUserComment();
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            RtcUserDTO rtcUserDTO = rtcUserMapper.selectByPhoneOrAccount(userDetails.getUsername());
            rtcUserComment.setUserId(rtcUserDTO.getUuid());
            BeanUtils.copyProperties(commentDTO, rtcUserComment);

            rtcUserCommentMapper.insertSelective(rtcUserComment);
            return ResultData.SUCCESS(null, "评论成功");
        }
        return ResultData.FAIL(null, 400);
    }

    /**
     * 翻译评论
     *
     * @param commentId
     * @return
     */
    @Override
    public ResultData translateComment(Integer commentId) throws Exception {
        Map resultMap = new HashMap();
        resultMap.put("commentId", commentId);
        resultMap.put("comment", "");
        String key = "translate-comment:commentId:" + commentId;
        if (stringRedisTemplate.hasKey(key)) {
            resultMap.put("comment", stringRedisTemplate.opsForValue().get(key));
            return ResultData.SUCCESS(resultMap);
        }
        RtcUserComment rtcUserComment = rtcUserCommentMapper.selectByPrimaryKey(commentId);
        String comment = rtcUserComment.getComment();
        Map map = CommonUtils.translate2(comment, "auto", "en");
        int code = (int) map.get("code");
        if (code == 200) {
            comment = (String) map.get("data");
            stringRedisTemplate.opsForValue().set(key, comment);
            resultMap.put("comment", comment);
            return ResultData.SUCCESS(resultMap);
        }
        return ResultData.FAIL(resultMap, 708, CODE_708);
    }

    /**
     * 更换邮箱-通过邮箱发送验证码
     *
     * @param email
     * @return
     */
    @Override
    public ResultData send4ChangeEmail(String email) {
        // 邮箱格式验证
        if (email == null || !UserUtils.checkEmailRegex(email)) {
            return ResultData.FAIL(email, 850, EMAIL_CODE_850);
        }

        // 邮箱不能与原来相同
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        RtcUserDTO rtcUser = rtcUserMapper.selectByPhoneOrAccount(userDetails.getUsername());
        String oldEmail = rtcUser.getEmail();
        if (oldEmail != null && oldEmail.equals(email)) {
            return ResultData.FAIL(email, 855, EMAIL_CODE_855);
        }

        // 邮箱已注册
        if (rtcUserMapper.checkEmaillRegistered(email) != null) {
            return ResultData.FAIL(email, 851, EMAIL_CODE_851);
        }

        // 校验验证码次数
        String verificationCode = UserUtils.getVerificationCode();
        // 验证，15分钟内最多发5次，一个验证码有效期15分钟
        if (checkVerificationCodeRedis(email, verificationCode)) {
            // 发送邮件验证码
            try {
                UserUtils.sendEmailVerificationCode(email, verificationCode);
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("发送验证码失败:{}", e);
                return ResultData.FAIL(null, 703, CODE_703);
            }
            return ResultData.SUCCESS(email, "验证码已发送");
        }

        return ResultData.FAIL(email, 702, CODE_702);
    }

    /**
     * 更换邮箱-更换成功后删除验证码
     *
     * @param body
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultData changeEmail(String body) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            HashMap<String, String> map = objectMapper.readValue(body, HashMap.class);
            String email = map.get("email");
            String verificationCode = map.get("verificationCode");
            if (email == null || verificationCode == null) {
                return ResultData.FAIL(body, 400, "数据有误");
            }

            // 邮箱格式验证
            if (email == null || !UserUtils.checkEmailRegex(email)) {
                return ResultData.FAIL(email, 850, EMAIL_CODE_850);
            }

            // 邮箱不能与原来相同
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            RtcUserDTO rtcUser = rtcUserMapper.selectByPhoneOrAccount(userDetails.getUsername());
            String oldEmail = rtcUser.getEmail();
            if (oldEmail != null && oldEmail.equals(email)) {
                return ResultData.FAIL(email, 855, EMAIL_CODE_855);
            }

            // 邮箱已注册
            if (rtcUserMapper.checkEmaillRegistered(email) != null) {
                return ResultData.FAIL(email, 851, EMAIL_CODE_851);
            }
            // 该邮箱尚未发送验证码
            if (!stringRedisTemplate.hasKey(email)) {
                return ResultData.FAIL(email, 852, EMAIL_CODE_852);
            }
            // 检验验证码
            if (!verificationCode.equals(stringRedisTemplate.opsForValue().get(email))) {
                return ResultData.FAIL(email, 707, CODE_707);
            }

            // 修改邮箱
            RtcUser data = new RtcUser();
            data.setId(rtcUser.getId());
            data.setEmail(email);
            rtcUserMapper.updateByPrimaryKeySelective(data);

            // 删除验证码
            stringRedisTemplate.delete(email);

        } catch (JsonProcessingException e) {
            logger.info("changeEmail():{},{}", e, body);
            return ResultData.FAIL(body, 400, "数据有误");
        }
        return ResultData.SUCCESS(body, 200, "更新邮箱成功");
    }

    /**
     * 忘记密码-邮箱-发送验证码
     *
     * @param email
     * @return
     */
    @Override
    public ResultData send4ForgetEmailPassword(String email) {
        // 邮箱格式验证
        if (!UserUtils.checkEmailRegex(email)) {
            return ResultData.FAIL(email, 850, EMAIL_CODE_850);
        }
        // 邮箱未注册
        if (rtcUserMapper.checkEmaillRegistered(email) == null) {
            return ResultData.FAIL(email, 856, EMAIL_CODE_856);
        }
        String verificationCode = UserUtils.getVerificationCode();
        // 验证，15分钟内最多发5次，一个验证码有效期15分钟
        if (checkVerificationCodeRedis(email, verificationCode)) {
            // 发送邮件验证码
            try {
                UserUtils.sendEmailVerificationCode(email, verificationCode);
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("发送验证码失败:{}", e);
                return ResultData.FAIL(null, 703, CODE_703);
            }
            return ResultData.SUCCESS(email, "验证码已发送");
        }

        return ResultData.FAIL(email, 702, CODE_702);
    }

    /**
     * 忘记密码-邮箱-校验验证码
     *
     * @param body
     * @return
     */
    @Override
    public ResultData check4ForgetEmailPassword(String body) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            HashMap<String, String> hashMap = objectMapper.readValue(body, HashMap.class);
            String email = hashMap.get("email");
            String verificationCode = hashMap.get("verificationCode");
            // 邮箱格式验证
            if (!UserUtils.checkEmailRegex(email)) {
                return ResultData.FAIL(body, 850, EMAIL_CODE_850);
            }
            // 邮箱未注册
            if (rtcUserMapper.checkEmaillRegistered(email) == null) {
                return ResultData.FAIL(body, 856, EMAIL_CODE_856);
            }
            // 邮箱未发送验证码
            if (!stringRedisTemplate.hasKey(email)) {
                return ResultData.FAIL(body, 852, EMAIL_CODE_852);
            }

            // 校验验证码
            if (stringRedisTemplate.opsForValue().get(email).equals(verificationCode)) {
                return ResultData.SUCCESS(body, 200, "验证码校验成功");
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            logger.info("check4ForgetEmailPassword():{},{}", body, e);
        }

        return ResultData.FAIL(body, 707, CODE_707);
    }

    /**
     * 忘记密码-邮箱-修改密码
     *
     * @param body
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultData forgetEmailPassword(String body) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            HashMap<String, String> hashMap = objectMapper.readValue(body, HashMap.class);
            String email = hashMap.get("email");
            String password = hashMap.get("password");
            String retypePassword = hashMap.get("retypePassword");
            String verificationCode = hashMap.get("verificationCode");

            // 邮箱格式验证
            if (!UserUtils.checkEmailRegex(email)) {
                return ResultData.FAIL(body, 850, EMAIL_CODE_850);
            }
            // 校验数据格式
            if (password == null || !password.equals(retypePassword)) {
                return ResultData.FAIL(body, 705, CODE_705);
            }
            // 邮箱未注册
            if (rtcUserMapper.checkEmaillRegistered(email) == null) {
                return ResultData.FAIL(body, 856, EMAIL_CODE_856);
            }

            // 邮箱未发送验证码
            if (!stringRedisTemplate.hasKey(email)) {
                return ResultData.FAIL(body, 852, EMAIL_CODE_852);
            }

            // 校验密码格式
            if (!UserUtils.checkPasswordFormat(password)) {
                return ResultData.FAIL(body, 903, "密码格式错误");
            }

            // 校验验证码
            if (stringRedisTemplate.opsForValue().get(email).equals(verificationCode)) {
                RtcUserDTO rtcUserDTO = rtcUserMapper.selectByPhoneOrAccount(email);
                if (new BCryptPasswordEncoder().matches(password, rtcUserDTO.getPassword())) {
                    return ResultData.FAIL(body, 904, "新密码不能和原密码相同");
                }
                RtcUser rtcUser = new RtcUser();
                rtcUser.setId(rtcUserDTO.getId());
                rtcUser.setPassword(UserUtils.hexBCryptPassword(password));
                rtcUserMapper.updateByPrimaryKeySelective(rtcUser);
                // 删除验证码
                stringRedisTemplate.delete(email);
                return ResultData.SUCCESS(body, 200, "修改密码成功");
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            logger.info("forgetEmailPassword():{},{}", body, e);
        }
        return ResultData.SUCCESS(null);
    }

    /**
     * 检验验证码发送频率限制并记录在redis，设置过期时间
     *
     * @param verificationCode
     * @return 可以发送返回true，超过限制返回false
     */
    public boolean checkVerificationCodeRedis(String account, String verificationCode) {
        if (!stringRedisTemplate.hasKey(account)) {
            stringRedisTemplate.opsForValue().set("countdown:" + account, verificationCode, 55, TimeUnit.SECONDS);
            stringRedisTemplate.opsForValue().set(account, verificationCode, verificationCodeTTL, TimeUnit.MINUTES);
            stringRedisTemplate.opsForValue().increment(account + "_incr");
            stringRedisTemplate.expire(account + "_incr", verificationCodeTTL, TimeUnit.MINUTES);
            return true;
        } else {
            if (stringRedisTemplate.hasKey("countdown:" + account)) {
                return false;
            }
            int i = Integer.parseInt(stringRedisTemplate.opsForValue().get(account + "_incr"));
            if (i < redisEmailLimt) {
                stringRedisTemplate.opsForValue().set(account, verificationCode, verificationCodeTTL, TimeUnit.MINUTES);
                stringRedisTemplate.opsForValue().increment(account + "_incr");
                stringRedisTemplate.expire(account + "_incr", verificationCodeTTL, TimeUnit.MINUTES);
                return true;
            }
        }

        return false;
    }

}
