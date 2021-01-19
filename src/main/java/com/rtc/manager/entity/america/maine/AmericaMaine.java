package com.rtc.manager.entity.america.maine;

import java.time.LocalDateTime;

public class AmericaMaine {
    private Integer id;

    private String enterpriseId;

    private String name;

    private String charterNumber;

    private String filingType;

    private String enterpriseStatus;

    private String otherNames;

    private String registeredagentName;

    private String registeredagentAddress;

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

    public String getCharterNumber() {
        return charterNumber;
    }

    public void setCharterNumber(String charterNumber) {
        this.charterNumber = charterNumber == null ? null : charterNumber.trim();
    }

    public String getFilingType() {
        return filingType;
    }

    public void setFilingType(String filingType) {
        this.filingType = filingType == null ? null : filingType.trim();
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus == null ? null : enterpriseStatus.trim();
    }

    public String getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames == null ? null : otherNames.trim();
    }

    public String getRegisteredagentName() {
        return registeredagentName;
    }

    public void setRegisteredagentName(String registeredagentName) {
        this.registeredagentName = registeredagentName == null ? null : registeredagentName.trim();
    }

    public String getRegisteredagentAddress() {
        return registeredagentAddress;
    }

    public void setRegisteredagentAddress(String registeredagentAddress) {
        this.registeredagentAddress = registeredagentAddress == null ? null : registeredagentAddress.trim();
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