package com.rtc.manager.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

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

    private Date gmtModified;

    private Integer status;

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

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getgmtModified() {
        return gmtModified;
    }

    public void setgmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}