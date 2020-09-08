package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;

public class QccImportExportCreditVO {
    private Integer id;

    private String enterpriseId;

    private String registeredCustoms;

    private String businessCategory;

    private String registrationDate;

    private String content;

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

    public String getRegisteredCustoms() {
        return registeredCustoms;
    }

    public void setRegisteredCustoms(String registeredCustoms) {
        this.registeredCustoms = registeredCustoms;
    }

    public String getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}