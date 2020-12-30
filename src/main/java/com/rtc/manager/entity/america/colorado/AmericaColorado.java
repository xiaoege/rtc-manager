package com.rtc.manager.entity.america.colorado;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.rtc.manager.entity.dto.AmericaColoradoDetailsDTO;
import com.rtc.manager.entity.dto.AmericaColoradoDetailsRegisteredAgentDTO;

import java.time.LocalDateTime;

public class AmericaColorado {
    
    private Integer id;

    private String enterpriseId;

    private String name;

    private String enterpriseStatus;

    private String idNumber;

    private String periodicReportMonth;

    private String principalOfficeStreetAddress;

    private String principalOfficeMailingAddress;

    private String agentName;

    private String agentStreetAddress;

    private String agentMailingAddress;

    private String url;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private Integer status;

    public AmericaColorado() {
    }

    public AmericaColorado(AmericaColoradoDetailsDTO details) {
        this.name = details.getName();
        this.enterpriseStatus = details.getEnterpriseStatus();
        this.idNumber = details.getIdNumber();
        this.periodicReportMonth = details.getPeriodicReportMonth();
        this.principalOfficeStreetAddress = details.getPrincipalOfficeStreetAddress();
        this.principalOfficeMailingAddress = details.getPrincipalOfficeMailingAddress();
    }

    public AmericaColorado(AmericaColoradoDetailsRegisteredAgentDTO registeredAgent) {
        this.agentName = registeredAgent.getAgentName();
        this.agentStreetAddress = registeredAgent.getAgentStreetAddress();
        this.agentMailingAddress = registeredAgent.getAgentMailingAddress();
    }

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

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus == null ? null : enterpriseStatus.trim();
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    public String getPeriodicReportMonth() {
        return periodicReportMonth;
    }

    public void setPeriodicReportMonth(String periodicReportMonth) {
        this.periodicReportMonth = periodicReportMonth == null ? null : periodicReportMonth.trim();
    }

    public String getPrincipalOfficeStreetAddress() {
        return principalOfficeStreetAddress;
    }

    public void setPrincipalOfficeStreetAddress(String principalOfficeStreetAddress) {
        this.principalOfficeStreetAddress = principalOfficeStreetAddress == null ? null : principalOfficeStreetAddress.trim();
    }

    public String getPrincipalOfficeMailingAddress() {
        return principalOfficeMailingAddress;
    }

    public void setPrincipalOfficeMailingAddress(String principalOfficeMailingAddress) {
        this.principalOfficeMailingAddress = principalOfficeMailingAddress == null ? null : principalOfficeMailingAddress.trim();
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName == null ? null : agentName.trim();
    }

    public String getAgentStreetAddress() {
        return agentStreetAddress;
    }

    public void setAgentStreetAddress(String agentStreetAddress) {
        this.agentStreetAddress = agentStreetAddress == null ? null : agentStreetAddress.trim();
    }

    public String getAgentMailingAddress() {
        return agentMailingAddress;
    }

    public void setAgentMailingAddress(String agentMailingAddress) {
        this.agentMailingAddress = agentMailingAddress == null ? null : agentMailingAddress.trim();
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