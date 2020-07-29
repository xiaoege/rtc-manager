package com.rtc.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChenHang
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("register")
    public String register() {
        Boolean hasKey = stringRedisTemplate.hasKey("cat");
        if (hasKey) {
            ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
            String cat = ops.get("cat");
            stringRedisTemplate.delete("cat");
            return cat;
        }
        return "register";
    }
}
