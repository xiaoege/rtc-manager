package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaVermountAssumedBusinessDTO {
    @JsonAlias("Assumed Business Name")
    private String assumedBusinessName;

    @JsonAlias("Business ID")
    private String businessId;

    @JsonAlias("Registration Status")
    private String registrationStatus;

    public String getAssumedBusinessName() {
        return assumedBusinessName;
    }

    public void setAssumedBusinessName(String assumedBusinessName) {
        this.assumedBusinessName = assumedBusinessName;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus;
    }
}