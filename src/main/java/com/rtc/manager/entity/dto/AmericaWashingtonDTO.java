package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rtc.manager.entity.america.washington.AmericaWashingtonGovernor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaWashingtonDTO {
    @JsonAlias("Business Name")
    private String name;

    @JsonAlias("UBI Number")
    private String ubiNumber;

    @JsonAlias("Business Type")
    private String businessType;

    @JsonAlias("Business Status")
    private String businessStatus;

    @JsonAlias("Principal Office Street Address")
    private String address;

    @JsonAlias("Principal Office Mailing Address")
    private String mailingAddress;

    @JsonAlias("Expiration Date")
    private String expirationDate;

    @JsonAlias("Jurisdiction")
    private String jurisdiction;

    @JsonAlias("Formation/ Registration Date")
    private String registrationDate;

    @JsonAlias("Period of Duration")
    private String durationPeriod;

    @JsonAlias("Inactive Date")
    private String inactiveDate;

    @JsonAlias("Nature of Business")
    private String businessNature;

    private HashMap<String, String> registered;

    private List<AmericaWashingtonGovernor> governors;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUbiNumber() {
        return ubiNumber;
    }

    public void setUbiNumber(String ubiNumber) {
        this.ubiNumber = ubiNumber;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(String businessStatus) {
        this.businessStatus = businessStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getDurationPeriod() {
        return durationPeriod;
    }

    public void setDurationPeriod(String durationPeriod) {
        this.durationPeriod = durationPeriod;
    }

    public String getInactiveDate() {
        return inactiveDate;
    }

    public void setInactiveDate(String inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

    public String getBusinessNature() {
        return businessNature;
    }

    public void setBusinessNature(String businessNature) {
        this.businessNature = businessNature;
    }

    public HashMap<String, String> getRegistered() {
        return registered == null ? new HashMap<>() : registered;
    }

    public void setRegistered(HashMap<String, String> registered) {
        this.registered = registered;
    }

    public List<AmericaWashingtonGovernor> getGovernors() {
        return governors == null ? new ArrayList<>() : governors;
    }

    public void setGovernors(List<AmericaWashingtonGovernor> governors) {
        this.governors = governors;
    }

}