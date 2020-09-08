package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class QccAnnualReportVO {
    private Integer id;

    private String uuid;

    private String enterpriseId;

    private String year;

    private String unifiedSocialCreditCode;

    private String registrationNumber;

    private String businessStatus;

    private String businessTelephone;

    private String eMail;

    private String postCode;

    private String staffNumber;

    private String equityTransfer;

    private String purchaseEquity;

    private String postalAddress;

    private String totalAssets;

    private String totalEquity;

    private String totalOperatingIncome;

    private String totalProfit;

    private String netProfit;

    private String mainBusinessIncome;

    private String totalTax;

    private String totalLiabilities;

    private String endowmentInsurance;

    private String medicalInsurance;

    private String maternityInsurance;

    private String unemploymentInsurance;

    private String employmentInjuryInsurance;

    private List<QccAnnualReportShareholderVO> qccAnnualReportShareholderVOList;

    public Integer getId() {
        return id;
    }
    @JsonSetter("pid")
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getUnifiedSocialCreditCode() {
        return unifiedSocialCreditCode;
    }

    public void setUnifiedSocialCreditCode(String unifiedSocialCreditCode) {
        this.unifiedSocialCreditCode = unifiedSocialCreditCode;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(String businessStatus) {
        this.businessStatus = businessStatus;
    }

    public String getBusinessTelephone() {
        return businessTelephone;
    }

    public void setBusinessTelephone(String businessTelephone) {
        this.businessTelephone = businessTelephone;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber;
    }

    public String getEquityTransfer() {
        return equityTransfer;
    }

    public void setEquityTransfer(String equityTransfer) {
        this.equityTransfer = equityTransfer;
    }

    public String getPurchaseEquity() {
        return purchaseEquity;
    }

    public void setPurchaseEquity(String purchaseEquity) {
        this.purchaseEquity = purchaseEquity;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(String totalAssets) {
        this.totalAssets = totalAssets;
    }

    public String getTotalEquity() {
        return totalEquity;
    }

    public void setTotalEquity(String totalEquity) {
        this.totalEquity = totalEquity;
    }

    public String getTotalOperatingIncome() {
        return totalOperatingIncome;
    }

    public void setTotalOperatingIncome(String totalOperatingIncome) {
        this.totalOperatingIncome = totalOperatingIncome;
    }

    public String getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(String totalProfit) {
        this.totalProfit = totalProfit;
    }

    public String getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(String netProfit) {
        this.netProfit = netProfit;
    }

    public String getMainBusinessIncome() {
        return mainBusinessIncome;
    }

    public void setMainBusinessIncome(String mainBusinessIncome) {
        this.mainBusinessIncome = mainBusinessIncome;
    }

    public String getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(String totalTax) {
        this.totalTax = totalTax;
    }

    public String getTotalLiabilities() {
        return totalLiabilities;
    }

    public void setTotalLiabilities(String totalLiabilities) {
        this.totalLiabilities = totalLiabilities;
    }

    public String getEndowmentInsurance() {
        return endowmentInsurance;
    }

    public void setEndowmentInsurance(String endowmentInsurance) {
        this.endowmentInsurance = endowmentInsurance;
    }

    public String getMedicalInsurance() {
        return medicalInsurance;
    }

    public void setMedicalInsurance(String medicalInsurance) {
        this.medicalInsurance = medicalInsurance;
    }

    public String getMaternityInsurance() {
        return maternityInsurance;
    }

    public void setMaternityInsurance(String maternityInsurance) {
        this.maternityInsurance = maternityInsurance;
    }

    public String getUnemploymentInsurance() {
        return unemploymentInsurance;
    }

    public void setUnemploymentInsurance(String unemploymentInsurance) {
        this.unemploymentInsurance = unemploymentInsurance;
    }

    public String getEmploymentInjuryInsurance() {
        return employmentInjuryInsurance;
    }

    public void setEmploymentInjuryInsurance(String employmentInjuryInsurance) {
        this.employmentInjuryInsurance = employmentInjuryInsurance;
    }

    public List<QccAnnualReportShareholderVO> getQccAnnualReportShareholderVOList() {
        return qccAnnualReportShareholderVOList;
    }

    public void setQccAnnualReportShareholderVOList(List<QccAnnualReportShareholderVO> qccAnnualReportShareholderVOList) {
        this.qccAnnualReportShareholderVOList = qccAnnualReportShareholderVOList;
    }
}