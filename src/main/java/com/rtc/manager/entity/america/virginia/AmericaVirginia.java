package com.rtc.manager.entity.america.virginia;

import com.rtc.manager.entity.dto.AmericaVirginiaEntityInformationDTO;
import com.rtc.manager.entity.dto.AmericaVirginiaRegisteredAgentInformationDTO;

import java.time.LocalDateTime;
import java.util.HashMap;

public class AmericaVirginia {
    private Integer id;

    private String enterpriseId;

    private String name;

    private String entityId;

    private String entityType;

    private String entityStatus;

    private String formationDate;

    private String statusReason;

    private String vaQualificationDate;

    private String statusDate;

    private String industryCode;

    private String periodOfDuration;

    private String jurisdiction;

    private String annualReportDueDate;

    private String registrationFeeDueDate;

    private String charterFee;

    private String email;

    private String contactNumber;

    private String raType;

    private String raLocality;

    private String raQualification;

    private String raName;

    private String raAddress;

    private String address;

    private String share;

    private String mailingAddress;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private Integer status;

    public AmericaVirginia() {
    }

    public AmericaVirginia(AmericaVirginiaEntityInformationDTO entityInformationDTO,
                           AmericaVirginiaRegisteredAgentInformationDTO registeredAgentInformationDTO,
                           String address,
                           String share,
                           String mailingAddress) {
        this.name = entityInformationDTO.getName();
        this.entityId = entityInformationDTO.getEntityId();
        this.entityType = entityInformationDTO.getEntityType();
        this.entityStatus = entityInformationDTO.getEntityStatus();
        this.formationDate = entityInformationDTO.getFormationDate();
        this.statusReason = entityInformationDTO.getStatusReason();
        this.vaQualificationDate = entityInformationDTO.getVaQualificationDate();
        this.statusDate = entityInformationDTO.getStatusDate();
        this.industryCode = entityInformationDTO.getIndustryCode();
        this.periodOfDuration = entityInformationDTO.getPeriodOfDuration();
        this.jurisdiction = entityInformationDTO.getJurisdiction();
        this.annualReportDueDate = entityInformationDTO.getAnnualReportDueDate();
        this.registrationFeeDueDate = entityInformationDTO.getRegistrationFeeDueDate();
        this.charterFee = entityInformationDTO.getCharterFee();
        this.email = entityInformationDTO.getEmail();
        this.contactNumber = entityInformationDTO.getContactNumber();

        this.raType = registeredAgentInformationDTO.getRaType();
        this.raLocality = registeredAgentInformationDTO.getRaLocality();
        this.raQualification = registeredAgentInformationDTO.getRaQualification();
        this.raName = registeredAgentInformationDTO.getRaName();
        this.raAddress = registeredAgentInformationDTO.getRaAddress();

        this.address = address;
        this.share = share;
        this.mailingAddress = mailingAddress;
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

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId == null ? null : entityId.trim();
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType == null ? null : entityType.trim();
    }

    public String getEntityStatus() {
        return entityStatus;
    }

    public void setEntityStatus(String entityStatus) {
        this.entityStatus = entityStatus == null ? null : entityStatus.trim();
    }

    public String getFormationDate() {
        return formationDate;
    }

    public void setFormationDate(String formationDate) {
        this.formationDate = formationDate == null ? null : formationDate.trim();
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason == null ? null : statusReason.trim();
    }

    public String getVaQualificationDate() {
        return vaQualificationDate;
    }

    public void setVaQualificationDate(String vaQualificationDate) {
        this.vaQualificationDate = vaQualificationDate == null ? null : vaQualificationDate.trim();
    }

    public String getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(String statusDate) {
        this.statusDate = statusDate == null ? null : statusDate.trim();
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode == null ? null : industryCode.trim();
    }

    public String getPeriodOfDuration() {
        return periodOfDuration;
    }

    public void setPeriodOfDuration(String periodOfDuration) {
        this.periodOfDuration = periodOfDuration == null ? null : periodOfDuration.trim();
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction == null ? null : jurisdiction.trim();
    }

    public String getAnnualReportDueDate() {
        return annualReportDueDate;
    }

    public void setAnnualReportDueDate(String annualReportDueDate) {
        this.annualReportDueDate = annualReportDueDate == null ? null : annualReportDueDate.trim();
    }

    public String getRegistrationFeeDueDate() {
        return registrationFeeDueDate;
    }

    public void setRegistrationFeeDueDate(String registrationFeeDueDate) {
        this.registrationFeeDueDate = registrationFeeDueDate == null ? null : registrationFeeDueDate.trim();
    }

    public String getCharterFee() {
        return charterFee;
    }

    public void setCharterFee(String charterFee) {
        this.charterFee = charterFee == null ? null : charterFee.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber == null ? null : contactNumber.trim();
    }

    public String getRaType() {
        return raType;
    }

    public void setRaType(String raType) {
        this.raType = raType == null ? null : raType.trim();
    }

    public String getRaLocality() {
        return raLocality;
    }

    public void setRaLocality(String raLocality) {
        this.raLocality = raLocality == null ? null : raLocality.trim();
    }

    public String getRaQualification() {
        return raQualification;
    }

    public void setRaQualification(String raQualification) {
        this.raQualification = raQualification == null ? null : raQualification.trim();
    }

    public String getRaName() {
        return raName;
    }

    public void setRaName(String raName) {
        this.raName = raName == null ? null : raName.trim();
    }

    public String getRaAddress() {
        return raAddress;
    }

    public void setRaAddress(String raAddress) {
        this.raAddress = raAddress == null ? null : raAddress.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share == null ? null : share.trim();
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress == null ? null : mailingAddress.trim();
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