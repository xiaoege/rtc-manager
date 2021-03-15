package com.rtc.manager.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QccSaveException {
    private Integer id;

    private String enterpriseId;
    @JsonAlias("列入日期")
    private String saveDate;
    @JsonAlias("作出决定机关")
    private String desicionAuthority;
    @JsonAlias("列入经营异常名录原因")
    private String saveReason;

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

    public String getSaveDate() {
        return saveDate;
    }

    public void setSaveDate(String saveDate) {
        this.saveDate = saveDate == null ? null : saveDate.trim();
    }

    public String getDesicionAuthority() {
        return desicionAuthority;
    }

    public void setDesicionAuthority(String desicionAuthority) {
        this.desicionAuthority = desicionAuthority == null ? null : desicionAuthority.trim();
    }

    public String getSaveReason() {
        return saveReason;
    }

    public void setSaveReason(String saveReason) {
        this.saveReason = saveReason == null ? null : saveReason.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getgmtModified() {
        return gmtModified;
    }

    public void setgmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}