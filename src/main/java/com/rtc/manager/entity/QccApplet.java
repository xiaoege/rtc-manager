package com.rtc.manager.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QccApplet {
    private Integer id;

    private String enterpriseId;

    @JsonAlias("名称")
    private String name;

    @JsonAlias("分类")
    private String sort;

    @JsonAlias("关联公众号")
    private String associatedOfficialAccount;

    @JsonAlias("公众号预估阅读量")
    private String predictReadingVolume;

    private Date gmtCreate;

    private Date gmtModified;

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

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}