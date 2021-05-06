package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaIowaBasicDTO {
    @JsonAlias("Business No.")
    private String businessNo;
    @JsonAlias("Legal Name")
    private String name;
    @JsonAlias("Status")
    private String enterpriseStatus;
    @JsonAlias("Type")
    private String type;
    @JsonAlias("State of Inc.")
    private String incState;
    @JsonAlias("Modified")
    private String modified;
    @JsonAlias("Expiration Date")
    private String expirationDate;
    @JsonAlias("Effective Date")
    private String effectiveDate;
    @JsonAlias("Filing Date")
    private String filingDate;
    @JsonAlias("Chapter")
    private String chapter;

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIncState() {
        return incState;
    }

    public void setIncState(String incState) {
        this.incState = incState;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getFilingDate() {
        return filingDate;
    }

    public void setFilingDate(String filingDate) {
        this.filingDate = filingDate;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }
}