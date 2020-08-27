package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

/**
 * @author ChenHang
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RtcUserVO {
    @JsonSetter("pid")
    private Integer id;
    private String nickname;
    private String phone;
    @JsonAlias("country_code")
    private String countryCode;
    private String email;
    private String synopsis;
    private String country;
    private String enterprise;
    private String address;
//    @JsonSetter("Authorization")
//    private String authorization;
    @JsonIgnore
    private String uuid;
}
