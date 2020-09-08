package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rtc.manager.entity.vietnam.VietnamBusinessActivities;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VietnamJsonDTO {
    private Integer id;

    private String enterpriseId;
    @JsonAlias("Enterprise name")
    private String enterpriseName;
    @JsonAlias("Enterprise name in foreign language")
    private String enterpriseNameInForeignLanguage;
    @JsonAlias("Enterprise short name")
    private String enterpriseShortName;
    @JsonAlias("Enterpirse_status")
    private String enterpirseStatus;
    @JsonAlias("Enterprise code")
    private String enterpriseCode;
    @JsonAlias("Legal type")
    private String legalType;
    @JsonAlias("Founding date")
    private String foundingDate;
    @JsonAlias("Representative first name")
    private String representativeFirstName;
    @JsonAlias("Head office address")
    private String headOfficeAddress;
    @JsonAlias("business activities")
    private List<VietnamBusinessActivities> vietnamBusinessActivitiesList;

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

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseNameInForeignLanguage() {
        return enterpriseNameInForeignLanguage;
    }

    public void setEnterpriseNameInForeignLanguage(String enterpriseNameInForeignLanguage) {
        this.enterpriseNameInForeignLanguage = enterpriseNameInForeignLanguage;
    }

    public String getEnterpriseShortName() {
        return enterpriseShortName;
    }

    public void setEnterpriseShortName(String enterpriseShortName) {
        this.enterpriseShortName = enterpriseShortName;
    }

    public String getEnterpirseStatus() {
        return enterpirseStatus;
    }

    public void setEnterpirseStatus(String enterpirseStatus) {
        this.enterpirseStatus = enterpirseStatus;
    }

    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }

    public String getLegalType() {
        return legalType;
    }

    public void setLegalType(String legalType) {
        this.legalType = legalType;
    }

    public String getFoundingDate() {
        return foundingDate;
    }

    public void setFoundingDate(String foundingDate) {
        this.foundingDate = foundingDate;
    }

    public String getRepresentativeFirstName() {
        return representativeFirstName;
    }

    public void setRepresentativeFirstName(String representativeFirstName) {
        this.representativeFirstName = representativeFirstName;
    }

    public String getHeadOfficeAddress() {
        return headOfficeAddress;
    }

    public void setHeadOfficeAddress(String headOfficeAddress) {
        this.headOfficeAddress = headOfficeAddress;
    }

    public List<VietnamBusinessActivities> getVietnamBusinessActivitiesList() {
        return vietnamBusinessActivitiesList;
    }

    public void setVietnamBusinessActivitiesList(List<VietnamBusinessActivities> vietnamBusinessActivitiesList) {
        this.vietnamBusinessActivitiesList = vietnamBusinessActivitiesList;
    }
}