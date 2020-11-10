package com.rtc.manager.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author ChenHang
 */
@ApiIgnore
@RestController
@RequestMapping("redis")
public class RedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("test")
    public Object test(@RequestParam(name = "key", required = false) String key) throws JsonProcessingException {
//        stringRedisTemplate.boundValueOps()
        String str = "妙";
        byte[] bytes = str.getBytes();
        stringRedisTemplate.getClientList();


        return null;
    }

}
