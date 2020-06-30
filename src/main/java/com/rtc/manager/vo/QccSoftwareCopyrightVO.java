package com.rtc.manager.vo;

import lombok.Data;

import java.util.Date;

@Data
public class QccSoftwareCopyrightVO {
    private Integer id;

    private String enterpriseId;

    private String name;

    private String version;

    private String releaseDate;

    private String abbreviation;

    private String registrationNumber;

    private String registrationApprovalDate;

}