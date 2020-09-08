package com.rtc.manager.vo.vietnam;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class VietnamEnterpriseVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;
    @JsonSetter("e_name")
    private String enterpriseName;

    private String enterpriseNameInForeignLanguage;

    private String enterpriseShortName;

    private String enterpirseStatus;

    private String enterpriseCode;

    private String legalType;
    @JsonSetter("establishmentDate")
    private String foundingDate;

    private String representativeFirstName;
    @JsonSetter("address")
    private String headOfficeAddress;

    private List<VietnamBusinessActivitiesVO> vsciList;

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

    public List<VietnamBusinessActivitiesVO> getVsciList() {
        return vsciList;
    }

    public void setVsciList(List<VietnamBusinessActivitiesVO> vsciList) {
        this.vsciList = vsciList;
    }
}