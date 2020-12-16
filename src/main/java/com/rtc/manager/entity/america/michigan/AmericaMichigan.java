package com.rtc.manager.entity.america.michigan;

import com.rtc.manager.entity.dto.AmericaMichiganPrincipleOfficeDTO;
import com.rtc.manager.entity.dto.AmericaMichiganRegInfoDTO;
import com.rtc.manager.entity.dto.AmericaMichiganResidentDTO;

import java.time.LocalDateTime;

public class AmericaMichigan {
    private Integer id;

    private String enterpriseId;

    private String idNumberHeader;

    private String nameHeader;

    private String name;

    private String entityType;

    private String idNumber;

    private String oldIdNumber;

    private String organisationDate;

    private String purpose;

    private String inactiveDate;

    private String term;

    private String recentAnnualReportYear;

    private String recentAnnualReportWithes;

    private String actsFormedUnder;

    private String sumInfo;

    private String residentAgentName;

    private String residentStreet;

    private String aptsuiteother;

    private String residentCity;

    private String residentState;

    private String residentZip;

    private String principleStreet;

    private String aptsuiteotherlblpricipal;

    private String principleCity;

    private String principleState;

    private String principleZip;

    private String reginfonAme;

    private String reginfoStreet;

    private String reginfoApt;

    private String reginfoCity;

    private String reginfoState;

    private String reginfoZipcode;

    private String reginfoCountry;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private Integer status;

    public AmericaMichigan() {
    }

