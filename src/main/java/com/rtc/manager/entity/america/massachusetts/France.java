package com.rtc.manager.entity.america.massachusetts;

import java.time.LocalDateTime;

public class France {
    private Integer id;

    private String enterpriseId;

    private String name;

    private String registryNumber;

    private String registeredOffice;

    private String siret;

    private String activities;

    private String registration;

    private String beneficiaries;

    private String turnover;

    private String profit;

    private String workforce;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private Integer status;

    private String close;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRegistryNumber() {
        return registryNumber;
    }

    public void setRegistryNumber(String registryNumber) {
        this.registryNumber = registryNumber == null ? null : registryNumber.trim();
    }

    public String getRegisteredOffice() {
        return registeredOffice;
    }

    public void setRegisteredOffice(String registeredOffice) {
        this.registeredOffice = registeredOffice == null ? null : registeredOffice.trim();
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret == null ? null : siret.trim();
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities == null ? null : activities.trim();
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration == null ? null : registration.trim();
    }

    public String getBeneficiaries() {
        return beneficiaries;
    }

    public void setBeneficiaries(String beneficiaries) {
        this.beneficiaries = beneficiaries == null ? null : beneficiaries.trim();
    }

    public String getTurnover() {
        return turnover;
    }

    public void setTurnover(String turnover) {
        this.turnover = turnover == null ? null : turnover.trim();
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit == null ? null : profit.trim();
    }

    public String getWorkforce() {
        return workforce;
    }

    public void setWorkforce(String workforce) {
        this.workforce = workforce == null ? null : workforce.trim();
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

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close == null ? null : close.trim();
    }
}