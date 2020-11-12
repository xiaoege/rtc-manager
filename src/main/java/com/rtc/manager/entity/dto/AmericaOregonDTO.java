package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rtc.manager.entity.america.oregon.AmericaOregonAssociate;
import com.rtc.manager.entity.america.oregon.AmericaOregonNameHistory;
import com.rtc.manager.entity.america.oregon.AmericaOregonSummaryHistory;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaOregonDTO {
    private String enterpriseId;
    @JsonAlias("Registry Nbr")
    private String registryNbr;
    @JsonAlias("Entity Type")
    private String entityType;
    @JsonAlias("Entity Status")
    private String entityStatus;
    @JsonAlias("Jurisdiction")
    private String jurisdiction;
    @JsonAlias("Registry Date")
    private String registryDate;
    @JsonAlias("Next Renewal Date")
    private String nextRenewalDate;
    @JsonAlias("Renewal Due?")
    private String renewalDue;
    @JsonAlias("Entity Name")
    private String entityName;
    @JsonAlias("Foreign Name")
    private String foreignName;
    @JsonAlias("Affidavit?")
    private String affidavit;
    private String url;
    @JsonAlias("associatedNames")
    private List<AmericaOregonAssociate> associateList;
    @JsonAlias("nameHistory")
    private List<AmericaOregonNameHistory> nameHistoryList;
    @JsonAlias("summaryHistory")
    private List<AmericaOregonSummaryHistory> summaryHistoryList;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getRegistryNbr() {
        return registryNbr;
    }

    public void setRegistryNbr(String registryNbr) {
        this.registryNbr = registryNbr;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getEntityStatus() {
        return entityStatus;
    }

    public void setEntityStatus(String entityStatus) {
        this.entityStatus = entityStatus;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public String getRegistryDate() {
        return registryDate;
    }

    public void setRegistryDate(String registryDate) {
        this.registryDate = registryDate;
    }

    public String getNextRenewalDate() {
        return nextRenewalDate;
    }

    public void setNextRenewalDate(String nextRenewalDate) {
        this.nextRenewalDate = nextRenewalDate;
    }

    public String getRenewalDue() {
        return renewalDue;
    }

    public void setRenewalDue(String renewalDue) {
        this.renewalDue = renewalDue;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getForeignName() {
        return foreignName;
    }

    public void setForeignName(String foreignName) {
        this.foreignName = foreignName;
    }

    public String getAffidavit() {
        return affidavit;
    }

    public void setAffidavit(String affidavit) {
        this.affidavit = affidavit;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<AmericaOregonAssociate> getAssociateList() {
        return associateList;
    }

    public void setAssociateList(List<AmericaOregonAssociate> associateList) {
        this.associateList = associateList;
    }

    public List<AmericaOregonNameHistory> getNameHistoryList() {
        return nameHistoryList;
    }

    public void setNameHistoryList(List<AmericaOregonNameHistory> nameHistoryList) {
        this.nameHistoryList = nameHistoryList;
    }

    public List<AmericaOregonSummaryHistory> getSummaryHistoryList() {
        return summaryHistoryList;
    }

    public void setSummaryHistoryList(List<AmericaOregonSummaryHistory> summaryHistoryList) {
        this.summaryHistoryList = summaryHistoryList;
    }
}