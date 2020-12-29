package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FranceDTO {
    private String enterpriseId;
    @JsonAlias("company name")
    private String name;

    @JsonAlias("registry number")
    private String registryNumber;

    @JsonAlias("registered office")
    private String registeredOffice;

    @JsonAlias("siret")
    private String siret;

    @JsonAlias("activities")
    private String activities;

    @JsonAlias("registration")
    private String registration;

    @JsonAlias("beneficiaries")
    private String beneficiaries;

    @JsonAlias("last key figure close")
    private List close;

    @JsonAlias("last key figure turnover")
    private List turnover;

    @JsonAlias("last key figure profit")
    private List profit;

    @JsonAlias("last key figure workforce")
    private String[] workforce;

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

    public String getRegistryNumber() {
        return registryNumber;
    }

    public void setRegistryNumber(String registryNumber) {
        this.registryNumber = registryNumber;
    }

    public String getRegisteredOffice() {
        return registeredOffice;
    }

    public void setRegisteredOffice(String registeredOffice) {
        this.registeredOffice = registeredOffice;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getBeneficiaries() {
        return beneficiaries;
    }

    public void setBeneficiaries(String beneficiaries) {
        this.beneficiaries = beneficiaries;
    }

    public List getClose() {
        return close;
    }

    public void setClose(List close) {
        this.close = close;
    }

    public List getTurnover() {
        return turnover;
    }

    public void setTurnover(List turnover) {
        this.turnover = turnover;
    }

    public List getProfit() {
        return profit;
    }

    public void setProfit(List profit) {
        this.profit = profit;
    }

    public String[] getWorkforce() {
        return workforce;
    }

    public void setWorkforce(String[] workforce) {
        this.workforce = workforce;
    }
}