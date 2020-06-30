package com.rtc.manager.vo;

import java.util.Date;

public class QccAdministrativeSanctionVO {
    private Integer id;

    private String enterpriseId;

    private Integer determineDocumentNumber;

    private String violationsType;

    private String content;

    private Date publicationDate;

    private String decisionMakingOrgan;

    private Date decisionDate;

    private Date gmtCreate;

    private Date gmtModify;

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

    public Integer getDetermineDocumentNumber() {
        return determineDocumentNumber;
    }

    public void setDetermineDocumentNumber(Integer determineDocumentNumber) {
        this.determineDocumentNumber = determineDocumentNumber;
    }

    public String getViolationsType() {
        return violationsType;
    }

    public void setViolationsType(String violationsType) {
        this.violationsType = violationsType == null ? null : violationsType.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getDecisionMakingOrgan() {
        return decisionMakingOrgan;
    }

    public void setDecisionMakingOrgan(String decisionMakingOrgan) {
        this.decisionMakingOrgan = decisionMakingOrgan == null ? null : decisionMakingOrgan.trim();
    }

    public Date getDecisionDate() {
        return decisionDate;
    }

    public void setDecisionDate(Date decisionDate) {
        this.decisionDate = decisionDate;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}