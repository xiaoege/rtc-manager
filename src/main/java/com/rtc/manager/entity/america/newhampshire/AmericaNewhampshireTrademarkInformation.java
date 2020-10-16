package com.rtc.manager.entity.america.newhampshire;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.time.LocalDateTime;

public class AmericaNewhampshireTrademarkInformation {
    private Integer id;

    private String enterpriseId;
    @JsonAlias("trademarkNumber")
    private String trademarkNumber;
    @JsonAlias("trademarkName")
    private String trademarkName;
    @JsonAlias("businessAddress")
    private String businessAddress;
    @JsonAlias("mailingAddress")
    private String mailingAddress;

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

    public String getTrademarkNumber() {
        return trademarkNumber;
    }

    public void setTrademarkNumber(String trademarkNumber) {
        this.trademarkNumber = trademarkNumber == null ? null : trademarkNumber.trim();
    }

    public String getTrademarkName() {
        return trademarkName;
    }

    public void setTrademarkName(String trademarkName) {
        this.trademarkName = trademarkName == null ? null : trademarkName.trim();
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress == null ? null : businessAddress.trim();
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress == null ? null : mailingAddress.trim();
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}