package com.rtc.manager.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.util.StringUtils;

import javax.mail.internet.MimeMessage;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ChenHang
 */
public class EmailUtils {


    /**
     * 验证是否为邮箱
     */
    private final static Pattern PATTERN_EMAIL = Pattern.compile("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");

    private static JavaMailSenderImpl JAVA_MAIL_SENDER;

    static {
        JAVA_MAIL_SENDER = new JavaMailSenderImpl();
        JAVA_MAIL_SENDER.setHost("smtp.sina.com");
        JAVA_MAIL_SENDER.setUsername("c237113730@sina.com");
        JAVA_MAIL_SENDER.setPassword("88a169c98a5fd127");
        JAVA_MAIL_SENDER.setDefaultEncoding("UTF-8");

    }

    public static boolean sendEmailVerificationCode(String email, String verificationCode) {
        //发送邮箱验证码
        try {
            MimeMessage message = JAVA_MAIL_SENDER.createMimeMessage();
            message.addHeader("X-Mailer", "Microsoft Outlook Express 6.00.2900.2869");
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("c237113730@sina.com", "xiaoe");
            helper.setTo(email);
            // 主题
            helper.setSubject("测试邮件");
            // 内容
            String text = "Welcome to register. Your verification code is " + verificationCode + " ,please use within 15 minutes.";
            text = "<p style='font-size=16px'>Welcome to register.</p>" +
                    "<p style='font-size=16px'>Your verification code is  <b>" + verificationCode + "</b>  ,please use within 15 minutes.</p>";
            helper.setText(text, true);

            JAVA_MAIL_SENDER.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 验证邮箱格式
     *
     * @param email
     * @return
     */
    public static boolean checkEmailRegex(String email) {
        if (!StringUtils.isEmpty(email)) {
            Matcher matcher = PATTERN_EMAIL.matcher(email);
            return matcher.matches();
        }

        return false;
    }

    /**
     * 返回6位数字验证码
     *
     * @return String
     */
    public static String getVerificationCode() {
        BigDecimal bigDecimal = new BigDecimal(Math.random(), new MathContext(6, RoundingMode.HALF_UP));
        BigDecimal multiply = bigDecimal.multiply(new BigDecimal(Math.pow(10, 6)));
        DecimalFormat decimalFormat = new DecimalFormat("######");
        String format = decimalFormat.format(multiply);
        return format;
    }

    public static void main(String[] args) {
        String email = "237113730@qqcom";
    }
}
