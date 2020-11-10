package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaWyomingPartyDTO {

    private String enterpriseId;
    @JsonAlias("PARTY_ID")
    private String partyId;
    @JsonAlias("PARTY_TYPE")
    private String partyType;
    @JsonAlias("SOURCE_ID")
    private String sourceId;
    @JsonAlias("SOURCE_TYPE")
    private String sourceType;
    @JsonAlias("ORG_NAME")
    private String orgName;
    @JsonAlias("FIRST_NAME")
    private String firstName;
    @JsonAlias("MIDDLE_NAME")
    private String middleName;
    @JsonAlias("LAST_NAME")
    private String lastName;
    @JsonAlias("INDIVIDUAL_TITLE")
    private String individualTitle;
    @JsonAlias("ADDR1")
    private String addr1;
    @JsonAlias("ADDR2")
    private String addr2;
    @JsonAlias("ADDR3")
    private String addr3;
    @JsonAlias("CITY")
    private String city;
    @JsonAlias("COUNTY")
    private String county;
    @JsonAlias("STATE")
    private String state;
    @JsonAlias("POSTAL_CODE")
    private String postalCode;
    @JsonAlias("COUNTRY")
    private String country;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getPartyType() {
        return partyType;
    }

    public void setPartyType(String partyType) {
        this.partyType = partyType;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIndividualTitle() {
        return individualTitle;
    }

    public void setIndividualTitle(String individualTitle) {
        this.individualTitle = individualTitle;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public String getAddr3() {
        return addr3;
    }

    public void setAddr3(String addr3) {
        this.addr3 = addr3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}