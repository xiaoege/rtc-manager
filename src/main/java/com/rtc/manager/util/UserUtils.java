package com.rtc.manager.util;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import javax.mail.internet.MimeMessage;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ChenHang
 */
public class UserUtils {


    /**
     * 验证是否为邮箱
     */
    private final static Pattern PATTERN_EMAIL = Pattern.compile("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");

    /**
     * 验证昵称，可以有字母，数字，下划线，点。3-30个字符之间，不能以Comcheck开头，只能以字母开头
     */
    private final static Pattern PATTERN_NICKNAME = Pattern.compile("^[A-Za-z][A-Za-z0-9_.]{2,29}$");

    /**
     * 验证密码，可以有字母，数字，5-15个字符之间，只能以字母开头
     */
    private final static Pattern PATTERN_PASSWORD = Pattern.compile("^[A-Za-z][A-Za-z0-9]{4,14}$");

    private static JavaMailSenderImpl JAVA_MAIL_SENDER;

    static {
        JAVA_MAIL_SENDER = new JavaMailSenderImpl();
        JAVA_MAIL_SENDER.setHost("smtp.sina.com");
        JAVA_MAIL_SENDER.setUsername("c237113730@sina.com");
        JAVA_MAIL_SENDER.setPassword("88a169c98a5fd127");
        JAVA_MAIL_SENDER.setDefaultEncoding("UTF-8");

    }

    /**
     * 发送邮箱验证码
     *
     * @param email
     * @param verificationCode
     * @return
     */
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

    /**
     * 密码md5加密
     *
     * @param password
     * @return password和salt的map
     */
    public static Map<String, String> hexPassword(String password) {
        Map map = new HashMap();
        String salt = UUID.randomUUID().toString();
        String salt1 = "9981";
        String hex = DigestUtils.md5DigestAsHex((DigestUtils.md5DigestAsHex((password + salt).getBytes()) + salt1).getBytes());

        map.put("password", hex);
        map.put("salt", salt);
        return map;
    }

    /**
     * 验证密码，可以有字母，数字，5-15个字符之间，只能以字母开头
     *
     * @param password 加密前的密码
     * @return boolean
     */
    public static boolean checkPasswordFormat(String password) {
        if (password != null) {
            Matcher matcher = PATTERN_PASSWORD.matcher(password);
            if (matcher.matches()) {
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * 校验昵称格式，可以有字母，数字，下划线，点，3-30个字符之间，不能以Comcheck开头，只能以字母开头
     *
     * @param nickname
     */
    public static boolean checkNicknameFormat(String nickname) {
        if (nickname != null && !nickname.toLowerCase().startsWith("comcheck")) {
            Matcher matcher = PATTERN_NICKNAME.matcher(nickname);
            if (matcher.matches()) {
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * BCrypt加密密码
     */
    public static String hexBCryptPassword(String password) {
        if (password == null) {
            return null;
        }
        return new BCryptPasswordEncoder().encode(password);
    }

    /**
     * 创建token
     */
    public static String getToken(String name) {
        if (name != null) {
            String salt = "9981";
            return "Bearer " + DigestUtils.md5DigestAsHex((name + salt).getBytes());
        }
        return "";
    }


    public static void main(String[] args) {
        String str = "189517887331";
//        str = "12345678901";
        System.out.println(checkPhoneFormat(str));

    }

    /**
     * 检验手机号格式
     *
     * @param phone
     * @return
     */
    public static boolean checkPhoneFormat(String phone) {
        boolean flag = false;
        try {
            PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
            Phonenumber.PhoneNumber phoneNumber = null;
            // 需要传入国家代码，如果不传，phone则必须以+开头
            phoneNumber = phoneUtil.parse(phone, "CN");
            Phonenumber.PhoneNumber.CountryCodeSource countryCodeSource = phoneNumber.getCountryCodeSource();
            // 验证是否是一个正确的手机号，注意以防运营商对手机号段发生变化
            boolean validNumber = phoneUtil.isValidNumber(phoneNumber);
            // 可能是一个正确的手机号（只验证格式）
            boolean possibleNumber = phoneUtil.isPossibleNumber(phoneNumber);

            flag = validNumber;
        } catch (NumberParseException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
