package com.rtc.manager.entity.america.california;

import com.rtc.manager.entity.dto.AmericaCaliforniaAddressDTO;
import com.rtc.manager.entity.dto.AmericaCaliforniaAgentDTO;
import com.rtc.manager.entity.dto.AmericaCaliforniaDTO;
import com.rtc.manager.entity.dto.AmericaCaliforniaMailDTO;

import java.time.LocalDateTime;

public class AmericaCalifornia {
    public AmericaCalifornia() {
    }

    public AmericaCalifornia(AmericaCaliforniaAgentDTO agentDTO, AmericaCaliforniaAddressDTO addressDTO, AmericaCaliforniaMailDTO mailDTO) {
        if (agentDTO != null) {
            this.agentName = agentDTO.getAgentName();
            this.agentAddress = agentDTO.getAgentAddress();
            this.agentCity = agentDTO.getAgentCity();
            this.agentState = agentDTO.getAgentState();
            this.agentZip = agentDTO.getAgentZip();
        }
        if (addressDTO != null) {
            this.address = addressDTO.getAddress();
            this.city = addressDTO.getCity();
            this.state = addressDTO.getState();
            this.zip = addressDTO.getZip();
        }
        if (mailDTO != null) {
            this.mailingAddress = mailDTO.getMailingAddress();
            this.mailingCity = mailDTO.getMailingCity();
            this.mailingState = mailDTO.getMailingState();
            this.mailingZip = mailDTO.getMailingZip();
        }
    }

    private Integer id;

    private String enterpriseId;

    private String entityNumber;

    private String name;

    private String registrationDate;

    private String jurisdiction;

    private String entityType;

    private String enterpriseStatus;

    private String agentName;

    private String agentAddress;

    private String agentCity;

    private String agentState;

    private String agentZip;

    private String address;

    private String city;

    private String state;

    private String zip;

    private String mailingAddress;

    private String mailingCity;

    private String mailingState;

    private String mailingZip;

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

    public String getEntityNumber() {
        return entityNumber;
    }

    public void setEntityNumber(String entityNumber) {
        this.entityNumber = entityNumber == null ? null : entityNumber.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate == null ? null : registrationDate.trim();
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction == null ? null : jurisdiction.trim();
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType == null ? null : entityType.trim();
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus == null ? null : enterpriseStatus.trim();
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName == null ? null : agentName.trim();
    }

    public String getAgentAddress() {
        return agentAddress;
    }

    public void setAgentAddress(String agentAddress) {
        this.agentAddress = agentAddress == null ? null : agentAddress.trim();
    }

    public String getAgentCity() {
        return agentCity;
    }

    public void setAgentCity(String agentCity) {
        this.agentCity = agentCity == null ? null : agentCity.trim();
    }

    public String getAgentState() {
        return agentState;
    }

    public void setAgentState(String agentState) {
        this.agentState = agentState == null ? null : agentState.trim();
    }

    public String getAgentZip() {
        return agentZip;
    }

    public void setAgentZip(String agentZip) {
        this.agentZip = agentZip == null ? null : agentZip.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip == null ? null : zip.trim();
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress == null ? null : mailingAddress.trim();
    }

    public String getMailingCity() {
        return mailingCity;
    }

    public void setMailingCity(String mailingCity) {
        this.mailingCity = mailingCity == null ? null : mailingCity.trim();
    }

    public String getMailingState() {
        return mailingState;
    }

    public void setMailingState(String mailingState) {
        this.mailingState = mailingState == null ? null : mailingState.trim();
    }

    public String getMailingZip() {
        return mailingZip;
    }

    public void setMailingZip(String mailingZip) {
        this.mailingZip = mailingZip == null ? null : mailingZip.trim();
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