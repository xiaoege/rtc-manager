package com.rtc.manager.entity.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author ChenHang
 */
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRetypePassword() {
        return retypePassword;
    }

    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
