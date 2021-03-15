package com.rtc.manager.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QccAnnualReport {
    private Integer id;

    private String uuid;

    private String enterpriseId;

    private String year;

    @JsonAlias("统一社会信用代码")
    private String unifiedSocialCreditCode;

    @JsonAlias("注册号")
    private String registrationNumber;

    @JsonAlias("企业经营状态")
    private String businessStatus;

    @JsonAlias("企业联系电话")
    private String businessTelephone;

    @JsonAlias("电子邮箱")
    private String eMail;

    @JsonAlias("邮政编码")
    private String postCode;

    @JsonAlias("从业人数")
    private String staffNumber;

    @JsonAlias("有限责任公司本年度是否发生股东股权转让")
    private String equityTransfer;

    @JsonAlias("企业是否有投资信息或购买其他公司股权")
    private String purchaseEquity;

    @JsonAlias("企业通讯地址")
    private String postalAddress;

    @JsonAlias("资产总额")
    private String totalAssets;

    @JsonAlias("所有者权益合计")
    private String totalEquity;

    @JsonAlias("营业总收入")
    private String totalOperatingIncome;

    @JsonAlias("利润总额")
    private String totalProfit;

    @JsonAlias("净利润")
    private String netProfit;

    @JsonAlias("营业总收入中主营业务收入")
    private String mainBusinessIncome;

    @JsonAlias("纳税总额")
    private String totalTax;

    @JsonAlias("负债总额")
    private String totalLiabilities;

    @JsonAlias("城镇职工基本养老保险")
    private String endowmentInsurance;

    @JsonAlias("职工基本医疗保险")
    private String medicalInsurance;

    @JsonAlias("生育保险")
    private String maternityInsurance;

    @JsonAlias("失业保险")
    private String unemploymentInsurance;

    @JsonAlias("工伤保险")
    private String employmentInjuryInsurance;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer status;

    public Integer getId() {
        return id;
    }

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

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getgmtModified() {
        return gmtModified;
    }

    public void setgmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}