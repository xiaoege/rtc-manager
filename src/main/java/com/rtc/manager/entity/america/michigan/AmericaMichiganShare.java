package com.rtc.manager.entity.america.michigan;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.time.LocalDateTime;

public class AmericaMichiganShare {
    private Integer id;

    private String enterpriseId;
    @JsonAlias("Total Authorized Shares")
    private String totalAuthorizedShares;

    @JsonAlias("Shares Attributable to Michigan")
    private String sharesAttributableMichigan;

    @JsonAlias("Most Recent Apportionment %")
    private String mostRecentApportionment;

    @JsonAlias("Year Ending")
    private String yearEnding;

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

    public String getTotalAuthorizedShares() {
        return totalAuthorizedShares;
    }

    public void setTotalAuthorizedShares(String totalAuthorizedShares) {
        this.totalAuthorizedShares = totalAuthorizedShares == null ? null : totalAuthorizedShares.trim();
    }

    public String getSharesAttributableMichigan() {
        return sharesAttributableMichigan;
    }

    public void setSharesAttributableMichigan(String sharesAttributableMichigan) {
        this.sharesAttributableMichigan = sharesAttributableMichigan == null ? null : sharesAttributableMichigan.trim();
    }

    public String getMostRecentApportionment() {
        return mostRecentApportionment;
    }

    public void setMostRecentApportionment(String mostRecentApportionment) {
        this.mostRecentApportionment = mostRecentApportionment == null ? null : mostRecentApportionment.trim();
    }

    public String getYearEnding() {
        return yearEnding;
    }

    public void setYearEnding(String yearEnding) {
        this.yearEnding = yearEnding == null ? null : yearEnding.trim();
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