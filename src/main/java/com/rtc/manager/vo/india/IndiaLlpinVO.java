package com.rtc.manager.vo.india;

import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * @author ChenHang
 */
public class IndiaLlpinVO {
    @JsonSetter("pid")
    private Integer id;
    private String enterpriseId;
    private String llpin;
    @JsonSetter("e_name")
    private String llpName;
    private String numberOfPartners;
    private String numberOfDesignatedPartners;
    private String rocCode;
    @JsonSetter("establishmentDate")
    private String dateOfIncorporation;
    @JsonSetter("address")
    private String registratedAddress;
    private String emailId;
    private String previousFirm;
    private String totalObligationOfContribution;
    private String mainDivisionOfBusiness;
    private String descriptionOfMainDivision;
    private String statementDate;
    private String annualDate;
    private String llpStatus;

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
        this.enterpriseId = enterpriseId;
    }

    public String getLlpin() {
        return llpin;
    }

    public void setLlpin(String llpin) {
        this.llpin = llpin;
    }

    public String getLlpName() {
        return llpName;
    }

    public void setLlpName(String llpName) {
        this.llpName = llpName;
    }

    public String getNumberOfPartners() {
        return numberOfPartners;
    }

    public void setNumberOfPartners(String numberOfPartners) {
        this.numberOfPartners = numberOfPartners;
    }

    public String getNumberOfDesignatedPartners() {
        return numberOfDesignatedPartners;
    }

    public void setNumberOfDesignatedPartners(String numberOfDesignatedPartners) {
        this.numberOfDesignatedPartners = numberOfDesignatedPartners;
    }

    public String getRocCode() {
        return rocCode;
    }

    public void setRocCode(String rocCode) {
        this.rocCode = rocCode;
    }

    public String getDateOfIncorporation() {
        return dateOfIncorporation;
    }

    public void setDateOfIncorporation(String dateOfIncorporation) {
        this.dateOfIncorporation = dateOfIncorporation;
    }

    public String getRegistratedAddress() {
        return registratedAddress;
    }

    public void setRegistratedAddress(String registratedAddress) {
        this.registratedAddress = registratedAddress;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPreviousFirm() {
        return previousFirm;
    }

    public void setPreviousFirm(String previousFirm) {
        this.previousFirm = previousFirm;
    }

    public String getTotalObligationOfContribution() {
        return totalObligationOfContribution;
    }

    public void setTotalObligationOfContribution(String totalObligationOfContribution) {
        this.totalObligationOfContribution = totalObligationOfContribution;
    }

    public String getMainDivisionOfBusiness() {
        return mainDivisionOfBusiness;
    }

    public void setMainDivisionOfBusiness(String mainDivisionOfBusiness) {
        this.mainDivisionOfBusiness = mainDivisionOfBusiness;
    }

    public String getDescriptionOfMainDivision() {
        return descriptionOfMainDivision;
    }

    public void setDescriptionOfMainDivision(String descriptionOfMainDivision) {
        this.descriptionOfMainDivision = descriptionOfMainDivision;
    }

    public String getStatementDate() {
        return statementDate;
    }

    public void setStatementDate(String statementDate) {
        this.statementDate = statementDate;
    }

    public String getAnnualDate() {
        return annualDate;
    }

    public void setAnnualDate(String annualDate) {
        this.annualDate = annualDate;
    }

    public String getLlpStatus() {
        return llpStatus;
    }

    public void setLlpStatus(String llpStatus) {
        this.llpStatus = llpStatus;
    }
}
