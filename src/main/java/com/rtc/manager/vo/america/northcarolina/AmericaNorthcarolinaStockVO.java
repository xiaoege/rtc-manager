package com.rtc.manager.vo.america.northcarolina;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaNorthcarolinaStockVO {
    private Integer id;
    private String enterpriseId;
    private String stockClass;
    private String share;
    private String parValue;
    private String noParValue;

    public Integer getId() {
        return id;
    }
    @JsonSetter("pid")
    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getStockClass() {
        return stockClass;
    }

    public void setStockClass(String stockClass) {
        this.stockClass = stockClass;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public String getParValue() {
        return parValue;
    }

    public void setParValue(String parValue) {
        this.parValue = parValue;
    }

    public String getNoParValue() {
        return noParValue;
    }

    public void setNoParValue(String noParValue) {
        this.noParValue = noParValue;
    }
}