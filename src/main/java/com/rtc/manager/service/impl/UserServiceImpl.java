package com.rtc.manager.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.rtc.manager.dao.RtcUserCommentMapper;
import com.rtc.manager.dao.RtcUserFavouriteMapper;
import com.rtc.manager.dao.RtcUserMapper;
import com.rtc.manager.entity.RtcUser;
import com.rtc.manager.entity.RtcUserComment;
import com.rtc.manager.entity.RtcUserFavourite;
import com.rtc.manager.entity.dto.PhoneRegisterDTO;
import com.rtc.manager.entity.dto.RemoveFavouriteDTO;
import com.rtc.manager.entity.dto.RtcUserDTO;
import com.rtc.manager.entity.dto.UserCommentDTO;
import com.rtc.manager.service.UserService;
import com.rtc.manager.util.ElasticsearchUtils;
import com.rtc.manager.util.UserUtils;
import com.rtc.manager.vo.ResultData;
import com.rtc.manager.vo.RtcUserVO;
import com.rtc.manager.vo.SearchEnterpriseListVO;
import com.rtc.manager.vo.UserCommentVO;
import org.apache.lucene.search.TotalHits;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.script.ScriptType;
import org.elasticsearch.script.mustache.SearchTemplateRequest;
import org.elasticsearch.script.mustache.SearchTemplateResponse;
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
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.lang.reflect.Array;
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
    private static Long verificationCodeTTL;

    @Value("${rtc.loginTokenTTL}")
    private static Long loginTokenTTL;

    private final RestHighLevelClient client = ElasticsearchUtils.getClient();

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private static final JavaMailSenderImpl JAVA_MAIL_SENDER;
    private static final String EMAIL_CODE_700 = "邮箱格式错误";
    private static final String EMAIL_CODE_701 = "邮箱已注册";
    private static final String EMAIL_CODE_704 = "该邮箱尚未发送验证码";
    private static final String CODE_702 = "验证码发送次数过多，请" + verificationCodeTTL + "分钟稍后再试";
    private static final String CODE_703 = "验证码发送失败";
    private static final String CODE_705 = "数据有误";
    private static final String CODE_707 = "验证码错误";

    private static final String PHONE_CODE_800 = "手机号格式错误";
    private static final String PHONE_CODE_801 = "手机号已注册";
    private static final String PHONE_CODE_802 = "请输入手机号";
    private static final String PHONE_CODE_804 = "该手机号尚未发送验证码";

    @Value("${rtc.mail.redisEmailLimt}")
    private Integer redisEmailLimt;

    @Value("${rtc.portraitURI}")
    private String PORTRAIT_URI;

    static {
        JAVA_MAIL_SENDER = new JavaMailSenderImpl();
        JAVA_MAIL_SENDER.setHost("smtp.sina.com");
        JAVA_MAIL_SENDER.setUsername("c237113730@sina.com");
        JAVA_MAIL_SENDER.setPassword("88a169c98a5fd127");
        JAVA_MAIL_SENDER.setDefaultEncoding("UTF-8");

    }

    /**
     * 校验邮箱是否注册
     *
     * @param emaill
     * @return
     */
    @Override
    public ResultData checkEmaillRegistered(String emaill) {
        // 正则判断是否是邮箱
        if (!UserUtils.checkEmailRegex(emaill)) {
            return ResultData.FAIL(emaill, 700, EMAIL_CODE_700);
        } else if (rtcUserMapper.checkEmaillRegistered(emaill) != null) {
            return ResultData.FAIL(emaill, 701, EMAIL_CODE_701);
        }

        // 验证码
        String verificationCode = UserUtils.getVerificationCode();

        // 验证，15分钟内最多发5次，一个验证码有效期15分钟
        if (checkVerificationCodeRedis(emaill, verificationCode)) {
            // 发送邮件验证码
            UserUtils.sendEmailVerificationCode(emaill, verificationCode);
            return ResultData.SUCCESS(emaill, "验证码已发送");
        } else if (!checkVerificationCodeRedis(emaill, verificationCode)) {
            return ResultData.FAIL(emaill, 702, CODE_702);
        }

        return ResultData.FAIL(emaill, 703, CODE_703);
    }

    /**
     * 邮箱注册
     *
     * @param data
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultData emailRegister(String data) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        RtcUserDTO rtcUserDTO = objectMapper.readValue(data, RtcUserDTO.class);

        if (rtcUserDTO == null) {
            return ResultData.FAIL(data, 705, CODE_705);
        }
        RtcUser rtcUser = new RtcUser();
        BeanUtils.copyProperties(rtcUserDTO, rtcUser);

        String email = rtcUserDTO.getEmail();

        // 邮箱格式错误
        if (!UserUtils.checkEmailRegex(email)) {
            return ResultData.FAIL(email, 700, EMAIL_CODE_700);
            // 邮箱已注册
        } else if (rtcUserMapper.checkEmaillRegistered(email) != null) {
            return ResultData.FAIL(email, 701, EMAIL_CODE_701);
            // 没发过验证码
        } else if (!stringRedisTemplate.hasKey(email)) {
            return ResultData.FAIL(email, 704, EMAIL_CODE_704);
        } else if (rtcUserDTO.getVerificationCode() == null) {
            // 没填验证码
//            return ResultData.FAIL(email, 705, CODE_706);
        }
        String verificationCodeRedis = stringRedisTemplate.opsForValue().get(email);
        if (rtcUserDTO.getVerificationCode().equals(verificationCodeRedis)) {
            Map<String, String> map = UserUtils.hexPassword(rtcUser.getPassword());
            rtcUser.setPassword(map.get("password"));
            rtcUser.setSalt(map.get("salt"));
            rtcUserMapper.insertSelective(rtcUser);
            return ResultData.SUCCESS(data, "注册成功");
        }
        return ResultData.FAIL(data, 707, CODE_707);
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

        // 手机号已注册
        if (rtcUserMapper.checkPhoneRegistered(phone) != null) {
            return ResultData.FAIL(phone, 801, PHONE_CODE_801);
        }

        // 校验验证码次数
        String verificationCode = UserUtils.getVerificationCode();
        if (!checkVerificationCodeRedis(phone, verificationCode)) {
            return ResultData.FAIL(phone, 702, CODE_702);
        }

        // todo 发送验证码


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
        String token = UserUtils.getToken(rtcUserDTO.getUuid());
        stringRedisTemplate.opsForValue().set(token, rtcUserDTO.getUuid(), loginTokenTTL, TimeUnit.DAYS);
        Map map = new HashMap();
        map.put("account", phone);
        map.put("Authorization", token);
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

        String authHeader = request.getHeader("Authorization");
        String account = stringRedisTemplate.opsForValue().get(authHeader);
        RtcUserVO rtcUserVO = rtcUserMapper.selectByPhoneOrAccount2RtcUserVO(account);
        String oldNickname = rtcUserVO.getNickname();
        String nicknameToken = authHeader;
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

        String portraitPath = "";
        String portraitURI = "";
        if (portrait != null) {
            if (!portrait.equals(rtcUserVO.getPortrait())) {
                // 删除原来头像文件，把临时头像文件夹里的文件放进头像文件夹，然后删除临时文件夹头像
                String uuid = rtcUserVO.getUuid();
                portrait = PORTRAIT + "/temp/" + portrait.substring(portrait.indexOf("/temp/") + "/temp/".length());
                File tempFile = new File(portrait);
                portraitPath = PORTRAIT + "/" + uuid + "/" + tempFile.getName();
                portraitURI = PORTRAIT_URI + "/" + uuid + "/" + tempFile.getName();
                File portraitFile = new File(portraitPath);
                BufferedInputStream in = null;
                try {
                    in = new BufferedInputStream(new FileInputStream(tempFile));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    return ResultData.FAIL(null, 906, "请重新上传头像");
                }
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(portraitFile));
                byte[] bytes = new byte[1024 * 2];
                while (in.read(bytes) > 0) {
                    out.write(bytes);
                }
                out.flush();
                out.close();
                in.close();
                // 删除临时头像
                tempFile.delete();
                File tempDir = new File(PORTRAIT + "/temp/" + uuid);
                tempDir.delete();
                // 删除原来头像
                if (oldPortrait != null) {
                    oldPortrait = PORTRAIT + "/" + oldPortrait.substring(oldPortrait.indexOf("/portrait/") + "/portrait/".length());
                    File file = new File(oldPortrait);
                    file.delete();
                }
            }
        }


        rtcUser.setId(rtcUserVO.getId());
        rtcUser.setPassword(null);
        rtcUser.setPhone(null);
        rtcUser.setCountryCode(null);
        rtcUser.setPortrait(portraitURI);
        rtcUserMapper.updateByPrimaryKeySelective(rtcUser);

        RtcUserVO vo = rtcUserMapper.selectByPhoneOrAccount2RtcUserVO(nickname == null ? oldNickname : nickname);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
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
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultData updatePassword(String user) {
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
        return ResultData.SUCCESS(null);
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
            return ResultData.FAIL(null, 805, "该手机号尚未注册");
        }
        RtcUserDTO rtcUserDTO = rtcUserMapper.selectByPhoneOrAccount(phone);
        if (!countryCode.equals(rtcUserDTO.getCountryCode())) {
            return ResultData.FAIL(null, 803, "国家代码与手机号不符");
        }

        // 校验验证码次数
        String verificationCode = UserUtils.getVerificationCode();
        if (!checkVerificationCodeRedis(phone, verificationCode)) {
            return ResultData.FAIL(phone, 702, CODE_702);
        }

        // todo 发送验证码


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
            return ResultData.FAIL(null, 805, "该手机号尚未注册");
        }
        RtcUserDTO rtcUserDTO = rtcUserMapper.selectByPhoneOrAccount(phone);
        if (!countryCode.equals(rtcUserDTO.getCountryCode())) {
            return ResultData.FAIL(null, 803, "国家代码与手机号不符");
        }
        // 该手机号尚未发送验证码
        if (!stringRedisTemplate.hasKey(phone)) {
            return ResultData.FAIL(null, 804, "该手机号尚未发送验证码");
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
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            if (stringRedisTemplate.hasKey(authHeader)) {
                String uuid = stringRedisTemplate.opsForValue().get(authHeader);
                RtcUserVO rtcUserVO = rtcUserMapper.selectByPhoneOrAccount2RtcUserVO(uuid);
                UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                Collection<? extends GrantedAuthority> authorities = principal.getAuthorities();
                ArrayList<SimpleGrantedAuthority> authoritieList = new ArrayList(authorities);
                SimpleGrantedAuthority simpleGrantedAuthority = authoritieList.get(0);
                Map map = new HashMap();
                map.put("role", simpleGrantedAuthority.getAuthority());
                map.put("user", rtcUserVO);
                return ResultData.SUCCESS(map);
            }
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
            return ResultData.FAIL(null, 804, "该手机号尚未发送验证码");
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
        String oldPhone = userDetails.getUsername();
//        String oldPhone = map.get("oldPhone");
        String newPhone = map.get("phone");
        String countryCode = map.get("countryCode");
        String verificationCode = map.get("verificationCode");
        // todo 手机号格式校验
        if (newPhone == null || countryCode == null || verificationCode == null) {
            return ResultData.FAIL(user, 400, "数据有误");
        }
        if (oldPhone.equals(newPhone)) {
            return ResultData.FAIL(user, 805, "新手机号不能和原来一样");
        }

        if (rtcUserMapper.checkPhoneRegistered(newPhone) != null) {
            return ResultData.FAIL(user, 801, "手机号已注册");
        }

        // 手机尚未发送验证码
        if (!stringRedisTemplate.hasKey(newPhone)) {
            return ResultData.FAIL(user, 804, "该手机号尚未发送验证码");
        }
        // 验证码错误
        if (!stringRedisTemplate.opsForValue().get(newPhone).equals(verificationCode)) {
            return ResultData.FAIL(user, 707, "验证码错误");
        }

        RtcUserDTO rtcUserDTO = rtcUserMapper.selectByPhoneOrAccount(oldPhone);
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
     * @param phone
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
        if (phone.equals(userDetails.getUsername())) {
            return ResultData.FAIL(null, 805, "新手机号不能和原来一样");
        }
        // 该手机号已注册
        if (rtcUserMapper.checkPhoneRegistered(phone) != null) {
            return ResultData.FAIL(null, 801, "该手机号已注册");
        }

        // 校验验证码次数
        String verificationCode = UserUtils.getVerificationCode();
        if (!checkVerificationCodeRedis(phone, verificationCode)) {
            return ResultData.FAIL(phone, 702, CODE_702);
        }
        // todo 发送验证码

        return ResultData.FAIL(null, 200, "发送验证码成功");
    }


    /**
     * 上传头像,返回头像的URL
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
        List<String> suffList = List.of("jpg", "jpeg", "png", "bmp");
        String suffString = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        if (!suffList.contains(suffString)) {
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

        // 删除上一次上传的临时头像
        File[] files = temp.listFiles();
        if (files.length == 1) {
            files[0].delete();
        }

        File portraitFile = File.createTempFile(LocalDate.now() + "-", "." + suffString, temp);
        file.transferTo(portraitFile);

        Map map = new HashMap();
        map.put("portrait", PORTRAIT_URI + "/temp/" + uuid + "/" + portraitFile.getName());

        return ResultData.SUCCESS(map, 200, "上传头像成功");
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

        SearchRequest searchRequest = new SearchRequest("china", "india-cin", "india-llpin", "vietnam");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        List voList = new ArrayList();

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
                        userCommentVO.setPid(rtcUserFavourite.getId());
                        voList.add(userCommentVO);
                    }
                }
            }
        }



        return ResultData.SUCCESS(voList);
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
        } catch (JsonProcessingException e) {
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
     * 检验验证码发送频率限制并记录在redis，设置过期时间
     *
     * @param verificationCode
     * @return
     */
    public boolean checkVerificationCodeRedis(String account, String verificationCode) {
        if (!stringRedisTemplate.hasKey(account)) {
            stringRedisTemplate.opsForValue().set(account, verificationCode, verificationCodeTTL, TimeUnit.MINUTES);
            stringRedisTemplate.opsForValue().increment(account + "_incr");
            stringRedisTemplate.expire(account + "_incr", verificationCodeTTL, TimeUnit.MINUTES);
            return true;
        } else if (stringRedisTemplate.hasKey(account)) {
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
