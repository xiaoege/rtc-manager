package com.rtc.manager.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;
import java.util.HashMap;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Qcc {
    private Integer id;

    private String enterpriseId;

    private String rtcEnterpriseUuid;

    @JsonAlias("名称")
    private String name;

    @JsonAlias("电话")
    private String telephone;

    @JsonAlias("官网")
    private String url;

    @JsonAlias("邮箱")
    private String email;

    @JsonAlias("地址")
    private String address;

    @JsonAlias("地区")
    private String countryRegion;

    @JsonAlias("基本信息")
    private HashMap basicInformation;

    @JsonAlias("法律诉讼")
    private HashMap legalProceeding;

    @JsonAlias("经营状况")
    private HashMap businessStatus;

    @JsonAlias("经营风险")
    private HashMap businessRisk;

    @JsonAlias("企业发展")
    private HashMap enterpriseDevelopment;

    @JsonAlias("知识产权")
    private HashMap intellectualProperty;

    private Date gmtCreate;

    private Date gmtModify;

    private Integer status;

    @JsonAlias("简介")
    private String synopsis;

    private String nation;
}