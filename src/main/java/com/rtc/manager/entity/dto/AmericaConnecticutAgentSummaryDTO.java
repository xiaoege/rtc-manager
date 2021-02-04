package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaConnecticutAgentSummaryDTO {
    @JsonAlias("Agent Name")
    private String agentName;
    @JsonAlias("Agent Business Address")
    private String agentBusinessAddress;
    @JsonAlias("Agent Residence Address")
    private String agentResidenceAddress;

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentBusinessAddress() {
        return agentBusinessAddress;
    }

    public void setAgentBusinessAddress(String agentBusinessAddress) {
        this.agentBusinessAddress = agentBusinessAddress;
    }

    public String getAgentResidenceAddress() {
        return agentResidenceAddress;
    }

    public void setAgentResidenceAddress(String agentResidenceAddress) {
        this.agentResidenceAddress = agentResidenceAddress;
    }
}