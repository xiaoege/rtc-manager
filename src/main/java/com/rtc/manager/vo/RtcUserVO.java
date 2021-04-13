package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.rtc.manager.entity.RtcUserOauth;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChenHang
 */
@ApiModel("用户信息")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RtcUserVO {
    private Integer id;
    @ApiModelProperty("昵称")
    private String nickname;
    @ApiModelProperty("手机号")
    private String phone;
    @ApiModelProperty("手机号国家代码")
    @JsonAlias("country_code")
    private String countryCode;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("简介")
    private String synopsis;
    @ApiModelProperty("国家")
    private String country;
    @ApiModelProperty("公司")
    private String enterprise;
    @ApiModelProperty("地址")
    private String address;
//    @JsonSetter("Authorization")
//    private String authorization;
    @JsonIgnore
    private String uuid;

    @ApiModelProperty("头像url")
    private String portrait;
    @ApiModelProperty("第三方")
    private List<RtcUserOauth> oauthList;

    public Integer getId() {
        return id;
    }
    @JsonSetter("pid")
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public List<RtcUserOauth> getOauthList() {
        return oauthList;
    }

    public void setOauthList(List<RtcUserOauth> oauthList) {
        this.oauthList = oauthList;
    }
}
