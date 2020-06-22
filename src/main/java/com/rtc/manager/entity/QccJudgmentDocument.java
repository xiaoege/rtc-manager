package com.rtc.manager.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QccJudgmentDocument {
    private Integer id;

    private String enterpriseId;

    @JsonAlias("裁判文书标题")
    private String title;

    @JsonAlias("案由")
    private String reason;

    @JsonAlias("发布日期")
    private String releaseDate;

    @JsonAlias("案号")
    private String caseCode;

    @JsonAlias("案件身份")
    private String caseStatus;

    @JsonAlias("法院名称")
    private String courtName;

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
        this.enterpriseId = enterpriseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCaseCode() {
        return caseCode;
    }

    public void setCaseCode(String caseCode) {
        this.caseCode = caseCode;
    }

    public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    public String getCourtName() {
        return courtName;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
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