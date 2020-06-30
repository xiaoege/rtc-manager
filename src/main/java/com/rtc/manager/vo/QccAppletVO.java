package com.rtc.manager.vo;

import java.util.Date;

public class QccAppletVO {
    private Integer id;

    private String enterpriseId;

    private String name;

    private String sort;

    private String associatedOfficialAccount;

    private String predictReadingVolume;

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
        this.enterpriseId = enterpriseId == null ? null : enterpriseId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    public String getAssociatedOfficialAccount() {
        return associatedOfficialAccount;
    }

    public void setAssociatedOfficialAccount(String associatedOfficialAccount) {
        this.associatedOfficialAccount = associatedOfficialAccount == null ? null : associatedOfficialAccount.trim();
    }

    public String getPredictReadingVolume() {
        return predictReadingVolume;
    }

    public void setPredictReadingVolume(String predictReadingVolume) {
        this.predictReadingVolume = predictReadingVolume == null ? null : predictReadingVolume.trim();
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