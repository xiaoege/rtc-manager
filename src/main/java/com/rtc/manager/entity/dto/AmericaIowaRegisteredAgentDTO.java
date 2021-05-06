package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaIowaRegisteredAgentDTO {

    @JsonAlias("Full Name")
    private String agentFullName;

    @JsonAlias("Address")
    private String agentAddress;

    @JsonAlias("Address 2")
    private String agentSpareAddress;

    @JsonAlias("city")
    private String agentCity;

    @JsonAlias("state")
    private String agentState;

    @JsonAlias("zip")
    private String agentZip;

    public String getAgentFullName() {
        return agentFullName;
    }

    public void setAgentFullName(String agentFullName) {
        this.agentFullName = agentFullName;
    }

    public String getAgentAddress() {
        return agentAddress;
    }

    public void setAgentAddress(String agentAddress) {
        this.agentAddress = agentAddress;
    }

    public String getAgentSpareAddress() {
        return agentSpareAddress;
    }

    public void setAgentSpareAddress(String agentSpareAddress) {
        this.agentSpareAddress = agentSpareAddress;
    }

    public String getAgentCity() {
        return agentCity;
    }

    public void setAgentCity(String agentCity) {
        this.agentCity = agentCity;
    }

    public String getAgentState() {
        return agentState;
    }

    public void setAgentState(String agentState) {
        this.agentState = agentState;
    }

    public String getAgentZip() {
        return agentZip;
    }

    public void setAgentZip(String agentZip) {
        this.agentZip = agentZip;
    }
}