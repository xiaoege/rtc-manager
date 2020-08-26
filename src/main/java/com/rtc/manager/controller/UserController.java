package com.rtc.manager.controller;

import com.rtc.manager.dao.RtcUserMapper;
import com.rtc.manager.entity.dto.PhoneRegisterDTO;
import com.rtc.manager.service.UserService;
import com.rtc.manager.util.RedisUtils;
import com.rtc.manager.vo.ResultData;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
    @ApiIgnore
    @ApiOperation("邮箱注册")
    @ApiResponses({@ApiResponse(code = 700, message = "邮箱格式错误"),
            @ApiResponse(code = 701, message = "邮箱已注册"),
            @ApiResponse(code = 702, message = "验证码发送次数过多，请15分钟稍后再试"),
            @ApiResponse(code = 703, message = "验证码发送失败"),
            @ApiResponse(code = 704, message = "该邮箱尚未发送验证码"),
            @ApiResponse(code = 705, message = "数据有误"),
            @ApiResponse(code = 706, message = "请输入验证码"),
            @ApiResponse(code = 707, message = "验证码错误")})
    @PostMapping("emailRegister")
    public ResultData emailRegister(@RequestParam(name = "data") String data) throws Exception {
        //校验验证码,注册
        ResultData resultData = userService.emailRegister(data);

        return resultData;
    }

    /**
     * 校验邮箱，发送验证码
     *
     * @param email
     * @return
     */
    @ApiIgnore
    @ApiOperation("校验邮箱，发送验证码")
    @ApiResponses({@ApiResponse(code = 700, message = "邮箱格式错误"),
            @ApiResponse(code = 701, message = "邮箱已注册"),
            @ApiResponse(code = 702, message = "验证码发送次数过多，请15分钟稍后再试"),
            @ApiResponse(code = 703, message = "验证码发送失败"),
            @ApiResponse(code = 704, message = "该邮箱尚未发送验证码"),
            @ApiResponse(code = 705, message = "数据有误"),
            @ApiResponse(code = 706, message = "请输入验证码"),
            @ApiResponse(code = 707, message = "验证码错误")})
    @PostMapping("checkEmaillRegistered")
    public ResultData checkEmaillRegistered(@RequestParam(name = "email") String email) {
        ResultData resultData = userService.checkEmaillRegistered(email);

        return resultData;
    }

    /**
     * 手机注册
     *
     * @param user
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "手机注册", notes = "参数例子:\n" +
            "{\n" +
            "    \"phone\":\"189\",\n" +
            "    \"countryCode\":\"\",\n" +
            "    \"password\":\"asd\",\n" +
            "    \"retypePassword\":\"asd\",\n" +
            "    \"verificationCode\":\"30505\"\n" +
            "}\n" +
            "phone:手机号,countryCode:手机号国家代码,password:密码,retypePassword:确认密码,verificationCode:验证码")
    @ApiResponses({@ApiResponse(code = 705, message = "数据有误"),
            @ApiResponse(code = 707, message = "验证码错误"),
            @ApiResponse(code = 800, message = "手机号格式错误"),
            @ApiResponse(code = 801, message = "手机号已注册"),
            @ApiResponse(code = 804, message = "该手机号尚未发送验证码")})
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
    @ApiImplicitParams({@ApiImplicitParam(name = "phone", value = "手机号", required = true),
            @ApiImplicitParam(name = "countryCode", value = "手机号国家代码", required = true)})
    @ApiResponses({@ApiResponse(code = 702, message = "验证码发送次数过多，请15分钟稍后再试"),
            @ApiResponse(code = 800, message = "手机号格式错误"),
            @ApiResponse(code = 801, message = "手机号已注册")})
    @PostMapping("verificationCodeRegistered")
    public ResultData verificationCodeRegistered(@RequestBody(required = true) HashMap<String, String> map) {
        String phone = map.get("phone");
        String countryCode = map.get("countryCode");
        ResultData resultData = userService.verificationCodeRegistered(phone, countryCode);
        return resultData;
    }

    /**
     * 修改用户基本信息
     *
     * @param user
     * @return
     */
    @ApiIgnore
    @PutMapping("updateUser")
    public ResultData updateUser(@RequestParam(name = "user", required = true) String user) {
        ResultData resultData;
        try {
            resultData = userService.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultData.FAIL(user, 400, "数据有误");
        }

        return resultData;
    }

    /**
     * 根据原始密码修改密码
     *
     * @param oldPassword    oldPassword
     * @param newPassword    newPassword
     * @param retypePassword retypePassword
     * @return
     */
    @ApiIgnore
    @ApiOperation(value = "根据原始密码修改密码")
    @PatchMapping("updatePassword")
    public ResultData updatePassword(String oldPassword, String newPassword, String retypePassword) {
        userService.updatePassword(oldPassword, newPassword, retypePassword);
        return null;
    }

    /**
     * 忘记密码，通过手机号发送验证码-然后修改密码(不在此处)
     *
     * @param phone
     * @return
     */
    @ApiIgnore
    @GetMapping("forgetPassword")
    public ResultData forgetPasswordSendVerificationCode(String phone, String countryCode) {
        userService.forgetPasswordSendVerificationCode(phone, countryCode);
        return null;
    }

    /**
     * 检验手机号相对应的验证码
     *
     * @param phone
     * @param countryCode
     * @param verificationCode
     * @return
     */
    @ApiIgnore
    @GetMapping("checkVerificationCode")
    public ResultData checkVerificationCode(String phone, String countryCode, String verificationCode) {
        return userService.checkVerificationCode(phone, countryCode, verificationCode);
    }

    /**
     * 上传头像
     */
    @ApiIgnore
    @PostMapping("uploadPortrait")
    public ResultData uploadPortrait() {

        return null;
    }

    @ApiOperation(value = "登录，此文档仅供参考，不可在swagger里调用，调用请使用/login路径", notes = "参数放在body里")
    @ApiResponses({@ApiResponse(code = 200, message = "{\n" +
            "    \"code\": 200,\n" +
            "    \"data\": {\n" +
            "        \"Authorization\": \"Bearer 9b8dc8b599368836ed7deb163e01ded1\",\n" +
            "        \"user\": {\n" +
            "            \"nickname\": \"333\",\n" +
            "            \"phone\": \"333\",\n" +
            "            \"countryCode\": null,\n" +
            "            \"email\": \"xxxx\",\n" +
            "            \"synopsis\": \"简介\",\n" +
            "            \"country\": \"天朝\",\n" +
            "            \"enterprise\": \"公司\",\n" +
            "            \"address\": \"南京\",\n" +
            "            \"pid\": 12\n" +
            "        },\n" +
            "        \"account\": \"333\"\n" +
            "    },\n" +
            "    \"message\": \"登录成功\"\n" +
            "}"),
            @ApiResponse(code = 1002, message = "{\n" +
                    "    \"code\": 401,\n" +
                    "    \"message\": \"该账号不存在\"\n" +
                    "}"), @ApiResponse(code = 1003, message = "{\n" +
            "    \"code\": 401,\n" +
            "    \"message\": \"密码错误\"\n" +
            "}")})
    @ApiImplicitParam(name = "", value = "参数示例：{\"username\":\"333\",\"password\":\"asd\"}", paramType = "body")
    @PostMapping("login")
    public String swagger_login() {
        return "请使用/login来调用";
    }

    @ApiOperation(value = "登出，此文档仅供参考，不可在swagger里调用，调用请使用/logout路径", notes = "参数放在header里")
    @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer 9b8dc8b599368836ed7deb163e01ded1", paramType = "header")
    @ApiResponses(@ApiResponse(code = 200, message = "{\n" +
            "    \"code\": 200,\n" +
            "    \"message\": \"登出成功\"\n" +
            "}"))
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
    @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer 9b8dc8b599368836ed7deb163e01ded1", paramType = "header")
    @ApiResponses({@ApiResponse(code = 200, message = "{\n" +
            "    \"message\": \"请求成功\",\n" +
            "    \"data\": {\n" +
            "        \"nickname\": \"333\",\n" +
            "        \"phone\": \"333\",\n" +
            "        \"countryCode\": null,\n" +
            "        \"email\": \"xxxx\",\n" +
            "        \"synopsis\": \"简介\",\n" +
            "        \"country\": \"天朝\",\n" +
            "        \"enterprise\": \"公司\",\n" +
            "        \"address\": \"南京\",\n" +
            "        \"pid\": 12\n" +
            "    },\n" +
            "    \"code\": 200\n" +
            "}")})
    @GetMapping("getUserInformation")
    public ResultData getUserInformation(HttpServletRequest request) {
        return userService.getUserInformation(request);
    }
}
