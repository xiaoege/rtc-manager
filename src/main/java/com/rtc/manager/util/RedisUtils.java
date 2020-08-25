package com.rtc.manager.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author ChenHang
 */
@Component
public class RedisUtils {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public Set<String> listKey() {
        Set<String> keys = stringRedisTemplate.keys("*");
        return keys;
    }

    public String getValue(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    public boolean hasKey(String key) {
        return stringRedisTemplate.hasKey(key);
    }
}
