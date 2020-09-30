package com.rtc.manager.entity.america.alabama;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaAlabamaMember {
    private Integer id;

    private String enterpriseId;
    @JsonAlias("Incorporator Name")
    private String memberName;
    @JsonAlias("Incorporator Street Address")
    private String memberStreetAddress;
    @JsonAlias("Incorporator Mailing Address")
    private String memberMailingAddress;

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

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    public String getMemberStreetAddress() {
        return memberStreetAddress;
    }

    public void setMemberStreetAddress(String memberStreetAddress) {
        this.memberStreetAddress = memberStreetAddress == null ? null : memberStreetAddress.trim();
    }

    public String getMemberMailingAddress() {
        return memberMailingAddress;
    }

    public void setMemberMailingAddress(String memberMailingAddress) {
        this.memberMailingAddress = memberMailingAddress == null ? null : memberMailingAddress.trim();
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