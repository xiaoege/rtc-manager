package com.rtc.manager.controller;

import com.rtc.manager.entity.dto.PhoneRegisterDTO;
import com.rtc.manager.service.UserService;
import com.rtc.manager.vo.ResultData;
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
            @ApiImplicitParam(name = "map", value = "参数示例：{\"phone\":\"123\", \"countryCode\":\"123456\"}", required = true),
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
     * 修改用户基本信息，成功后返回该用户的最新信息
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "修改用户基本信息", notes = "成功后返回该用户的最新信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer 9051a99276af0a1f1c5b22c5ef264719", paramType = "header", required = true, example = "Bearer 9051a99276af0a1f1c5b22c5ef264719"),
            @ApiImplicitParam(name = "user", value = "参数示例：{\n" +
                    "    \"nickname\": \"miaopasi\",\n" +
                    "    \"synopsis\": \"喵\",\n" +
                    "    \"country\": \"喵\",\n" +
                    "    \"enterprise\": \"喵\",\n" +
                    "    \"address\": \"喵\",\n" +
                    "    \"portrait\": \"http://192.168.1.125/portrait/temp/dc410238-c5cc-4ad3-8e2f-96e0b145b239/2020-09-02-9643372645178440190.png\"\n" +
                    "}", paramType = "body")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "{\n" +
                    "    \"message\": \"请求成功\",\n" +
                    "    \"data\": {\n" +
                    "        \"role\": \"ROLE_USER\",\n" +
                    "        \"user\": {\n" +
                    "            \"nickname\": \"miaopasi\",\n" +
                    "            \"phone\": \"996\",\n" +
                    "            \"countryCode\": \"\",\n" +
                    "            \"email\": null,\n" +
                    "            \"synopsis\": \"喵\",\n" +
                    "            \"country\": \"喵\",\n" +
                    "            \"enterprise\": \"喵\",\n" +
                    "            \"address\": \"喵\",\n" +
                    "            \"portrait\": \"http://192.168.1.125/portrait/dc410238-c5cc-4ad3-8e2f-96e0b145b239/2020-09-02-9643372645178440190.png\",\n" +
                    "            \"pid\": 35\n" +
                    "        },\n" +
                    "        \"account\": \"miaopasi\"\n" +
                    "    },\n" +
                    "    \"code\": 200\n" +
                    "}"),
            @ApiResponse(code = 901, message = "昵称格式错误"),
            @ApiResponse(code = 902, message = "昵称已存在"),
            @ApiResponse(code = 906, message = "请重新上传头像")
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
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer 9051a99276af0a1f1c5b22c5ef264719", paramType = "header", required = true, example = "Bearer 9051a99276af0a1f1c5b22c5ef264719"),
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
            @ApiImplicitParam(name = "map", value = "参数示例：{\n" +
                    "    \"phone\":\"777\",\n" +
                    "    \"countryCode\":\"+86\",\n" +
                    "    \"verificationCode\":\"123456\"\n" +
                    "}", paramType = "body")
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
     * 更换手机号-校验原始手机号
     */
    @ApiOperation(value = "更换手机号-校验原始手机号")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "参数示例：{\"phone\":\"666\"}", paramType = "body")
    })
    @ApiResponses({
            @ApiResponse(code = 806, message = "输入的手机号和原始手机号不一致")
    }
    )
    @PostMapping("checkOriginalPhone")
    public ResultData checkOriginalPhone(@RequestBody String phone) {
        // todo 校验手机号
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
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer 9051a99276af0a1f1c5b22c5ef264719", paramType = "header", required = true, example = "Bearer 9051a99276af0a1f1c5b22c5ef264719"),
            @ApiImplicitParam(name = "user", value = "参数示例：{\n" +
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
            @ApiResponse(code = 801, message = "该手机号已注册"),
            @ApiResponse(code = 805, message = "新手机号不能和原来一样")
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
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer 9051a99276af0a1f1c5b22c5ef264719", paramType = "header", required = true, example = "Bearer 9051a99276af0a1f1c5b22c5ef264719"),
            @ApiImplicitParam(name = "user", value = "参数示例：{\n" +
                    "    \"phone\": \"777\",\n" +
                    "    \"countryCode\": \"asd\",\n" +
                    "    \"verificationCode\": \"581106\"\n" +
                    "}", paramType = "body")
    })
    @ApiResponses({
            @ApiResponse(code = 707, message = "验证码错误"),
            @ApiResponse(code = 801, message = "手机号已注册"),
            @ApiResponse(code = 804, message = "该手机号尚未发送验证码"),
            @ApiResponse(code = 805, message = "新手机号不能和原来一样")
    })
    @PostMapping("changePhone")
    public ResultData changePhone(@RequestBody String user) {
        return userService.changePhone(user);
    }

    /**
     * 上传头像,返回头像的URL
     */
    @ApiOperation(value = "上传头像,返回头像的URL")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer 9051a99276af0a1f1c5b22c5ef264719", paramType = "header", required = true, example = "Bearer 9051a99276af0a1f1c5b22c5ef264719"),
            @ApiImplicitParam(name = "file", value = "后缀名是jpg,jpeg,png,bmp格式的图片,大小在2MB以内", paramType = "form", dataType = "__file")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "{\n" +
                    "    \"message\": \"上传头像成功\",\n" +
                    "    \"data\": {\n" +
                    "        \"portrait\": \"http://192.168.1.125/portrait/temp/dc410238-c5cc-4ad3-8e2f-96e0b145b239/2020-09-02-9643372645178440190.png\"\n" +
                    "    },\n" +
                    "    \"code\": 200\n" +
                    "}"),
            @ApiResponse(code = 905, message = "头像文件格式错误")
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
    @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer 9051a99276af0a1f1c5b22c5ef264719", paramType = "header", required = true, example = "Bearer 9051a99276af0a1f1c5b22c5ef264719")
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
    @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer 9051a99276af0a1f1c5b22c5ef264719", paramType = "header", required = true, example = "Bearer 9051a99276af0a1f1c5b22c5ef264719")
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
                    "            \"pid\": 46,\n" +
                    "            \"portrait\": \"http://192.168.1.125/portrait/8f2928ea-377e-4141-803b-129d5942acb5/2020-09-01-363159222557607733.png\",\n" +
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
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer 9051a99276af0a1f1c5b22c5ef264719", paramType = "header", required = true, example = "Bearer 9051a99276af0a1f1c5b22c5ef264719"),
            @ApiImplicitParam(name = "body", value = "参数示例：{\n" +
                    "    \"enterpriseId\":\"829f84ee2c0f404eb821f3cfca3f6a30\",\n" +
                    "    \"nation\":\"India\",\n" +
                    "    \"e_type\":\"llpin\"\n" +
                    "}", paramType = "body", dataType = "string")
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
     * @param body
     * @return
     */
    @ApiOperation(value = "我的收藏-移除收藏")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer 9051a99276af0a1f1c5b22c5ef264719", paramType = "header", required = true, example = "Bearer 9051a99276af0a1f1c5b22c5ef264719"),
            @ApiImplicitParam(name = "body", value = "参数示例：{\n" +
                    "    \"pidArray\": [\n" +
                    "        11,14,15\n" +
                    "    ]\n" +
                    "}", paramType = "body")
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
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer 9051a99276af0a1f1c5b22c5ef264719", paramType = "header", required = true, example = "Bearer 9051a99276af0a1f1c5b22c5ef264719"),
            @ApiImplicitParam(name = "sort", value ="默认根据添加时间倒序排列，在此基础上可以选择国家/字母排列。参数示例：nation：根据国家排列。e_name：根据字母排列"),
            @ApiImplicitParam(name = "pageNum", value = "当前页数，此接口的pageNum从1开始", required = false, defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "当前页大小", required = false, defaultValue = "20")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "{\n" +
                    "    \"message\": \"请求成功\",\n" +
                    "    \"data\": [\n" +
                    "        {\n" +
                    "            \"nation\": \"India\",\n" +
                    "            \"pid\": 360,\n" +
                    "            \"enterpriseId\": \"96cabb14df324335bc268e1b200082b7\",\n" +
                    "            \"legalRepresentative\": null,\n" +
                    "            \"establishmentDate\": \"25/01/2016\",\n" +
                    "            \"address\": \"C 301, HARI OM SADAN, RATAN NAGAR, FOUR BUNGALOWS, ANDHERI (WEST) MUMBAI Mumbai City MH 400053 IN\",\n" +
                    "            \"e_type\": \"llpin\",\n" +
                    "            \"e_name\": \"9TH E FILMS LLP\"\n" +
                    "        }, \"code\": 200\n" +
                    "}")
    })
    @GetMapping("listFavourite")
    public ResultData listFavourite(@RequestParam(name = "sort", required = false) String sort,
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
     * @param body
     * @return
     */
    @ApiOperation(value = "新增评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer 9051a99276af0a1f1c5b22c5ef264719", paramType = "header", required = true, example = "Bearer 9051a99276af0a1f1c5b22c5ef264719"),
            @ApiImplicitParam(name = "body", value = "参数示例：{\n" +
                    "    \"comment\":\"评论内容\",\n" +
                    "    \"enterpriseId\":\"e74d2f1a75fe47e08a9b80649644aa61\",\n" +
                    "    \"nation\":\"Vietnam\",\n" +
                    "    \"e_type\":\"Vietnam\"\n" +
                    "}", paramType = "body")
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
}
