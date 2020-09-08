package com.rtc.manager.vo.india;

import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * @author ChenHang
 */
public class IndiaLlpinVO {
    private Integer id;
    private String enterpriseId;
    private String llpin;
    private String llpName;
    private String numberOfPartners;
    private String numberOfDesignatedPartners;
    private String rocCode;
    private String dateOfIncorporation;
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
    @JsonSetter("pid")
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
    @JsonSetter("e_name")
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
    @JsonSetter("establishmentDate")
    public void setDateOfIncorporation(String dateOfIncorporation) {
        this.dateOfIncorporation = dateOfIncorporation;
    }

    public String getRegistratedAddress() {
        return registratedAddress;
    }
    @JsonSetter("address")
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
