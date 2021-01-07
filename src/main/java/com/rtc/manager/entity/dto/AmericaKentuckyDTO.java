package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rtc.manager.entity.america.kentucky.AmericaKentuckyAssumeName;
import com.rtc.manager.entity.america.kentucky.AmericaKentuckyHistory;
import com.rtc.manager.entity.america.kentucky.AmericaKentuckyOfficer;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaKentuckyDTO {
    private String enterpriseId;
    @JsonAlias("Organization Number")
    private String organizationNumber;

    @JsonAlias("Name")
    private String name;

    @JsonAlias("Profit or Non-Profit")
    private String profit;

    @JsonAlias("Company Type")
    private String type;

    @JsonAlias("Status")
    private String enterpriseStatus;

    @JsonAlias("Standing")
    private String standing;

    @JsonAlias("State")
    private String state;

    @JsonAlias("File Date")
    private String fileDate;

    @JsonAlias("Organization Date")
    private String organizationDate;

    @JsonAlias("Last Annual Report")
    private String lastAnnualReport;

    @JsonAlias("Principal Office")
    private String principalOffice;

    @JsonAlias("Registered Agent")
    private String registeredAgent;

    @JsonAlias("officers")
    private List<AmericaKentuckyOfficer> officerList;

    @JsonAlias("history")
    private List<AmericaKentuckyHistory> historyList;

    @JsonAlias("assumedNames")
    private List<AmericaKentuckyAssumeName> assumeNameList;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getOrganizationNumber() {
        return organizationNumber;
    }

    public void setOrganizationNumber(String organizationNumber) {
        this.organizationNumber = organizationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public String getStanding() {
        return standing;
    }

    public void setStanding(String standing) {
        this.standing = standing;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getFileDate() {
        return fileDate;
    }

    public void setFileDate(String fileDate) {
        this.fileDate = fileDate;
    }

    public String getOrganizationDate() {
        return organizationDate;
    }

    public void setOrganizationDate(String organizationDate) {
        this.organizationDate = organizationDate;
    }

    public String getLastAnnualReport() {
        return lastAnnualReport;
    }

    public void setLastAnnualReport(String lastAnnualReport) {
        this.lastAnnualReport = lastAnnualReport;
    }

    public String getPrincipalOffice() {
        return principalOffice;
    }

    public void setPrincipalOffice(String principalOffice) {
        this.principalOffice = principalOffice;
    }

    public String getRegisteredAgent() {
        return registeredAgent;
    }

    public void setRegisteredAgent(String registeredAgent) {
        this.registeredAgent = registeredAgent;
    }

    public List<AmericaKentuckyOfficer> getOfficerList() {
        return officerList;
    }

    public void setOfficerList(List<AmericaKentuckyOfficer> officerList) {
        this.officerList = officerList;
    }

    public List<AmericaKentuckyHistory> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(List<AmericaKentuckyHistory> historyList) {
        this.historyList = historyList;
    }

    public List<AmericaKentuckyAssumeName> getAssumeNameList() {
        return assumeNameList;
    }

    public void setAssumeNameList(List<AmericaKentuckyAssumeName> assumeNameList) {
        this.assumeNameList = assumeNameList;
    }
}