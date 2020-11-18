package com.rtc.manager.entity.america.rhodeisland;

import com.rtc.manager.entity.dto.AmericaRhodeislandOfficeLocationDTO;
import com.rtc.manager.entity.dto.AmericaRhodeislandPrincipleLocationDTO;
import com.rtc.manager.entity.dto.AmericaRhodeislandResidentLocationDTO;

import java.time.LocalDateTime;

public class AmericaRhodeisland {
    public AmericaRhodeisland() {
    }

    public AmericaRhodeisland(String enterpriseId, AmericaRhodeislandPrincipleLocationDTO principleLocation,
                              AmericaRhodeislandOfficeLocationDTO officeLocation, AmericaRhodeislandResidentLocationDTO residentLocation) {
        this.enterpriseId = enterpriseId;
        this.principleStreet = principleLocation.getPrincipleStreet();
        this.principleCity = principleLocation.getPrincipleCity();
        this.principleState = principleLocation.getPrincipleState();
        this.principleZip = principleLocation.getPrincipleZip();
        this.principleCountry = principleLocation.getPrincipleCountry();

        this.officeStreet = officeLocation.getOfficeStreet();
        this.officeCity = officeLocation.getOfficeCity();
        this.officeState = officeLocation.getOfficeState();
        this.officeZip = officeLocation.getOfficeZip();
        this.officeCountry = officeLocation.getOfficeCountry();

        this.residentAgentName = residentLocation.getResidentAgentName();
        this.residentStreet = residentLocation.getResidentStreet();
        this.residentCity = residentLocation.getResidentCity();
        this.residentState = residentLocation.getResidentState();
        this.residentZip = residentLocation.getResidentZip();
        this.residentCountry = residentLocation.getResidentCountry();
    }

    private Integer id;

    private String enterpriseId;

    private String name;

    private String type;

    private String organisationDate;

    private String effectiveDate;

    private String residentAgentFlag;

    private String consentFlag;

    private String number;

    private String state;

    private String country;

    private String principleStreet;

    private String principleCity;

    private String principleState;

    private String principleZip;

    private String principleCountry;

    private String officeStreet;

    private String officeCity;

    private String officeState;

    private String officeZip;

    private String officeCountry;

    private String residentAgentName;

    private String residentStreet;

    private String residentCity;

    private String residentState;

    private String residentZip;

    private String residentCountry;

    private String purpose;

    private String naics;

    private String url;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId == null ? null : enterpriseId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getOrganisationDate() {
        return organisationDate;
    }

    public void setOrganisationDate(String organisationDate) {
        this.organisationDate = organisationDate == null ? null : organisationDate.trim();
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate == null ? null : effectiveDate.trim();
    }

    public String getResidentAgentFlag() {
        return residentAgentFlag;
    }

    public void setResidentAgentFlag(String residentAgentFlag) {
        this.residentAgentFlag = residentAgentFlag == null ? null : residentAgentFlag.trim();
    }

    public String getConsentFlag() {
        return consentFlag;
    }

    public void setConsentFlag(String consentFlag) {
        this.consentFlag = consentFlag == null ? null : consentFlag.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getPrincipleStreet() {
        return principleStreet;
    }

    public void setPrincipleStreet(String principleStreet) {
        this.principleStreet = principleStreet == null ? null : principleStreet.trim();
    }

    public String getPrincipleCity() {
        return principleCity;
    }

    public void setPrincipleCity(String principleCity) {
        this.principleCity = principleCity == null ? null : principleCity.trim();
    }

    public String getPrincipleState() {
        return principleState;
    }

    public void setPrincipleState(String principleState) {
        this.principleState = principleState == null ? null : principleState.trim();
    }

    public String getPrincipleZip() {
        return principleZip;
    }

    public void setPrincipleZip(String principleZip) {
        this.principleZip = principleZip == null ? null : principleZip.trim();
    }

    public String getPrincipleCountry() {
        return principleCountry;
    }

    public void setPrincipleCountry(String principleCountry) {
        this.principleCountry = principleCountry == null ? null : principleCountry.trim();
    }

    public String getOfficeStreet() {
        return officeStreet;
    }

    public void setOfficeStreet(String officeStreet) {
        this.officeStreet = officeStreet == null ? null : officeStreet.trim();
    }

    public String getOfficeCity() {
        return officeCity;
    }

    public void setOfficeCity(String officeCity) {
        this.officeCity = officeCity == null ? null : officeCity.trim();
    }

    public String getOfficeState() {
        return officeState;
    }

    public void setOfficeState(String officeState) {
        this.officeState = officeState == null ? null : officeState.trim();
    }

    public String getOfficeZip() {
        return officeZip;
    }

    public void setOfficeZip(String officeZip) {
        this.officeZip = officeZip == null ? null : officeZip.trim();
    }

    public String getOfficeCountry() {
        return officeCountry;
    }

    public void setOfficeCountry(String officeCountry) {
        this.officeCountry = officeCountry == null ? null : officeCountry.trim();
    }

    public String getResidentAgentName() {
        return residentAgentName;
    }

    public void setResidentAgentName(String residentAgentName) {
        this.residentAgentName = residentAgentName == null ? null : residentAgentName.trim();
    }

    public String getResidentStreet() {
        return residentStreet;
    }

    public void setResidentStreet(String residentStreet) {
        this.residentStreet = residentStreet == null ? null : residentStreet.trim();
    }

    public String getResidentCity() {
        return residentCity;
    }

    public void setResidentCity(String residentCity) {
        this.residentCity = residentCity == null ? null : residentCity.trim();
    }

    public String getResidentState() {
        return residentState;
    }

    public void setResidentState(String residentState) {
        this.residentState = residentState == null ? null : residentState.trim();
    }

    public String getResidentZip() {
        return residentZip;
    }

    public void setResidentZip(String residentZip) {
        this.residentZip = residentZip == null ? null : residentZip.trim();
    }

    public String getResidentCountry() {
        return residentCountry;
    }

    public void setResidentCountry(String residentCountry) {
        this.residentCountry = residentCountry == null ? null : residentCountry.trim();
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    public String getNaics() {
        return naics;
    }

    public void setNaics(String naics) {
        this.naics = naics == null ? null : naics.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}