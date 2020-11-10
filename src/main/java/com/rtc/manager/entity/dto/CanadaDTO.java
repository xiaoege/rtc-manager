package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rtc.manager.entity.canada.CanadaAnnualFiling;
import com.rtc.manager.entity.canada.CanadaCorporateHistory;
import com.rtc.manager.entity.canada.CanadaDirector;
import com.rtc.manager.entity.canada.CanadaRegisteredOfficeAddress;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CanadaDTO {
    private String enterpriseId;
    @JsonAlias("Corporation Number")
    private String corporationNumber;
    @JsonAlias("Business Number (BN)")
    private String businessNumber;
    @JsonAlias("Corporate Name")
    private String name;
    @JsonAlias("Status")
    private String enterpriseStatus;
    @JsonAlias("Governing Legislation")
    private String governingLegislation;
    @JsonAlias("registeredOfficeAddress")
    private CanadaRegisteredOfficeAddress registeredOfficeAddress;
    @JsonAlias("directors")
    private List<CanadaDirector> canadaDirectorList;
    @JsonAlias("annualFilings")
    private CanadaAnnualFiling annualFiling;
    @JsonAlias("corporateHistory")
    private List<CanadaCorporateHistory> corporateHistoryList;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getCorporationNumber() {
        return corporationNumber;
    }

    public void setCorporationNumber(String corporationNumber) {
        this.corporationNumber = corporationNumber;
    }

    public String getBusinessNumber() {
        return businessNumber;
    }

    public void setBusinessNumber(String businessNumber) {
        this.businessNumber = businessNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public String getGoverningLegislation() {
        return governingLegislation;
    }

    public void setGoverningLegislation(String governingLegislation) {
        this.governingLegislation = governingLegislation;
    }

    public CanadaRegisteredOfficeAddress getRegisteredOfficeAddress() {
        return registeredOfficeAddress;
    }

    public void setRegisteredOfficeAddress(CanadaRegisteredOfficeAddress registeredOfficeAddress) {
        this.registeredOfficeAddress = registeredOfficeAddress;
    }

    public List<CanadaDirector> getCanadaDirectorList() {
        return canadaDirectorList;
    }

    public void setCanadaDirectorList(List<CanadaDirector> canadaDirectorList) {
        this.canadaDirectorList = canadaDirectorList;
    }

    public CanadaAnnualFiling getAnnualFiling() {
        return annualFiling;
    }

    public void setAnnualFiling(CanadaAnnualFiling annualFiling) {
        this.annualFiling = annualFiling;
    }

    public List<CanadaCorporateHistory> getCorporateHistoryList() {
        return corporateHistoryList;
    }

    public void setCorporateHistoryList(List<CanadaCorporateHistory> corporateHistoryList) {
        this.corporateHistoryList = corporateHistoryList;
    }
}