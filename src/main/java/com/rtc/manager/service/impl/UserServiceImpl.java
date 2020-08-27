package com.rtc.manager.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rtc.manager.dao.RtcUserMapper;
import com.rtc.manager.entity.RtcUser;
import com.rtc.manager.entity.dto.PhoneRegisterDTO;
import com.rtc.manager.entity.dto.RtcUserDTO;
import com.rtc.manager.service.UserService;
import com.rtc.manager.util.UserUtils;
import com.rtc.manager.vo.ResultData;
import com.rtc.manager.vo.RtcUserVO;
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

import javax.servlet.http.HttpServletRequest;
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

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private static final JavaMailSenderImpl JAVA_MAIL_SENDER;
    private static final String EMAIL_CODE_700 = "邮箱格式错误";
    private static final String EMAIL_CODE_701 = "邮箱已注册";
    private static final String EMAIL_CODE_704 = "该邮箱尚未发送验证码";
    private static final String CODE_702 = "验证码发送次数过多，请15分钟稍后再试";
    private static final String CODE_703 = "验证码发送失败";
    private static final String CODE_705 = "数据有误";
    private static final String CODE_707 = "验证码错误";

    private static final String PHONE_CODE_800 = "手机号格式错误";
    private static final String PHONE_CODE_801 = "手机号已注册";
    private static final String PHONE_CODE_802 = "请输入手机号";
    private static final String PHONE_CODE_804 = "该手机号尚未发送验证码";

    @Value("${rtc.mail.redisEmailLimt}")
    private Integer redisEmailLimt;

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
        stringRedisTemplate.opsForValue().set(token, rtcUserDTO.getUuid(), 30, TimeUnit.DAYS);
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
        ObjectMapper objectMapper = new ObjectMapper();
        RtcUser rtcUser = objectMapper.readValue(user, RtcUser.class);
        String nickname = rtcUser.getNickname();
        if (nickname != null) {
            // 验证昵称格式
            if (!UserUtils.checkNicknameFormat(nickname)) {
                return ResultData.FAIL(user, 901, "昵称格式错误");
            }
            // 检验昵称是否存在
            if (rtcUserMapper.checkNicknameRegistered(nickname) != null) {
                return ResultData.FAIL(user, 902, "昵称已存在");
            }
        }
        String authHeader = request.getHeader("Authorization");
        // 手机号，昵称唯一。对应的2个token也唯一。修改昵称，则原token删除，生成新token，返回新的token
        String account = stringRedisTemplate.opsForValue().get(authHeader);
        String nicknameToken = authHeader;
        RtcUserVO rtcUserVO = rtcUserMapper.selectByPhoneOrAccount2RtcUserVO(account);
        String oldNickname = rtcUserVO.getNickname();
        rtcUser.setId(rtcUserVO.getId());
        rtcUser.setPassword(null);
        rtcUser.setPhone(null);
        rtcUser.setCountryCode(null);
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
        // todo 校验密码格式
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
        }

        // 该手机号尚未注册
        if (rtcUserMapper.checkPhoneRegistered(phone) == null) {
            return ResultData.FAIL(null, 805, "该手机号尚未注册");
        }

        // 校验验证码次数
        String verificationCode = UserUtils.getVerificationCode();
        if (!checkVerificationCodeRedis(phone, verificationCode)) {
            return ResultData.FAIL(phone, 702, CODE_702);
        }

        // 发送验证码


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
        }
        // 该手机号尚未注册
        if (rtcUserMapper.checkPhoneRegistered(phone) == null) {
            return ResultData.FAIL(null, 805, "该手机号尚未注册");
        }
        // 该手机号尚未发送验证码
        if (!stringRedisTemplate.hasKey(phone)) {
            return ResultData.FAIL(null, 804, "该手机号尚未发送验证码");
        }
        // 校验验证码
        if (stringRedisTemplate.opsForValue().get(phone).equals(verificationCode)) {
            return ResultData.SUCCESS(null, 806, "校验验证码成功");
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
     * 检验验证码发送频率限制并记录在redis，设置过期时间
     *
     * @param verificationCode
     * @return
     */
    public boolean checkVerificationCodeRedis(String account, String verificationCode) {
        if (!stringRedisTemplate.hasKey(account)) {
            stringRedisTemplate.opsForValue().set(account, verificationCode, 15, TimeUnit.MINUTES);
            stringRedisTemplate.opsForValue().increment(account + "_incr");
            stringRedisTemplate.expire(account + "_incr", 15, TimeUnit.MINUTES);
            return true;
        } else if (stringRedisTemplate.hasKey(account)) {
            int i = Integer.parseInt(stringRedisTemplate.opsForValue().get(account + "_incr"));
            if (i < redisEmailLimt) {
                stringRedisTemplate.opsForValue().set(account, verificationCode, 15, TimeUnit.MINUTES);
                stringRedisTemplate.opsForValue().increment(account + "_incr");
                stringRedisTemplate.expire(account + "_incr", 15, TimeUnit.MINUTES);
                return true;
            }

        }

        return false;
    }

}
