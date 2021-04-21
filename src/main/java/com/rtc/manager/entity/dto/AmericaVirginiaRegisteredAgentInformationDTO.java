package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaVirginiaRegisteredAgentInformationDTO {
    @JsonAlias("RA Type:")
    private String raType;
    @JsonAlias("Locality:")
    private String raLocality;
    @JsonAlias("RA Qualification:")
    private String raQualification;
    @JsonAlias("Name:")
    private String raName;
    @JsonAlias("Registered Office Address:")
    private String raAddress;

    public String getRaType() {
        return raType;
    }

    public void setRaType(String raType) {
        this.raType = raType;
    }

    public String getRaLocality() {
        return raLocality;
    }

    public void setRaLocality(String raLocality) {
        this.raLocality = raLocality;
    }

    public String getRaQualification() {
        return raQualification;
    }

    public void setRaQualification(String raQualification) {
        this.raQualification = raQualification;
    }

    public String getRaName() {
        return raName;
    }

    public void setRaName(String raName) {
        this.raName = raName;
    }

    public String getRaAddress() {
        return raAddress;
    }

    public void setRaAddress(String raAddress) {
        this.raAddress = raAddress;
    }
}