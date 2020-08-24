package com.rtc.manager.entity.dto;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

/**
 * @author ChenHang
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RtcUserDTO {
    @JsonSetter("pid")
    private Integer id;
    private String nickname;
    private String password;
    private String phone;
    @JsonAlias("country_code")
    private String countryCode;
    private String email;
    private String verificationCode;
    private String roleName;
    private String synopsis;
    private String country;
    private String enterprise;

}
