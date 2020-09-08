package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;

public class QccClientVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;
    private String name;
    private String saleProportion;
    private String saleAmount;
    private String reportDate;
    private String source;
    private String relationship;

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
        this.enterpriseId = enterpriseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSaleProportion() {
        return saleProportion;
    }

    public void setSaleProportion(String saleProportion) {
        this.saleProportion = saleProportion;
    }

    public String getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(String saleAmount) {
        this.saleAmount = saleAmount;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
}