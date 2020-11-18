package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author ChenHang
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaRhodeislandOfficeLocationDTO {
    private String officeStreet;
    private String officeCity;
    private String officeState;
    private String officeZip;
    private String officeCountry;

    public String getOfficeStreet() {
        return officeStreet;
    }

    public void setOfficeStreet(String officeStreet) {
        this.officeStreet = officeStreet;
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

    public String getOfficeCountry() {
        return officeCountry;
    }

    public void setOfficeCountry(String officeCountry) {
        this.officeCountry = officeCountry;
    }
}
