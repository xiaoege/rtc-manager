package com.rtc.manager.entity.america.wyoming;

import java.time.LocalDateTime;

public class AmericaWyomingFilingAnnualReport {
    private Integer id;

    private String enterpriseId;

    private String filingAnnualReportId;

    private String filingId;

    private String enterpriseStatus;

    private String annualReportNum;

    private String filingYear;

    private String filingDate;

    private String licenseTaxAmt;

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

    public String getFilingAnnualReportId() {
        return filingAnnualReportId;
    }

    public void setFilingAnnualReportId(String filingAnnualReportId) {
        this.filingAnnualReportId = filingAnnualReportId == null ? null : filingAnnualReportId.trim();
    }

    public String getFilingId() {
        return filingId;
    }

    public void setFilingId(String filingId) {
        this.filingId = filingId == null ? null : filingId.trim();
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus == null ? null : enterpriseStatus.trim();
    }

    public String getAnnualReportNum() {
        return annualReportNum;
    }

    public void setAnnualReportNum(String annualReportNum) {
        this.annualReportNum = annualReportNum == null ? null : annualReportNum.trim();
    }

    public String getFilingYear() {
        return filingYear;
    }

    public void setFilingYear(String filingYear) {
        this.filingYear = filingYear == null ? null : filingYear.trim();
    }

    public String getFilingDate() {
        return filingDate;
    }

    public void setFilingDate(String filingDate) {
        this.filingDate = filingDate == null ? null : filingDate.trim();
    }

    public String getLicenseTaxAmt() {
        return licenseTaxAmt;
    }

    public void setLicenseTaxAmt(String licenseTaxAmt) {
        this.licenseTaxAmt = licenseTaxAmt == null ? null : licenseTaxAmt.trim();
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