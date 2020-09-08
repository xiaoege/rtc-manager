package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;

public class QccAppletVO {
    private Integer id;

    private String enterpriseId;

    private String name;

    private String sort;

    private String associatedOfficialAccount;

    private String predictReadingVolume;

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

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getAssociatedOfficialAccount() {
        return associatedOfficialAccount;
    }

    public void setAssociatedOfficialAccount(String associatedOfficialAccount) {
        this.associatedOfficialAccount = associatedOfficialAccount;
    }

    public String getPredictReadingVolume() {
        return predictReadingVolume;
    }

    public void setPredictReadingVolume(String predictReadingVolume) {
        this.predictReadingVolume = predictReadingVolume;
    }
}