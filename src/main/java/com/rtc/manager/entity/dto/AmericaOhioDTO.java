package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaOhioDTO {
    private String enterpriseId;
    @JsonAlias("Entity #")
    private String entityNumber;
    @JsonAlias("Filing Type")
    private String filingType;
    @JsonAlias("Original Filing Date")
    private String originalFilingDate;
    @JsonAlias("Location")
    private String location;
    @JsonAlias("Business Name")
    private String name;
    @JsonAlias("Status")
    private String enterpriseStatus;
    @JsonAlias("Exp. Date")
    private String expDate;
    @JsonAlias("agentInfo")
    private String agentInfo;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEntityNumber() {
        return entityNumber;
    }

    public void setEntityNumber(String entityNumber) {
        this.entityNumber = entityNumber;
    }

    public String getFilingType() {
        return filingType;
    }

    public void setFilingType(String filingType) {
        this.filingType = filingType;
    }

    public String getOriginalFilingDate() {
        return originalFilingDate;
    }

    public void setOriginalFilingDate(String originalFilingDate) {
        this.originalFilingDate = originalFilingDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getAgentInfo() {
        return agentInfo;
    }

    public void setAgentInfo(String agentInfo) {
        this.agentInfo = agentInfo;
    }
}