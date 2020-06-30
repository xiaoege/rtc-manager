package com.rtc.manager.entity;

import java.util.Date;

public class QccRemoveException {
    private Integer id;

    private String enterpriseId;

    private String saveReason;

    private String desicionAuthority;

    private String removeDate;

    private String removeReason;

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

    public String getSaveReason() {
        return saveReason;
    }

    public void setSaveReason(String saveReason) {
        this.saveReason = saveReason == null ? null : saveReason.trim();
    }

    public String getDesicionAuthority() {
        return desicionAuthority;
    }

    public void setDesicionAuthority(String desicionAuthority) {
        this.desicionAuthority = desicionAuthority == null ? null : desicionAuthority.trim();
    }

    public String getRemoveDate() {
        return removeDate;
    }

    public void setRemoveDate(String removeDate) {
        this.removeDate = removeDate == null ? null : removeDate.trim();
    }

    public String getRemoveReason() {
        return removeReason;
    }

    public void setRemoveReason(String removeReason) {
        this.removeReason = removeReason == null ? null : removeReason.trim();
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