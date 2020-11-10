package com.rtc.manager.entity.america.florida;

import java.time.LocalDateTime;

public class AmericaFlorida {
    private Integer id;

    private String enterpriseId;

    private String name;

    private String documentNumber;

    private String feiEinNumber;

    private String fieldDate;

    private String state;

    private String enterpriseStatus;

    private String effectiveDate;

    private String lastEvent;

    private String eventFiledDate;

    private String eventEffectiveDate;

    private String principalAddress;

    private String mailingAddress;

    private String registeredAgentNameAddress;

    private String pageUrl;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber == null ? null : documentNumber.trim();
    }

    public String getFeiEinNumber() {
        return feiEinNumber;
    }

    public void setFeiEinNumber(String feiEinNumber) {
        this.feiEinNumber = feiEinNumber == null ? null : feiEinNumber.trim();
    }

    public String getFieldDate() {
        return fieldDate;
    }

    public void setFieldDate(String fieldDate) {
        this.fieldDate = fieldDate == null ? null : fieldDate.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus == null ? null : enterpriseStatus.trim();
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate == null ? null : effectiveDate.trim();
    }

    public String getLastEvent() {
        return lastEvent;
    }

    public void setLastEvent(String lastEvent) {
        this.lastEvent = lastEvent == null ? null : lastEvent.trim();
    }

    public String getEventFiledDate() {
        return eventFiledDate;
    }

    public void setEventFiledDate(String eventFiledDate) {
        this.eventFiledDate = eventFiledDate == null ? null : eventFiledDate.trim();
    }

    public String getEventEffectiveDate() {
        return eventEffectiveDate;
    }

    public void setEventEffectiveDate(String eventEffectiveDate) {
        this.eventEffectiveDate = eventEffectiveDate == null ? null : eventEffectiveDate.trim();
    }

    public String getPrincipalAddress() {
        return principalAddress;
    }

    public void setPrincipalAddress(String principalAddress) {
        this.principalAddress = principalAddress == null ? null : principalAddress.trim();
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress == null ? null : mailingAddress.trim();
    }

    public String getRegisteredAgentNameAddress() {
        return registeredAgentNameAddress;
    }

    public void setRegisteredAgentNameAddress(String registeredAgentNameAddress) {
        this.registeredAgentNameAddress = registeredAgentNameAddress == null ? null : registeredAgentNameAddress.trim();
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl == null ? null : pageUrl.trim();
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