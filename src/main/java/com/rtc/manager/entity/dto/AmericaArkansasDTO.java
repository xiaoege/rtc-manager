package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaArkansasDTO {
    private String enterpriseId;
    @JsonAlias("Corporation Name")
    private String name;

    @JsonAlias("Fictitious Names")
    private String fictitiousName;

    @JsonAlias("Filing #")
    private String filingNumber;

    @JsonAlias("Filing Type")
    private String filingType;

    @JsonAlias("Filed under Act")
    private String filedUnderAct;

    @JsonAlias("Status")
    private String enterpriseStatus;

    @JsonAlias("Principal Address")
    private String principalAddress;

    @JsonAlias("Reg. Agent")
    private String regAgent;

    @JsonAlias("Agent Address")
    private String agentAddress;

    @JsonAlias("Date Filed")
    private String filedDate;

    @JsonAlias("Officers")
    private String officer;

    @JsonAlias("Foreign Name")
    private String foreignName;

    @JsonAlias("Foreign Address")
    private String foreignAddress;

    @JsonAlias("State of Origin")
    private String originState;

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

    public String getFictitiousName() {
        return fictitiousName;
    }

    public void setFictitiousName(String fictitiousName) {
        this.fictitiousName = fictitiousName;
    }

    public String getFilingNumber() {
        return filingNumber;
    }

    public void setFilingNumber(String filingNumber) {
        this.filingNumber = filingNumber;
    }

    public String getFilingType() {
        return filingType;
    }

    public void setFilingType(String filingType) {
        this.filingType = filingType;
    }

    public String getFiledUnderAct() {
        return filedUnderAct;
    }

    public void setFiledUnderAct(String filedUnderAct) {
        this.filedUnderAct = filedUnderAct;
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public String getPrincipalAddress() {
        return principalAddress;
    }

    public void setPrincipalAddress(String principalAddress) {
        this.principalAddress = principalAddress;
    }

    public String getRegAgent() {
        return regAgent;
    }

    public void setRegAgent(String regAgent) {
        this.regAgent = regAgent;
    }

    public String getAgentAddress() {
        return agentAddress;
    }

    public void setAgentAddress(String agentAddress) {
        this.agentAddress = agentAddress;
    }

    public String getFiledDate() {
        return filedDate;
    }

    public void setFiledDate(String filedDate) {
        this.filedDate = filedDate;
    }

    public String getOfficer() {
        return officer;
    }

    public void setOfficer(String officer) {
        this.officer = officer;
    }

    public String getForeignName() {
        return foreignName;
    }

    public void setForeignName(String foreignName) {
        this.foreignName = foreignName;
    }

    public String getForeignAddress() {
        return foreignAddress;
    }

    public void setForeignAddress(String foreignAddress) {
        this.foreignAddress = foreignAddress;
    }

    public String getOriginState() {
        return originState;
    }

    public void setOriginState(String originState) {
        this.originState = originState;
    }
}