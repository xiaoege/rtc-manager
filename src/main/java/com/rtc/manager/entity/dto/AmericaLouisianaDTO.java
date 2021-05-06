package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rtc.manager.entity.america.louisiana.AmericaLouisianaOfficer;
import com.rtc.manager.entity.america.louisiana.AmericaLouisianaRegisteredAgent;

import java.util.HashMap;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaLouisianaDTO {
    private String name;

    private String type;

    private String city;

    private String istatus;
    @JsonAlias("Business")
    private String business;

    @JsonAlias("Charter Number")
    private String charterNumber;

    @JsonAlias("Registration Date")
    private String registrationDate;

    private String domicileAddress;

    private String mailingAddress;

    private String principalBusinessOffice;
    @JsonAlias("registeredOfficeInLouisiana")
    private String registeredOfficeLouisiana;
    @JsonAlias("principalBusinessEstablishmentInLouisiana")
    private String principalBusinessEstablishmentLouisiana;

    private String enterpriseStatus;

    private String inactiveReason;

    private String fileDate;

    private String lastReportFile;

    private String enterpriseType;

    private String previous;

    private List<HashMap> previousNames;

    private HashMap status;

    private List<AmericaLouisianaRegisteredAgent> registeredAgent;

    private List<AmericaLouisianaOfficer> officers;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIstatus() {
        return istatus;
    }

    public void setIstatus(String istatus) {
        this.istatus = istatus;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getCharterNumber() {
        return charterNumber;
    }

    public void setCharterNumber(String charterNumber) {
        this.charterNumber = charterNumber;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getDomicileAddress() {
        return domicileAddress;
    }

    public void setDomicileAddress(String domicileAddress) {
        this.domicileAddress = domicileAddress;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getPrincipalBusinessOffice() {
        return principalBusinessOffice;
    }

    public void setPrincipalBusinessOffice(String principalBusinessOffice) {
        this.principalBusinessOffice = principalBusinessOffice;
    }

    public String getRegisteredOfficeLouisiana() {
        return registeredOfficeLouisiana;
    }

    public void setRegisteredOfficeLouisiana(String registeredOfficeLouisiana) {
        this.registeredOfficeLouisiana = registeredOfficeLouisiana;
    }

    public String getPrincipalBusinessEstablishmentLouisiana() {
        return principalBusinessEstablishmentLouisiana;
    }

    public void setPrincipalBusinessEstablishmentLouisiana(String principalBusinessEstablishmentLouisiana) {
        this.principalBusinessEstablishmentLouisiana = principalBusinessEstablishmentLouisiana;
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public String getInactiveReason() {
        return inactiveReason;
    }

    public void setInactiveReason(String inactiveReason) {
        this.inactiveReason = inactiveReason;
    }

    public String getFileDate() {
        return fileDate;
    }

    public void setFileDate(String fileDate) {
        this.fileDate = fileDate;
    }

    public String getLastReportFile() {
        return lastReportFile;
    }

    public void setLastReportFile(String lastReportFile) {
        this.lastReportFile = lastReportFile;
    }

    public String getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(String enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<HashMap> getPreviousNames() {
        return previousNames;
    }

    public void setPreviousNames(List<HashMap> previousNames) {
        this.previousNames = previousNames;
    }

    public HashMap getStatus() {
        return status;
    }

    public void setStatus(HashMap status) {
        this.status = status;
    }

    public List<AmericaLouisianaRegisteredAgent> getRegisteredAgent() {
        return registeredAgent;
    }

    public void setRegisteredAgent(List<AmericaLouisianaRegisteredAgent> registeredAgent) {
        this.registeredAgent = registeredAgent;
    }

    public List<AmericaLouisianaOfficer> getOfficers() {
        return officers;
    }

    public void setOfficers(List<AmericaLouisianaOfficer> officers) {
        this.officers = officers;
    }
}