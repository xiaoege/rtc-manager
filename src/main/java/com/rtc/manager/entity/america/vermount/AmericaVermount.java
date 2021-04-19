package com.rtc.manager.entity.america.vermount;

import java.time.LocalDateTime;

public class AmericaVermount {
    private Integer id;

    private String enterpriseId;

    private String name;

    private String businessId;

    private String businessType;

    private String businessStatus;

    private String expirationDate;

    private String registrationDate;

    private String naicsCode;

    private String naicsSubCode;

    private String address;

    private String mailingAddress;

    private String citizenship;

    private String principal;

    private String applicant;

    private String registrant;

    private String registeredAgent;

    private String individualRegistrant;

    private String otherAddress;

    private String businessPoint;

    private String assumedBusiness;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private Integer status;

    public AmericaVermount() {
    }

    public AmericaVermount(String principal, String applicant, String registrant, String registeredAgent, String individualRegistrant, String otherAddress, String businessPoint, String assumedBusiness) {
        this.principal = principal;
        this.applicant = applicant;
        this.registrant = registrant;
        this.registeredAgent = registeredAgent;
        this.individualRegistrant = individualRegistrant;
        this.otherAddress = otherAddress;
        this.businessPoint = businessPoint;
        this.assumedBusiness = assumedBusiness;
    }

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

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId == null ? null : businessId.trim();
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

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate == null ? null : expirationDate.trim();
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate == null ? null : registrationDate.trim();
    }

    public String getNaicsCode() {
        return naicsCode;
    }

    public void setNaicsCode(String naicsCode) {
        this.naicsCode = naicsCode == null ? null : naicsCode.trim();
    }

    public String getNaicsSubCode() {
        return naicsSubCode;
    }

    public void setNaicsSubCode(String naicsSubCode) {
        this.naicsSubCode = naicsSubCode == null ? null : naicsSubCode.trim();
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

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship == null ? null : citizenship.trim();
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal == null ? null : principal.trim();
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant == null ? null : applicant.trim();
    }

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant == null ? null : registrant.trim();
    }

    public String getRegisteredAgent() {
        return registeredAgent;
    }

    public void setRegisteredAgent(String registeredAgent) {
        this.registeredAgent = registeredAgent == null ? null : registeredAgent.trim();
    }

    public String getIndividualRegistrant() {
        return individualRegistrant;
    }

    public void setIndividualRegistrant(String individualRegistrant) {
        this.individualRegistrant = individualRegistrant == null ? null : individualRegistrant.trim();
    }

    public String getOtherAddress() {
        return otherAddress;
    }

    public void setOtherAddress(String otherAddress) {
        this.otherAddress = otherAddress == null ? null : otherAddress.trim();
    }

    public String getBusinessPoint() {
        return businessPoint;
    }

    public void setBusinessPoint(String businessPoint) {
        this.businessPoint = businessPoint == null ? null : businessPoint.trim();
    }

    public String getAssumedBusiness() {
        return assumedBusiness;
    }

    public void setAssumedBusiness(String assumedBusiness) {
        this.assumedBusiness = assumedBusiness == null ? null : assumedBusiness.trim();
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