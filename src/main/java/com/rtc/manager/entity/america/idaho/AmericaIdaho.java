package com.rtc.manager.entity.america.idaho;

import java.time.LocalDateTime;

public class AmericaIdaho {
    private Integer id;

    private String enterpriseId;

    private String name;

    private String number;

    private String filingType;

    private String enterpriseStatus;

    private String formedIn;

    private String durationTerm;

    private String principalAddress;

    private String mailingAddress;

    private String initialFilingDate;

    private String arDueDate;

    private String registeredAgent;

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getFilingType() {
        return filingType;
    }

    public void setFilingType(String filingType) {
        this.filingType = filingType == null ? null : filingType.trim();
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus == null ? null : enterpriseStatus.trim();
    }

    public String getFormedIn() {
        return formedIn;
    }

    public void setFormedIn(String formedIn) {
        this.formedIn = formedIn == null ? null : formedIn.trim();
    }

    public String getDurationTerm() {
        return durationTerm;
    }

    public void setDurationTerm(String durationTerm) {
        this.durationTerm = durationTerm == null ? null : durationTerm.trim();
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

    public String getInitialFilingDate() {
        return initialFilingDate;
    }

    public void setInitialFilingDate(String initialFilingDate) {
        this.initialFilingDate = initialFilingDate == null ? null : initialFilingDate.trim();
    }

    public String getArDueDate() {
        return arDueDate;
    }

    public void setArDueDate(String arDueDate) {
        this.arDueDate = arDueDate == null ? null : arDueDate.trim();
    }

    public String getRegisteredAgent() {
        return registeredAgent;
    }

    public void setRegisteredAgent(String registeredAgent) {
        this.registeredAgent = registeredAgent == null ? null : registeredAgent.trim();
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