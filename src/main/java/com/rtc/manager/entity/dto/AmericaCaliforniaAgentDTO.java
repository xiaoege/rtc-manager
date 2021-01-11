package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author ChenHang
 */
public class AmericaCaliforniaAgentDTO {
    @JsonAlias("Name")
    private String agentName;
    @JsonAlias("Address")
    private String agentAddress;
    @JsonAlias("City")
    private String agentCity;
    @JsonAlias("State")
    private String agentState;
    @JsonAlias("Zip")
    private String agentZip;

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
