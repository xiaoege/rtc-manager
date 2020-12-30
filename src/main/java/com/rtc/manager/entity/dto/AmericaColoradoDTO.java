package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class AmericaColoradoDTO {

    private String url;

    @JsonAlias("Details")
    private AmericaColoradoDetailsDTO details;

    @JsonAlias("Registered Agent")
    private AmericaColoradoDetailsRegisteredAgentDTO registeredAgent;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public AmericaColoradoDetailsDTO getDetails() {
        return details;
    }

    public void setDetails(AmericaColoradoDetailsDTO details) {
        this.details = details;
    }

    public AmericaColoradoDetailsRegisteredAgentDTO getRegisteredAgent() {
        return registeredAgent;
    }

    public void setRegisteredAgent(AmericaColoradoDetailsRegisteredAgentDTO registeredAgent) {
        this.registeredAgent = registeredAgent;
    }
}