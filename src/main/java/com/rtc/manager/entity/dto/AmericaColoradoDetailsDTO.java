package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaColoradoDetailsDTO {
    @JsonAlias("Name")
    private String name;

    @JsonAlias("Status")
    private String enterpriseStatus;

    @JsonAlias("ID number")
    private String idNumber;

    @JsonAlias("Periodic report month")
    private String periodicReportMonth;

    @JsonAlias("Principal office street address")
    private String principalOfficeStreetAddress;

    @JsonAlias("Principal office mailing address")
    private String principalOfficeMailingAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPeriodicReportMonth() {
        return periodicReportMonth;
    }

    public void setPeriodicReportMonth(String periodicReportMonth) {
        this.periodicReportMonth = periodicReportMonth;
    }

    public String getPrincipalOfficeStreetAddress() {
        return principalOfficeStreetAddress;
    }

    public void setPrincipalOfficeStreetAddress(String principalOfficeStreetAddress) {
        this.principalOfficeStreetAddress = principalOfficeStreetAddress;
    }

    public String getPrincipalOfficeMailingAddress() {
        return principalOfficeMailingAddress;
    }

    public void setPrincipalOfficeMailingAddress(String principalOfficeMailingAddress) {
        this.principalOfficeMailingAddress = principalOfficeMailingAddress;
    }
}