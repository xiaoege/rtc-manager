package com.rtc.manager.controller;

import com.rtc.manager.service.UserService;
import com.rtc.manager.vo.ResultData;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author ChenHang
 */
@Api(tags = "用户接口")
@RestController
@RequestMapping("user")
public class UserController {

    /**
     *
     * @param data
     * @return
     * @throws Exception
     */
    @ApiIgnore
    @ApiOperation("邮箱注册")
    @ApiResponses({@ApiResponse(code = 700,message = "邮箱格式错误"),
            @ApiResponse(code = 701,message = "邮箱已注册"),
            @ApiResponse(code = 702,message = "验证码发送次数过多，请15分钟稍后再试"),
            @ApiResponse(code = 703,message = "验证码发送失败"),
            @ApiResponse(code = 704,message = "该邮箱尚未发送验证码"),
            @ApiResponse(code = 705,message = "数据有误"),
            @ApiResponse(code = 706,message = "请输入验证码"),
            @ApiResponse(code = 707,message = "验证码错误")})
    @PostMapping("emailRegister")
    public ResultData emailRegister(@RequestParam(name = "data") String data) throws Exception {
        //校验验证码,注册
        ResultData resultData = userService.register(data);

        return resultData;
    }

    @Autowired
    private UserService userService;

    /**
     * 校验邮箱，发送验证码
     * @param email
     * @return
     */
    @ApiOperation("校验邮箱，发送验证码")
    @ApiResponses({@ApiResponse(code = 700,message = "邮箱格式错误"),
            @ApiResponse(code = 701,message = "邮箱已注册"),
            @ApiResponse(code = 702,message = "验证码发送次数过多，请15分钟稍后再试"),
            @ApiResponse(code = 703,message = "验证码发送失败"),
            @ApiResponse(code = 704,message = "该邮箱尚未发送验证码"),
            @ApiResponse(code = 705,message = "数据有误"),
            @ApiResponse(code = 706,message = "请输入验证码"),
            @ApiResponse(code = 707,message = "验证码错误")})
    @PostMapping("checkEmaillRegistered")
    public ResultData checkEmaillRegistered(@RequestParam(name = "email") String email) {
        ResultData resultData = userService.checkEmaillRegistered(email);

        return resultData;
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @ApiOperation("登录")
    @PostMapping("login")
    public ResultData login(@RequestBody String user) {


        return null;
    }

}
