package com.rtc.manager.entity.america.newhampshire;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaNewhampshire {
    private Integer id;

    private String enterpriseId;

    private String businessName;

    private String businessId;

    private String businessType;

    private String businessStatus;

    private String businessCreationDate;

    private String nameInStateOfIncorporation;

    private String dateOfFormationInJurisdiction;

    private String principalOfficeAddress;

    private String mailingAddress;

    private String citizenshipStateOfIncorporation;

    private String lastAnnualReportYear;

    private String nextReportYear;

    private String duration;

    private String businessEmail;

    private String phone;

    private String notificationEmail;

    private String fiscalYearEndDate;

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

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName == null ? null : businessName.trim();
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

    public String getBusinessCreationDate() {
        return businessCreationDate;
    }

    public void setBusinessCreationDate(String businessCreationDate) {
        this.businessCreationDate = businessCreationDate == null ? null : businessCreationDate.trim();
    }

    public String getNameInStateOfIncorporation() {
        return nameInStateOfIncorporation;
    }

    public void setNameInStateOfIncorporation(String nameInStateOfIncorporation) {
        this.nameInStateOfIncorporation = nameInStateOfIncorporation == null ? null : nameInStateOfIncorporation.trim();
    }

    public String getDateOfFormationInJurisdiction() {
        return dateOfFormationInJurisdiction;
    }

    public void setDateOfFormationInJurisdiction(String dateOfFormationInJurisdiction) {
        this.dateOfFormationInJurisdiction = dateOfFormationInJurisdiction == null ? null : dateOfFormationInJurisdiction.trim();
    }

    public String getPrincipalOfficeAddress() {
        return principalOfficeAddress;
    }

    public void setPrincipalOfficeAddress(String principalOfficeAddress) {
        this.principalOfficeAddress = principalOfficeAddress == null ? null : principalOfficeAddress.trim();
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress == null ? null : mailingAddress.trim();
    }

    public String getCitizenshipStateOfIncorporation() {
        return citizenshipStateOfIncorporation;
    }

    public void setCitizenshipStateOfIncorporation(String citizenshipStateOfIncorporation) {
        this.citizenshipStateOfIncorporation = citizenshipStateOfIncorporation == null ? null : citizenshipStateOfIncorporation.trim();
    }

    public String getLastAnnualReportYear() {
        return lastAnnualReportYear;
    }

    public void setLastAnnualReportYear(String lastAnnualReportYear) {
        this.lastAnnualReportYear = lastAnnualReportYear == null ? null : lastAnnualReportYear.trim();
    }

    public String getNextReportYear() {
        return nextReportYear;
    }

    public void setNextReportYear(String nextReportYear) {
        this.nextReportYear = nextReportYear == null ? null : nextReportYear.trim();
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
    }

    public String getBusinessEmail() {
        return businessEmail;
    }

    public void setBusinessEmail(String businessEmail) {
        this.businessEmail = businessEmail == null ? null : businessEmail.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getNotificationEmail() {
        return notificationEmail;
    }

    public void setNotificationEmail(String notificationEmail) {
        this.notificationEmail = notificationEmail == null ? null : notificationEmail.trim();
    }

    public String getFiscalYearEndDate() {
        return fiscalYearEndDate;
    }

    public void setFiscalYearEndDate(String fiscalYearEndDate) {
        this.fiscalYearEndDate = fiscalYearEndDate == null ? null : fiscalYearEndDate.trim();
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