package com.rtc.manager.entity.america.northcarolina;

import java.time.LocalDateTime;

public class AmericaNorthcarolina {
    private Integer id;

    private String enterpriseId;

    private String name;

    private String type;

    private String sosId;

    private String enterpriseStatus;

    private String dateFormed;

    private String citizenship;

    private String incorporationState;

    private String annualReportDueDate;

    private String registeredAgent;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getSosId() {
        return sosId;
    }

    public void setSosId(String sosId) {
        this.sosId = sosId;
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus == null ? null : enterpriseStatus.trim();
    }

    public String getDateFormed() {
        return dateFormed;
    }

    public void setDateFormed(String dateFormed) {
        this.dateFormed = dateFormed == null ? null : dateFormed.trim();
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship == null ? null : citizenship.trim();
    }

    public String getIncorporationState() {
        return incorporationState;
    }

    public void setIncorporationState(String incorporationState) {
        this.incorporationState = incorporationState == null ? null : incorporationState.trim();
    }

    public String getAnnualReportDueDate() {
        return annualReportDueDate;
    }

    public void setAnnualReportDueDate(String annualReportDueDate) {
        this.annualReportDueDate = annualReportDueDate == null ? null : annualReportDueDate.trim();
    }

    public String getRegisteredAgent() {
        return registeredAgent;
    }

    public void setRegisteredAgent(String registeredAgent) {
        this.registeredAgent = registeredAgent == null ? null : registeredAgent.trim();
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