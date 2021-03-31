package com.rtc.manager.entity.india;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IndiaLlpin {
    private Integer id;

    private String enterpriseId;
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

    public String getLlpin() {
        return llpin;
    }

    public void setLlpin(String llpin) {
        this.llpin = llpin == null ? null : llpin.trim();
    }

    public String getLlpName() {
        return llpName;
    }

    public void setLlpName(String llpName) {
        this.llpName = llpName == null ? null : llpName.trim();
    }

    public String getNumberOfPartners() {
        return numberOfPartners;
    }

    public void setNumberOfPartners(String numberOfPartners) {
        this.numberOfPartners = numberOfPartners == null ? null : numberOfPartners.trim();
    }

    public String getNumberOfDesignatedPartners() {
        return numberOfDesignatedPartners;
    }

    public void setNumberOfDesignatedPartners(String numberOfDesignatedPartners) {
        this.numberOfDesignatedPartners = numberOfDesignatedPartners == null ? null : numberOfDesignatedPartners.trim();
    }

    public String getRocCode() {
        return rocCode;
    }

    public void setRocCode(String rocCode) {
        this.rocCode = rocCode == null ? null : rocCode.trim();
    }

    public String getDateOfIncorporation() {
        return dateOfIncorporation;
    }

    public void setDateOfIncorporation(String dateOfIncorporation) {
        this.dateOfIncorporation = dateOfIncorporation == null ? null : dateOfIncorporation.trim();
    }

    public String getRegistratedAddress() {
        return registratedAddress;
    }

    public void setRegistratedAddress(String registratedAddress) {
        this.registratedAddress = registratedAddress == null ? null : registratedAddress.trim();
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId == null ? null : emailId.trim();
    }

    public String getPreviousFirm() {
        return previousFirm;
    }

    public void setPreviousFirm(String previousFirm) {
        this.previousFirm = previousFirm == null ? null : previousFirm.trim();
    }

    public String getTotalObligationOfContribution() {
        return totalObligationOfContribution;
    }

    public void setTotalObligationOfContribution(String totalObligationOfContribution) {
        this.totalObligationOfContribution = totalObligationOfContribution == null ? null : totalObligationOfContribution.trim();
    }

    public String getMainDivisionOfBusiness() {
        return mainDivisionOfBusiness;
    }

    public void setMainDivisionOfBusiness(String mainDivisionOfBusiness) {
        this.mainDivisionOfBusiness = mainDivisionOfBusiness == null ? null : mainDivisionOfBusiness.trim();
    }

    public String getDescriptionOfMainDivision() {
        return descriptionOfMainDivision;
    }

    public void setDescriptionOfMainDivision(String descriptionOfMainDivision) {
        this.descriptionOfMainDivision = descriptionOfMainDivision == null ? null : descriptionOfMainDivision.trim();
    }

    public String getStatementDate() {
        return statementDate;
    }

    public void setStatementDate(String statementDate) {
        this.statementDate = statementDate == null ? null : statementDate.trim();
    }

    public String getAnnualDate() {
        return annualDate;
    }

    public void setAnnualDate(String annualDate) {
        this.annualDate = annualDate == null ? null : annualDate.trim();
    }

    public String getLlpStatus() {
        return llpStatus;
    }

    public void setLlpStatus(String llpStatus) {
        this.llpStatus = llpStatus == null ? null : llpStatus.trim();
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