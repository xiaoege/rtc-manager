package com.rtc.manager.service;

import com.rtc.manager.vo.ResultData;

/**
 * @author ChenHang
 */
public interface UserService {
    /**
     * 邮箱验证是否已注册，发送验证码
     * @param email
     * @return
     */
    ResultData checkEmaillRegistered(String email);

    /**
     * 注册
     * @param data
     * @return
     */
    ResultData register(String data) throws Exception;
}
