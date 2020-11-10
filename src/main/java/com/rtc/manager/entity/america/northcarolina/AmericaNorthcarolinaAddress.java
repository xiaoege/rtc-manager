package com.rtc.manager.entity.america.northcarolina;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaNorthcarolinaAddress {
    private Integer id;

    private String enterpriseId;
    @JsonAlias("Mailing")
    private String mailing;
    @JsonAlias("Principal Office")
    private String principalOffice;
    @JsonAlias("Reg Office")
    private String regOffice;
    @JsonAlias("Reg Mailing")
    private String regMailing;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

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

    public String getMailing() {
        return mailing;
    }

    public void setMailing(String mailing) {
        this.mailing = mailing == null ? null : mailing.trim();
    }

    public String getPrincipalOffice() {
        return principalOffice;
    }

    public void setPrincipalOffice(String principalOffice) {
        this.principalOffice = principalOffice == null ? null : principalOffice.trim();
    }

    public String getRegOffice() {
        return regOffice;
    }

    public void setRegOffice(String regOffice) {
        this.regOffice = regOffice == null ? null : regOffice.trim();
    }

    public String getRegMailing() {
        return regMailing;
    }

    public void setRegMailing(String regMailing) {
        this.regMailing = regMailing == null ? null : regMailing.trim();
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}