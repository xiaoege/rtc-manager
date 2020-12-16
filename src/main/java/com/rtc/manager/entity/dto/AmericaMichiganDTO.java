package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.*;
import com.rtc.manager.entity.america.michigan.AmericaMichiganOfficer;
import com.rtc.manager.entity.america.michigan.AmericaMichiganShare;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaMichiganDTO {

    private String enterpriseId;
    @JsonAlias("IDNumberHeader")
    private String idNumberHeader;
    @JsonAlias("EntityNameHeader")
    private String nameHeader;
    @JsonAlias("EntityName")
    private String name;
    @JsonAlias("EntityType")
    private String entityType;
    @JsonAlias("IDNumber")
    private String idNumber;
    @JsonAlias("OldIDNumber")
    private String oldIdNumber;
    @JsonAlias("OrganisationDate")
    private String organisationDate;
    @JsonAlias("Purpose")
    private String purpose;
    @JsonAlias("InactiveDate")
    private String inactiveDate;
    @JsonAlias("Term")
    private String term;
    @JsonAlias("MostRecentAnnualReportYear")
    private String recentAnnualReportYear;
    @JsonAlias("MostRecentAnnualReportWithOfficersAndDirectors")
    private String recentAnnualReportWithes;
    @JsonAlias("ActsFormedUnder")
    private String actsFormedUnder;
    @JsonAlias("Sum")
    private String sumInfo;

    @JsonAlias("Resident")
    private AmericaMichiganResidentDTO residentDTO;

    @JsonAlias("PrincipleOffice")
    private AmericaMichiganPrincipleOfficeDTO principleOfficeDTO;

    @JsonAlias("RegInfo")
    private AmericaMichiganRegInfoDTO regInfoDTO;

    @JsonAlias("officers")
    private List<AmericaMichiganOfficer> officerList;

    @JsonAlias("shares")
    private List<AmericaMichiganShare> shareList;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getIdNumberHeader() {
        return idNumberHeader;
    }

    public void setIdNumberHeader(String idNumberHeader) {
        this.idNumberHeader = idNumberHeader;
    }

    public String getNameHeader() {
        return nameHeader;
    }

    public void setNameHeader(String nameHeader) {
        this.nameHeader = nameHeader;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getOldIdNumber() {
        return oldIdNumber;
    }

    public void setOldIdNumber(String oldIdNumber) {
        this.oldIdNumber = oldIdNumber;
    }

    public String getOrganisationDate() {
        return organisationDate;
    }

    public void setOrganisationDate(String organisationDate) {
        this.organisationDate = organisationDate;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getInactiveDate() {
        return inactiveDate;
    }

    public void setInactiveDate(String inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getRecentAnnualReportYear() {
        return recentAnnualReportYear;
    }

    public void setRecentAnnualReportYear(String recentAnnualReportYear) {
        this.recentAnnualReportYear = recentAnnualReportYear;
    }

    public String getRecentAnnualReportWithes() {
        return recentAnnualReportWithes;
    }

    public void setRecentAnnualReportWithes(String recentAnnualReportWithes) {
        this.recentAnnualReportWithes = recentAnnualReportWithes;
    }

    public String getActsFormedUnder() {
        return actsFormedUnder;
    }

    public void setActsFormedUnder(String actsFormedUnder) {
        this.actsFormedUnder = actsFormedUnder;
    }

    public String getSumInfo() {
        return sumInfo;
    }

    public void setSumInfo(String sumInfo) {
        this.sumInfo = sumInfo;
    }

    public AmericaMichiganResidentDTO getResidentDTO() {
        return residentDTO;
    }

    public void setResidentDTO(AmericaMichiganResidentDTO residentDTO) {
        this.residentDTO = residentDTO;
    }

    public AmericaMichiganPrincipleOfficeDTO getPrincipleOfficeDTO() {
        return principleOfficeDTO;
    }

    public void setPrincipleOfficeDTO(AmericaMichiganPrincipleOfficeDTO principleOfficeDTO) {
        this.principleOfficeDTO = principleOfficeDTO;
    }

    public AmericaMichiganRegInfoDTO getRegInfoDTO() {
        return regInfoDTO;
    }

    public void setRegInfoDTO(AmericaMichiganRegInfoDTO regInfoDTO) {
        this.regInfoDTO = regInfoDTO;
    }

    public List<AmericaMichiganOfficer> getOfficerList() {
        return officerList;
    }

    public void setOfficerList(List<AmericaMichiganOfficer> officerList) {
        this.officerList = officerList;
    }

    public List<AmericaMichiganShare> getShareList() {
        return shareList;
    }

    public void setShareList(List<AmericaMichiganShare> shareList) {
        this.shareList = shareList;
    }
}