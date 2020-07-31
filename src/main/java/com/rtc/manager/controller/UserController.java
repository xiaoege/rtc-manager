package com.rtc.manager.controller;

import com.rtc.manager.service.UserService;
import com.rtc.manager.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author ChenHang
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public ResultData register(@RequestBody String data) throws Exception {
        //校验验证码,注册
        ResultData resultData = userService.register(data);

        return resultData;
    }

    /**
     * 校验邮箱，发送验证码
     * @param email
     * @return
     */
    @PostMapping("checkEmaillRegistered")
    public ResultData checkEmaillRegistered(@RequestParam(name = "email") String email) {
        ResultData resultData = userService.checkEmaillRegistered(email);

        return resultData;
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @PostMapping("login")
    public ResultData login(@RequestBody String user) {


        return null;
    }

}
