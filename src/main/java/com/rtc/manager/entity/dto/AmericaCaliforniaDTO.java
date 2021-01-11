package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaCaliforniaDTO {
    private String enterpriseId;
    @JsonAlias("Entity Number")
    private String entityNumber;
    @JsonAlias("Entity Name")
    private String name;
    @JsonAlias("Registration Date")
    private String registrationDate;
    @JsonAlias("Jurisdiction")
    private String jurisdiction;
    @JsonAlias("Entity Type")
    private String entityType;
    @JsonAlias("Status")
    private String enterpriseStatus;
    @JsonAlias("Agent for Service of Process")
    private AmericaCaliforniaAgentDTO agentDTO;
    @JsonAlias("Entity Address")
    private AmericaCaliforniaAddressDTO addressDTO;
    @JsonAlias("Entity Mailing Address")
    private AmericaCaliforniaMailDTO mailDTO;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;
    @JsonIgnore
    private Integer status;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEntityNumber() {
        return entityNumber;
    }

    public void setEntityNumber(String entityNumber) {
        this.entityNumber = entityNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public AmericaCaliforniaAgentDTO getAgentDTO() {
        return agentDTO;
    }

    public void setAgentDTO(AmericaCaliforniaAgentDTO agentDTO) {
        this.agentDTO = agentDTO;
    }

    public AmericaCaliforniaAddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AmericaCaliforniaAddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public AmericaCaliforniaMailDTO getMailDTO() {
        return mailDTO;
    }

    public void setMailDTO(AmericaCaliforniaMailDTO mailDTO) {
        this.mailDTO = mailDTO;
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