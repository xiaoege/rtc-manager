package com.rtc.manager.entity.india;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IndiaCin {
    private Integer id;

    private String enterpriseId;
    @JsonAlias("CIN")
    private String cin;
    @JsonAlias("Company Name")
    private String companyName;
    @JsonAlias("ROC Code")
    private String rocCode;
    @JsonAlias("Registration Number")
    private String registrationNumber;
    @JsonAlias("Company Category")
    private String companyCategory;
    @JsonAlias("Company SubCategory")
    private String companySubCategory;
    @JsonAlias("Class of Company")
    private String classOfCompany;
    @JsonAlias("Authorised Capital(Rs)")
    private String authorisedCapital;
    @JsonAlias("Paid up Capital(Rs)")
    private String paidUpCapital;
    @JsonAlias("Number of Members(Applicable in case of company without Share Capital)")
    private String numberOfMembers;
    @JsonAlias("Date of Incorporation")
    private String dateOfIncorporation;
    @JsonAlias("Email Id")
    private String emailId;
    @JsonAlias("Whether Listed or not")
    private String whetherListedOrNot;
    @JsonAlias("ACTIVE compliance")
    private String activeCompliant;
    @JsonAlias("Suspended at stock exchange")
    private String suspendedAtStockExchange;
    @JsonAlias("Date of last AGM")
    private String dateOfLastAgm;
    @JsonAlias("Date of Balance Sheet")
    private String dateOfBalanceSheet;
    @JsonAlias("Company Status(for efiling)")
    private String companyStatus;
    @JsonAlias("Registered Address")
    private String registeredAddress;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private Integer status;

    private String logo;

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

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin == null ? null : cin.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getRocCode() {
        return rocCode;
    }

    public void setRocCode(String rocCode) {
        this.rocCode = rocCode == null ? null : rocCode.trim();
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber == null ? null : registrationNumber.trim();
    }

    public String getCompanyCategory() {
        return companyCategory;
    }

    public void setCompanyCategory(String companyCategory) {
        this.companyCategory = companyCategory == null ? null : companyCategory.trim();
    }

    public String getCompanySubCategory() {
        return companySubCategory;
    }

    public void setCompanySubCategory(String companySubCategory) {
        this.companySubCategory = companySubCategory == null ? null : companySubCategory.trim();
    }

    public String getClassOfCompany() {
        return classOfCompany;
    }

    public void setClassOfCompany(String classOfCompany) {
        this.classOfCompany = classOfCompany == null ? null : classOfCompany.trim();
    }

    public String getAuthorisedCapital() {
        return authorisedCapital;
    }

    public void setAuthorisedCapital(String authorisedCapital) {
        this.authorisedCapital = authorisedCapital == null ? null : authorisedCapital.trim();
    }

    public String getPaidUpCapital() {
        return paidUpCapital;
    }

    public void setPaidUpCapital(String paidUpCapital) {
        this.paidUpCapital = paidUpCapital == null ? null : paidUpCapital.trim();
    }

    public String getNumberOfMembers() {
        return numberOfMembers;
    }

    public void setNumberOfMembers(String numberOfMembers) {
        this.numberOfMembers = numberOfMembers == null ? null : numberOfMembers.trim();
    }

    public String getDateOfIncorporation() {
        return dateOfIncorporation;
    }

    public void setDateOfIncorporation(String dateOfIncorporation) {
        this.dateOfIncorporation = dateOfIncorporation == null ? null : dateOfIncorporation.trim();
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId == null ? null : emailId.trim();
    }

    public String getWhetherListedOrNot() {
        return whetherListedOrNot;
    }

    public void setWhetherListedOrNot(String whetherListedOrNot) {
        this.whetherListedOrNot = whetherListedOrNot == null ? null : whetherListedOrNot.trim();
    }

    public String getActiveCompliant() {
        return activeCompliant;
    }

    public void setActiveCompliant(String activeCompliant) {
        this.activeCompliant = activeCompliant == null ? null : activeCompliant.trim();
    }

    public String getSuspendedAtStockExchange() {
        return suspendedAtStockExchange;
    }

    public void setSuspendedAtStockExchange(String suspendedAtStockExchange) {
        this.suspendedAtStockExchange = suspendedAtStockExchange == null ? null : suspendedAtStockExchange.trim();
    }

    public String getDateOfLastAgm() {
        return dateOfLastAgm;
    }

    public void setDateOfLastAgm(String dateOfLastAgm) {
        this.dateOfLastAgm = dateOfLastAgm == null ? null : dateOfLastAgm.trim();
    }

    public String getDateOfBalanceSheet() {
        return dateOfBalanceSheet;
    }

    public void setDateOfBalanceSheet(String dateOfBalanceSheet) {
        this.dateOfBalanceSheet = dateOfBalanceSheet == null ? null : dateOfBalanceSheet.trim();
    }

    public String getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(String companyStatus) {
        this.companyStatus = companyStatus == null ? null : companyStatus.trim();
    }

    public String getRegisteredAddress() {
        return registeredAddress;
    }

    public void setRegisteredAddress(String registeredAddress) {
        this.registeredAddress = registeredAddress == null ? null : registeredAddress.trim();
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}