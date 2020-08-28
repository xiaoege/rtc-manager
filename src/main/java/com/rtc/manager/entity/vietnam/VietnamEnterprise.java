package com.rtc.manager.entity.vietnam;

import java.time.LocalDateTime;

public class VietnamEnterprise {
    private Integer id;

    private String enterpriseId;

    private String enterpriseName;

    private String enterpriseNameInForeignLanguage;

    private String enterpriseShortName;

    private String enterpirseStatus;

    private String enterpriseCode;

    private String legalType;

    private String foundingDate;

    private String representativeFirstName;

    private String headOfficeAddress;

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

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName == null ? null : enterpriseName.trim();
    }

    public String getEnterpriseNameInForeignLanguage() {
        return enterpriseNameInForeignLanguage;
    }

    public void setEnterpriseNameInForeignLanguage(String enterpriseNameInForeignLanguage) {
        this.enterpriseNameInForeignLanguage = enterpriseNameInForeignLanguage == null ? null : enterpriseNameInForeignLanguage.trim();
    }

    public String getEnterpriseShortName() {
        return enterpriseShortName;
    }

    public void setEnterpriseShortName(String enterpriseShortName) {
        this.enterpriseShortName = enterpriseShortName == null ? null : enterpriseShortName.trim();
    }

    public String getEnterpirseStatus() {
        return enterpirseStatus;
    }

    public void setEnterpirseStatus(String enterpirseStatus) {
        this.enterpirseStatus = enterpirseStatus == null ? null : enterpirseStatus.trim();
    }

    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode == null ? null : enterpriseCode.trim();
    }

    public String getLegalType() {
        return legalType;
    }

    public void setLegalType(String legalType) {
        this.legalType = legalType == null ? null : legalType.trim();
    }

    public String getFoundingDate() {
        return foundingDate;
    }

    public void setFoundingDate(String foundingDate) {
        this.foundingDate = foundingDate == null ? null : foundingDate.trim();
    }

    public String getRepresentativeFirstName() {
        return representativeFirstName;
    }

    public void setRepresentativeFirstName(String representativeFirstName) {
        this.representativeFirstName = representativeFirstName == null ? null : representativeFirstName.trim();
    }

    public String getHeadOfficeAddress() {
        return headOfficeAddress;
    }

    public void setHeadOfficeAddress(String headOfficeAddress) {
        this.headOfficeAddress = headOfficeAddress == null ? null : headOfficeAddress.trim();
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