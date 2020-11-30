package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rtc.manager.entity.america.mississippi.AmericaMississippiNameHistory;
import com.rtc.manager.entity.america.mississippi.AmericaMississippiOfficeDirector;
import com.rtc.manager.entity.america.mississippi.AmericaMississippiRegisteredAgent;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaMississippiDTO {
    private String enterpriseId;

    private String name;

    @JsonAlias("businessInformation")
    private AmericaMississippiBusinessInformationDTO businessInformation;

    @JsonAlias("nameHistory")
    private List<AmericaMississippiNameHistory> nameHistoryList;
    @JsonAlias("officeDirectors")
    private List<AmericaMississippiOfficeDirector> officeDirectorList;
    @JsonAlias("registeredAgent")
    private List<AmericaMississippiRegisteredAgent> registeredAgentList;

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

    public AmericaMississippiBusinessInformationDTO getBusinessInformation() {
        return businessInformation;
    }

    public void setBusinessInformation(AmericaMississippiBusinessInformationDTO businessInformation) {
        this.businessInformation = businessInformation;
    }

    public List<AmericaMississippiNameHistory> getNameHistoryList() {
        return nameHistoryList;
    }

    public void setNameHistoryList(List<AmericaMississippiNameHistory> nameHistoryList) {
        this.nameHistoryList = nameHistoryList;
    }

    public List<AmericaMississippiOfficeDirector> getOfficeDirectorList() {
        return officeDirectorList;
    }

    public void setOfficeDirectorList(List<AmericaMississippiOfficeDirector> officeDirectorList) {
        this.officeDirectorList = officeDirectorList;
    }

    public List<AmericaMississippiRegisteredAgent> getRegisteredAgentList() {
        return registeredAgentList;
    }

    public void setRegisteredAgentList(List<AmericaMississippiRegisteredAgent> registeredAgentList) {
        this.registeredAgentList = registeredAgentList;
    }
}