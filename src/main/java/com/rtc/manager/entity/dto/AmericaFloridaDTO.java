package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaFloridaDTO {
    private String enterpriseId;
    @JsonAlias("Title")
    private String name;
    @JsonAlias("Document Number")
    private String documentNumber;
    @JsonAlias("FEI/EIN Number")
    private String feiEinNumber;
    @JsonAlias("Data Filed")
    private String fieldDate;
    @JsonAlias("State")
    private String state;
    @JsonAlias("Status")
    private String enterpriseStatus;
    @JsonAlias("Effective Date")
    private String effectiveDate;
    @JsonAlias("Last Event")
    private String lastEvent;
    @JsonAlias("Event Date Filed")
    private String eventFiledDate;
    @JsonAlias("Event Effective Date")
    private String eventEffectiveDate;
    @JsonAlias("Principal Address")
    private String principalAddress;
    @JsonAlias("Mailing Address")
    private String mailingAddress;
    @JsonAlias("Registered Agent Name & Address")
    private String registeredAgentNameAddress;
    @JsonAlias("Page Url")
    private String pageUrl;
    @JsonAlias("Authorized Person Details")
    private List<String> authorizedPersonDetailList;
    @JsonAlias("Annual Report Year")
    private List<String> annualReportYearList;
    @JsonAlias("Annual Report Filed Data")
    private List<String> annualReportFieldList;

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

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getFeiEinNumber() {
        return feiEinNumber;
    }

    public void setFeiEinNumber(String feiEinNumber) {
        this.feiEinNumber = feiEinNumber;
    }

    public String getFieldDate() {
        return fieldDate;
    }

    public void setFieldDate(String fieldDate) {
        this.fieldDate = fieldDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getLastEvent() {
        return lastEvent;
    }

    public void setLastEvent(String lastEvent) {
        this.lastEvent = lastEvent;
    }

    public String getEventFiledDate() {
        return eventFiledDate;
    }

    public void setEventFiledDate(String eventFiledDate) {
        this.eventFiledDate = eventFiledDate;
    }

    public String getEventEffectiveDate() {
        return eventEffectiveDate;
    }

    public void setEventEffectiveDate(String eventEffectiveDate) {
        this.eventEffectiveDate = eventEffectiveDate;
    }

    public String getPrincipalAddress() {
        return principalAddress;
    }

    public void setPrincipalAddress(String principalAddress) {
        this.principalAddress = principalAddress;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getRegisteredAgentNameAddress() {
        return registeredAgentNameAddress;
    }

    public void setRegisteredAgentNameAddress(String registeredAgentNameAddress) {
        this.registeredAgentNameAddress = registeredAgentNameAddress;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public List<String> getAuthorizedPersonDetailList() {
        return authorizedPersonDetailList;
    }

    public void setAuthorizedPersonDetailList(List<String> authorizedPersonDetailList) {
        this.authorizedPersonDetailList = authorizedPersonDetailList;
    }

    public List<String> getAnnualReportYearList() {
        return annualReportYearList;
    }

    public void setAnnualReportYearList(List<String> annualReportYearList) {
        this.annualReportYearList = annualReportYearList;
    }

    public List<String> getAnnualReportFieldList() {
        return annualReportFieldList;
    }

    public void setAnnualReportFieldList(List<String> annualReportFieldList) {
        this.annualReportFieldList = annualReportFieldList;
    }
}