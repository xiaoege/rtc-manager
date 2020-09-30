package com.rtc.manager.entity.america.alabama;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaAlabama {
    private Integer id;

    private String enterpriseId;

    private String name;

    private String entityIdNumber;

    private String entityType;

    private String principalAddress;

    private String principalMailingAddress;

    private String enterpriseStatus;

    private String placeOfFormation;

    private String formationDate;

    private String registeredAgentName;

    private String registeredOfficeStreetAddress;

    private String registeredOfficeMailingAddress;

    private String natureOfBusiness;

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

    public String getEntityIdNumber() {
        return entityIdNumber;
    }

    public void setEntityIdNumber(String entityIdNumber) {
        this.entityIdNumber = entityIdNumber == null ? null : entityIdNumber.trim();
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType == null ? null : entityType.trim();
    }

    public String getPrincipalAddress() {
        return principalAddress;
    }

    public void setPrincipalAddress(String principalAddress) {
        this.principalAddress = principalAddress == null ? null : principalAddress.trim();
    }

    public String getPrincipalMailingAddress() {
        return principalMailingAddress;
    }

    public void setPrincipalMailingAddress(String principalMailingAddress) {
        this.principalMailingAddress = principalMailingAddress == null ? null : principalMailingAddress.trim();
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus == null ? null : enterpriseStatus.trim();
    }

    public String getPlaceOfFormation() {
        return placeOfFormation;
    }

    public void setPlaceOfFormation(String placeOfFormation) {
        this.placeOfFormation = placeOfFormation == null ? null : placeOfFormation.trim();
    }

    public String getFormationDate() {
        return formationDate;
    }

    public void setFormationDate(String formationDate) {
        this.formationDate = formationDate == null ? null : formationDate.trim();
    }

    public String getRegisteredAgentName() {
        return registeredAgentName;
    }

    public void setRegisteredAgentName(String registeredAgentName) {
        this.registeredAgentName = registeredAgentName == null ? null : registeredAgentName.trim();
    }

    public String getRegisteredOfficeStreetAddress() {
        return registeredOfficeStreetAddress;
    }

    public void setRegisteredOfficeStreetAddress(String registeredOfficeStreetAddress) {
        this.registeredOfficeStreetAddress = registeredOfficeStreetAddress == null ? null : registeredOfficeStreetAddress.trim();
    }

    public String getRegisteredOfficeMailingAddress() {
        return registeredOfficeMailingAddress;
    }

    public void setRegisteredOfficeMailingAddress(String registeredOfficeMailingAddress) {
        this.registeredOfficeMailingAddress = registeredOfficeMailingAddress == null ? null : registeredOfficeMailingAddress.trim();
    }

    public String getNatureOfBusiness() {
        return natureOfBusiness;
    }

    public void setNatureOfBusiness(String natureOfBusiness) {
        this.natureOfBusiness = natureOfBusiness == null ? null : natureOfBusiness.trim();
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