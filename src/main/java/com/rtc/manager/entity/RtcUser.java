package com.rtc.manager.entity;

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

    private String countryCode;

    private String email;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private Integer status;

    private String salt;

    private Integer roleId;

    private String synopsis;

    private String country;

    private String enterprise;

}
