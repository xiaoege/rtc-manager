package com.rtc.manager.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QccAnnualReportShareholder {
    private Integer id;

    private String enterpriseId;

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
        this.enterpriseId = enterpriseId == null ? null : enterpriseId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSubscribedCapital() {
        return subscribedCapital;
    }

    public void setSubscribedCapital(String subscribedCapital) {
        this.subscribedCapital = subscribedCapital == null ? null : subscribedCapital.trim();
    }

    public String getSubscribedCapitalDate() {
        return subscribedCapitalDate;
    }

    public void setSubscribedCapitalDate(String subscribedCapitalDate) {
        this.subscribedCapitalDate = subscribedCapitalDate == null ? null : subscribedCapitalDate.trim();
    }

    public String getSubscribedCapitalWay() {
        return subscribedCapitalWay;
    }

    public void setSubscribedCapitalWay(String subscribedCapitalWay) {
        this.subscribedCapitalWay = subscribedCapitalWay == null ? null : subscribedCapitalWay.trim();
    }

    public String getPaidCapital() {
        return paidCapital;
    }

    public void setPaidCapital(String paidCapital) {
        this.paidCapital = paidCapital == null ? null : paidCapital.trim();
    }

    public String getPaidCapitalDate() {
        return paidCapitalDate;
    }

    public void setPaidCapitalDate(String paidCapitalDate) {
        this.paidCapitalDate = paidCapitalDate == null ? null : paidCapitalDate.trim();
    }

    public String getPaidCapitalWay() {
        return paidCapitalWay;
    }

    public void setPaidCapitalWay(String paidCapitalWay) {
        this.paidCapitalWay = paidCapitalWay == null ? null : paidCapitalWay.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}