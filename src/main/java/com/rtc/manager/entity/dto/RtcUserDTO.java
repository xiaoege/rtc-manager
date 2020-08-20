package com.rtc.manager.entity.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author ChenHang
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RtcUserDTO {
    private String nickname;
    private String password;
    private Long phone;
    private String email;
    private Integer gender;
    private String verificationCode;
    private String roleName;

}
