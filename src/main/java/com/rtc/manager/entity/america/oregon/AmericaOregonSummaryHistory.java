package com.rtc.manager.entity.america.oregon;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaOregonSummaryHistory {
    private Integer id;

    private String enterpriseId;
    @JsonAlias("Image Available")
    private String imageAvailable;
    @JsonAlias("Action")
    private String action;
    @JsonAlias("Transaction Date")
    private String transactionDate;
    @JsonAlias("Effective Date")
    private String effectiveDate;
    @JsonAlias("Status")
    private String summaryStatus;
    @JsonAlias("Name/Agent Change")
    private String nameAgentChange;
    @JsonAlias("Dissolved By")
    private String dissolvedBy;

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

    public String getImageAvailable() {
        return imageAvailable;
    }

    public void setImageAvailable(String imageAvailable) {
        this.imageAvailable = imageAvailable == null ? null : imageAvailable.trim();
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate == null ? null : transactionDate.trim();
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate == null ? null : effectiveDate.trim();
    }

    public String getSummaryStatus() {
        return summaryStatus;
    }

    public void setSummaryStatus(String summaryStatus) {
        this.summaryStatus = summaryStatus == null ? null : summaryStatus.trim();
    }

    public String getNameAgentChange() {
        return nameAgentChange;
    }

    public void setNameAgentChange(String nameAgentChange) {
        this.nameAgentChange = nameAgentChange == null ? null : nameAgentChange.trim();
    }

    public String getDissolvedBy() {
        return dissolvedBy;
    }

    public void setDissolvedBy(String dissolvedBy) {
        this.dissolvedBy = dissolvedBy == null ? null : dissolvedBy.trim();
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