package com.rtc.manager.entity.america.utah;

import java.time.LocalDateTime;

public class AmericaUtah {
    private Integer id;

    private String enterpriseId;

    private String name;

    private String entityNumber;

    private String companyType;

    private String address;

    private String originState;

    private String registeredAgent;

    private String registeredAgentAddress;

    private String enterpriseStatus;

    private String statusDescription;

    private String employmentVerification;

    private String registrationDate;

    private String renewBy;

    private String lastRenewed;

    private String naicsCode;

    private String naicsTitle;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEntityNumber() {
        return entityNumber;
    }

    public void setEntityNumber(String entityNumber) {
        this.entityNumber = entityNumber == null ? null : entityNumber.trim();
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType == null ? null : companyType.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getOriginState() {
        return originState;
    }

    public void setOriginState(String originState) {
        this.originState = originState == null ? null : originState.trim();
    }

    public String getRegisteredAgent() {
        return registeredAgent;
    }

    public void setRegisteredAgent(String registeredAgent) {
        this.registeredAgent = registeredAgent == null ? null : registeredAgent.trim();
    }

    public String getRegisteredAgentAddress() {
        return registeredAgentAddress;
    }

    public void setRegisteredAgentAddress(String registeredAgentAddress) {
        this.registeredAgentAddress = registeredAgentAddress == null ? null : registeredAgentAddress.trim();
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus == null ? null : enterpriseStatus.trim();
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription == null ? null : statusDescription.trim();
    }

    public String getEmploymentVerification() {
        return employmentVerification;
    }

    public void setEmploymentVerification(String employmentVerification) {
        this.employmentVerification = employmentVerification == null ? null : employmentVerification.trim();
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate == null ? null : registrationDate.trim();
    }

    public String getRenewBy() {
        return renewBy;
    }

    public void setRenewBy(String renewBy) {
        this.renewBy = renewBy == null ? null : renewBy.trim();
    }

    public String getLastRenewed() {
        return lastRenewed;
    }

    public void setLastRenewed(String lastRenewed) {
        this.lastRenewed = lastRenewed == null ? null : lastRenewed.trim();
    }

    public String getNaicsCode() {
        return naicsCode;
    }

    public void setNaicsCode(String naicsCode) {
        this.naicsCode = naicsCode == null ? null : naicsCode.trim();
    }

    public String getNaicsTitle() {
        return naicsTitle;
    }

    public void setNaicsTitle(String naicsTitle) {
        this.naicsTitle = naicsTitle == null ? null : naicsTitle.trim();
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