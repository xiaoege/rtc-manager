package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rtc.manager.entity.america.minnesota.AmericaMinnesotaMarkholder;
import com.rtc.manager.entity.america.minnesota.AmericaMinnesotaNameholder;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaMinnesotaDTO {
    private String enterpriseid;

    private String name;
    @JsonAlias("Business Type")
    private String businessType;
    @JsonAlias("MN Statute")
    private String mnStatute;
    @JsonAlias("File Number")
    private String fileNumber;
    @JsonAlias("Home Jurisdiction")
    private String homeJurisdiction;
    @JsonAlias("Filing Date")
    private String filingDate;
    @JsonAlias("Status")
    private String enterpriseStatus;
    @JsonAlias("Renewal Due Date")
    private String renewalDueDate;
    @JsonAlias("Registered Office Address")
    private String registeredOfficeAddress;
    @JsonAlias("Number of Shares")
    private String numberOfShares;
    @JsonAlias("Registered Agent(s)")
    private String registeredAgent;
    @JsonAlias("Chief Executive Officer")
    private String chiefExecutiveOfficer;
    @JsonAlias("Principal Executive Office Address")
    private String principalExecutiveOfficeAddress;
    @JsonAlias("Manager")
    private String manager;
    @JsonAlias("Mailing Address")
    private String mailingAddress;
    @JsonAlias("Mark Type")
    private String markType;
    @JsonAlias("nameHolders")
    private List<AmericaMinnesotaNameholder> nameholderList;
    @JsonAlias("markholders")
    private List<AmericaMinnesotaMarkholder> markholderList;

    public String getEnterpriseid() {
        return enterpriseid;
    }

    public void setEnterpriseid(String enterpriseid) {
        this.enterpriseid = enterpriseid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getMnStatute() {
        return mnStatute;
    }

    public void setMnStatute(String mnStatute) {
        this.mnStatute = mnStatute;
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

    public String getHomeJurisdiction() {
        return homeJurisdiction;
    }

    public void setHomeJurisdiction(String homeJurisdiction) {
        this.homeJurisdiction = homeJurisdiction;
    }

    public String getFilingDate() {
        return filingDate;
    }

    public void setFilingDate(String filingDate) {
        this.filingDate = filingDate;
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public String getRenewalDueDate() {
        return renewalDueDate;
    }

    public void setRenewalDueDate(String renewalDueDate) {
        this.renewalDueDate = renewalDueDate;
    }

    public String getRegisteredOfficeAddress() {
        return registeredOfficeAddress;
    }

    public void setRegisteredOfficeAddress(String registeredOfficeAddress) {
        this.registeredOfficeAddress = registeredOfficeAddress;
    }

    public String getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(String numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    public String getRegisteredAgent() {
        return registeredAgent;
    }

    public void setRegisteredAgent(String registeredAgent) {
        this.registeredAgent = registeredAgent;
    }

    public String getChiefExecutiveOfficer() {
        return chiefExecutiveOfficer;
    }

    public void setChiefExecutiveOfficer(String chiefExecutiveOfficer) {
        this.chiefExecutiveOfficer = chiefExecutiveOfficer;
    }

    public String getPrincipalExecutiveOfficeAddress() {
        return principalExecutiveOfficeAddress;
    }

    public void setPrincipalExecutiveOfficeAddress(String principalExecutiveOfficeAddress) {
        this.principalExecutiveOfficeAddress = principalExecutiveOfficeAddress;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getMarkType() {
        return markType;
    }

    public void setMarkType(String markType) {
        this.markType = markType;
    }

    public List<AmericaMinnesotaNameholder> getNameholderList() {
        return nameholderList;
    }

    public void setNameholderList(List<AmericaMinnesotaNameholder> nameholderList) {
        this.nameholderList = nameholderList;
    }

    public List<AmericaMinnesotaMarkholder> getMarkholderList() {
        return markholderList;
    }

    public void setMarkholderList(List<AmericaMinnesotaMarkholder> markholderList) {
        this.markholderList = markholderList;
    }
}