package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QccTaxArrearsNoticeVO {
    @JsonSetter("pid")
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getCurrentArrears() {
        return currentArrears;
    }

    public void setCurrentArrears(String currentArrears) {
        this.currentArrears = currentArrears;
    }

    public String getReleaseCompany() {
        return releaseCompany;
    }

    public void setReleaseCompany(String releaseCompany) {
        this.releaseCompany = releaseCompany;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}