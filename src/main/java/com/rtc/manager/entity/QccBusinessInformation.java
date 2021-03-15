package com.rtc.manager.entity;

import com.fasterxml.jackson.annotation.*;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QccBusinessInformation {
    private Integer id;

    private String enterpriseId;

    @JsonAlias("经营状态")
    private String businessStatus;

    @JsonAlias("成立日期")
    private String establishmentDate;

    @JsonAlias("注册资本")
    private String registeredCapital;

    @JsonAlias("实缴资本")
    private String paidInCapital;

    @JsonAlias("核准日期")
    private String checkDate;

    @JsonAlias("统一社会信用代码")
    private String unifiedSocialCreditCode;

    @JsonAlias("组织机构代码")
    private String organizationCode;

    @JsonAlias("工商注册号")
    private String businessRegistrationNo;

    @JsonAlias("纳税人识别号")
    private String taxpayerRegistrationNumber;

    @JsonAlias("进出口企业代码")
    private String importExportEnterpriseCode;

    @JsonAlias("所属行业")
    private String industry;

    @JsonAlias("企业类型")
    private String businessType;

    @JsonAlias("营业期限")
    private String businessTerm;

    @JsonAlias("登记机关")
    private String registrationAuthority;

    @JsonAlias("人员规模")
    private String staffSize;

    @JsonAlias("参保人数")
    private String staffInsured;

    @JsonAlias("所属地区")
    private String area;

    @JsonAlias("曾用名")
    private String oldName;

    @JsonAlias("英文名")
    private String englishName;

    @JsonAlias("企业地址")
    private String businessAddress;

    @JsonAlias("经营范围")
    private String businessScope;

    @JsonAlias("法定代表人")
    private String legalRepresentative;

    private Date gmtCreate;

    private Date gmtModified;

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
        this.enterpriseId = enterpriseId;
    }

    public String getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(String businessStatus) {
        this.businessStatus = businessStatus;
    }

    public String getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(String establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    public String getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getPaidInCapital() {
        return paidInCapital;
    }

    public void setPaidInCapital(String paidInCapital) {
        this.paidInCapital = paidInCapital;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public String getUnifiedSocialCreditCode() {
        return unifiedSocialCreditCode;
    }

    public void setUnifiedSocialCreditCode(String unifiedSocialCreditCode) {
        this.unifiedSocialCreditCode = unifiedSocialCreditCode;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getBusinessRegistrationNo() {
        return businessRegistrationNo;
    }

    public void setBusinessRegistrationNo(String businessRegistrationNo) {
        this.businessRegistrationNo = businessRegistrationNo;
    }

    public String getTaxpayerRegistrationNumber() {
        return taxpayerRegistrationNumber;
    }

    public void setTaxpayerRegistrationNumber(String taxpayerRegistrationNumber) {
        this.taxpayerRegistrationNumber = taxpayerRegistrationNumber;
    }

    public String getImportExportEnterpriseCode() {
        return importExportEnterpriseCode;
    }

    public void setImportExportEnterpriseCode(String importExportEnterpriseCode) {
        this.importExportEnterpriseCode = importExportEnterpriseCode;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessTerm() {
        return businessTerm;
    }

    public void setBusinessTerm(String businessTerm) {
        this.businessTerm = businessTerm;
    }

    public String getRegistrationAuthority() {
        return registrationAuthority;
    }

    public void setRegistrationAuthority(String registrationAuthority) {
        this.registrationAuthority = registrationAuthority;
    }

    public String getStaffSize() {
        return staffSize;
    }

    public void setStaffSize(String staffSize) {
        this.staffSize = staffSize;
    }

    public String getStaffInsured() {
        return staffInsured;
    }

    public void setStaffInsured(String staffInsured) {
        this.staffInsured = staffInsured;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
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