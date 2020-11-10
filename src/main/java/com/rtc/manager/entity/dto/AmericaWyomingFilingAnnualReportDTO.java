package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaWyomingFilingAnnualReportDTO {

    private String enterpriseId;
    @JsonAlias("FILING_ANNUAL_REPORT_ID")
    private String filingAnnualReportId;
    @JsonAlias("FILING_ID")
    private String filingId;
    @JsonAlias("STATUS")
    private String enterpriseStatus;
    @JsonAlias("ANNUAL_REPORT_NUM")
    private String annualReportNum;
    @JsonAlias("FILING_YEAR")
    private String filingYear;
    @JsonAlias("FILING_DATE")
    private String filingDate;
    @JsonAlias("LICENSE_TAX_AMT")
    private String licenseTaxAmt;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getFilingAnnualReportId() {
        return filingAnnualReportId;
    }

    public void setFilingAnnualReportId(String filingAnnualReportId) {
        this.filingAnnualReportId = filingAnnualReportId;
    }

    public String getFilingId() {
        return filingId;
    }

    public void setFilingId(String filingId) {
        this.filingId = filingId;
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public String getAnnualReportNum() {
        return annualReportNum;
    }

    public void setAnnualReportNum(String annualReportNum) {
        this.annualReportNum = annualReportNum;
    }

    public String getFilingYear() {
        return filingYear;
    }

    public void setFilingYear(String filingYear) {
        this.filingYear = filingYear;
    }

    public String getFilingDate() {
        return filingDate;
    }

    public void setFilingDate(String filingDate) {
        this.filingDate = filingDate;
    }

    public String getLicenseTaxAmt() {
        return licenseTaxAmt;
    }

    public void setLicenseTaxAmt(String licenseTaxAmt) {
        this.licenseTaxAmt = licenseTaxAmt;
    }
}