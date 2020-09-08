package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;

public class QccAdministrativeSanctionVO {
    private Integer id;

    private String enterpriseId;

    private String determineDocumentNumber;

    private String violationsType;

    private String content;

    private String publicationDate;

    private String decisionMakingOrgan;

    private String decisionDate;

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

    public String getDetermineDocumentNumber() {
        return determineDocumentNumber;
    }

    public void setDetermineDocumentNumber(String determineDocumentNumber) {
        this.determineDocumentNumber = determineDocumentNumber;
    }

    public String getViolationsType() {
        return violationsType;
    }

    public void setViolationsType(String violationsType) {
        this.violationsType = violationsType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getDecisionMakingOrgan() {
        return decisionMakingOrgan;
    }

    public void setDecisionMakingOrgan(String decisionMakingOrgan) {
        this.decisionMakingOrgan = decisionMakingOrgan;
    }

    public String getDecisionDate() {
        return decisionDate;
    }

    public void setDecisionDate(String decisionDate) {
        this.decisionDate = decisionDate;
    }
}