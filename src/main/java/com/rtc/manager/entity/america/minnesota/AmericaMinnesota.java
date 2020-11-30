package com.rtc.manager.entity.america.minnesota;

import java.time.LocalDateTime;

public class AmericaMinnesota {
    private Integer id;

    private String enterpriseId;

    private String name;

    private String businessType;

    private String mnStatute;

    private String fileNumber;

    private String homeJurisdiction;

    private String filingDate;

    private String enterpriseStatus;

    private String renewalDueDate;

    private String registeredOfficeAddress;

    private String numberOfShares;

    private String registeredAgent;

    private String chiefExecutiveOfficer;

    private String principalExecutiveOfficeAddress;

    private String manager;

    private String mailingAddress;

    private String markType;

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

    public void setEnterpriseId(String enterpriseid) {
        this.enterpriseId = enterpriseid == null ? null : enterpriseid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    public String getMnStatute() {
        return mnStatute;
    }

    public void setMnStatute(String mnStatute) {
        this.mnStatute = mnStatute == null ? null : mnStatute.trim();
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber == null ? null : fileNumber.trim();
    }

    public String getHomeJurisdiction() {
        return homeJurisdiction;
    }

    public void setHomeJurisdiction(String homeJurisdiction) {
        this.homeJurisdiction = homeJurisdiction == null ? null : homeJurisdiction.trim();
    }

    public String getFilingDate() {
        return filingDate;
    }

    public void setFilingDate(String filingDate) {
        this.filingDate = filingDate == null ? null : filingDate.trim();
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus == null ? null : enterpriseStatus.trim();
    }

    public String getRenewalDueDate() {
        return renewalDueDate;
    }

    public void setRenewalDueDate(String renewalDueDate) {
        this.renewalDueDate = renewalDueDate == null ? null : renewalDueDate.trim();
    }

    public String getRegisteredOfficeAddress() {
        return registeredOfficeAddress;
    }

    public void setRegisteredOfficeAddress(String registeredOfficeAddress) {
        this.registeredOfficeAddress = registeredOfficeAddress == null ? null : registeredOfficeAddress.trim();
    }

    public String getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(String numberOfShares) {
        this.numberOfShares = numberOfShares == null ? null : numberOfShares.trim();
    }

    public String getRegisteredAgent() {
        return registeredAgent;
    }

    public void setRegisteredAgent(String registeredAgent) {
        this.registeredAgent = registeredAgent == null ? null : registeredAgent.trim();
    }

    public String getChiefExecutiveOfficer() {
        return chiefExecutiveOfficer;
    }

    public void setChiefExecutiveOfficer(String chiefExecutiveOfficer) {
        this.chiefExecutiveOfficer = chiefExecutiveOfficer == null ? null : chiefExecutiveOfficer.trim();
    }

    public String getPrincipalExecutiveOfficeAddress() {
        return principalExecutiveOfficeAddress;
    }

    public void setPrincipalExecutiveOfficeAddress(String principalExecutiveOfficeAddress) {
        this.principalExecutiveOfficeAddress = principalExecutiveOfficeAddress == null ? null : principalExecutiveOfficeAddress.trim();
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress == null ? null : mailingAddress.trim();
    }

    public String getMarkType() {
        return markType;
    }

    public void setMarkType(String markType) {
        this.markType = markType == null ? null : markType.trim();
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