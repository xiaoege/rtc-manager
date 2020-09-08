package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;

public class QccKeymanVO {
    private Integer id;

    private String enterpriseId;

    private String name;

    private String duty;

    private String shareholdingRatio;

    private String ultimateBeneficialShares;

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

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getShareholdingRatio() {
        return shareholdingRatio;
    }

    public void setShareholdingRatio(String shareholdingRatio) {
        this.shareholdingRatio = shareholdingRatio;
    }

    public String getUltimateBeneficialShares() {
        return ultimateBeneficialShares;
    }

    public void setUltimateBeneficialShares(String ultimateBeneficialShares) {
        this.ultimateBeneficialShares = ultimateBeneficialShares;
    }
}