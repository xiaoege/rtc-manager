package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author ChenHang
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaRhodeislandResidentLocationDTO {
    private String residentAgentName;
    private String residentStreet;
    private String residentCity;
    private String residentState;
    private String residentZip;
    private String residentCountry;

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

    public String getResidentCountry() {
        return residentCountry;
    }

    public void setResidentCountry(String residentCountry) {
        this.residentCountry = residentCountry;
    }
}
