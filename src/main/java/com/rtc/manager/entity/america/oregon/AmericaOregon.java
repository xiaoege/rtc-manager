package com.rtc.manager.entity.america.oregon;

import java.time.LocalDateTime;

public class AmericaOregon {
    private Integer id;

    private String enterpriseId;

    private String registryNbr;

    private String entityType;

    private String entityStatus;

    private String jurisdiction;

    private String registryDate;

    private String nextRenewalDate;

    private String renewalDue;

    private String entityName;

    private String foreignName;

    private String affidavit;

    private String url;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

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
        this.enterpriseId = enterpriseId == null ? null : enterpriseId.trim();
    }

    public String getRegistryNbr() {
        return registryNbr;
    }

    public void setRegistryNbr(String registryNbr) {
        this.registryNbr = registryNbr == null ? null : registryNbr.trim();
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType == null ? null : entityType.trim();
    }

    public String getEntityStatus() {
        return entityStatus;
    }

    public void setEntityStatus(String entityStatus) {
        this.entityStatus = entityStatus == null ? null : entityStatus.trim();
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction == null ? null : jurisdiction.trim();
    }

    public String getRegistryDate() {
        return registryDate;
    }

    public void setRegistryDate(String registryDate) {
        this.registryDate = registryDate == null ? null : registryDate.trim();
    }

    public String getNextRenewalDate() {
        return nextRenewalDate;
    }

    public void setNextRenewalDate(String nextRenewalDate) {
        this.nextRenewalDate = nextRenewalDate == null ? null : nextRenewalDate.trim();
    }

    public String getRenewalDue() {
        return renewalDue;
    }

    public void setRenewalDue(String renewalDue) {
        this.renewalDue = renewalDue == null ? null : renewalDue.trim();
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName == null ? null : entityName.trim();
    }

    public String getForeignName() {
        return foreignName;
    }

    public void setForeignName(String foreignName) {
        this.foreignName = foreignName == null ? null : foreignName.trim();
    }

    public String getAffidavit() {
        return affidavit;
    }

    public void setAffidavit(String affidavit) {
        this.affidavit = affidavit == null ? null : affidavit.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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
}