package com.rtc.manager.entity.america.rhodeisland;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;
@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaRhodeislandStock {
    private Integer id;

    private String enterpriseId;
    @JsonAlias("classOfStock")
    private String stockClass;

    private String series;

    private String parValuePerShare;

    private String totalAuthorized;
    @JsonAlias("totalIssuedAndOutstanding")
    private String totalIssuedOutstanding;

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

    public String getStockClass() {
        return stockClass;
    }

    public void setStockClass(String stockClass) {
        this.stockClass = stockClass == null ? null : stockClass.trim();
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series == null ? null : series.trim();
    }

    public String getParValuePerShare() {
        return parValuePerShare;
    }

    public void setParValuePerShare(String parValuePerShare) {
        this.parValuePerShare = parValuePerShare == null ? null : parValuePerShare.trim();
    }

    public String getTotalAuthorized() {
        return totalAuthorized;
    }

    public void setTotalAuthorized(String totalAuthorized) {
        this.totalAuthorized = totalAuthorized == null ? null : totalAuthorized.trim();
    }

    public String getTotalIssuedOutstanding() {
        return totalIssuedOutstanding;
    }

    public void setTotalIssuedOutstanding(String totalIssuedOutstanding) {
        this.totalIssuedOutstanding = totalIssuedOutstanding == null ? null : totalIssuedOutstanding.trim();
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