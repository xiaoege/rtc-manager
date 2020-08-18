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
     * 邮箱注册
     * @param data
     * @return
     */
    ResultData emailRegister(String data) throws Exception;

    /**
     * 校验手机，发送验证码
     * @param phone
     * @return
     */
    ResultData checkPhoneRegistered(String phone);

    /**
     * 手机注册
     * @param user
     * @return
     */
    ResultData phoneRegister (String user)throws Exception;

    /**
     * 登录
     * @param user
     */
    void login(String user);
}
