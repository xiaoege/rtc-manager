package com.rtc.manager;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author ChenHang
 */
public class BCryptTest {
    public static void main(String[] args) {
        String password = "喵帕斯";
        String password1 = "喵帕斯";
        String password2 = "莲华";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(password);
        String encode1 = encoder.encode(password1);
        String encode2 = encoder.encode(password2);
        boolean b = encoder.matches("喵帕斯", encode);


        System.out.println("🐱");
    }
}
