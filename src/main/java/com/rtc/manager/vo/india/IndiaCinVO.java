package com.rtc.manager.vo.india;

import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * @author ChenHang
 */
public class IndiaCinVO {
    @JsonSetter("pid")
    private Integer id;
    private String enterpriseId;
    private String cin;
    @JsonSetter("e_name")
    private String companyName;
    private String rocCode;
    private String registrationNumber;
    private String companyCategory;
    private String companySubCategory;
    private String classOfCompany;
    private String authorisedCapital;
    private String paidUpCapital;
    private String numberOfMembers;
    @JsonSetter("establishmentDate")
    private String dateOfIncorporation;
    private String emailId;
    private String whetherListedOrNot;
    private String activeCompliant;
    private String suspendedAtStockExchange;
    private String dateOfLastAgm;
    private String dateOfBalanceSheet;
    private String companyStatus;
    @JsonSetter("address")
    private String registeredAddress;

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
