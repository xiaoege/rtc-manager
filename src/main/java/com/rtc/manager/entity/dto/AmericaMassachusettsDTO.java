package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rtc.manager.entity.america.massachusetts.AmericaMassachusettsManager;
import com.rtc.manager.entity.america.massachusetts.AmericaMassachusettsOfficer;
import com.rtc.manager.entity.america.massachusetts.AmericaMassachusettsOtherManager;
import com.rtc.manager.entity.america.massachusetts.AmericaMassachusettsPerson;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaMassachusettsDTO {
    private String enterpriseid;
    @JsonAlias("EntityName")
    private String name;
    @JsonAlias("EntityType")
    private String entityType;
    @JsonAlias("OrganisationDate")
    private String organisationDate;
    @JsonAlias("PrincipleStreet")
    private String principleStreet;
    @JsonAlias("CertainDate")
    private String certainDate;
    @JsonAlias("PrincipleCity")
    private String principleCity;
    @JsonAlias("PrincipleState")
    private String principleState;
    @JsonAlias("PrincipleZip")
    private String principleZip;
    @JsonAlias("PrincipleCountry")
    private String principleCountry;
    @JsonAlias("OfficeStreet")
    private String officeStreet;
    @JsonAlias("OfficeCity")
    private String officeCity;
    @JsonAlias("OfficeState")
    private String officeState;
    @JsonAlias("OfficeZip")
    private String officeZip;
    @JsonAlias("OfficeCountry")
    private String officeCountry;
    @JsonAlias("ResidentAgentName")
    private String residentAgentName;
    @JsonAlias("ResidentStreet")
    private String residentStreet;
    @JsonAlias("ResidentCity")
    private String residentCity;
    @JsonAlias("ResidentState")
    private String residentState;
    @JsonAlias("ResidentZip")
    private String residentZip;
    @JsonAlias("ResidentCountry")
    private String residentCountry;
    @JsonAlias("InactiveDate")
    private String inactiveDate;
    @JsonAlias("RecStreet")
    private String recStreet;
    @JsonAlias("RecCity")
    private String recCity;
    @JsonAlias("RecState")
    private String recState;
    @JsonAlias("RecZip")
    private String recZip;
    @JsonAlias("RecCountry")
    private String recCountry;
    @JsonAlias("IDNumber")
    private String idNumber;
    @JsonAlias("Officers")
    private List<AmericaMassachusettsOfficer> officerList;
    @JsonAlias("Managers")
    private List<AmericaMassachusettsManager> managerList;
    @JsonAlias("OtherManagers")
    private List<AmericaMassachusettsOtherManager> otherManagerList;
    @JsonAlias("Persons")
    private List<AmericaMassachusettsPerson> personList;

    public String getEnterpriseid() {
        return enterpriseid;
    }

    public void setEnterpriseid(String enterpriseid) {
        this.enterpriseid = enterpriseid;
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

    public String getOrganisationDate() {
        return organisationDate;
    }

    public void setOrganisationDate(String organisationDate) {
        this.organisationDate = organisationDate;
    }

    public String getPrincipleStreet() {
        return principleStreet;
    }

    public void setPrincipleStreet(String principleStreet) {
        this.principleStreet = principleStreet;
    }

    public String getCertainDate() {
        return certainDate;
    }

    public void setCertainDate(String certainDate) {
        this.certainDate = certainDate;
    }

    public String getPrincipleCity() {
        return principleCity;
    }

    public void setPrincipleCity(String principleCity) {
        this.principleCity = principleCity;
    }

    public String getPrincipleState() {
        return principleState;
    }

    public void setPrincipleState(String principleState) {
        this.principleState = principleState;
    }

    public String getPrincipleZip() {
        return principleZip;
    }

    public void setPrincipleZip(String principleZip) {
        this.principleZip = principleZip;
    }

    public String getPrincipleCountry() {
        return principleCountry;
    }

    public void setPrincipleCountry(String principleCountry) {
        this.principleCountry = principleCountry;
    }

    public String getOfficeStreet() {
        return officeStreet;
    }

    public void setOfficeStreet(String officeStreet) {
        this.officeStreet = officeStreet;
    }

    public String getOfficeCity() {
        return officeCity;
    }

    public void setOfficeCity(String officeCity) {
        this.officeCity = officeCity;
    }

    public String getOfficeState() {
        return officeState;
    }

    public void setOfficeState(String officeState) {
        this.officeState = officeState;
    }

    public String getOfficeZip() {
        return officeZip;
    }

    public void setOfficeZip(String officeZip) {
        this.officeZip = officeZip;
    }

    public String getOfficeCountry() {
        return officeCountry;
    }

    public void setOfficeCountry(String officeCountry) {
        this.officeCountry = officeCountry;
    }

    public String getResidentAgentName() {
        return residentAgentName;
    }

    public void setResidentAgentName(String residentAgentName) {
        this.residentAgentName = residentAgentName;
    }

    public String getResidentStreet() {
        return residentStreet;
    }

    public void setResidentStreet(String residentStreet) {
        this.residentStreet = residentStreet;
    }

    public String getResidentCity() {
        return residentCity;
    }

    public void setResidentCity(String residentCity) {
        this.residentCity = residentCity;
    }

    public String getResidentState() {
        return residentState;
    }

    public void setResidentState(String residentState) {
        this.residentState = residentState;
    }

    public String getResidentZip() {
        return residentZip;
    }

    public void setResidentZip(String residentZip) {
        this.residentZip = residentZip;
    }

    public String getResidentCountry() {
        return residentCountry;
    }

    public void setResidentCountry(String residentCountry) {
        this.residentCountry = residentCountry;
    }

    public String getInactiveDate() {
        return inactiveDate;
    }

    public void setInactiveDate(String inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

    public String getRecStreet() {
        return recStreet;
    }

    public void setRecStreet(String recStreet) {
        this.recStreet = recStreet;
    }

    public String getRecCity() {
        return recCity;
    }

    public void setRecCity(String recCity) {
        this.recCity = recCity;
    }

    public String getRecState() {
        return recState;
    }

    public void setRecState(String recState) {
        this.recState = recState;
    }

    public String getRecZip() {
        return recZip;
    }

    public void setRecZip(String recZip) {
        this.recZip = recZip;
    }

    public String getRecCountry() {
        return recCountry;
    }

    public void setRecCountry(String recCountry) {
        this.recCountry = recCountry;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public List<AmericaMassachusettsOfficer> getOfficerList() {
        return officerList;
    }

    public void setOfficerList(List<AmericaMassachusettsOfficer> officerList) {
        this.officerList = officerList;
    }

    public List<AmericaMassachusettsManager> getManagerList() {
        return managerList;
    }

    public void setManagerList(List<AmericaMassachusettsManager> managerList) {
        this.managerList = managerList;
    }

    public List<AmericaMassachusettsOtherManager> getOtherManagerList() {
        return otherManagerList;
    }

    public void setOtherManagerList(List<AmericaMassachusettsOtherManager> otherManagerList) {
        this.otherManagerList = otherManagerList;
    }

    public List<AmericaMassachusettsPerson> getPersonList() {
        return personList;
    }

    public void setPersonList(List<AmericaMassachusettsPerson> personList) {
        this.personList = personList;
    }
}