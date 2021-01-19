package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rtc.manager.entity.america.maine.AmericaMaineFiling;

import java.util.HashMap;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaMaineDTO {
    private String enterpriseId;
    @JsonAlias("Legal Name")
    private String name;

    @JsonAlias("Charter Number")
    private String charterNumber;

    @JsonAlias("Filing Type")
    private String filingType;

    @JsonAlias("Status")
    private String enterpriseStatus;

    @JsonAlias("otherNames")
    private List otherNames;

    private AmericaMaineRegisteredAgentDTO registeredAgent;

    @JsonAlias("filing")
    private List<AmericaMaineFiling> filingList;

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

    public String getCharterNumber() {
        return charterNumber;
    }

    public void setCharterNumber(String charterNumber) {
        this.charterNumber = charterNumber;
    }

    public String getFilingType() {
        return filingType;
    }

    public void setFilingType(String filingType) {
        this.filingType = filingType;
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public List getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(List otherNames) {
        this.otherNames = otherNames;
    }

    public AmericaMaineRegisteredAgentDTO getRegisteredAgent() {
        return registeredAgent;
    }

    public void setRegisteredAgent(AmericaMaineRegisteredAgentDTO registeredAgent) {
        this.registeredAgent = registeredAgent;
    }

    public List<AmericaMaineFiling> getFilingList() {
        return filingList;
    }

    public void setFilingList(List<AmericaMaineFiling> filingList) {
        this.filingList = filingList;
    }
}