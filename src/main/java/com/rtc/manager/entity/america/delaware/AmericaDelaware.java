package com.rtc.manager.entity.america.delaware;

import java.time.LocalDateTime;

public class AmericaDelaware {
    private Integer id;

    private String enterpriseId;

    private String fileNumber;

    private String name;

    private String entityKind;

    private String residency;

    private String incorporationFormationDate;

    private String entityType;

    private String state;

    private String agentName;

    private String agentAddress;

    private String agentCity;

    private String agentCounty;

    private String agentState;

    private String agentPostalCode;

    private String agentPhone;

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

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber == null ? null : fileNumber.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEntityKind() {
        return entityKind;
    }

    public void setEntityKind(String entityKind) {
        this.entityKind = entityKind == null ? null : entityKind.trim();
    }

    public String getResidency() {
        return residency;
    }

    public void setResidency(String residency) {
        this.residency = residency == null ? null : residency.trim();
    }

    public String getIncorporationFormationDate() {
        return incorporationFormationDate;
    }

    public void setIncorporationFormationDate(String incorporationFormationDate) {
        this.incorporationFormationDate = incorporationFormationDate == null ? null : incorporationFormationDate.trim();
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType == null ? null : entityType.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName == null ? null : agentName.trim();
    }

    public String getAgentAddress() {
        return agentAddress;
    }

    public void setAgentAddress(String agentAddress) {
        this.agentAddress = agentAddress == null ? null : agentAddress.trim();
    }

    public String getAgentCity() {
        return agentCity;
    }

    public void setAgentCity(String agentCity) {
        this.agentCity = agentCity == null ? null : agentCity.trim();
    }

    public String getAgentCounty() {
        return agentCounty;
    }

    public void setAgentCounty(String agentCounty) {
        this.agentCounty = agentCounty == null ? null : agentCounty.trim();
    }

    public String getAgentState() {
        return agentState;
    }

    public void setAgentState(String agentState) {
        this.agentState = agentState == null ? null : agentState.trim();
    }

    public String getAgentPostalCode() {
        return agentPostalCode;
    }

    public void setAgentPostalCode(String agentPostalCode) {
        this.agentPostalCode = agentPostalCode == null ? null : agentPostalCode.trim();
    }

    public String getAgentPhone() {
        return agentPhone;
    }

    public void setAgentPhone(String agentPhone) {
        this.agentPhone = agentPhone == null ? null : agentPhone.trim();
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