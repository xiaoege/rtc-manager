package com.rtc.manager.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ChenHang
 */
@Data
public class PhoneRegisterDTO {
    @ApiModelProperty(value = "手机号")
    private String phone;
    @ApiModelProperty(value = "手机号国家代码")
    private String countryCode;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "确认密码")
    private String retypePassword;
    @ApiModelProperty(value = "验证码")
    private String verificationCode;

}
