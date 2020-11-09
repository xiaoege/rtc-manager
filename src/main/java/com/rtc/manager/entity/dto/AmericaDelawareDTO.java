package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaDelawareDTO {
    private String enterpriseId;
    @JsonAlias("File Number")
    private String fileNumber;
    @JsonAlias("Entity Name")
    private String name;
    @JsonAlias("Entity Kind")
    private String entityKind;
    @JsonAlias("Residency")
    private String residency;
    @JsonAlias({"Incorporation Date / Formation Date", "Incorporation Date_Formation Date"})
    private String incorporationFormationDate;
    @JsonAlias("Entity Type")
    private String entityType;
    @JsonAlias("State")
    private String state;
    @JsonAlias("Agent Name")
    private String agentName;
    @JsonAlias("Agent Address")
    private String agentAddress;
    @JsonAlias("Agent City")
    private String agentCity;
    @JsonAlias("Agent County")
    private String agentCounty;
    @JsonAlias("Agent State")
    private String agentState;
    @JsonAlias("Agent Postal Code")
    private String agentPostalCode;
    @JsonAlias("Agent Phone")
    private String agentPhone;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEntityKind() {
        return entityKind;
    }

    public void setEntityKind(String entityKind) {
        this.entityKind = entityKind;
    }

    public String getResidency() {
        return residency;
    }

    public void setResidency(String residency) {
        this.residency = residency;
    }

    public String getIncorporationFormationDate() {
        return incorporationFormationDate;
    }

    public void setIncorporationFormationDate(String incorporationFormationDate) {
        this.incorporationFormationDate = incorporationFormationDate;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentAddress() {
        return agentAddress;
    }

    public void setAgentAddress(String agentAddress) {
        this.agentAddress = agentAddress;
    }

    public String getAgentCity() {
        return agentCity;
    }

    public void setAgentCity(String agentCity) {
        this.agentCity = agentCity;
    }

    public String getAgentCounty() {
        return agentCounty;
    }

    public void setAgentCounty(String agentCounty) {
        this.agentCounty = agentCounty;
    }

    public String getAgentState() {
        return agentState;
    }

    public void setAgentState(String agentState) {
        this.agentState = agentState;
    }

    public String getAgentPostalCode() {
        return agentPostalCode;
    }

    public void setAgentPostalCode(String agentPostalCode) {
        this.agentPostalCode = agentPostalCode;
    }

    public String getAgentPhone() {
        return agentPhone;
    }

    public void setAgentPhone(String agentPhone) {
        this.agentPhone = agentPhone;
    }
}