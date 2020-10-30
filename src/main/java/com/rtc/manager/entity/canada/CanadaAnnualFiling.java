package com.rtc.manager.entity.canada;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CanadaAnnualFiling {
    private Integer id;

    private String enterpriseId;
    @JsonAlias("Anniversary Date (MM-DD)")
    private String anniversaryDate;
    @JsonAlias("Date of Last Annual Meeting")
    private String lastAnnualMeetingDate;
    @JsonAlias("Annual Filing Period (MM-DD)")
    private String annualFilingPeriod;
    @JsonAlias("Type of Corporation")
    private String corporationType;
    @JsonAlias("Status of Annual Filings")
    private String annualFilingsStatus;

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

    public String getAnniversaryDate() {
        return anniversaryDate;
    }

    public void setAnniversaryDate(String anniversaryDate) {
        this.anniversaryDate = anniversaryDate == null ? null : anniversaryDate.trim();
    }

    public String getLastAnnualMeetingDate() {
        return lastAnnualMeetingDate;
    }

    public void setLastAnnualMeetingDate(String lastAnnualMeetingDate) {
        this.lastAnnualMeetingDate = lastAnnualMeetingDate == null ? null : lastAnnualMeetingDate.trim();
    }

    public String getAnnualFilingPeriod() {
        return annualFilingPeriod;
    }

    public void setAnnualFilingPeriod(String annualFilingPeriod) {
        this.annualFilingPeriod = annualFilingPeriod == null ? null : annualFilingPeriod.trim();
    }

    public String getCorporationType() {
        return corporationType;
    }

    public void setCorporationType(String corporationType) {
        this.corporationType = corporationType == null ? null : corporationType.trim();
    }

    public String getAnnualFilingsStatus() {
        return annualFilingsStatus;
    }

    public void setAnnualFilingsStatus(String annualFilingsStatus) {
        this.annualFilingsStatus = annualFilingsStatus == null ? null : annualFilingsStatus.trim();
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