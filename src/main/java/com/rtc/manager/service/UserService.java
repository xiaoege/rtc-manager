package com.rtc.manager.service;

import com.rtc.manager.vo.ResultData;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;

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
    ResultData checkEmailRegistered(String email);

    /**
     * 邮箱注册
     *
     * @param user
     * @return
     */
    ResultData emailRegister(HttpServletRequest request, String user) throws Exception;

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
     *
     * @param user
     * @return 修改密码后生成新的JWT，废弃原JWT
     */
    ResultData updatePassword(String user, HttpServletRequest request) throws Exception;

    /**
     * 忘记密码，通过手机号发送验证码
     *
     * @param phone
     * @param countryCode
     */
    ResultData sendPhoneVerificationCode(String phone, String countryCode);

    /**
     * 检验手机号相对应的验证码
     *
     * @param phone
     * @param countryCode
     * @param verificationCode
     * @return
     */
    ResultData checkVerificationCode(String phone, String countryCode, String verificationCode);

    /**
     * 查询用户信息，从header里读取用户账号
     *
     * @param request
     * @return
     */
    ResultData getUserInformation(HttpServletRequest request);

    /**
     * 忘记密码-修改密码
     *
     * @param user
     * @return
     */
    ResultData forgetPassword(String user);

    /**
     * 更换手机号
     *
     * @param user
     * @return
     */
    ResultData changePhone(String user);

    /**
     * 更换手机号-通过手机号发送验证码
     *
     * @param phone
     * @param countryCode
     * @return
     */
    ResultData send4ChangePhone(String phone, String countryCode);

    /**
     * 上传头像,保存在临时文件夹
     *
     * @param file
     * @return
     */
    ResultData uploadPortrait(MultipartFile file) throws FileNotFoundException, Exception;

    /**
     * 添加到收藏夹/从收藏夹移除
     *
     * @param body
     * @return
     */
    ResultData modifyFavourite(String body);


    /**
     * 查看收藏夹列表
     *
     * @return
     */
    ResultData listFavourite(String sort, int pageNum, int pageSize) throws IOException;

    /**
     * 我的收藏-移除收藏
     *
     * @param body
     * @return
     */
    ResultData removeFavourite(String body);

    /**
     * 新增评论
     *
     * @param body
     * @return
     */
    ResultData saveComment(String body);

    /**
     * 翻译评论
     *
     * @param commentId
     * @return
     */
    ResultData translateComment(Integer commentId) throws Exception;

    /**
     * 更换邮箱-通过邮箱发送验证码
     *
     * @param email
     * @return
     */
    ResultData send4ChangeEmail(String email);

    /**
     * 更换邮箱-更换成功后删除验证码
     *
     * @param body
     * @return
     */
    ResultData changeEmail(String body);

    /**
     * 忘记密码-邮箱-发送验证码
     *
     * @param email
     * @return
     */
    ResultData send4ForgetEmailPassword(String email);

    /**
     * 忘记密码-邮箱-校验验证码
     *
     * @param body
     * @return
     */
    ResultData check4ForgetEmailPassword(String body);

    /**
     * 忘记密码-邮箱-修改密码
     *
     * @param body
     * @return
     */
    ResultData forgetEmailPassword(String body);

    /**
     * 权限管理
     *
     * @return
     */
    ResultData authorizeUser(String body) throws Exception;

    /**
     * 冻结用户
     * @param body
     * @return
     * @throws Exception
     */
    ResultData freezeUser(String body) throws Exception;

    /**
     * 删除用户
     * @param body
     * @return
     * @throws Exception
     */
    ResultData deleteUser(String body) throws Exception;
}
