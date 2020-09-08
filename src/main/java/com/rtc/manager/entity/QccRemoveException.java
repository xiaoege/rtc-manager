package com.rtc.manager.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QccRemoveException {
    private Integer id;

    private String enterpriseId;

    @JsonAlias("列入经营异常名录原因")
    private String saveReason;

    @JsonAlias("作出决定机关")
    private String desicionAuthority;

    @JsonAlias("移出日期")
    private String removeDate;

    @JsonAlias("移出经营异常名录原因")
    private String removeReason;

    @JsonAlias("列入日期")
    private String saveDate;

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

    public String getSaveReason() {
        return saveReason;
    }

    public void setSaveReason(String saveReason) {
        this.saveReason = saveReason;
    }

    public String getDesicionAuthority() {
        return desicionAuthority;
    }

    public void setDesicionAuthority(String desicionAuthority) {
        this.desicionAuthority = desicionAuthority;
    }

    public String getRemoveDate() {
        return removeDate;
    }

    public void setRemoveDate(String removeDate) {
        this.removeDate = removeDate;
    }

    public String getRemoveReason() {
        return removeReason;
    }

    public void setRemoveReason(String removeReason) {
        this.removeReason = removeReason;
    }

    public String getSaveDate() {
        return saveDate;
    }

    public void setSaveDate(String saveDate) {
        this.saveDate = saveDate;
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