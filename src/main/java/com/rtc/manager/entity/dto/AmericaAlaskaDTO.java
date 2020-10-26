package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaAlaskaDTO {
    private String enterpriseId;
    @JsonAlias("Company Name")
    private String name;
    @JsonAlias("Company Type")
    private String type;
    @JsonAlias("Entity Type")
    private String entityType;
    @JsonAlias("Entity #")
    private String entityNumber;
    @JsonAlias("Status")
    private String enterpriseStatus;
    @JsonAlias("Ak form data")
    private String akFormData;
    @JsonAlias("Duration/Expiration")
    private String duration;
    @JsonAlias("Home state")
    private String homeState;
    @JsonAlias("Entity Mailing Address")
    private String entityMailingAddress;
    @JsonAlias("Entity Physical Address")
    private String entityPhysicalAddress;
    @JsonAlias("Agent Name")
    private String agentName;
    @JsonAlias("Registered mailing address")
    private String registeredMailingAddress;
    @JsonAlias("Registered physical address")
    private String registeredPhysicalAddress;
    @JsonAlias("Next Biennial Report Due")
    private List<String> nextBiennialReportDue;
    @JsonAlias("Official Entity")
    private List<String> officialEntity;
    @JsonAlias("Official Name")
    private List<String> officialName;
    @JsonAlias("Official Tite")
    private List<String> officialTite;
    @JsonAlias("Official Owned")
    private List<String> officialOwned;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getEntityNumber() {
        return entityNumber;
    }

    public void setEntityNumber(String entityNumber) {
        this.entityNumber = entityNumber;
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public String getAkFormData() {
        return akFormData;
    }

    public void setAkFormData(String akFormData) {
        this.akFormData = akFormData;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getHomeState() {
        return homeState;
    }

    public void setHomeState(String homeState) {
        this.homeState = homeState;
    }

    public String getEntityMailingAddress() {
        return entityMailingAddress;
    }

    public void setEntityMailingAddress(String entityMailingAddress) {
        this.entityMailingAddress = entityMailingAddress;
    }

    public String getEntityPhysicalAddress() {
        return entityPhysicalAddress;
    }

    public void setEntityPhysicalAddress(String entityPhysicalAddress) {
        this.entityPhysicalAddress = entityPhysicalAddress;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getRegisteredMailingAddress() {
        return registeredMailingAddress;
    }

    public void setRegisteredMailingAddress(String registeredMailingAddress) {
        this.registeredMailingAddress = registeredMailingAddress;
    }

    public String getRegisteredPhysicalAddress() {
        return registeredPhysicalAddress;
    }

    public void setRegisteredPhysicalAddress(String registeredPhysicalAddress) {
        this.registeredPhysicalAddress = registeredPhysicalAddress;
    }

    public List<String> getNextBiennialReportDue() {
        return nextBiennialReportDue;
    }

    public void setNextBiennialReportDue(List<String> nextBiennialReportDue) {
        this.nextBiennialReportDue = nextBiennialReportDue;
    }

    public List<String> getOfficialEntity() {
        return officialEntity;
    }

    public void setOfficialEntity(List<String> officialEntity) {
        this.officialEntity = officialEntity;
    }

    public List<String> getOfficialName() {
        return officialName;
    }

    public void setOfficialName(List<String> officialName) {
        this.officialName = officialName;
    }

    public List<String> getOfficialTite() {
        return officialTite;
    }

    public void setOfficialTite(List<String> officialTite) {
        this.officialTite = officialTite;
    }

    public List<String> getOfficialOwned() {
        return officialOwned;
    }

    public void setOfficialOwned(List<String> officialOwned) {
        this.officialOwned = officialOwned;
    }
}