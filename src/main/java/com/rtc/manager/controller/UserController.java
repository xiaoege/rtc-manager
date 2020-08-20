package com.rtc.manager.controller;

import com.rtc.manager.entity.dto.PhoneRegisterDTO;
import com.rtc.manager.service.UserService;
import com.rtc.manager.vo.ResultData;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

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
    @ApiOperation(value = "手机注册")
    @PostMapping("phoneRegister")
    public ResultData<PhoneRegisterDTO> phoneRegister(@RequestParam(name = "user", required = true) String user,
                                                      HttpServletRequest request) throws Exception {
        ResultData resultData = userService.phoneRegister(user, request);

        return resultData;
    }

    /**
     * 校验手机，发送验证码
     *
     * @param phone
     * @return
     */
    @ApiOperation(value = "校验手机，发送验证码")
    @ApiImplicitParams({@ApiImplicitParam(name = "phone", value = "手机号", required = true),
            @ApiImplicitParam(name = "countryCode", value = "手机号国家代码", required = true)})
    @ApiResponses({@ApiResponse(code = 702, message = "验证码发送次数过多，请15分钟稍后再试"),
            @ApiResponse(code = 703, message = "验证码发送失败"),
            @ApiResponse(code = 705, message = "数据有误"),
            @ApiResponse(code = 707, message = "验证码错误"),
            @ApiResponse(code = 800, message = "手机号格式错误"),
            @ApiResponse(code = 801, message = "手机号已注册"),
            @ApiResponse(code = 802, message = "请输入手机号"),
            @ApiResponse(code = 804, message = "该手机号尚未发送验证码")})
    @PostMapping("checkPhoneRegistered")
    public ResultData checkPhoneRegistered(@RequestParam(name = "phone", required = true) String phone,
                                           @RequestParam(name = "countryCode", required = true) String countryCode) {
        ResultData resultData = userService.checkPhoneRegistered(phone, countryCode);
        return resultData;
    }

}
