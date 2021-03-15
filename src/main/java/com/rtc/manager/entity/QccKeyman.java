package com.rtc.manager.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QccKeyman {
    private Integer id;

    private String enterpriseId;

    @JsonAlias("姓名")
    private String name;

    @JsonAlias("职务")
    private String duty;

    @JsonAlias("持股比例")
    private String shareholdingRatio;

    @JsonAlias("最终受益股份")
    private String ultimateBeneficialShares;

    private Date gmtCreate;

    private Date gmtModified;

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
        this.enterpriseId = enterpriseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

    public String getShareholdingRatio() {
        return shareholdingRatio;
    }

    public void setShareholdingRatio(String shareholdingRatio) {
        this.shareholdingRatio = shareholdingRatio == null ? null : shareholdingRatio.trim();
    }

    public String getUltimateBeneficialShares() {
        return ultimateBeneficialShares;
    }

    public void setUltimateBeneficialShares(String ultimateBeneficialShares) {
        this.ultimateBeneficialShares = ultimateBeneficialShares == null ? null : ultimateBeneficialShares.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getgmtModified() {
        return gmtModified;
    }

    public void setgmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}