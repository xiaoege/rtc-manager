package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QccChangeRecordVO {
    private Integer id;

    private String enterpriseId;
    @JsonAlias("变更日期")
    private String changeDate;
    @JsonAlias("变更项目")
    private String changeContent;
    @JsonAlias("变更前")
    private String beforeChange;
    @JsonAlias("变更后")
    private String afterChange;

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

    public String getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(String changeDate) {
        this.changeDate = changeDate == null ? null : changeDate.trim();
    }

    public String getChangeContent() {
        return changeContent;
    }

    public void setChangeContent(String changeContent) {
        this.changeContent = changeContent == null ? null : changeContent.trim();
    }

    public String getBeforeChange() {
        return beforeChange;
    }

    public void setBeforeChange(String beforeChange) {
        this.beforeChange = beforeChange == null ? null : beforeChange.trim();
    }

    public String getAfterChange() {
        return afterChange;
    }

    public void setAfterChange(String afterChange) {
        this.afterChange = afterChange == null ? null : afterChange.trim();
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