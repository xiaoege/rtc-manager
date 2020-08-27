package com.rtc.manager.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author ChenHang
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RtcUser {
    private Integer id;

    private String nickname;

    private String password;

    private String phone;

    @JsonAlias("country_code")
    private String countryCode;

    private String email;

    private String salt;

    private Integer roleId;

    private String synopsis;

    private String country;

    private String enterprise;

    private String address;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private Integer status;

}
