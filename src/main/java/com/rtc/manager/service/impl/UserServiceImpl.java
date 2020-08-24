package com.rtc.manager.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rtc.manager.dao.RtcUserMapper;
import com.rtc.manager.entity.RtcUser;
import com.rtc.manager.entity.dto.PhoneRegisterDTO;
import com.rtc.manager.entity.dto.RtcUserDTO;
import com.rtc.manager.service.UserService;
import com.rtc.manager.util.UserUtils;
import com.rtc.manager.vo.ResultData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
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
    public ResultData checkPhoneRegistered(String phone, String countryCode) {
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
    @Override
    public ResultData phoneRegister(String user, HttpServletRequest request) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        PhoneRegisterDTO phoneRegisterDTO = objectMapper.readValue(user, PhoneRegisterDTO.class);
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
        if (phone == null || verificationCode == null || password == null || retypePassword == null) {
            return ResultData.FAIL(user, 705, CODE_705);
        }

        // todo 手机号格式验证
        if (phone == null || countryCode == null) {
            return ResultData.FAIL(phone, 800, PHONE_CODE_800);
        }


        // todo 密码格式验证
        // 密码验证
        if (!password.equals(retypePassword)) {
            return ResultData.FAIL(user, 705, CODE_705);
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
        rtcUserMapper.insertSelective(rtcUser);

        return ResultData.SUCCESS(user, "注册成功");
    }


    /**
     * 修改用户基本信息
     *
     * @param user
     */
    @Override
    public void updateUser(String user) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        RtcUser rtcUser = objectMapper.readValue(user, RtcUser.class);
        String nickname = rtcUser.getNickname();
        if (nickname != null) {
            // 验证昵称格式
            if (!UserUtils.checkNicknameFormat(nickname)) {

            }
            // 检验昵称是否存在
        }
        // todo 修改mapper
        rtcUserMapper.updateByPrimaryKeySelective(rtcUser);
    }

    /**
     * 修改密码
     *
     * @param oldPassword
     * @param newPassword
     * @param retypePassword
     */
    @Override
    public void updatePassword(String oldPassword, String newPassword, String retypePassword) {
        if (newPassword == null || retypePassword == null || !newPassword.equals(retypePassword)) {

        }
        // todo 校验密码格式
        if (UserUtils.checkPasswordFormat(newPassword)) {
            HashMap<String, String> principal = (HashMap) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = principal.get("username");
            RtcUserDTO rtcUserDTO = rtcUserMapper.selectByPhoneOrAccount(username);
            RtcUser rtcUser = new RtcUser();
            rtcUser.setId(rtcUserDTO.getId());
            rtcUser.setPassword(UserUtils.hexBCryptPassword(newPassword));
            // 注意此时的昵称和手机号都是登录账号，谨防昵称在没有限制的条件下会是别人的手机号
            rtcUserMapper.updateByPrimaryKeySelective(rtcUser);
        }

    }

    /**
     * 忘记密码，通过手机号发送验证码
     *
     * @param phone
     * @param countryCode
     */
    @Override
    public void forgetPasswordSendVerificationCode(String phone, String countryCode) {
        // 手机号格式校验

        // 该手机号尚未注册
        if (rtcUserMapper.checkPhoneRegistered(phone) == null) {

        }

        // 发送验证码
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
        // 该手机号尚未注册
        if (rtcUserMapper.checkPhoneRegistered(phone) == null) {

        }
        // 该手机号尚未发送验证码
        if (!stringRedisTemplate.hasKey(phone)) {

        }
        if (verificationCode.equals(stringRedisTemplate.opsForValue().get(phone))) {

        }
        return ResultData.FAIL(verificationCode, 0);
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