    public AmericaMichigan(String enterpriseId, AmericaMichiganResidentDTO residentDTO, AmericaMichiganPrincipleOfficeDTO principleOfficeDTO, AmericaMichiganRegInfoDTO regInfoDTO) {
        this.enterpriseId = enterpriseId;
        this.residentAgentName = residentDTO.getResidentAgentName();
        this.residentStreet = residentDTO.getResidentStreet();
        this.aptsuiteother = residentDTO.getAptsuiteother();
        this.residentCity = residentDTO.getResidentCity();
        this.residentState = residentDTO.getResidentState();
        this.residentZip = residentDTO.getResidentZip();
        this.principleStreet = principleOfficeDTO.getPrincipleStreet();
        this.aptsuiteotherlblpricipal = principleOfficeDTO.getAptsuiteotherlblpricipal();
        this.principleCity = principleOfficeDTO.getPrincipleCity();
        this.principleState = principleOfficeDTO.getPrincipleState();
        this.principleZip = principleOfficeDTO.getPrincipleZip();
        this.reginfonAme = regInfoDTO.getReginfonAme();
        this.reginfoStreet = regInfoDTO.getReginfoStreet();
        this.reginfoApt = regInfoDTO.getReginfoApt();
        this.reginfoCity = regInfoDTO.getReginfoCity();
        this.reginfoState = regInfoDTO.getReginfoState();
        this.reginfoZipcode = regInfoDTO.getReginfoZipcode();
        this.reginfoCountry = regInfoDTO.getReginfoCountry();
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

    public String getIdNumberHeader() {
        return idNumberHeader;
    }

    public void setIdNumberHeader(String idNumberHeader) {
        this.idNumberHeader = idNumberHeader == null ? null : idNumberHeader.trim();
    }

    public String getNameHeader() {
        return nameHeader;
    }

    public void setNameHeader(String nameHeader) {
        this.nameHeader = nameHeader == null ? null : nameHeader.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType == null ? null : entityType.trim();
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    public String getOldIdNumber() {
        return oldIdNumber;
    }

    public void setOldIdNumber(String oldIdNumber) {
        this.oldIdNumber = oldIdNumber == null ? null : oldIdNumber.trim();
    }

    public String getOrganisationDate() {
        return organisationDate;
    }

    public void setOrganisationDate(String organisationDate) {
        this.organisationDate = organisationDate == null ? null : organisationDate.trim();
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    public String getInactiveDate() {
        return inactiveDate;
    }

    public void setInactiveDate(String inactiveDate) {
        this.inactiveDate = inactiveDate == null ? null : inactiveDate.trim();
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term == null ? null : term.trim();
    }

    public String getRecentAnnualReportYear() {
        return recentAnnualReportYear;
    }

    public void setRecentAnnualReportYear(String recentAnnualReportYear) {
        this.recentAnnualReportYear = recentAnnualReportYear == null ? null : recentAnnualReportYear.trim();
    }

    public String getRecentAnnualReportWithes() {
        return recentAnnualReportWithes;
    }

    public void setRecentAnnualReportWithes(String recentAnnualReportWithes) {
        this.recentAnnualReportWithes = recentAnnualReportWithes == null ? null : recentAnnualReportWithes.trim();
    }

    public String getActsFormedUnder() {
        return actsFormedUnder;
    }

    public void setActsFormedUnder(String actsFormedUnder) {
        this.actsFormedUnder = actsFormedUnder == null ? null : actsFormedUnder.trim();
    }

    public String getSumInfo() {
        return sumInfo;
    }

    public void setSumInfo(String sumInfo) {
        this.sumInfo = sumInfo == null ? null : sumInfo.trim();
    }

    public String getResidentAgentName() {
        return residentAgentName;
    }

    public void setResidentAgentName(String residentAgentName) {
        this.residentAgentName = residentAgentName == null ? null : residentAgentName.trim();
    }

    public String getResidentStreet() {
        return residentStreet;
    }

    public void setResidentStreet(String residentStreet) {
        this.residentStreet = residentStreet == null ? null : residentStreet.trim();
    }

    public String getAptsuiteother() {
        return aptsuiteother;
    }

    public void setAptsuiteother(String aptsuiteother) {
        this.aptsuiteother = aptsuiteother == null ? null : aptsuiteother.trim();
    }

    public String getResidentCity() {
        return residentCity;
    }

    public void setResidentCity(String residentCity) {
        this.residentCity = residentCity == null ? null : residentCity.trim();
    }

    public String getResidentState() {
        return residentState;
    }

    public void setResidentState(String residentState) {
        this.residentState = residentState == null ? null : residentState.trim();
    }

    public String getResidentZip() {
        return residentZip;
    }

    public void setResidentZip(String residentZip) {
        this.residentZip = residentZip == null ? null : residentZip.trim();
    }

    public String getPrincipleStreet() {
        return principleStreet;
    }

    public void setPrincipleStreet(String principleStreet) {
        this.principleStreet = principleStreet == null ? null : principleStreet.trim();
    }

    public String getAptsuiteotherlblpricipal() {
        return aptsuiteotherlblpricipal;
    }

    public void setAptsuiteotherlblpricipal(String aptsuiteotherlblpricipal) {
        this.aptsuiteotherlblpricipal = aptsuiteotherlblpricipal == null ? null : aptsuiteotherlblpricipal.trim();
    }

    public String getPrincipleCity() {
        return principleCity;
    }

    public void setPrincipleCity(String principleCity) {
        this.principleCity = principleCity == null ? null : principleCity.trim();
    }

    public String getPrincipleState() {
        return principleState;
    }

    public void setPrincipleState(String principleState) {
        this.principleState = principleState == null ? null : principleState.trim();
    }

    public String getPrincipleZip() {
        return principleZip;
    }

    public void setPrincipleZip(String principleZip) {
        this.principleZip = principleZip == null ? null : principleZip.trim();
    }

    public String getReginfonAme() {
        return reginfonAme;
    }

    public void setReginfonAme(String reginfonAme) {
        this.reginfonAme = reginfonAme == null ? null : reginfonAme.trim();
    }

    public String getReginfoStreet() {
        return reginfoStreet;
    }

    public void setReginfoStreet(String reginfoStreet) {
        this.reginfoStreet = reginfoStreet == null ? null : reginfoStreet.trim();
    }

    public String getReginfoApt() {
        return reginfoApt;
    }

    public void setReginfoApt(String reginfoApt) {
        this.reginfoApt = reginfoApt == null ? null : reginfoApt.trim();
    }

    public String getReginfoCity() {
        return reginfoCity;
    }

    public void setReginfoCity(String reginfoCity) {
        this.reginfoCity = reginfoCity == null ? null : reginfoCity.trim();
    }

    public String getReginfoState() {
        return reginfoState;
    }

    public void setReginfoState(String reginfoState) {
        this.reginfoState = reginfoState == null ? null : reginfoState.trim();
    }

    public String getReginfoZipcode() {
        return reginfoZipcode;
    }

    public void setReginfoZipcode(String reginfoZipcode) {
        this.reginfoZipcode = reginfoZipcode == null ? null : reginfoZipcode.trim();
    }

    public String getReginfoCountry() {
        return reginfoCountry;
    }

    public void setReginfoCountry(String reginfoCountry) {
        this.reginfoCountry = reginfoCountry == null ? null : reginfoCountry.trim();
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