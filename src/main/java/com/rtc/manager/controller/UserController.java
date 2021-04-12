package com.rtc.manager.controller;

import com.rtc.manager.entity.dto.PhoneRegisterDTO;
import com.rtc.manager.service.UserService;
import com.rtc.manager.vo.ResultData;
import com.rtc.manager.vo.SearchEnterpriseListVO;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author ChenHang
 */
@Api(tags = "用户接口")
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * @param data
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "邮箱注册,注册成功后删除验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", name = "user", required = true, value = "{\n" +
                    "\"email\": \"邮箱\",\n" +
                    "\"password\": \"注册密码\",\n" +
                    "\"retypePassword\": \"注册密码-确认\",\n" +
                    "\"verificationCode\": \"验证码\"" +
                    "\n}")
    })
    @ApiResponses({
            @ApiResponse(code = 705, message = "数据有误"),
            @ApiResponse(code = 707, message = "邮箱验证码错误"),
            @ApiResponse(code = 850, message = "邮箱格式错误"),
            @ApiResponse(code = 851, message = "邮箱已注册"),
            @ApiResponse(code = 852, message = "该邮箱尚未发送验证码")
    })
    @PostMapping("emailRegister")
    public ResultData emailRegister(@RequestBody String user, HttpServletRequest request) throws Exception {
        //校验验证码,注册
        ResultData resultData = userService.emailRegister(request, user);

        return resultData;
    }

    /**
     * 邮箱注册-校验邮箱，发送验证码
     *
     * @param email
     * @return
     */
    @ApiOperation("邮箱注册-校验邮箱，发送验证码")
    @ApiResponses({
            @ApiResponse(code = 850, message = "邮箱格式错误"),
            @ApiResponse(code = 851, message = "邮箱已注册"),
            @ApiResponse(code = 702, message = "验证码发送次数过多，请15分钟稍后再试"),
            @ApiResponse(code = 703, message = "验证码发送失败")
    })
    @ApiImplicitParam(name = "email", value = "邮箱", required = true)
    @PostMapping("checkEmailRegistered")
    public ResultData checkEmailRegistered(@RequestParam(name = "email") String email) {
        ResultData resultData = userService.checkEmailRegistered(email);

        return resultData;
    }

    /**
     * 更换邮箱-通过邮箱发送验证码
     *
     * @param phone
     * @return
     */
    @ApiOperation(value = "更换邮箱-通过邮箱发送验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer c699ffecd5ce5afc2efc849b4bad0d6c", paramType = "header", required = true, example = "Bearer c699ffecd5ce5afc2efc849b4bad0d6c"),
            @ApiImplicitParam(name = "user", paramType = "body", value = "{\n" +
                    "\"email\":\"邮箱\"" +
                    "\n}", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "{\n" +
                    "    \"message\": \"发送验证码成功\",\n" +
                    "    \"data\": null,\n" +
                    "    \"code\": 200\n" +
                    "}"),
            @ApiResponse(code = 702, message = "验证码发送次数过多，请15分钟稍后再试"),
            @ApiResponse(code = 703, message = "验证码发送失败"),
            @ApiResponse(code = 850, message = "邮箱格式错误"),
            @ApiResponse(code = 851, message = "该邮箱已注册"),
            @ApiResponse(code = 855, message = "邮箱不能与原来相同")
    })
    @PostMapping("send4ChangeEmail")
    public ResultData send4ChangeEmail(@RequestBody HashMap<String, String> user) {
        String email = user.get("email");
        return userService.send4ChangeEmail(email);
    }

    /**
     * 更换邮箱-更换成功后删除验证码
     *
     * @return
     */
    @ApiOperation(value = "更换邮箱-更换成功后删除验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer c699ffecd5ce5afc2efc849b4bad0d6c", paramType = "header", required = true, example = "Bearer c699ffecd5ce5afc2efc849b4bad0d6c"),
            @ApiImplicitParam(name = "body", value = "{\n" +
                    "    \"email\": \"邮箱\",\n" +
                    "    \"verificationCode\": \"验证码\"" +
                    "\n}", paramType = "body", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 707, message = "验证码错误"),
            @ApiResponse(code = 850, message = "邮箱格式错误"),
            @ApiResponse(code = 851, message = "邮箱已注册"),
            @ApiResponse(code = 852, message = "该邮箱尚未发送验证码"),
            @ApiResponse(code = 855, message = "邮箱不能与原来相同")
    })
    @PostMapping("changeEmail")
    public ResultData changeEmail(@RequestBody String body) {
        return userService.changeEmail(body);
    }

    /**
     * 手机注册,注册成功后删除验证码
     *
     * @param user
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "手机注册,注册成功后删除验证码")
    @ApiImplicitParam(name = "user", paramType = "body", value = "{\n" +
            "\"phone\":\"手机号\",\n" +
            "\"countryCode\":\"手机号国家代码\",\n" +
            "\"password\":\"密码\",\n" +
            "\"retypePassword\":\"确认密码\",\n" +
            "\"verificationCode\":\"验证码\"" +
            "\n}", required = true)
    @ApiResponses({
            @ApiResponse(code = 705, message = "数据有误"),
            @ApiResponse(code = 707, message = "验证码错误"),
            @ApiResponse(code = 800, message = "手机号格式错误"),
            @ApiResponse(code = 801, message = "手机号已注册"),
            @ApiResponse(code = 804, message = "该手机号尚未发送验证码"),
            @ApiResponse(code = 903, message = "密码格式错误")
    })
    @PostMapping("phoneRegister")
    public ResultData<PhoneRegisterDTO> phoneRegister(@RequestBody String user,
                                                      HttpServletRequest request) throws Exception {
        ResultData resultData = userService.phoneRegister(user, request);

        return resultData;
    }

    /**
     * 注册-校验手机，发送验证码
     *
     * @return
     */
    @ApiOperation(value = "注册-校验手机，发送验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "map", required = true, paramType = "body", value = "{\n" +
                    "\"phone\":\"手机号\",\n" +
                    "\"countryCode\":\"手机号国家代码\"\n" +
                    "\n}"),
    })
    @ApiResponses({
            @ApiResponse(code = 702, message = "验证码发送次数过多，请15分钟稍后再试"),
            @ApiResponse(code = 703, message = "验证码发送失败"),
            @ApiResponse(code = 800, message = "手机号格式错误"),
            @ApiResponse(code = 801, message = "手机号已注册")
    })
    @PostMapping("verificationCodeRegistered")
    public ResultData verificationCodeRegistered(@RequestBody(required = true) HashMap<String, String> map) {
        String phone = map.get("phone");
        String countryCode = map.get("countryCode");
        ResultData resultData = userService.verificationCodeRegistered(phone, countryCode);
        return resultData;
    }

    /**
     * 修改用户基本信息，成功后返回该用户的最新信息
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "修改用户基本信息", notes = "成功后返回该用户的最新信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer c699ffecd5ce5afc2efc849b4bad0d6c", paramType = "header", required = true, example = "Bearer c699ffecd5ce5afc2efc849b4bad0d6c"),
            @ApiImplicitParam(name = "user", value = "{\n" +
                    "    \"nickname\": \"昵称\",\n" +
                    "    \"synopsis\": \"简介\",\n" +
                    "    \"country\": \"国家\",\n" +
                    "    \"enterprise\": \"公司\",\n" +
                    "    \"address\": \"地址\",\n" +
                    "}", paramType = "body", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 901, message = "昵称格式错误"),
            @ApiResponse(code = 902, message = "昵称已存在")
    })
    @PutMapping("updateUser")
    public ResultData updateUser(@RequestBody String user, HttpServletRequest request) throws Exception {
        return userService.updateUser(user, request);
    }

    /**
     * 根据原始密码修改密码
     *
     * @param oldPassword    oldPassword
     * @param newPassword    newPassword
     * @param retypePassword retypePassword
     * @return
     */
    @ApiOperation(value = "根据原始密码修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer c699ffecd5ce5afc2efc849b4bad0d6c", paramType = "header", required = true, example = "Bearer c699ffecd5ce5afc2efc849b4bad0d6c"),
            @ApiImplicitParam(name = "user", value = "{\n" +
                    "    \"oldPassword\":\"原密码\",\n" +
                    "    \"newPassword\":\"新密码\",\n" +
                    "    \"retypePassword\":\"新密码-确认\"\n" +
                    "}", paramType = "body", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 903, message = "密码格式错误"),
            @ApiResponse(code = 1004, message = "原始密码错误")
    })
    @PutMapping("updatePassword")
    public ResultData updatePassword(@RequestBody String user) throws Exception {
        return userService.updatePassword(user);
    }

    /**
     * 忘记密码-通过手机号发送验证码
     *
     * @param phone
     * @return
     */
    @ApiOperation(value = "忘记密码-通过手机号发送验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "map", value = "{\n" +
                    "    \"phone\":\"手机号\",\n" +
                    "    \"countryCode\":\"手机号国家代码\"\n" +
                    "}", paramType = "body", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 702, message = "验证码发送次数过多，请15分钟稍后再试"),
            @ApiResponse(code = 703, message = "验证码发送失败"),
            @ApiResponse(code = 803, message = "国家代码与手机号不符"),
            @ApiResponse(code = 805, message = "该手机号尚未注册")
    })
    @PostMapping("sendPhoneVerificationCode")
    public ResultData sendPhoneVerificationCode(@RequestBody HashMap<String, String> map) {
        String phone = map.get("phone");
        String countryCode = map.get("countryCode");
        return userService.sendPhoneVerificationCode(phone, countryCode);
    }

    /**
     * 忘记密码-检验验证码
     *
     * @param phone
     * @param countryCode
     * @param verificationCode
     * @return
     */
    @ApiOperation(value = "忘记密码-检验验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "map", value = "{\n" +
                    "    \"phone\":\"手机号\",\n" +
                    "    \"countryCode\":\"手机号国家代码\",\n" +
                    "    \"verificationCode\":\"验证码\"\n" +
                    "}", paramType = "body", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 803, message = "国家代码与手机号不符"),
            @ApiResponse(code = 804, message = "该手机号尚未发送验证码"),
            @ApiResponse(code = 805, message = "该手机号尚未注册"),
            @ApiResponse(code = 200, message = "校验验证码成功"),
            @ApiResponse(code = 807, message = "校验验证码失败")
    })
    @PostMapping("checkVerificationCode")
    public ResultData checkVerificationCode(@RequestBody HashMap<String, String> map) {
        String phone = map.get("phone");
        String countryCode = map.get("countryCode");
        String verificationCode = map.get("verificationCode");
        return userService.checkVerificationCode(phone, countryCode, verificationCode);
    }

    /**
     * 忘记密码-手机-修改密码,修改成功后删除验证码
     *
     * @param user
     * @return
     */
    @ApiOperation("忘记密码-手机-修改密码,修改成功后删除验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "{\n" +
                    "    \"phone\":\"手机号\",\n" +
                    "    \"password\":\"新密码\",\n" +
                    "    \"retypePassword\":\"新密码-确认\",\n" +
                    "    \"countryCode\":\"手机号国家代码\",\n" +
                    "    \"verificationCode\":\"验证码\"\n" +
                    "}", paramType = "body", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 903, message = "密码格式错误"),
            @ApiResponse(code = 904, message = "新密码不能和原密码相同"),
            @ApiResponse(code = 804, message = "该手机号尚未发送验证码"),
            @ApiResponse(code = 707, message = "验证码错误"),
    })
    @PutMapping("forgetPassword")
    public ResultData forgetPassword(@RequestBody String user) {
        return userService.forgetPassword(user);
    }

    /**
     * 更换手机号-校验原始手机号
     */
    @ApiIgnore
    @Deprecated
    @ApiOperation(value = "更换手机号-校验原始手机号")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "{\"phone\":\"手机号\"}", paramType = "body", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 806, message = "输入的手机号和原始手机号不一致")
    }
    )
    @PostMapping("checkOriginalPhone")
    public ResultData checkOriginalPhone(@RequestBody String phone) {
        if (phone == null) {
            return ResultData.FAIL(null, 400, "数据有误");
        }
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!phone.equals(userDetails.getUsername())) {
            return ResultData.FAIL(null, 806, "输入的手机号和原始手机号不一致");
        }
        return ResultData.SUCCESS(null);
    }

    /**
     * 更换手机号-通过手机号发送验证码
     *
     * @param phone
     * @return
     */
    @ApiOperation(value = "更换手机号-通过手机号发送验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer c699ffecd5ce5afc2efc849b4bad0d6c", paramType = "header", required = true, example = "Bearer c699ffecd5ce5afc2efc849b4bad0d6c"),
            @ApiImplicitParam(name = "user", value = "{\n" +
                    "    \"phone\":\"新手机号\",\n" +
                    "    \"countryCode\":\"手机号国家代码\"" +
                    "\n}", paramType = "body", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "{\n" +
                    "    \"message\": \"发送验证码成功\",\n" +
                    "    \"data\": null,\n" +
                    "    \"code\": 200\n" +
                    "}"),
            @ApiResponse(code = 702, message = "验证码发送次数过多，请15分钟稍后再试"),
            @ApiResponse(code = 703, message = "验证码发送失败"),
            @ApiResponse(code = 801, message = "该手机号已注册"),
            @ApiResponse(code = 807, message = "新手机号不能和原来一样")
    })
    @PostMapping("send4ChangePhone")
    public ResultData send4ChangePhone(@RequestBody HashMap<String, String> user) {
        String phone = user.get("phone");
        String countryCode = user.get("countryCode");
        return userService.send4ChangePhone(phone, countryCode);
    }

    /**
     * 更换手机号,更换成功后删除验证码
     *
     * @return
     */
    @ApiOperation(value = "更换手机号,更换成功后删除验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer c699ffecd5ce5afc2efc849b4bad0d6c", paramType = "header", required = true, example = "Bearer c699ffecd5ce5afc2efc849b4bad0d6c"),
            @ApiImplicitParam(name = "user", value = "{\n" +
                    "    \"phone\": \"新手机号\",\n" +
                    "    \"countryCode\": \"手机号国家代码\",\n" +
                    "    \"verificationCode\": \"验证码\"\n" +
                    "}", paramType = "body", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 707, message = "验证码错误"),
            @ApiResponse(code = 801, message = "手机号已注册"),
            @ApiResponse(code = 804, message = "该手机号尚未发送验证码"),
            @ApiResponse(code = 807, message = "新手机号不能和原来一样")
    })
    @PostMapping("changePhone")
    public ResultData changePhone(@RequestBody String user) {
        return userService.changePhone(user);
    }

    /**
     * 上传头像
     */
    @ApiOperation(value = "上传头像")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer c699ffecd5ce5afc2efc849b4bad0d6c", paramType = "header", required = true, example = "Bearer c699ffecd5ce5afc2efc849b4bad0d6c"),
            @ApiImplicitParam(name = "file", value = "后缀名是jpg,jpeg,png,bmp格式的图片,大小在2MB以内", paramType = "form", dataType = "__file", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "{\n" +
                    "    \"message\": \"上传头像成功\",\n" +
                    "    \"data\": null,\n" +
                    "    \"code\": 200\n" +
                    "}"),
            @ApiResponse(code = 905, message = "头像文件格式错误"),
            @ApiResponse(code = 906, message = "请重新上传头像")
    })
    @PostMapping("uploadPortrait")
    public ResultData uploadPortrait(@RequestParam(name = "file", required = true) MultipartFile file) throws Exception {
        return userService.uploadPortrait(file);
    }

    @ApiOperation(value = "登录，此文档仅供参考，不可在swagger里调用，调用请使用/login路径", notes = "参数放在body里")
    @ApiResponses({
            @ApiResponse(code = 200, message = "{\n" +
                    "    \"code\": 200,\n" +
                    "    \"data\": {\n" +
                    "        \"Authorization\": \"token\",\n" +
                    "        \"role\": \"ROLE_USER\",\n" +
                    "        \"user\": {\n" +
                    "            \"nickname\": \"昵称\",\n" +
                    "            \"phone\": \"手机号\",\n" +
                    "            \"countryCode\": 手机号国家代码,\n" +
                    "            \"email\": \"邮箱\",\n" +
                    "            \"synopsis\": \"简介\",\n" +
                    "            \"country\": \"国家\",\n" +
                    "            \"enterprise\": \"企业\",\n" +
                    "            \"address\": \"地址\",\n" +
                    "            \"pid\": pid,\n" +
                    "            \"Authorization\": token\n" +
                    "        },\n" +
                    "        \"account\": \"账号\"\n" +
                    "    },\n" +
                    "    \"message\": \"登录成功\"\n" +
                    "}"),
            @ApiResponse(code = 1002, message = "{\n" +
                    "    \"code\": 1002\n" +
                    "    \"message\": \"该账号不存在\"\n" +
                    "}"), @ApiResponse(code = 1003, message = "{\n" +
            "    \"code\": 1003\n" +
            "    \"message\": \"密码错误\"\n" +
            "}")
    })
    @ApiImplicitParam(name = "", value = "参数示例：{\"username\":\"333\",\"password\":\"asd\"}", paramType = "body")
    @PostMapping("login")
    public String swagger_login() {
        return "请使用/login来调用";
    }

    @ApiOperation(value = "登出，此文档仅供参考，不可在swagger里调用，调用请使用/logout路径", notes = "参数放在header里")
    @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer c699ffecd5ce5afc2efc849b4bad0d6c", paramType = "header", required = true, example = "Bearer c699ffecd5ce5afc2efc849b4bad0d6c")
    @ApiResponses(
            @ApiResponse(code = 200, message = "{\n" +
                    "    \"code\": 200,\n" +
                    "    \"message\": \"登出成功\"\n" +
                    "}")
    )
    @PostMapping("logout")
    public String swagger_logout() {
        return "请使用/logout来调用";
    }


    /**
     * 查询用户信息，从header里读取用户账号
     *
     * @return
     */
    @ApiOperation(value = "查询用户信息", notes = "参数在header里")
    @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer c699ffecd5ce5afc2efc849b4bad0d6c", paramType = "header", required = true, example = "Bearer c699ffecd5ce5afc2efc849b4bad0d6c")
    @ApiResponses({
            @ApiResponse(code = 200, message = "{\n" +
                    "    \"message\": \"请求成功\",\n" +
                    "    \"data\": {\n" +
                    "        \"role\": \"角色\",\n" +
                    "        \"user\": {\n" +
                    "            \"nickname\": \"昵称\",\n" +
                    "            \"phone\": \"手机号\",\n" +
                    "            \"countryCode\": \"手机号国家代码\",\n" +
                    "            \"email\": \"邮箱\",\n" +
                    "            \"synopsis\": \"简介\",\n" +
                    "            \"country\": \"国家\",\n" +
                    "            \"enterprise\": \"公司\",\n" +
                    "            \"address\": \"地址\",\n" +
                    "            \"pid\": pid,\n" +
                    "            \"portrait\": \"头像url\",\n" +
                    "        }\n" +
                    "    },\n" +
                    "    \"code\": 200\n" +
                    "}")
    })
    @GetMapping("getUserInformation")
    public ResultData getUserInformation(HttpServletRequest request) {
        return userService.getUserInformation(request);
    }

    /**
     * 添加到收藏夹/从收藏夹移除(公司页面)
     *
     * @param body
     * @return
     */
    @ApiOperation(value = "添加到收藏夹/从收藏夹移除(公司页面)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer c699ffecd5ce5afc2efc849b4bad0d6c", paramType = "header", required = true, example = "Bearer c699ffecd5ce5afc2efc849b4bad0d6c"),
            @ApiImplicitParam(name = "body", value = "{\n" +
                    "    \"enterpriseId\":\"公司ID（内部）\",\n" +
                    "    \"nation\":\"国家\",\n" +
                    "    \"e_type\":\"地区\"\n" +
                    "}", paramType = "body", dataType = "string", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "{\n" +
                    "    \"message\": \"移除收藏成功\",\n" +
                    "    \"data\": 0,\n" +
                    "    \"code\": 200\n" +
                    "}或{\n" +
                    "    \"message\": \"添加收藏成功\",\n" +
                    "    \"data\": 1,\n" +
                    "    \"code\": 200\n" +
                    "}，data返回的是当前企业是否被当前用户所收藏，0未收藏，1收藏")
    })
    @PostMapping("modifyFavourite")
    public ResultData modifyFavourite(@RequestBody String body) {
        return userService.modifyFavourite(body);
    }


    /**
     * 我的收藏-移除收藏
     *
     * @param body
     * @return
     */
    @ApiOperation(value = "我的收藏-移除收藏")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer c699ffecd5ce5afc2efc849b4bad0d6c", paramType = "header", required = true, example = "Bearer c699ffecd5ce5afc2efc849b4bad0d6c"),
            @ApiImplicitParam(name = "body", value = "参数示例：{\n" +
                    "    \"pidArray\": [\n" +
                    "        11,14,15\n" +
                    "    ]\n" +
                    "}", paramType = "body", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "{\n" +
                    "    \"message\": \"移除收藏成功\",\n" +
                    "    \"data\": 200,\n" +
                    "    \"code\": 200\n" +
                    "}")
    })
    @PostMapping("removeFavourite")
    public ResultData removeFavourite(@RequestBody String body) {
        return userService.removeFavourite(body);
    }

    /**
     * 查看收藏夹列表，默认查看20个
     *
     * @return
     */
    @ApiOperation(value = "查看收藏夹列表，默认查看20个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer c699ffecd5ce5afc2efc849b4bad0d6c", paramType = "header", required = true, example = "Bearer c699ffecd5ce5afc2efc849b4bad0d6c"),
            @ApiImplicitParam(name = "sort", value = "默认根据添加时间倒序排列，在此基础上可以选择国家排列，字母排列不依照时间倒序。参数示例：nation：根据国家排列。e_name：根据字母排列"),
            @ApiImplicitParam(name = "pageNum", value = "当前页数，此接口的pageNum从1开始", required = false, defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "当前页大小", required = false, defaultValue = "20")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "{\n" +
                    "    \"message\": \"请求成功\",\n" +
                    "    \"data\": {\n" +
                    "        \"total\": 总数,\n" +
                    "        \"pageSize\": 当前页大小,\n" +
                    "        \"list\": [\n" +
                    "            {\n" +
                    "                \"eType\": \"公司所在地区(国家的次一级，例如美国的肯塔基州)\",\n" +
                    "                \"eName\": \"公司名\",\n" +
                    "                \"nation\": \"India\",\n" +
                    "                \"pid\": 73,\n" +
                    "                \"enterpriseId\": \"公司id-内部定义\",\n" +
                    "                \"legalRepresentative\": \"公司所在国家\",\n" +
                    "                \"establishmentDate\": \"成立日期\",\n" +
                    "                \"address\": \"公司地址\",\n" +
                    "                \"gmtCreate\": \"收藏时间\"\n" +
                    "            }" +
                    "        ],\n" +
                    "        \"pageNum\": 当前页\n" +
                    "    },\n" +
                    "    \"code\": 200\n" +
                    "}")
    })
    @GetMapping("listFavourite")
    public ResultData<SearchEnterpriseListVO> listFavourite(@RequestParam(name = "sort", required = false) String sort,
                                                            @RequestParam(name = "pageNum", required = false, defaultValue = "0") int pageNum,
                                                            @RequestParam(name = "pageSize", required = false, defaultValue = "20") int pageSize) throws IOException {
        // 此处的pageNum在es里从0开始
        if (pageNum < 2) {
            pageNum = 0;
        } else {
            pageNum -= 1;
        }
        return userService.listFavourite(sort, pageNum, pageSize);
    }

    /**
     * 新增评论
     *
     * @param body
     * @return
     */
    @ApiOperation(value = "新增评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer c699ffecd5ce5afc2efc849b4bad0d6c", paramType = "header", required = true, example = "Bearer c699ffecd5ce5afc2efc849b4bad0d6c"),
            @ApiImplicitParam(name = "body", value = "{\n" +
                    "    \"comment\":\"评论内容\",\n" +
                    "    \"enterpriseId\":\"公司ID（内部）\",\n" +
                    "    \"nation\":\"国家\",\n" +
                    "    \"e_type\":\"地区\"\n" +
                    "    \"stars\":\"评星\"\n" +
                    "} , stars数据类型:string, 参数取值:[0, 0.5, 1, 1.5, 2, 2.5, 3, 3.5, 4, 4.5, 5]", paramType = "body", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "{\n" +
                    "    \"message\": \"评论成功\",\n" +
                    "    \"data\": null,\n" +
                    "    \"code\": 200\n" +
                    "}")
    })
    @PostMapping("saveComment")
    public ResultData saveComment(@RequestBody String body) {
        return userService.saveComment(body);
    }

    /**
     * 翻译评论
     *
     * @param commentId
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "翻译评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer c699ffecd5ce5afc2efc849b4bad0d6c", paramType = "header", required = true, example = "Bearer c699ffecd5ce5afc2efc849b4bad0d6c"),
            @ApiImplicitParam(name = "commentId", value = "参数示例：86", paramType = "query", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "{\n" +
                    "    \"message\": \"请求成功\",\n" +
                    "    \"data\": {\n" +
                    "        \"commentId\": 评论id,\n" +
                    "        \"comment\": \"评论内容\"\n" +
                    "    },\n" +
                    "    \"code\": 200\n" +
                    "}"),
            @ApiResponse(code = 708, message = "{\n" +
                    "    \"message\": \"翻译失败\",\n" +
                    "    \"data\": {\n" +
                    "        \"commentId\": 评论id,\n" +
                    "        \"comment\":\"评论内容\"" +
                    "}")
    })
    @GetMapping("translateComment")
    public ResultData translateComment(@RequestParam(name = "commentId") Integer commentId) throws Exception {
        return userService.translateComment(commentId);
    }

    /**
     * 忘记密码-邮箱-发送验证码
     *
     * @param email
     * @return
     */
    @ApiOperation(value = "忘记密码-邮箱-发送验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer c699ffecd5ce5afc2efc849b4bad0d6c", paramType = "header", required = true, example = "Bearer c699ffecd5ce5afc2efc849b4bad0d6c"),
            @ApiImplicitParam(name = "email", value = "参数示例：xxx@qq.com", paramType = "query", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "{\n" +
                    "    \"message\": \"请求成功\",\n" +
                    "    \"data\": \"邮箱\",\n" +
                    "    \"code\": 200\n" +
                    "}"),
            @ApiResponse(code = 702, message = "验证码发送次数过多，请稍后再试"),
            @ApiResponse(code = 703, message = "验证码发送失败"),
            @ApiResponse(code = 850, message = "邮箱格式错误"),
            @ApiResponse(code = 856, message = "该邮箱尚未注册")
    })
    @GetMapping("send4ForgetEmailPassword")
    public ResultData send4ForgetEmailPassword(@RequestParam String email) {
        return userService.send4ForgetEmailPassword(email);
    }

    /**
     * 忘记密码-邮箱-校验验证码
     *
     * @param email
     * @return
     */
    @ApiOperation(value = "忘记密码-邮箱-校验验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer c699ffecd5ce5afc2efc849b4bad0d6c", paramType = "header", required = true, example = "Bearer c699ffecd5ce5afc2efc849b4bad0d6c"),
            @ApiImplicitParam(name = "body", value = "{\n" +
                    "    \"email\": \"邮箱\",\n" +
                    "    \"verificationCode\": \"验证码\"\n" +
                    "}", paramType = "body", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "{\n" +
                    "    \"message\": \"验证码校验成功\",\n" +
                    "    \"data\": {\"email\": \"邮箱\",\"verificationCode\": \"验证码\"} ,\n" +
                    "    \"code\": 200\n" +
                    "}"),
            @ApiResponse(code = 707, message = "验证码错误"),
            @ApiResponse(code = 850, message = "邮箱格式错误"),
            @ApiResponse(code = 852, message = "该邮箱尚未发送验证码"),
            @ApiResponse(code = 856, message = "该邮箱尚未注册")
    })
    @PostMapping("check4ForgetEmailPassword")
    public ResultData check4ForgetEmailPassword(@RequestBody String body) {
        return userService.check4ForgetEmailPassword(body);
    }

    /**
     * 忘记密码-邮箱-修改密码
     */
    @ApiOperation(value = "忘记密码-邮箱-修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer c699ffecd5ce5afc2efc849b4bad0d6c", paramType = "header", required = true, example = "Bearer c699ffecd5ce5afc2efc849b4bad0d6c"),
            @ApiImplicitParam(name = "body", value = "{\n" +
                    "    \"email\": \"邮箱\",\n" +
                    "    \"verificationCode\": \"验证码\",\n" +
                    "    \"password\":\"密码\",\n" +
                    "    \"retypePassword\":\"密码确认\"\n" +
                    "}", paramType = "body", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "修改密码成功"),
            @ApiResponse(code = 705, message = "705"),
            @ApiResponse(code = 850, message = "邮箱格式错误"),
            @ApiResponse(code = 852, message = "该邮箱尚未发送验证码"),
            @ApiResponse(code = 856, message = "该邮箱尚未注册"),
            @ApiResponse(code = 903, message = "密码格式错误"),
            @ApiResponse(code = 904, message = "新密码不能和原密码相同")
    })
    @PutMapping("forgetEmailPassword")
    public ResultData forgetEmailPassword(@RequestBody String body) {
        return userService.forgetEmailPassword(body);
    }

}
