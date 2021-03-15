package com.rtc.manager.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QccEquityOutPledge {
    private Integer id;

    private String enterpriseId;
    @JsonAlias("登记编号")
    private String code;
    @JsonAlias("出质人")
    private String pledgor;
    @JsonAlias("质权人")
    private String pledgee;
    @JsonAlias("出质股权标的企业")
    private String enterprise;
    @JsonAlias("出质股权数额(万元)")
    private String amount;
    @JsonAlias("登记日期")
    private String registrationDate;
    @JsonAlias("状态")
    private String pledgeStatus;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getPledgor() {
        return pledgor;
    }

    public void setPledgor(String pledgor) {
        this.pledgor = pledgor == null ? null : pledgor.trim();
    }

    public String getPledgee() {
        return pledgee;
    }

    public void setPledgee(String pledgee) {
        this.pledgee = pledgee == null ? null : pledgee.trim();
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise == null ? null : enterprise.trim();
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate == null ? null : registrationDate.trim();
    }

    public String getPledgeStatus() {
        return pledgeStatus;
    }

    public void setPledgeStatus(String pledgeStatus) {
        this.pledgeStatus = pledgeStatus == null ? null : pledgeStatus.trim();
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