package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaIdahoDTO {
    private String enterpriseId;

    private String name;

    @JsonAlias("id")
    private String number;

    @JsonAlias("Filing Type")
    private String filingType;

    @JsonAlias("Status")
    private String enterpriseStatus;

    @JsonAlias("Formed In")
    private String formedIn;

    @JsonAlias("Term of Duration")
    private String durationTerm;

    @JsonAlias("Principal Address")
    private String principalAddress;

    @JsonAlias("Mailing Address")
    private String mailingAddress;

    @JsonAlias("Initial Filing Date")
    private String initialFilingDate;

    @JsonAlias("AR Due Date")
    private String arDueDate;

    @JsonAlias("Registered Agent")
    private String registeredAgent;

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFilingType() {
        return filingType;
    }

    public void setFilingType(String filingType) {
        this.filingType = filingType;
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public String getFormedIn() {
        return formedIn;
    }

    public void setFormedIn(String formedIn) {
        this.formedIn = formedIn;
    }

    public String getDurationTerm() {
        return durationTerm;
    }

    public void setDurationTerm(String durationTerm) {
        this.durationTerm = durationTerm;
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

    public String getInitialFilingDate() {
        return initialFilingDate;
    }

    public void setInitialFilingDate(String initialFilingDate) {
        this.initialFilingDate = initialFilingDate;
    }

    public String getArDueDate() {
        return arDueDate;
    }

    public void setArDueDate(String arDueDate) {
        this.arDueDate = arDueDate;
    }

    public String getRegisteredAgent() {
        return registeredAgent;
    }

    public void setRegisteredAgent(String registeredAgent) {
        this.registeredAgent = registeredAgent;
    }
}