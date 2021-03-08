package com.rtc.manager.entity.america.americaarkansas;

import java.time.LocalDateTime;

public class AmericaArkansas {
    private Integer id;

    private String enterpriseId;

    private String name;

    private String fictitiousName;

    private String filingNumber;

    private String filingType;

    private String filedUnderAct;

    private String enterpriseStatus;

    private String principalAddress;

    private String regAgent;

    private String agentAddress;

    private String filedDate;

    private String officer;

    private String foreignName;

    private String foreignAddress;

    private String originState;

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

    public String getFictitiousName() {
        return fictitiousName;
    }

    public void setFictitiousName(String fictitiousName) {
        this.fictitiousName = fictitiousName == null ? null : fictitiousName.trim();
    }

    public String getFilingNumber() {
        return filingNumber;
    }

    public void setFilingNumber(String filingNumber) {
        this.filingNumber = filingNumber == null ? null : filingNumber.trim();
    }

    public String getFilingType() {
        return filingType;
    }

    public void setFilingType(String filingType) {
        this.filingType = filingType == null ? null : filingType.trim();
    }

    public String getFiledUnderAct() {
        return filedUnderAct;
    }

    public void setFiledUnderAct(String filedUnderAct) {
        this.filedUnderAct = filedUnderAct == null ? null : filedUnderAct.trim();
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus == null ? null : enterpriseStatus.trim();
    }

    public String getPrincipalAddress() {
        return principalAddress;
    }

    public void setPrincipalAddress(String principalAddress) {
        this.principalAddress = principalAddress == null ? null : principalAddress.trim();
    }

    public String getRegAgent() {
        return regAgent;
    }

    public void setRegAgent(String regAgent) {
        this.regAgent = regAgent == null ? null : regAgent.trim();
    }

    public String getAgentAddress() {
        return agentAddress;
    }

    public void setAgentAddress(String agentAddress) {
        this.agentAddress = agentAddress == null ? null : agentAddress.trim();
    }

    public String getFiledDate() {
        return filedDate;
    }

    public void setFiledDate(String filedDate) {
        this.filedDate = filedDate == null ? null : filedDate.trim();
    }

    public String getOfficer() {
        return officer;
    }

    public void setOfficer(String officer) {
        this.officer = officer == null ? null : officer.trim();
    }

    public String getForeignName() {
        return foreignName;
    }

    public void setForeignName(String foreignName) {
        this.foreignName = foreignName == null ? null : foreignName.trim();
    }

    public String getForeignAddress() {
        return foreignAddress;
    }

    public void setForeignAddress(String foreignAddress) {
        this.foreignAddress = foreignAddress == null ? null : foreignAddress.trim();
    }

    public String getOriginState() {
        return originState;
    }

    public void setOriginState(String originState) {
        this.originState = originState == null ? null : originState.trim();
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