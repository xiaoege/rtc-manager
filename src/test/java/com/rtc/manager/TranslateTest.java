package com.rtc.manager;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ChenHang
 */
public class TranslateTest {

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String url = "http://api.fanyi.baidu.com/api/trans/vip/translate";
        String q = "";
        String from = "zh";
        String to = "en";
        String appid = "20200722000524091";
        String salt = "";
        String sign = "";
        String data = "";
//        byte[] decode = Base64.getDecoder().decode(url);
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] digest = messageDigest.digest(url.getBytes());
        System.out.println(new String(digest,"UTF-8"));

    }

}
