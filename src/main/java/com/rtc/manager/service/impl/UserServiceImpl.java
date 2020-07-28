package com.rtc.manager.service.impl;

import com.rtc.manager.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

/**
 * @author ChenHang
 */
@Service
public class UserServiceImpl implements UserService {

    public static void main(String[] args) {
        sendEmailVerificationCode();
    }

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private static final JavaMailSenderImpl JAVA_MAIL_SENDER;

    static {
        JAVA_MAIL_SENDER = new JavaMailSenderImpl();
        JAVA_MAIL_SENDER.setHost("smtp.sina.com");
        JAVA_MAIL_SENDER.setUsername("c237113730@sina.com");
        JAVA_MAIL_SENDER.setPassword("88a169c98a5fd127");
        JAVA_MAIL_SENDER.setDefaultEncoding("UTF-8");

//        Properties properties = new Properties();
//        JAVA_MAIL_SENDER.setJavaMailProperties(null);

    }


    public boolean checkEmaillRegistered(String emaill) {
        //正则判断是否是邮箱

        //判断是否注册过

        return false;
    }

    public static boolean sendEmailVerificationCode() {
        //redis防止重复请求

        //发送邮箱验证码
        try {
            MimeMessage message = JAVA_MAIL_SENDER.createMimeMessage();
            message.addHeader("X-Mailer", "Microsoft Outlook Express 6.00.2900.2869");
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("c237113730@sina.com", "xiaoe");
            helper.setTo("237113730@qq.com");
            helper.setSubject("测试邮件");
            helper.setText("测试内容", true);

            JAVA_MAIL_SENDER.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
