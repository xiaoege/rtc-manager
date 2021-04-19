package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class AmericaUtahDTO {
    private String name;

    @JsonAlias("Entity Number")
    private String entityNumber;

    @JsonAlias("Company Type")
    private String companyType;

    @JsonAlias("Address")
    private String address;

    @JsonAlias("State of Origin")
    private String originState;

    @JsonAlias("Registered Agent")
    private String registeredAgent;

    @JsonAlias("Registered Agent Address")
    private String registeredAgentAddress;

    @JsonAlias("Status")
    private String enterpriseStatus;

    @JsonAlias("Status Description")
    private String statusDescription;

    @JsonAlias("Employment Verification")
    private String employmentVerification;

    @JsonAlias("Registration Date")
    private String registrationDate;

    @JsonAlias("Renew By")
    private String renewBy;

    @JsonAlias("Last Renewed")
    private String lastRenewed;

    @JsonAlias("NAICS Code")
    private String naicsCode;

    @JsonAlias("NAICS Title")
    private String naicsTitle;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEntityNumber() {
        return entityNumber;
    }

    public void setEntityNumber(String entityNumber) {
        this.entityNumber = entityNumber;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOriginState() {
        return originState;
    }

    public void setOriginState(String originState) {
        this.originState = originState;
    }

    public String getRegisteredAgent() {
        return registeredAgent;
    }

    public void setRegisteredAgent(String registeredAgent) {
        this.registeredAgent = registeredAgent;
    }

    public String getRegisteredAgentAddress() {
        return registeredAgentAddress;
    }

    public void setRegisteredAgentAddress(String registeredAgentAddress) {
        this.registeredAgentAddress = registeredAgentAddress;
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getEmploymentVerification() {
        return employmentVerification;
    }

    public void setEmploymentVerification(String employmentVerification) {
        this.employmentVerification = employmentVerification;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getRenewBy() {
        return renewBy;
    }

    public void setRenewBy(String renewBy) {
        this.renewBy = renewBy;
    }

    public String getLastRenewed() {
        return lastRenewed;
    }

    public void setLastRenewed(String lastRenewed) {
        this.lastRenewed = lastRenewed;
    }

    public String getNaicsCode() {
        return naicsCode;
    }

    public void setNaicsCode(String naicsCode) {
        this.naicsCode = naicsCode;
    }

    public String getNaicsTitle() {
        return naicsTitle;
    }

    public void setNaicsTitle(String naicsTitle) {
        this.naicsTitle = naicsTitle;
    }
}