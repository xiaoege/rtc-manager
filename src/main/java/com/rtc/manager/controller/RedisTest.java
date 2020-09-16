package com.rtc.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author ChenHang
 */
@RestController
@RequestMapping("redis")
public class RedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("test")
    public Object test(@RequestParam(name = "key", required = false) String key) {
//        stringRedisTemplate.boundValueOps()
        String str = "妙";
        byte[] bytes = str.getBytes();
        stringRedisTemplate.getClientList();

        return null;
    }

}
