package com.rtc.manager.vo.america.alabama;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

/**
 * @author ChenHang
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaAlabamaVO {
    private Integer id;
    private String enterpriseId;
    private String name;
    private String entityIdNumber;
    private String entityType;
    private String principalAddress;
    private String principalMailingAddress;
    private String enterpriseStatus;
    private String placeOfFormation;
    private String formationDate;
    private String registeredAgentName;
    private String registeredOfficeStreetAddress;
    private String registeredOfficeMailingAddress;
    private String natureOfBusiness;
    private int favourite;

    List<AmericaAlabamaIncorporatorVO> incorporatorList;

    List<AmericaAlabamaMemberVO> memberList;

    List<AmericaAlabamaDirectorVO> directorList;

    public Integer getId() {
        return id;
    }

    @JsonSetter("pid")
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

    public List<AmericaAlabamaIncorporatorVO> getIncorporatorList() {
        return incorporatorList;
    }

    public void setIncorporatorList(List<AmericaAlabamaIncorporatorVO> incorporatorList) {
        this.incorporatorList = incorporatorList;
    }

    public List<AmericaAlabamaMemberVO> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<AmericaAlabamaMemberVO> memberList) {
        this.memberList = memberList;
    }

    public List<AmericaAlabamaDirectorVO> getDirectorList() {
        return directorList;
    }

    public void setDirectorList(List<AmericaAlabamaDirectorVO> directorList) {
        this.directorList = directorList;
    }

    public int getFavourite() {
        return favourite;
    }

    public void setFavourite(int favourite) {
        this.favourite = favourite;
    }
}
