package com.rtc.manager.entity.america.alabama;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaAlabamaIncorporator {
    private Integer id;

    private String enterpriseId;
    @JsonAlias("Incorporator Name")
    private String incorporatorName;
    @JsonAlias("Incorporator Street Address")
    private String incorporatorStreetAddress;
    @JsonAlias("Incorporator Mailing Address")
    private String incorporatorMailingAddress;

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

    public String getIncorporatorName() {
        return incorporatorName;
    }

    public void setIncorporatorName(String incorporatorName) {
        this.incorporatorName = incorporatorName == null ? null : incorporatorName.trim();
    }

    public String getIncorporatorStreetAddress() {
        return incorporatorStreetAddress;
    }

    public void setIncorporatorStreetAddress(String incorporatorStreetAddress) {
        this.incorporatorStreetAddress = incorporatorStreetAddress == null ? null : incorporatorStreetAddress.trim();
    }

    public String getIncorporatorMailingAddress() {
        return incorporatorMailingAddress;
    }

    public void setIncorporatorMailingAddress(String incorporatorMailingAddress) {
        this.incorporatorMailingAddress = incorporatorMailingAddress == null ? null : incorporatorMailingAddress.trim();
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