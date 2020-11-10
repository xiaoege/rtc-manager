package com.rtc.manager.entity.america.northcarolina;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaNorthcarolinaStock {
    private Integer id;

    private String enterpriseId;
    @JsonAlias("Class")
    private String stockClass;
    @JsonAlias("Shares")
    private String share;
    @JsonAlias("Par Value")
    private String parValue;
    @JsonAlias("No Par Value")
    private String noParValue;

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

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share == null ? null : share.trim();
    }

    public String getParValue() {
        return parValue;
    }

    public void setParValue(String parValue) {
        this.parValue = parValue == null ? null : parValue.trim();
    }

    public String getNoParValue() {
        return noParValue;
    }

    public void setNoParValue(String noParValue) {
        this.noParValue = noParValue == null ? null : noParValue.trim();
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