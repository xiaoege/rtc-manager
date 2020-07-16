package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

import java.util.Date;

@Data
public class QccSoftwareCopyrightVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;

    private String name;

    private String version;

    private String releaseDate;

    private String abbreviation;

    private String registrationNumber;

    private String registrationApprovalDate;

}