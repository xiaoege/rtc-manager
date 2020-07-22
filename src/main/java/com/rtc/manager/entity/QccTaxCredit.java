package com.rtc.manager.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QccTaxCredit {
    private Integer id;

    private String enterpriseId;

    @JsonAlias("评价年度")
    private String year;

    @JsonAlias("纳税人识别号")
    private String taxpayerIdentificationNumber;

    @JsonAlias("纳税信用等级")
    private String taxCreditRank;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModify;

    private Integer status;

    @JsonAlias("评价单位")
    private String evaluationCop;
}