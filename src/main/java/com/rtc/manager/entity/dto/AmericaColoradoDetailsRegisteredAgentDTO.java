package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class AmericaColoradoDetailsRegisteredAgentDTO {
    @JsonAlias("Name")
    private String agentName;

    @JsonAlias("Street address")
    private String agentStreetAddress;

    @JsonAlias("Mailing address")
    private String agentMailingAddress;

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentStreetAddress() {
        return agentStreetAddress;
    }

    public void setAgentStreetAddress(String agentStreetAddress) {
        this.agentStreetAddress = agentStreetAddress;
    }

    public String getAgentMailingAddress() {
        return agentMailingAddress;
    }

    public void setAgentMailingAddress(String agentMailingAddress) {
        this.agentMailingAddress = agentMailingAddress;
    }
}