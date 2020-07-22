package com.rtc.manager.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QccFilingInformation {
    private Integer id;

    private String enterpriseId;
    @JsonAlias("案号")
    private String code;
    @JsonAlias("公诉人/原告/上诉人/申请人")
    private String prosecutor;
    @JsonAlias("被告人/被告/被上诉人/被申请人")
    private String defendant;
    @JsonAlias("法院名称")
    private String courtName;
    @JsonAlias("立案日期")
    private String filingDate;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModify;

    private Integer status;

}