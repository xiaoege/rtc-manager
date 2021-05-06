package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaIowaOfficeDTO {

    @JsonAlias("Full Name")
    private String officeFullName;

    @JsonAlias("Address")
    private String officeAddress;

    @JsonAlias("Address 2")
    private String officeSpareAddress;

    @JsonAlias("city")
    private String officeCity;

    @JsonAlias("state")
    private String officeState;

    @JsonAlias("zip")
    private String officeZip;

    public String getOfficeFullName() {
        return officeFullName;
    }

    public void setOfficeFullName(String officeFullName) {
        this.officeFullName = officeFullName;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getOfficeSpareAddress() {
        return officeSpareAddress;
    }

    public void setOfficeSpareAddress(String officeSpareAddress) {
        this.officeSpareAddress = officeSpareAddress;
    }

    public String getOfficeCity() {
        return officeCity;
    }

    public void setOfficeCity(String officeCity) {
        this.officeCity = officeCity;
    }

    public String getOfficeState() {
        return officeState;
    }

    public void setOfficeState(String officeState) {
        this.officeState = officeState;
    }

    public String getOfficeZip() {
        return officeZip;
    }

    public void setOfficeZip(String officeZip) {
        this.officeZip = officeZip;
    }
}