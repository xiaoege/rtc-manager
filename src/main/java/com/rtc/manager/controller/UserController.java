package com.rtc.manager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChenHang
 */
@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping("register")
    public String register() {

        return "register";
    }
}
