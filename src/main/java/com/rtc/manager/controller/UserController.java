package com.rtc.manager.controller;

import com.rtc.manager.entity.dto.PhoneRegisterDTO;
import com.rtc.manager.service.UserService;
import com.rtc.manager.vo.ResultData;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
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
    @ApiIgnore
    @ApiOperation("邮箱注册")
    @ApiResponses({
            @ApiResponse(code = 700, message = "邮箱格式错误"),
            @ApiResponse(code = 701, message = "邮箱已注册"),
            @ApiResponse(code = 702, message = "验证码发送次数过多，请15分钟稍后再试"),
            @ApiResponse(code = 703, message = "验证码发送失败"),
            @ApiResponse(code = 704, message = "该邮箱尚未发送验证码"),
            @ApiResponse(code = 705, message = "数据有误"),
            @ApiResponse(code = 706, message = "请输入验证码"),
            @ApiResponse(code = 707, message = "验证码错误")
    })
    @Deprecated
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
    @ApiResponses({
            @ApiResponse(code = 700, message = "邮箱格式错误"),
            @ApiResponse(code = 701, message = "邮箱已注册"),
            @ApiResponse(code = 702, message = "验证码发送次数过多，请15分钟稍后再试"),
            @ApiResponse(code = 703, message = "验证码发送失败"),
            @ApiResponse(code = 704, message = "该邮箱尚未发送验证码"),
            @ApiResponse(code = 705, message = "数据有误"),
            @ApiResponse(code = 706, message = "请输入验证码"),
            @ApiResponse(code = 707, message = "验证码错误")
    })
    @Deprecated
    @PostMapping("checkEmaillRegistered")
    public ResultData checkEmaillRegistered(@RequestParam(name = "email") String email) {
        ResultData resultData = userService.checkEmaillRegistered(email);

        return resultData;
    }

    /**
     * 手机注册,注册成功后删除验证码
     *
     * @param user
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "手机注册,注册成功后删除验证码", notes = "参数例子:\n" +
            "{\n" +
            "    \"phone\":\"189\",\n" +
            "    \"countryCode\":\"\",\n" +
            "    \"password\":\"asd\",\n" +
            "    \"retypePassword\":\"asd\",\n" +
            "    \"verificationCode\":\"30505\"\n" +
            "}\n" +
            "phone:手机号,countryCode:手机号国家代码,password:密码,retypePassword:确认密码,verificationCode:验证码")
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
            @ApiImplicitParam(name = "phone", value = "手机号", required = true),
            @ApiImplicitParam(name = "countryCode", value = "手机号国家代码", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 702, message = "验证码发送次数过多，请15分钟稍后再试"),
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
     * 修改用户基本信息，成功后返回该用户的最新信息 + 新昵称/旧昵称的token
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "修改用户基本信息", notes = "成功后返回该用户的最新信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer 9b8dc8b599368836ed7deb163e01ded1", paramType = "header"),
            @ApiImplicitParam(name = "user", value = "参数示例：{\n" +
                    "    \"nickname\":\"miaomiao\",\n" +
                    "    \"synopsis\":\"喵喵\",\n" +
                    "    \"country\":\"喵喵\",\n" +
                    "    \"enterprise\":\"喵喵\",\n" +
                    "    \"address\":\"喵喵\"\n" +
                    "}", paramType = "body")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "{\n" +
                    "    \"message\": \"请求成功\",\n" +
                    "    \"data\": {\n" +
                    "        \"role\": \"ROLE_USER\",\n" +
                    "        \"user\": {\n" +
                    "            \"nickname\": \"miaopasi211\",\n" +
                    "            \"phone\": \"321\",\n" +
                    "            \"countryCode\": \"+86\",\n" +
                    "            \"email\": \"ad\",\n" +
                    "            \"synopsis\": \"喵喵\",\n" +
                    "            \"country\": \"喵喵\",\n" +
                    "            \"enterprise\": \"喵喵\",\n" +
                    "            \"address\": \"喵喵\",\n" +
                    "            \"pid\": 45\n" +
                    "        },\n" +
                    "        \"account\": \"miaopasi211\"\n" +
                    "    },\n" +
                    "    \"code\": 200\n" +
                    "}"),
            @ApiResponse(code = 901, message = "昵称格式错误"),
            @ApiResponse(code = 902, message = "昵称已存在")
    })
    @PutMapping("updateUser")
    public ResultData updateUser(@RequestBody String user, HttpServletRequest request) {
        ResultData resultData;
        try {
            resultData = userService.updateUser(user, request);
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
    @ApiOperation(value = "根据原始密码修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer 9b8dc8b599368836ed7deb163e01ded1", paramType = "header"),
            @ApiImplicitParam(name = "user", value = "参数示例：{\n" +
                    "    \"oldPassword\":\"asd\",\n" +
                    "    \"newPassword\":\"asd111\",\n" +
                    "    \"retypePassword\":\"asd111\"\n" +
                    "}", paramType = "body")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "{\n" +
                    "    \"message\": \"请求成功\",\n" +
                    "    \"data\": \"null\",\n" +
                    "    \"code\": 200\n" +
                    "}"),
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
            @ApiImplicitParam(name = "map", value = "参数示例：{\n" +
                    "    \"phone\":\"777\",\n" +
                    "    \"countryCode\":\"+86\"\n" +
                    "}", paramType = "body")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "{\n" +
                    "    \"message\": \"发送验证码成功\",\n" +
                    "    \"data\": null,\n" +
                    "    \"code\": 200\n" +
                    "}"),
            @ApiResponse(code = 702, message = "验证码发送次数过多，请15分钟稍后再试"),
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
            @ApiImplicitParam(name = "map", value = "参数示例：{\n" +
                    "    \"phone\":\"777\",\n" +
                    "    \"countryCode\":\"+86\",\n" +
                    "    \"verificationCode\":\"123456\"\n" +
                    "}", paramType = "body")
    })
    @ApiResponses({
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
     * 忘记密码-修改密码,修改成功后删除验证码
     *
     * @param user
     * @return
     */
    @ApiOperation("忘记密码-修改密码,修改成功后删除验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "参数示例：{\n" +
                    "    \"phone\":\"321\",\n" +
                    "    \"password\":\"asd123\",\n" +
                    "    \"retypePassword\":\"asd123\",\n" +
                    "    \"countryCode\":\"86\",\n" +
                    "    \"verificationCode\":\"783269\"\n" +
                    "}", paramType = "body")
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
     * 更换手机号
     *
     * @return
     */
    @ApiIgnore
    @PostMapping("changePhone")
    public ResultData changePhone(@RequestBody String user) {
        return userService.changePhone(user);
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
    @ApiResponses({
            @ApiResponse(code = 200, message = "{\n" +
                    "    \"code\": 200,\n" +
                    "    \"data\": {\n" +
                    "        \"Authorization\": \"Bearer 9b8dc8b599368836ed7deb163e01ded1\",\n" +
                    "        \"role\": \"ROLE_USER\",\n" +
                    "        \"user\": {\n" +
                    "            \"nickname\": \"ca123tddd\",\n" +
                    "            \"phone\": \"333\",\n" +
                    "            \"countryCode\": null,\n" +
                    "            \"email\": \"email\",\n" +
                    "            \"synopsis\": \"synopsis\",\n" +
                    "            \"country\": \"country\",\n" +
                    "            \"enterprise\": \"enterprise\",\n" +
                    "            \"address\": \"address\",\n" +
                    "            \"pid\": 19,\n" +
                    "            \"Authorization\": null\n" +
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
            "}")
    })
    @ApiImplicitParam(name = "", value = "参数示例：{\"username\":\"333\",\"password\":\"asd\"}", paramType = "body")
    @PostMapping("login")
    public String swagger_login() {
        return "请使用/login来调用";
    }

    @ApiOperation(value = "登出，此文档仅供参考，不可在swagger里调用，调用请使用/logout路径", notes = "参数放在header里")
    @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer 9b8dc8b599368836ed7deb163e01ded1", paramType = "header")
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
    @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer 9b8dc8b599368836ed7deb163e01ded1", paramType = "header")
    @ApiResponses({
            @ApiResponse(code = 200, message = "{\n" +
                    "    \"message\": \"请求成功\",\n" +
                    "    \"data\": {\n" +
                    "        \"role\": \"ROLE_USER\",\n" +
                    "        \"user\": {\n" +
                    "            \"nickname\": \"996\",\n" +
                    "            \"phone\": \"996\",\n" +
                    "            \"countryCode\": \"+86\",\n" +
                    "            \"email\": \"ad\",\n" +
                    "            \"synopsis\": \"喵喵\",\n" +
                    "            \"country\": \"喵喵\",\n" +
                    "            \"enterprise\": \"喵喵\",\n" +
                    "            \"address\": \"喵喵\",\n" +
                    "            \"pid\": 46\n" +
                    "        }\n" +
                    "    },\n" +
                    "    \"code\": 200\n" +
                    "}")
    })
    @GetMapping("getUserInformation")
    public ResultData getUserInformation(HttpServletRequest request) {
        return userService.getUserInformation(request);
    }
}
