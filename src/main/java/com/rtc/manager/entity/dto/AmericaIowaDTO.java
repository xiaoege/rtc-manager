package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rtc.manager.entity.america.iowa.AmericaIowaOfficer;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaIowaDTO {

    private AmericaIowaBasicDTO basic;

    private AmericaIowaRegisteredAgentDTO registeredAgent;

    private AmericaIowaOfficeDTO homeOffice;

    private List<AmericaIowaNamesDTO> names;

    private List<AmericaIowaOfficer> officers;

    public AmericaIowaBasicDTO getBasic() {
        return basic;
    }

    public void setBasic(AmericaIowaBasicDTO basic) {
        this.basic = basic;
    }

    public AmericaIowaRegisteredAgentDTO getRegisteredAgent() {
        return registeredAgent;
    }

    public void setRegisteredAgent(AmericaIowaRegisteredAgentDTO registeredAgent) {
        this.registeredAgent = registeredAgent;
    }

    public AmericaIowaOfficeDTO getHomeOffice() {
        return homeOffice;
    }

    public void setHomeOffice(AmericaIowaOfficeDTO homeOffice) {
        this.homeOffice = homeOffice;
    }

    public List<AmericaIowaNamesDTO> getNames() {
        return names;
    }

    public void setNames(List<AmericaIowaNamesDTO> names) {
        this.names = names;
    }

    public List<AmericaIowaOfficer> getOfficers() {
        return officers;
    }

    public void setOfficers(List<AmericaIowaOfficer> officers) {
        this.officers = officers;
    }
}