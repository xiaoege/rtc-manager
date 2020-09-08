package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;

public class QccAdministrativeLicenseVO {
    private Integer id;

    private String enterpriseId;

    private String decisionDocumentNo;

    private String licenseAuthority;

    private String licenseDate;

    private String content;

    private String validFrom;

    private String validUntil;

    private String decisionDocumentName;

    public Integer getId() {
        return id;
    }
    @JsonSetter("pid")
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
}