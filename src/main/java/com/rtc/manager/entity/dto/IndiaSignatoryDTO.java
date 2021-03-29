package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IndiaSignatoryDTO {
    @JsonAlias("DIN/PAN")
    private String dinPan;
    @JsonAlias("Name")
    private String name;
    @JsonAlias("Begin date")
    private String beginDate;
    @JsonAlias("End date")
    private String endDate;
    @JsonAlias("Surrendered DIN")
    private String surrenderedDin;

    public String getDinPan() {
        return dinPan;
    }

    public void setDinPan(String dinPan) {
        this.dinPan = dinPan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSurrenderedDin() {
        return surrenderedDin;
    }

    public void setSurrenderedDin(String surrenderedDin) {
        this.surrenderedDin = surrenderedDin;
    }
}