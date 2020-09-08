package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;

public class QccAnnualReportShareholderVO {
    @JsonSetter("pid")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getAnnualReportUuid() {
        return annualReportUuid;
    }

    public void setAnnualReportUuid(String annualReportUuid) {
        this.annualReportUuid = annualReportUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubscribedCapital() {
        return subscribedCapital;
    }

    public void setSubscribedCapital(String subscribedCapital) {
        this.subscribedCapital = subscribedCapital;
    }

    public String getSubscribedCapitalDate() {
        return subscribedCapitalDate;
    }

    public void setSubscribedCapitalDate(String subscribedCapitalDate) {
        this.subscribedCapitalDate = subscribedCapitalDate;
    }

    public String getSubscribedCapitalWay() {
        return subscribedCapitalWay;
    }

    public void setSubscribedCapitalWay(String subscribedCapitalWay) {
        this.subscribedCapitalWay = subscribedCapitalWay;
    }

    public String getPaidCapital() {
        return paidCapital;
    }

    public void setPaidCapital(String paidCapital) {
        this.paidCapital = paidCapital;
    }

    public String getPaidCapitalDate() {
        return paidCapitalDate;
    }

    public void setPaidCapitalDate(String paidCapitalDate) {
        this.paidCapitalDate = paidCapitalDate;
    }

    public String getPaidCapitalWay() {
        return paidCapitalWay;
    }

    public void setPaidCapitalWay(String paidCapitalWay) {
        this.paidCapitalWay = paidCapitalWay;
    }
}