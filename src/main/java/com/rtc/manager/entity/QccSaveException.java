package com.rtc.manager.entity;

import java.util.Date;

public class QccSaveException {
    private Integer id;

    private String enterpriseId;

    private String saveDate;

    private String desicionAuthority;

    private String saveReason;

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