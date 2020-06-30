package com.rtc.manager.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QccAnnualReportShareholder {
    private Integer id;

    private String enterpriseId;

    private String annualReportUuid;

    @JsonAlias("发起人")
    private String name;

    @JsonAlias("认缴出资额(万元)")
    private String subscribedCapital;

    @JsonAlias("认缴出资日期")
    private String subscribedCapitalDate;

    @JsonAlias("认缴出资方式")
    private String subscribedCapitalWay;

    @JsonAlias("实缴出资额(万元)")
    private String paidCapital;

    @JsonAlias("实缴出资日期")
    private String paidCapitalDate;

    @JsonAlias("实缴出资方式")
    private String paidCapitalWay;

    private Date gmtCreate;

    private Date gmtModify;

    private Integer status;

}