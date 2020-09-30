package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rtc.manager.entity.america.alabama.AmericaAlabama;
import com.rtc.manager.entity.america.alabama.AmericaAlabamaDirector;
import com.rtc.manager.entity.america.alabama.AmericaAlabamaIncorporator;
import com.rtc.manager.entity.america.alabama.AmericaAlabamaMember;

import java.util.List;

/**
 * @author ChenHang
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaAlabamaDTO {
    private Integer id;

    private String enterpriseId;

    private String name;
    @JsonAlias("Entity ID Number")
    private String entityIdNumber;
    @JsonAlias("Entity Type")
    private String entityType;
    @JsonAlias("Principal Address")
    private String principalAddress;
    @JsonAlias("Principal Mailing Address")
    private String principalMailingAddress;
    @JsonAlias("Status")
    private String enterpriseStatus;
    @JsonAlias("Place of Formation")
    private String placeOfFormation;
    @JsonAlias("Formation Date")
    private String formationDate;
    @JsonAlias("Registered Agent Name")
    private String registeredAgentName;
    @JsonAlias("Registered Office Street Address")
    private String registeredOfficeStreetAddress;
    @JsonAlias("Registered Office Mailing Address")
    private String registeredOfficeMailingAddress;
    @JsonAlias("Nature of Business")
    private String natureOfBusiness;

    @JsonAlias("incorporators")
    List<AmericaAlabamaIncorporator> incorporatorList;

    @JsonAlias("members")
    List<AmericaAlabamaMember> memberList;

    @JsonAlias("directors")
    List<AmericaAlabamaDirector> directorList;

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
        this.enterpriseId = enterpriseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEntityIdNumber() {
        return entityIdNumber;
    }

    public void setEntityIdNumber(String entityIdNumber) {
        this.entityIdNumber = entityIdNumber;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getPrincipalAddress() {
        return principalAddress;
    }

    public void setPrincipalAddress(String principalAddress) {
        this.principalAddress = principalAddress;
    }

    public String getPrincipalMailingAddress() {
        return principalMailingAddress;
    }

    public void setPrincipalMailingAddress(String principalMailingAddress) {
        this.principalMailingAddress = principalMailingAddress;
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public String getPlaceOfFormation() {
        return placeOfFormation;
    }

    public void setPlaceOfFormation(String placeOfFormation) {
        this.placeOfFormation = placeOfFormation;
    }

    public String getFormationDate() {
        return formationDate;
    }

    public void setFormationDate(String formationDate) {
        this.formationDate = formationDate;
    }

    public String getRegisteredAgentName() {
        return registeredAgentName;
    }

    public void setRegisteredAgentName(String registeredAgentName) {
        this.registeredAgentName = registeredAgentName;
    }

    public String getRegisteredOfficeStreetAddress() {
        return registeredOfficeStreetAddress;
    }

    public void setRegisteredOfficeStreetAddress(String registeredOfficeStreetAddress) {
        this.registeredOfficeStreetAddress = registeredOfficeStreetAddress;
    }

    public String getRegisteredOfficeMailingAddress() {
        return registeredOfficeMailingAddress;
    }

    public void setRegisteredOfficeMailingAddress(String registeredOfficeMailingAddress) {
        this.registeredOfficeMailingAddress = registeredOfficeMailingAddress;
    }

    public String getNatureOfBusiness() {
        return natureOfBusiness;
    }

    public void setNatureOfBusiness(String natureOfBusiness) {
        this.natureOfBusiness = natureOfBusiness;
    }

    public List<AmericaAlabamaIncorporator> getIncorporatorList() {
        return incorporatorList;
    }

    public void setIncorporatorList(List<AmericaAlabamaIncorporator> incorporatorList) {
        this.incorporatorList = incorporatorList;
    }

    public List<AmericaAlabamaMember> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<AmericaAlabamaMember> memberList) {
        this.memberList = memberList;
    }

    public List<AmericaAlabamaDirector> getDirectorList() {
        return directorList;
    }

    public void setDirectorList(List<AmericaAlabamaDirector> directorList) {
        this.directorList = directorList;
    }
}
