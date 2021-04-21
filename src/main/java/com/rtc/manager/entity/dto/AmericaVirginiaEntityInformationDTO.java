package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaVirginiaEntityInformationDTO {
    @JsonAlias("Entity Name:")
    private String name;

    @JsonAlias("Entity ID:")
    private String entityId;

    @JsonAlias("Entity Type:")
    private String entityType;

    @JsonAlias("Entity Status:")
    private String entityStatus;

    @JsonAlias("Formation Date:")
    private String formationDate;

    @JsonAlias("Reason for Status:")
    private String statusReason;

    @JsonAlias("VA Qualification Date:")
    private String vaQualificationDate;

    @JsonAlias("Status Date:")
    private String statusDate;

    @JsonAlias("Industry Code:")
    private String industryCode;

    @JsonAlias("Period of Duration:")
    private String periodOfDuration;

    @JsonAlias("Jurisdiction:")
    private String jurisdiction;

    @JsonAlias("Annual Report Due Date:")
    private String annualReportDueDate;

    @JsonAlias("Registration Fee Due Date:")
    private String registrationFeeDueDate;

    @JsonAlias("Charter Fee:")
    private String charterFee;

    @JsonAlias("Email Address:")
    private String email;

    @JsonAlias("Contact Number:")
    private String contactNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getEntityStatus() {
        return entityStatus;
    }

    public void setEntityStatus(String entityStatus) {
        this.entityStatus = entityStatus;
    }

    public String getFormationDate() {
        return formationDate;
    }

    public void setFormationDate(String formationDate) {
        this.formationDate = formationDate;
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    public String getVaQualificationDate() {
        return vaQualificationDate;
    }

    public void setVaQualificationDate(String vaQualificationDate) {
        this.vaQualificationDate = vaQualificationDate;
    }

    public String getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(String statusDate) {
        this.statusDate = statusDate;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    public String getPeriodOfDuration() {
        return periodOfDuration;
    }

    public void setPeriodOfDuration(String periodOfDuration) {
        this.periodOfDuration = periodOfDuration;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public String getAnnualReportDueDate() {
        return annualReportDueDate;
    }

    public void setAnnualReportDueDate(String annualReportDueDate) {
        this.annualReportDueDate = annualReportDueDate;
    }

    public String getRegistrationFeeDueDate() {
        return registrationFeeDueDate;
    }

    public void setRegistrationFeeDueDate(String registrationFeeDueDate) {
        this.registrationFeeDueDate = registrationFeeDueDate;
    }

    public String getCharterFee() {
        return charterFee;
    }

    public void setCharterFee(String charterFee) {
        this.charterFee = charterFee;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}