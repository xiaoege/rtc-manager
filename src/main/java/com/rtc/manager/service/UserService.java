package com.rtc.manager.service;

import com.rtc.manager.vo.ResultData;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ChenHang
 */
public interface UserService {
    /**
     * 邮箱验证是否已注册，发送验证码
     *
     * @param email
     * @return
     */
    ResultData checkEmaillRegistered(String email);

    /**
     * 邮箱注册
     *
     * @param data
     * @return
     */
    ResultData emailRegister(String data) throws Exception;

    /**
     * 校验手机，发送验证码
     *
     * @param phone
     * @param countryCode
     * @return
     */
    ResultData verificationCodeRegistered(String phone, String countryCode);

    /**
     * 手机注册
     *
     * @param user
     * @param request
     * @return
     */
    ResultData phoneRegister(String user, HttpServletRequest request) throws Exception;


    /**
     * 修改用户基本信息
     *
     * @param user
     */
    ResultData updateUser(String user) throws Exception;

    /**
     * 修改密码
     * @param oldPassword
     * @param newPassword
     * @param retypePassword
     */
    void updatePassword(String oldPassword, String newPassword, String retypePassword);

    /**
     * 忘记密码，通过手机号发送验证码
     * @param phone
     * @param countryCode
     */
    void forgetPasswordSendVerificationCode(String phone, String countryCode);

    /**
     * 检验手机号相对应的验证码
     * @param phone
     * @param countryCode
     * @param verificationCode
     * @return
     */
    ResultData checkVerificationCode(String phone, String countryCode, String verificationCode);
}
