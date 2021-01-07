package com.rtc.manager.entity.america.kentucky;

import java.time.LocalDateTime;

public class AmericaKentucky {
    private Integer id;

    private String enterpriseId;

    private String organizationNumber;

    private String name;

    private String profit;

    private String type;

    private String enterpriseStatus;

    private String standing;

    private String state;

    private String fileDate;

    private String organizationDate;

    private String lastAnnualReport;

    private String principalOffice;

    private String registeredAgent;

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

    public String getOrganizationNumber() {
        return organizationNumber;
    }

    public void setOrganizationNumber(String organizationNumber) {
        this.organizationNumber = organizationNumber == null ? null : organizationNumber.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit == null ? null : profit.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus == null ? null : enterpriseStatus.trim();
    }

    public String getStanding() {
        return standing;
    }

    public void setStanding(String standing) {
        this.standing = standing == null ? null : standing.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getFileDate() {
        return fileDate;
    }

    public void setFileDate(String fileDate) {
        this.fileDate = fileDate == null ? null : fileDate.trim();
    }

    public String getOrganizationDate() {
        return organizationDate;
    }

    public void setOrganizationDate(String organizationDate) {
        this.organizationDate = organizationDate == null ? null : organizationDate.trim();
    }

    public String getLastAnnualReport() {
        return lastAnnualReport;
    }

    public void setLastAnnualReport(String lastAnnualReport) {
        this.lastAnnualReport = lastAnnualReport == null ? null : lastAnnualReport.trim();
    }

    public String getPrincipalOffice() {
        return principalOffice;
    }

    public void setPrincipalOffice(String principalOffice) {
        this.principalOffice = principalOffice == null ? null : principalOffice.trim();
    }

    public String getRegisteredAgent() {
        return registeredAgent;
    }

    public void setRegisteredAgent(String registeredAgent) {
        this.registeredAgent = registeredAgent == null ? null : registeredAgent.trim();
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