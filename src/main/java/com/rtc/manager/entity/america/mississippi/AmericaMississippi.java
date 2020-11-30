package com.rtc.manager.entity.america.mississippi;

import com.rtc.manager.entity.dto.AmericaMississippiBusinessInformationDTO;

import java.time.LocalDateTime;

public class AmericaMississippi {
    public AmericaMississippi() {
    }

    public AmericaMississippi(String enterpriseId, AmericaMississippiBusinessInformationDTO dto) {
        this.enterpriseId = enterpriseId;
        this.businessType = dto.getBusinessType();
        this.businessId = dto.getBusinessId();
        this.enterpriseStatus = dto.getEnterpriseStatus();
        this.effectiveDate = dto.getEffectiveDate();
        this.stateOfIncorporation = dto.getStateOfIncorporation();
        this.principalOfficeAddress = dto.getPrincipalOfficeAddress();
    }

    private Integer id;

    private String enterpriseId;

    private String name;

    private String businessType;

    private String businessId;

    private String enterpriseStatus;

    private String effectiveDate;

    private String stateOfIncorporation;

    private String principalOfficeAddress;

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

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId == null ? null : businessId.trim();
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus == null ? null : enterpriseStatus.trim();
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate == null ? null : effectiveDate.trim();
    }

    public String getStateOfIncorporation() {
        return stateOfIncorporation;
    }

    public void setStateOfIncorporation(String stateOfIncorporation) {
        this.stateOfIncorporation = stateOfIncorporation == null ? null : stateOfIncorporation.trim();
    }

    public String getPrincipalOfficeAddress() {
        return principalOfficeAddress;
    }

    public void setPrincipalOfficeAddress(String principalOfficeAddress) {
        this.principalOfficeAddress = principalOfficeAddress == null ? null : principalOfficeAddress.trim();
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