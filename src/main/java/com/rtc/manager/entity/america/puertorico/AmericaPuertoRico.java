package com.rtc.manager.entity.america.puertorico;

import com.rtc.manager.entity.dto.AmericaPuertoRicoDomicileDTO;
import com.rtc.manager.entity.dto.AmericaPuertoRicoOfficeAddressDTO;
import com.rtc.manager.entity.dto.AmericaPuertoRicoResidentAgentDTO;

import java.time.LocalDateTime;

public class AmericaPuertoRico {
    public AmericaPuertoRico() {
    }

    public AmericaPuertoRico(String enterpriseId, AmericaPuertoRicoDomicileDTO domicile,
                             AmericaPuertoRicoOfficeAddressDTO officeAddress,
                             AmericaPuertoRicoResidentAgentDTO residentAgent) {
        this.enterpriseId = enterpriseId;
        this.homeState = domicile.getHomeState();
        this.domicileAddress = domicile.getDomicileAddress();
        this.incorporationDate = domicile.getIncorporationDate();
        this.domicileExpirationDate = domicile.getDomicileExpirationDate();
        this.officeStreetAddress = officeAddress.getOfficeStreetAddress();
        this.officeMailingAddress = officeAddress.getOfficeMailingAddress();
        this.residentName = residentAgent.getResidentName();
        this.residentStreetAddress = residentAgent.getResidentStreetAddress();
        this.residentMailingAddress = residentAgent.getResidentMailingAddress();
    }

    private Integer id;

    private String enterpriseId;

    private String name;

    private String registerNumber;

    private String enterpriseStatus;

    private String formationDate;

    private String effectiveDate;

    private String expirationDate;

    private String enterpriseClass;

    private String type;

    private String jurisdiction;

    private String homeState;

    private String domicileAddress;

    private String incorporationDate;

    private String domicileExpirationDate;

    private String officeStreetAddress;

    private String officeMailingAddress;

    private String residentName;

    private String residentStreetAddress;

    private String residentMailingAddress;

    private String purpose;

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

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber == null ? null : registerNumber.trim();
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus == null ? null : enterpriseStatus.trim();
    }

    public String getFormationDate() {
        return formationDate;
    }

    public void setFormationDate(String formationDate) {
        this.formationDate = formationDate == null ? null : formationDate.trim();
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate == null ? null : effectiveDate.trim();
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate == null ? null : expirationDate.trim();
    }

    public String getEnterpriseClass() {
        return enterpriseClass;
    }

    public void setEnterpriseClass(String enterpriseClass) {
        this.enterpriseClass = enterpriseClass == null ? null : enterpriseClass.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction == null ? null : jurisdiction.trim();
    }

    public String getHomeState() {
        return homeState;
    }

    public void setHomeState(String homeState) {
        this.homeState = homeState == null ? null : homeState.trim();
    }

    public String getDomicileAddress() {
        return domicileAddress;
    }

    public void setDomicileAddress(String domicileAddress) {
        this.domicileAddress = domicileAddress == null ? null : domicileAddress.trim();
    }

    public String getIncorporationDate() {
        return incorporationDate;
    }

    public void setIncorporationDate(String incorporationDate) {
        this.incorporationDate = incorporationDate == null ? null : incorporationDate.trim();
    }

    public String getDomicileExpirationDate() {
        return domicileExpirationDate;
    }

    public void setDomicileExpirationDate(String domicileExpirationDate) {
        this.domicileExpirationDate = domicileExpirationDate == null ? null : domicileExpirationDate.trim();
    }

    public String getOfficeStreetAddress() {
        return officeStreetAddress;
    }

    public void setOfficeStreetAddress(String officeStreetAddress) {
        this.officeStreetAddress = officeStreetAddress == null ? null : officeStreetAddress.trim();
    }

    public String getOfficeMailingAddress() {
        return officeMailingAddress;
    }

    public void setOfficeMailingAddress(String officeMailingAddress) {
        this.officeMailingAddress = officeMailingAddress == null ? null : officeMailingAddress.trim();
    }

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName == null ? null : residentName.trim();
    }

    public String getResidentStreetAddress() {
        return residentStreetAddress;
    }

    public void setResidentStreetAddress(String residentStreetAddress) {
        this.residentStreetAddress = residentStreetAddress == null ? null : residentStreetAddress.trim();
    }

    public String getResidentMailingAddress() {
        return residentMailingAddress;
    }

    public void setResidentMailingAddress(String residentMailingAddress) {
        this.residentMailingAddress = residentMailingAddress == null ? null : residentMailingAddress.trim();
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
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