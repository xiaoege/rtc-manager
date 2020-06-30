package com.rtc.manager.vo;

import lombok.Data;

@Data
public class QccAnnualReportShareholderVO {
    private Integer id;

    private String enterpriseId;

    private String annualReportUuid;

    private String name;

    private String subscribedCapital;

    private String subscribedCapitalDate;

    private String subscribedCapitalWay;

    private String paidCapital;

    private String paidCapitalDate;

    private String paidCapitalWay;

}