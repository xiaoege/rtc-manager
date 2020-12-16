package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

/**
 * @author ChenHang
 */
public class AmericaMichiganRegInfoDTO {
    @JsonAlias("RegInfoName")
    private String reginfonAme;
    @JsonAlias("RegInfoStreetAdd")
    private String reginfoStreet;
    @JsonAlias("RegInfoApt")
    private String reginfoApt;
    @JsonAlias("RegInfoCity")
    private String reginfoCity;
    @JsonAlias("RegInfoState")
    private String reginfoState;
    @JsonAlias("RegInfoZipCode")
    private String reginfoZipcode;
    @JsonAlias("ReginfoCountry")
    private String reginfoCountry;

    public String getReginfonAme() {
        return reginfonAme;
    }

    public void setReginfonAme(String reginfonAme) {
        this.reginfonAme = reginfonAme;
    }

    public String getReginfoStreet() {
        return reginfoStreet;
    }

    public void setReginfoStreet(String reginfoStreet) {
        this.reginfoStreet = reginfoStreet;
    }

    public String getReginfoApt() {
        return reginfoApt;
    }

    public void setReginfoApt(String reginfoApt) {
        this.reginfoApt = reginfoApt;
    }

    public String getReginfoCity() {
        return reginfoCity;
    }

    public void setReginfoCity(String reginfoCity) {
        this.reginfoCity = reginfoCity;
    }

    public String getReginfoState() {
        return reginfoState;
    }

    public void setReginfoState(String reginfoState) {
        this.reginfoState = reginfoState;
    }

    public String getReginfoZipcode() {
        return reginfoZipcode;
    }

    public void setReginfoZipcode(String reginfoZipcode) {
        this.reginfoZipcode = reginfoZipcode;
    }

    public String getReginfoCountry() {
        return reginfoCountry;
    }

    public void setReginfoCountry(String reginfoCountry) {
        this.reginfoCountry = reginfoCountry;
    }
}
