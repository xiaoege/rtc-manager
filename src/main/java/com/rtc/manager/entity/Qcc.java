package com.rtc.manager.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.HashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Qcc {
    private Integer id;

    private String enterpriseId;

    @JsonAlias("名称")
    private String name;

    @JsonAlias("电话")
    private String telephone;

    @JsonAlias("官网")
    private String url;

    @JsonAlias("邮箱")
    private String email;

    @JsonAlias("地址")
    private String address;

    @JsonAlias("地区")
    private String countryRegion;

    @JsonAlias("基本信息")
    private HashMap basicInformation;

    @JsonAlias("法律诉讼")
    private HashMap legalProceeding;

    @JsonAlias("经营状况")
    private HashMap businessStatus;

    @JsonAlias("经营风险")
    private HashMap businessRisk;

    @JsonAlias("企业发展")
    private HashMap enterpriseDevelopment;

    @JsonAlias("知识产权")
    private HashMap intellectualProperty;

    private Date gmtCreate;

    private Date gmtModify;

    private Integer status;

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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }

    public HashMap getBasicInformation() {
        return basicInformation;
    }

    public void setBasicInformation(HashMap basicInformation) {
        this.basicInformation = basicInformation;
    }

    public HashMap getLegalProceeding() {
        return legalProceeding;
    }

    public void setLegalProceeding(HashMap legalProceeding) {
        this.legalProceeding = legalProceeding;
    }

    public HashMap getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(HashMap businessStatus) {
        this.businessStatus = businessStatus;
    }

    public HashMap getBusinessRisk() {
        return businessRisk;
    }

    public void setBusinessRisk(HashMap businessRisk) {
        this.businessRisk = businessRisk;
    }

    public HashMap getEnterpriseDevelopment() {
        return enterpriseDevelopment;
    }

    public void setEnterpriseDevelopment(HashMap enterpriseDevelopment) {
        this.enterpriseDevelopment = enterpriseDevelopment;
    }

    public HashMap getIntellectualProperty() {
        return intellectualProperty;
    }

    public void setIntellectualProperty(HashMap intellectualProperty) {
        this.intellectualProperty = intellectualProperty;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}