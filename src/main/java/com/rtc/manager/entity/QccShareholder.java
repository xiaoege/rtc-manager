package com.rtc.manager.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QccShareholder {
    private Integer id;

    private String enterpriseId;

    @JsonAlias("股东及出资信息")
    private String name;

    @JsonAlias("持股比例")
    private String ratio;

    @JsonAlias({"认缴出资额(万元)", "认缴出资额(万美元)"})
    private String subscribedCapital;

    @JsonAlias("认缴出资日期")
    private String subscribedCapitalDate;

    private String paidCapital;

    private String paidCapitalDate;

    private String subscribedCapitalWay;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
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

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSubscribedCapitalWay() {
        return subscribedCapitalWay;
    }

    public void setSubscribedCapitalWay(String subscribedCapitalWay) {
        this.subscribedCapitalWay = subscribedCapitalWay;
    }

    public String getPaidCapitalWay() {
        return paidCapitalWay;
    }

    public void setPaidCapitalWay(String paidCapitalWay) {
        this.paidCapitalWay = paidCapitalWay;
    }
}