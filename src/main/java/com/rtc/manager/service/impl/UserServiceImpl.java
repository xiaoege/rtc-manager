package com.rtc.manager.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rtc.manager.dao.RtcUserMapper;
import com.rtc.manager.entity.RtcUser;
import com.rtc.manager.entity.dto.RtcUserDTO;
import com.rtc.manager.service.UserService;
import com.rtc.manager.util.EmailUtils;
import com.rtc.manager.vo.ResultData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private static final String EMAIL_CODE_702 = "验证码发送次数过多，请15分钟稍后再试";
    private static final String EMAIL_CODE_703 = "验证码发送失败";
    private static final String EMAIL_CODE_704 = "该邮箱尚未发送验证码";
    private static final String EMAIL_CODE_705 = "数据有误";
    private static final String EMAIL_CODE_706 = "请输入验证码";
    private static final String EMAIL_CODE_707 = "验证码错误";

    @Value("${rtc.mail.redisEmailLimt}")
    private Integer redisEmailLimt;

    static {
        JAVA_MAIL_SENDER = new JavaMailSenderImpl();
        JAVA_MAIL_SENDER.setHost("smtp.sina.com");
        JAVA_MAIL_SENDER.setUsername("c237113730@sina.com");
        JAVA_MAIL_SENDER.setPassword("88a169c98a5fd127");
        JAVA_MAIL_SENDER.setDefaultEncoding("UTF-8");

    }


    @Override
    public ResultData checkEmaillRegistered(String emaill) {
        // 正则判断是否是邮箱
        if (!EmailUtils.checkEmailRegex(emaill)) {
            return ResultData.FAIL(emaill, 700, EMAIL_CODE_700);
        } else if (rtcUserMapper.checkEmaillRegistered(emaill) != null) {
            return ResultData.FAIL(emaill, 701, EMAIL_CODE_701);
        }

        // 验证码
        String verificationCode = EmailUtils.getVerificationCode();

        // 验证，15分钟内最多发5次，一个验证码有效期15分钟
        if (checkVerificationCodeRedis(emaill, verificationCode)) {
            // 发送邮件验证码
            EmailUtils.sendEmailVerificationCode(emaill, verificationCode);
            return ResultData.SUCCESS(emaill, "验证码已发送");
        } else if (!checkVerificationCodeRedis(emaill, verificationCode)) {
            return ResultData.FAIL(emaill, 702, EMAIL_CODE_702);
        }

        return ResultData.FAIL(emaill, 703, EMAIL_CODE_703);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultData register(String data) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        RtcUserDTO rtcUserDTO = objectMapper.readValue(data, RtcUserDTO.class);

        if (rtcUserDTO == null) {
            return ResultData.FAIL(data, 705, EMAIL_CODE_705);
        }
        RtcUser rtcUser = new RtcUser();
        BeanUtils.copyProperties(rtcUserDTO, rtcUser);

        String email = rtcUserDTO.getEmail();

        // 邮箱格式错误
        if (!EmailUtils.checkEmailRegex(email)) {
            return ResultData.FAIL(email, 700, EMAIL_CODE_700);
            // 邮箱已注册
        } else if (rtcUserMapper.checkEmaillRegistered(email) != null) {
            return ResultData.FAIL(email, 701, EMAIL_CODE_701);
            // 没发过验证码
        } else if (!stringRedisTemplate.hasKey(email)) {
            return ResultData.FAIL(email, 704, EMAIL_CODE_704);
        } else if (rtcUserDTO.getVerificationCode() == null) {
            // 没填验证码
            return ResultData.FAIL(email, 705, EMAIL_CODE_706);
        }
        String verificationCodeRedis = stringRedisTemplate.opsForValue().get(email);
        if (rtcUserDTO.getVerificationCode().equals(verificationCodeRedis)) {
            rtcUserMapper.insertSelective(rtcUser);
            return ResultData.SUCCESS(data, "注册成功");
        }
        return ResultData.FAIL(data, 707, EMAIL_CODE_707);
    }


    /**
     * 检验验证码
     *
     * @param verificationCode
     * @return
     */
    public boolean checkVerificationCodeRedis(String email, String verificationCode) {
        if (!stringRedisTemplate.hasKey(email)) {
            stringRedisTemplate.opsForValue().set(email, verificationCode, 15, TimeUnit.MINUTES);
            stringRedisTemplate.opsForValue().increment(email + "_incr");
            return true;
        } else if (stringRedisTemplate.hasKey(email)) {
            int i = Integer.parseInt(stringRedisTemplate.opsForValue().get(email + "_incr"));
            if (i <= redisEmailLimt) {
                stringRedisTemplate.opsForValue().set(email, verificationCode, 15, TimeUnit.MINUTES);
                stringRedisTemplate.opsForValue().increment(email + "_incr");
                return true;
            }

        }

        return false;
    }

}
