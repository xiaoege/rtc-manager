package com.rtc.manager.service;

import com.rtc.manager.vo.ResultData;
import org.springframework.web.multipart.MultipartFile;

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
     * 修改用户基本信息，成功后返回该用户的最新信息 + 新昵称/旧昵称的token
     *
     * @param user
     * @param request
     */
    ResultData updateUser(String user, HttpServletRequest request) throws Exception;

    /**
     * 修改密码
     * @param user
     */
    ResultData updatePassword(String user) throws Exception;

    /**
     * 忘记密码，通过手机号发送验证码
     * @param phone
     * @param countryCode
     */
    ResultData sendPhoneVerificationCode(String phone, String countryCode);

    /**
     * 检验手机号相对应的验证码
     * @param phone
     * @param countryCode
     * @param verificationCode
     * @return
     */
    ResultData checkVerificationCode(String phone, String countryCode, String verificationCode);

    /**
     * 查询用户信息，从header里读取用户账号
     * @return
     * @param request
     */
    ResultData getUserInformation(HttpServletRequest request);

    /**
     * 忘记密码-修改密码
     * @param user
     * @return
     */
    ResultData forgetPassword(String user);

    /**
     * 更换手机号
     * @param user
     * @return
     */
    ResultData changePhone(String user);

    /**
     * 更换手机号-通过手机号发送验证码
     * @param phone
     * @param countryCode
     * @return
     */
    ResultData send4ChangePhone(String phone, String countryCode);

    /**
     * 上传头像
     * @param file
     * @return
     */
    ResultData uploadPortrait(MultipartFile file);
}
