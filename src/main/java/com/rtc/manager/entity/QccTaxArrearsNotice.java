package com.rtc.manager.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QccTaxArrearsNotice {
    private Integer id;

    private String enterpriseId;
    @JsonAlias("欠税税种")
    private String type;
    @JsonAlias("欠税余额（元）")
    private String balance;
    @JsonAlias("当前新发生的欠税金额（元）")
    private String currentArrears;
    @JsonAlias("发布单位")
    private String releaseCompany;
    @JsonAlias("发布日期")
    private String releaseDate;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance == null ? null : balance.trim();
    }

    public String getCurrentArrears() {
        return currentArrears;
    }

    public void setCurrentArrears(String currentArrears) {
        this.currentArrears = currentArrears == null ? null : currentArrears.trim();
    }

    public String getReleaseCompany() {
        return releaseCompany;
    }

    public void setReleaseCompany(String releaseCompany) {
        this.releaseCompany = releaseCompany == null ? null : releaseCompany.trim();
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate == null ? null : releaseDate.trim();
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getgmtModified() {
        return gmtModified;
    }

    public void setgmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}