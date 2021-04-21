package com.rtc.manager.entity.america.washington;

import java.time.LocalDateTime;

public class AmericaWashington {
    private Integer id;

    private String enterpriseId;

    private String name;

    private String ubiNumber;

    private String businessType;

    private String businessStatus;

    private String address;

    private String mailingAddress;

    private String expirationDate;

    private String jurisdiction;

    private String registrationDate;

    private String durationPeriod;

    private String inactiveDate;

    private String businessNature;

    private String registeredAgentName;

    private String registeredStreetAddress;

    private String registeredMailingAddress;

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

    public String getUbiNumber() {
        return ubiNumber;
    }

    public void setUbiNumber(String ubiNumber) {
        this.ubiNumber = ubiNumber == null ? null : ubiNumber.trim();
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    public String getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(String businessStatus) {
        this.businessStatus = businessStatus == null ? null : businessStatus.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress == null ? null : mailingAddress.trim();
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate == null ? null : expirationDate.trim();
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction == null ? null : jurisdiction.trim();
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate == null ? null : registrationDate.trim();
    }

    public String getDurationPeriod() {
        return durationPeriod;
    }

    public void setDurationPeriod(String durationPeriod) {
        this.durationPeriod = durationPeriod == null ? null : durationPeriod.trim();
    }

    public String getInactiveDate() {
        return inactiveDate;
    }

    public void setInactiveDate(String inactiveDate) {
        this.inactiveDate = inactiveDate == null ? null : inactiveDate.trim();
    }

    public String getBusinessNature() {
        return businessNature;
    }

    public void setBusinessNature(String businessNature) {
        this.businessNature = businessNature == null ? null : businessNature.trim();
    }

    public String getRegisteredAgentName() {
        return registeredAgentName;
    }

    public void setRegisteredAgentName(String registeredAgentName) {
        this.registeredAgentName = registeredAgentName == null ? null : registeredAgentName.trim();
    }

    public String getRegisteredStreetAddress() {
        return registeredStreetAddress;
    }

    public void setRegisteredStreetAddress(String registeredStreetAddress) {
        this.registeredStreetAddress = registeredStreetAddress == null ? null : registeredStreetAddress.trim();
    }

    public String getRegisteredMailingAddress() {
        return registeredMailingAddress;
    }

    public void setRegisteredMailingAddress(String registeredMailingAddress) {
        this.registeredMailingAddress = registeredMailingAddress == null ? null : registeredMailingAddress.trim();
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