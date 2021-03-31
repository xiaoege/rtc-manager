package com.rtc.manager.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QccAdministrativeLicense {
    private Integer id;

    private String enterpriseId;

    @JsonAlias({"决定文书号","许可文件编号"})
    private String decisionDocumentNo;

    @JsonAlias("许可机关")
    private String licenseAuthority;

    @JsonAlias("决定日期")
    private String licenseDate;

    @JsonAlias({"内容","许可内容"})
    private String content;

    @JsonAlias("有效期自")
    private String validFrom;

    @JsonAlias("有效期至")
    private String validUntil;

    @JsonAlias("许可文件名称")
    private String decisionDocumentName;

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

    public String getDecisionDocumentNo() {
        return decisionDocumentNo;
    }

    public void setDecisionDocumentNo(String decisionDocumentNo) {
        this.decisionDocumentNo = decisionDocumentNo;
    }

    public String getLicenseAuthority() {
        return licenseAuthority;
    }

    public void setLicenseAuthority(String licenseAuthority) {
        this.licenseAuthority = licenseAuthority;
    }

    public String getLicenseDate() {
        return licenseDate;
    }

    public void setLicenseDate(String licenseDate) {
        this.licenseDate = licenseDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    public String getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }

    public String getDecisionDocumentName() {
        return decisionDocumentName;
    }

    public void setDecisionDocumentName(String decisionDocumentName) {
        this.decisionDocumentName = decisionDocumentName;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}