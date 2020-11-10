package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rtc.manager.entity.america.oklahoma.AmericaOklahomaRegisteredAgent;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaOklahomaDTO {
    private String enterpriseId;

    private String name;
    @JsonAlias("Filing Number")
    private String filingNumber;
    @JsonAlias("Name Type")
    private String nameType;
    @JsonAlias("Status")
    private String enterpriseStatus;
    @JsonAlias("Corp type")
    private String corpType;
    @JsonAlias("Jurisdiction")
    private String jurisdiction;
    @JsonAlias("Formation Date")
    private String formationDate;

    private String url;
    @JsonAlias("RegisteredAgent")
    private AmericaOklahomaRegisteredAgent registeredAgent;

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

    public String getFilingNumber() {
        return filingNumber;
    }

    public void setFilingNumber(String filingNumber) {
        this.filingNumber = filingNumber;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public String getCorpType() {
        return corpType;
    }

    public void setCorpType(String corpType) {
        this.corpType = corpType;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public String getFormationDate() {
        return formationDate;
    }

    public void setFormationDate(String formationDate) {
        this.formationDate = formationDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public AmericaOklahomaRegisteredAgent getRegisteredAgent() {
        return registeredAgent;
    }

    public void setRegisteredAgent(AmericaOklahomaRegisteredAgent registeredAgent) {
        this.registeredAgent = registeredAgent;
    }
}