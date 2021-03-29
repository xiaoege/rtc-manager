package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IndiaCinBasicDTO {
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

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRocCode() {
        return rocCode;
    }

    public void setRocCode(String rocCode) {
        this.rocCode = rocCode;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getCompanyCategory() {
        return companyCategory;
    }

    public void setCompanyCategory(String companyCategory) {
        this.companyCategory = companyCategory;
    }

    public String getCompanySubCategory() {
        return companySubCategory;
    }

    public void setCompanySubCategory(String companySubCategory) {
        this.companySubCategory = companySubCategory;
    }

    public String getClassOfCompany() {
        return classOfCompany;
    }

    public void setClassOfCompany(String classOfCompany) {
        this.classOfCompany = classOfCompany;
    }

    public String getAuthorisedCapital() {
        return authorisedCapital;
    }

    public void setAuthorisedCapital(String authorisedCapital) {
        this.authorisedCapital = authorisedCapital;
    }

    public String getPaidUpCapital() {
        return paidUpCapital;
    }

    public void setPaidUpCapital(String paidUpCapital) {
        this.paidUpCapital = paidUpCapital;
    }

    public String getNumberOfMembers() {
        return numberOfMembers;
    }

    public void setNumberOfMembers(String numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }

    public String getDateOfIncorporation() {
        return dateOfIncorporation;
    }

    public void setDateOfIncorporation(String dateOfIncorporation) {
        this.dateOfIncorporation = dateOfIncorporation;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getWhetherListedOrNot() {
        return whetherListedOrNot;
    }

    public void setWhetherListedOrNot(String whetherListedOrNot) {
        this.whetherListedOrNot = whetherListedOrNot;
    }

    public String getActiveCompliant() {
        return activeCompliant;
    }

    public void setActiveCompliant(String activeCompliant) {
        this.activeCompliant = activeCompliant;
    }

    public String getSuspendedAtStockExchange() {
        return suspendedAtStockExchange;
    }

    public void setSuspendedAtStockExchange(String suspendedAtStockExchange) {
        this.suspendedAtStockExchange = suspendedAtStockExchange;
    }

    public String getDateOfLastAgm() {
        return dateOfLastAgm;
    }

    public void setDateOfLastAgm(String dateOfLastAgm) {
        this.dateOfLastAgm = dateOfLastAgm;
    }

    public String getDateOfBalanceSheet() {
        return dateOfBalanceSheet;
    }

    public void setDateOfBalanceSheet(String dateOfBalanceSheet) {
        this.dateOfBalanceSheet = dateOfBalanceSheet;
    }

    public String getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(String companyStatus) {
        this.companyStatus = companyStatus;
    }

    public String getRegisteredAddress() {
        return registeredAddress;
    }

    public void setRegisteredAddress(String registeredAddress) {
        this.registeredAddress = registeredAddress;
    }
}