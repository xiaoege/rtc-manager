package com.rtc.manager.vo.canada;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CanadaAnnualFilingVO {
    private Integer id;

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

    public Integer getId() {
        return id;
    }
    @JsonSetter("pid")
    public void setId(Integer id) {
        this.id = id;
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

}