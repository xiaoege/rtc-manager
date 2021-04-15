package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IndiaLlpinBasicDTO {
    @JsonAlias("LLPIN")
    private String llpin;
    @JsonAlias("LLP Name")
    private String llpName;
    @JsonAlias("Number of Partners")
    private String numberOfPartners;
    @JsonAlias("Number of Designated Partners")
    private String numberOfDesignatedPartners;
    @JsonAlias("ROC Code")
    private String rocCode;
    @JsonAlias("Date of Incorporation")
    private String dateOfIncorporation;
    @JsonAlias("Registered Address")
    private String registratedAddress;
    @JsonAlias("Email Id")
    private String emailId;
    @JsonAlias("Previous firm/ company details, if applicable")
    private String previousFirm;
    @JsonAlias("Total Obligation of Contribution")
    private String totalObligationOfContribution;
    @JsonAlias("Main division of business activity to be carried out in India")
    private String mainDivisionOfBusiness;
    @JsonAlias("Description of main division")
    private String descriptionOfMainDivision;
    @JsonAlias("Date of last financial year end date for which Statement of Accounts and Solvency filed")
    private String statementDate;
    @JsonAlias("Date of last financial year end date for which Annual Return filed")
    private String annualDate;
    @JsonAlias("LLP Status")
    private String llpStatus;
    private String logo;

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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}