package com.rtc.manager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rtc.manager.entity.dto.RtcUserDTO;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * @author ChenHang
 */
public class PassworkTest {
    public static void main(String[] args) throws JsonProcessingException {
        String password = "123qwe654";
        String salt = UUID.randomUUID().toString();
        String salt1 = "9981";
        String hex = DigestUtils.md5DigestAsHex((DigestUtils.md5DigestAsHex((password + salt).getBytes()) + salt1).getBytes());

        System.out.println(1);

    }
}
