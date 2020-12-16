package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

/**
 * @author ChenHang
 */
public class AmericaMichiganResidentDTO {
    @JsonAlias("ResidentAgentName")
    private String residentAgentName;
    @JsonAlias("ResidentStreet")
    private String residentStreet;
    @JsonAlias("aptsuiteother")
    private String aptsuiteother;
    @JsonAlias("ResidentCity")
    private String residentCity;
    @JsonAlias("ResidentState")
    private String residentState;
    @JsonAlias("ResidentZip")
    private String residentZip;

    public String getResidentAgentName() {
        return residentAgentName;
    }

    public void setResidentAgentName(String residentAgentName) {
        this.residentAgentName = residentAgentName;
    }

    public String getResidentStreet() {
        return residentStreet;
    }

    public void setResidentStreet(String residentStreet) {
        this.residentStreet = residentStreet;
    }

    public String getAptsuiteother() {
        return aptsuiteother;
    }

    public void setAptsuiteother(String aptsuiteother) {
        this.aptsuiteother = aptsuiteother;
    }

    public String getResidentCity() {
        return residentCity;
    }

    public void setResidentCity(String residentCity) {
        this.residentCity = residentCity;
    }

    public String getResidentState() {
        return residentState;
    }

    public void setResidentState(String residentState) {
        this.residentState = residentState;
    }

    public String getResidentZip() {
        return residentZip;
    }

    public void setResidentZip(String residentZip) {
        this.residentZip = residentZip;
    }
}
