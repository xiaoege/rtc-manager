package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rtc.manager.entity.america.rhodeisland.AmericaRhodeislandManagerBusiness;
import com.rtc.manager.entity.america.rhodeisland.AmericaRhodeislandOfficerDirctor;
import com.rtc.manager.entity.america.rhodeisland.AmericaRhodeislandStock;

import java.util.List;

/**
 * @author ChenHang
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaRhodeislandDTO {
    private String enterpriseId;

    private String name;
    @JsonAlias("entityType")
    private String type;
    private String organisationDate;
    private String effectiveDate;
    private String residentAgentFlag;
    private String consentFlag;
    @JsonAlias("IDNumber")
    private String number;
    private String state;
    private String country;

    @JsonAlias("principleLocation")
    private AmericaRhodeislandPrincipleLocationDTO principleLocation;
    @JsonAlias("officeLocation")
    private AmericaRhodeislandOfficeLocationDTO officeLocation;
    @JsonAlias("residentLocation")
    private AmericaRhodeislandResidentLocationDTO residentLocation;

    private String purpose;
    @JsonAlias("NAICS")
    private String naics;
    private String url;
    @JsonAlias("officersAndDirctors")
    private List<AmericaRhodeislandOfficerDirctor> officerDirctorList;
    @JsonAlias("managerBusiness")
    private List<AmericaRhodeislandManagerBusiness> managerBusinessList;
    @JsonAlias("stocks")
    private List<AmericaRhodeislandStock> stockList;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrganisationDate() {
        return organisationDate;
    }

    public void setOrganisationDate(String organisationDate) {
        this.organisationDate = organisationDate;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getResidentAgentFlag() {
        return residentAgentFlag;
    }

    public void setResidentAgentFlag(String residentAgentFlag) {
        this.residentAgentFlag = residentAgentFlag;
    }

    public String getConsentFlag() {
        return consentFlag;
    }

    public void setConsentFlag(String consentFlag) {
        this.consentFlag = consentFlag;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public AmericaRhodeislandPrincipleLocationDTO getPrincipleLocation() {
        return principleLocation;
    }

    public void setPrincipleLocation(AmericaRhodeislandPrincipleLocationDTO principleLocation) {
        this.principleLocation = principleLocation;
    }

    public AmericaRhodeislandOfficeLocationDTO getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(AmericaRhodeislandOfficeLocationDTO officeLocation) {
        this.officeLocation = officeLocation;
    }

    public AmericaRhodeislandResidentLocationDTO getResidentLocation() {
        return residentLocation;
    }

    public void setResidentLocation(AmericaRhodeislandResidentLocationDTO residentLocation) {
        this.residentLocation = residentLocation;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getNaics() {
        return naics;
    }

    public void setNaics(String naics) {
        this.naics = naics;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<AmericaRhodeislandOfficerDirctor> getOfficerDirctorList() {
        return officerDirctorList;
    }

    public void setOfficerDirctorList(List<AmericaRhodeislandOfficerDirctor> officerDirctorList) {
        this.officerDirctorList = officerDirctorList;
    }

    public List<AmericaRhodeislandManagerBusiness> getManagerBusinessList() {
        return managerBusinessList;
    }

    public void setManagerBusinessList(List<AmericaRhodeislandManagerBusiness> managerBusinessList) {
        this.managerBusinessList = managerBusinessList;
    }

    public List<AmericaRhodeislandStock> getStockList() {
        return stockList;
    }

    public void setStockList(List<AmericaRhodeislandStock> stockList) {
        this.stockList = stockList;
    }
}
