package com.rtc.manager.entity.america.alaska;

import java.time.LocalDateTime;

public class AmericaAlaska {
    private Integer id;

    private String enterpriseId;

    private String name;

    private String type;

    private String entityType;

    private String entityNumber;

    private String enterpriseStatus;

    private String akFormData;

    private String duration;

    private String homeState;

    private String entityMailingAddress;

    private String entityPhysicalAddress;

    private String agentName;

    private String registeredMailingAddress;

    private String registeredPhysicalAddress;

    private String nextBiennialReportDue;

    private String officialEntity;

    private String officialName;

    private String officialTite;

    private String officialOwned;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType == null ? null : entityType.trim();
    }

    public String getEntityNumber() {
        return entityNumber;
    }

    public void setEntityNumber(String entityNumber) {
        this.entityNumber = entityNumber == null ? null : entityNumber.trim();
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus == null ? null : enterpriseStatus.trim();
    }

    public String getAkFormData() {
        return akFormData;
    }

    public void setAkFormData(String akFormData) {
        this.akFormData = akFormData == null ? null : akFormData.trim();
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
    }

    public String getHomeState() {
        return homeState;
    }

    public void setHomeState(String homeState) {
        this.homeState = homeState == null ? null : homeState.trim();
    }

    public String getEntityMailingAddress() {
        return entityMailingAddress;
    }

    public void setEntityMailingAddress(String entityMailingAddress) {
        this.entityMailingAddress = entityMailingAddress == null ? null : entityMailingAddress.trim();
    }

    public String getEntityPhysicalAddress() {
        return entityPhysicalAddress;
    }

    public void setEntityPhysicalAddress(String entityPhysicalAddress) {
        this.entityPhysicalAddress = entityPhysicalAddress == null ? null : entityPhysicalAddress.trim();
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName == null ? null : agentName.trim();
    }

    public String getRegisteredMailingAddress() {
        return registeredMailingAddress;
    }

    public void setRegisteredMailingAddress(String registeredMailingAddress) {
        this.registeredMailingAddress = registeredMailingAddress == null ? null : registeredMailingAddress.trim();
    }

    public String getRegisteredPhysicalAddress() {
        return registeredPhysicalAddress;
    }

    public void setRegisteredPhysicalAddress(String registeredPhysicalAddress) {
        this.registeredPhysicalAddress = registeredPhysicalAddress == null ? null : registeredPhysicalAddress.trim();
    }

    public String getNextBiennialReportDue() {
        return nextBiennialReportDue;
    }

    public void setNextBiennialReportDue(String nextBiennialReportDue) {
        this.nextBiennialReportDue = nextBiennialReportDue == null ? null : nextBiennialReportDue.trim();
    }

    public String getOfficialEntity() {
        return officialEntity;
    }

    public void setOfficialEntity(String officialEntity) {
        this.officialEntity = officialEntity == null ? null : officialEntity.trim();
    }

    public String getOfficialName() {
        return officialName;
    }

    public void setOfficialName(String officialName) {
        this.officialName = officialName == null ? null : officialName.trim();
    }

    public String getOfficialTite() {
        return officialTite;
    }

    public void setOfficialTite(String officialTite) {
        this.officialTite = officialTite == null ? null : officialTite.trim();
    }

    public String getOfficialOwned() {
        return officialOwned;
    }

    public void setOfficialOwned(String officialOwned) {
        this.officialOwned = officialOwned == null ? null : officialOwned.trim();
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