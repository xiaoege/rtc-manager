package com.rtc.manager.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QccTaxViolation {
    private Integer id;

    private String enterpriseId;
    @JsonAlias("发布日期")
    private String releaseDate;
    @JsonAlias("所属税务机关")
    private String taxAuthorities;
    @JsonAlias("案件性质")
    private String caseNature;
    @JsonAlias("主要违法事实")
    private String illegalFact;
    @JsonAlias("法律依据及处理处罚情况")
    private String basisPunishment;

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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate == null ? null : releaseDate.trim();
    }

    public String getTaxAuthorities() {
        return taxAuthorities;
    }

    public void setTaxAuthorities(String taxAuthorities) {
        this.taxAuthorities = taxAuthorities == null ? null : taxAuthorities.trim();
    }

    public String getCaseNature() {
        return caseNature;
    }

    public void setCaseNature(String caseNature) {
        this.caseNature = caseNature == null ? null : caseNature.trim();
    }

    public String getIllegalFact() {
        return illegalFact;
    }

    public void setIllegalFact(String illegalFact) {
        this.illegalFact = illegalFact == null ? null : illegalFact.trim();
    }

    public String getBasisPunishment() {
        return basisPunishment;
    }

    public void setBasisPunishment(String basisPunishment) {
        this.basisPunishment = basisPunishment == null ? null : basisPunishment.trim();
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getgmtModified() {
        return gmtModified;
    }

    public void setgmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}