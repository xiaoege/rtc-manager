package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author ChenHang
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaRhodeislandPrincipleLocationDTO {
    private String principleStreet;
    private String principleCity;
    private String principleState;
    private String principleZip;
    private String principleCountry;

    public String getPrincipleStreet() {
        return principleStreet;
    }

    public void setPrincipleStreet(String principleStreet) {
        this.principleStreet = principleStreet;
    }

    public String getPrincipleCity() {
        return principleCity;
    }

    public void setPrincipleCity(String principleCity) {
        this.principleCity = principleCity;
    }

    public String getPrincipleState() {
        return principleState;
    }

    public void setPrincipleState(String principleState) {
        this.principleState = principleState;
    }

    public String getPrincipleZip() {
        return principleZip;
    }

    public void setPrincipleZip(String principleZip) {
        this.principleZip = principleZip;
    }

    public String getPrincipleCountry() {
        return principleCountry;
    }

    public void setPrincipleCountry(String principleCountry) {
        this.principleCountry = principleCountry;
    }
}
