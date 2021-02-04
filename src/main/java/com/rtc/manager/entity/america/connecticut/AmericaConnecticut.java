package com.rtc.manager.entity.america.connecticut;

import com.rtc.manager.entity.dto.AmericaConnecticutAgentSummaryDTO;

import java.time.LocalDateTime;

public class AmericaConnecticut {
    private Integer id;

    private String enterpriseId;

    private String name;

    private String citizenshipStateInc;

    private String businessId;

    private String lastReportFiledYear;

    private String businessAddress;

    private String businessType;

    private String mailingAddress;

    private String businessStatus;

    private String registrationDate;

    private String annualReportDueDate;

    private String naicsCode;

    private String naicsSubCode;

    private String agentName;

    private String agentBusinessAddress;

    private String agentResidenceAddress;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private Integer status;

    public AmericaConnecticut() {
    }

    public AmericaConnecticut(AmericaConnecticutAgentSummaryDTO agentSummaryDTO) {
        if (agentSummaryDTO != null) {
            this.agentName = agentSummaryDTO.getAgentName();
            this.agentBusinessAddress = agentSummaryDTO.getAgentBusinessAddress();
            this.agentResidenceAddress = agentSummaryDTO.getAgentResidenceAddress();
        }
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

    public String getCitizenshipStateInc() {
        return citizenshipStateInc;
    }

    public void setCitizenshipStateInc(String citizenshipStateInc) {
        this.citizenshipStateInc = citizenshipStateInc == null ? null : citizenshipStateInc.trim();
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId == null ? null : businessId.trim();
    }

    public String getLastReportFiledYear() {
        return lastReportFiledYear;
    }

    public void setLastReportFiledYear(String lastReportFiledYear) {
        this.lastReportFiledYear = lastReportFiledYear == null ? null : lastReportFiledYear.trim();
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress == null ? null : businessAddress.trim();
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress == null ? null : mailingAddress.trim();
    }

    public String getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(String businessStatus) {
        this.businessStatus = businessStatus == null ? null : businessStatus.trim();
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate == null ? null : registrationDate.trim();
    }

    public String getAnnualReportDueDate() {
        return annualReportDueDate;
    }

    public void setAnnualReportDueDate(String annualReportDueDate) {
        this.annualReportDueDate = annualReportDueDate == null ? null : annualReportDueDate.trim();
    }

    public String getNaicsCode() {
        return naicsCode;
    }

    public void setNaicsCode(String naicsCode) {
        this.naicsCode = naicsCode == null ? null : naicsCode.trim();
    }

    public String getNaicsSubCode() {
        return naicsSubCode;
    }

    public void setNaicsSubCode(String naicsSubCode) {
        this.naicsSubCode = naicsSubCode == null ? null : naicsSubCode.trim();
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName == null ? null : agentName.trim();
    }

    public String getAgentBusinessAddress() {
        return agentBusinessAddress;
    }

    public void setAgentBusinessAddress(String agentBusinessAddress) {
        this.agentBusinessAddress = agentBusinessAddress == null ? null : agentBusinessAddress.trim();
    }

    public String getAgentResidenceAddress() {
        return agentResidenceAddress;
    }

    public void setAgentResidenceAddress(String agentResidenceAddress) {
        this.agentResidenceAddress = agentResidenceAddress == null ? null : agentResidenceAddress.trim();
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