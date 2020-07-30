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

    private String email;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModify;

    private Integer status;
}
