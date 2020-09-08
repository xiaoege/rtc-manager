package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;

public class QccSoftwareCopyrightVO {
    private Integer id;

    private String enterpriseId;

    private String name;

    private String version;

    private String releaseDate;

    private String abbreviation;

    private String registrationNumber;

    private String registrationApprovalDate;

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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationApprovalDate() {
        return registrationApprovalDate;
    }

    public void setRegistrationApprovalDate(String registrationApprovalDate) {
        this.registrationApprovalDate = registrationApprovalDate;
    }
}