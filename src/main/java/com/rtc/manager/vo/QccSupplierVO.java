package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;

public class QccSupplierVO {
    private Integer id;

    private String enterpriseId;

    private String name;

    private String proportionOfProcurement;

    private String purchaseAmount;

    private String reportPeriod;

    private String source;

    private String relationship;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProportionOfProcurement() {
        return proportionOfProcurement;
    }

    public void setProportionOfProcurement(String proportionOfProcurement) {
        this.proportionOfProcurement = proportionOfProcurement;
    }

    public String getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(String purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public String getReportPeriod() {
        return reportPeriod;
    }

    public void setReportPeriod(String reportPeriod) {
        this.reportPeriod = reportPeriod;
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