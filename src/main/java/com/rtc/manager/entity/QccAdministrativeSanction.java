package com.rtc.manager.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QccAdministrativeSanction {
    private Integer id;

    private String enterpriseId;

    @JsonAlias("决定文书号")
    private String determineDocumentNumber;

    @JsonAlias({"违法行为类型", "处罚事由/违法行为类型"})
    private String violationsType;

    @JsonAlias({"行政处罚内容", "处罚结果/内容"})
    private String content;

    @JsonAlias("公示日期")
    private String publicationDate;

    @JsonAlias("决定机关")
    private String decisionMakingOrgan;

    @JsonAlias("决定日期")
    private String decisionDate;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModify;

    private Integer status;

    @JsonAlias("处罚单位")
    private String punishmentUnit;

    @JsonAlias("数据来源")
    private String source;

    @JsonAlias("处罚日期")
    private String punishmentDate;

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

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(LocalDateTime gmtModify) {
        this.gmtModify = gmtModify;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPunishmentUnit() {
        return punishmentUnit;
    }

    public void setPunishmentUnit(String punishmentUnit) {
        this.punishmentUnit = punishmentUnit;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPunishmentDate() {
        return punishmentDate;
    }

    public void setPunishmentDate(String punishmentDate) {
        this.punishmentDate = punishmentDate;
    }
}