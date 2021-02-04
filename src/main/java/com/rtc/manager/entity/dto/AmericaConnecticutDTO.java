package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rtc.manager.entity.america.connecticut.AmericaConnecticutPrincipalDetail;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaConnecticutDTO {
    private String enterpriseId;
    @JsonAlias("Business Name:")
    private String name;
    @JsonAlias("Citizenship/State Inc:")
    private String citizenshipStateInc;
    @JsonAlias("Business ID:")
    private String businessId;
    @JsonAlias("Last Report Filed Year:")
    private String lastReportFiledYear;
    @JsonAlias("Business Address:")
    private String businessAddress;
    @JsonAlias("Business Type:")
    private String businessType;
    @JsonAlias("Mailing Address:")
    private String mailingAddress;
    @JsonAlias("Business Status:")
    private String businessStatus;
    @JsonAlias("Date Inc/Registration:")
    private String registrationDate;
    @JsonAlias("Annual Report Due Date:")
    private String annualReportDueDate;
    @JsonAlias("NAICS Code:")
    private String naicsCode;
    @JsonAlias("NAICS Sub Code:")
    private String naicsSubCode;
    @JsonAlias("agentSummary")
    private AmericaConnecticutAgentSummaryDTO agentSummaryDTO;
    @JsonAlias("principalsDetails")
    private List<AmericaConnecticutPrincipalDetail> principalDetailList;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCitizenshipStateInc() {
        return citizenshipStateInc;
    }

    public void setCitizenshipStateInc(String citizenshipStateInc) {
        this.citizenshipStateInc = citizenshipStateInc;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getLastReportFiledYear() {
        return lastReportFiledYear;
    }

    public void setLastReportFiledYear(String lastReportFiledYear) {
        this.lastReportFiledYear = lastReportFiledYear;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(String businessStatus) {
        this.businessStatus = businessStatus;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getAnnualReportDueDate() {
        return annualReportDueDate;
    }

    public void setAnnualReportDueDate(String annualReportDueDate) {
        this.annualReportDueDate = annualReportDueDate;
    }

    public String getNaicsCode() {
        return naicsCode;
    }

    public void setNaicsCode(String naicsCode) {
        this.naicsCode = naicsCode;
    }

    public String getNaicsSubCode() {
        return naicsSubCode;
    }

    public void setNaicsSubCode(String naicsSubCode) {
        this.naicsSubCode = naicsSubCode;
    }

    public AmericaConnecticutAgentSummaryDTO getAgentSummaryDTO() {
        return agentSummaryDTO;
    }

    public void setAgentSummaryDTO(AmericaConnecticutAgentSummaryDTO agentSummaryDTO) {
        this.agentSummaryDTO = agentSummaryDTO;
    }

    public List<AmericaConnecticutPrincipalDetail> getPrincipalDetailList() {
        return principalDetailList;
    }

    public void setPrincipalDetailList(List<AmericaConnecticutPrincipalDetail> principalDetailList) {
        this.principalDetailList = principalDetailList;
    }
}