package com.rtc.manager.entity.india;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IndiaSignatory {
    private Integer id;

    private String enterpriseId;
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

    public String getDinPan() {
        return dinPan;
    }

    public void setDinPan(String dinPan) {
        this.dinPan = dinPan == null ? null : dinPan.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate == null ? null : beginDate.trim();
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    public String getSurrenderedDin() {
        return surrenderedDin;
    }

    public void setSurrenderedDin(String surrenderedDin) {
        this.surrenderedDin = surrenderedDin == null ? null : surrenderedDin.trim();
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