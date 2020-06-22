package com.rtc.manager.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

/**
 * @author ChenHang
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RtcEnterpriseDTO {
    private Integer id;

    private String uuid;

    private String name;

    @JsonAlias("Main Products")
    private String mainProducts;

    @JsonAlias("Country/Region")
    private String countryRegion;

    @JsonAlias("Total Revenue")
    private String totalRevenue;

    @JsonAlias("Top 3 Markets")
    private String top3Markets;

    private String trans6mTimes;

    private String trans6mAmount;

    private String url;

    private Integer qccMatch;

    private String qccSearchString;

    private List qccMatchSummary;

    private List qcc;

    private Date gmtCreate;

    private Date gmtUpdate;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMainProducts() {
        return mainProducts;
    }

    public void setMainProducts(String mainProducts) {
        this.mainProducts = mainProducts;
    }

    public String getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }

    public String getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(String totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public String getTop3Markets() {
        return top3Markets;
    }

    public void setTop3Markets(String top3Markets) {
        this.top3Markets = top3Markets;
    }

    public String getTrans6mTimes() {
        return trans6mTimes;
    }

    public void setTrans6mTimes(String trans6mTimes) {
        this.trans6mTimes = trans6mTimes;
    }

    public String getTrans6mAmount() {
        return trans6mAmount;
    }

    public void setTrans6mAmount(String trans6mAmount) {
        this.trans6mAmount = trans6mAmount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getQccMatch() {
        return qccMatch;
    }

    public void setQccMatch(Integer qccMatch) {
        this.qccMatch = qccMatch;
    }

    public String getQccSearchString() {
        return qccSearchString;
    }

    public void setQccSearchString(String qccSearchString) {
        this.qccSearchString = qccSearchString;
    }

    public List getQccMatchSummary() {
        return qccMatchSummary;
    }

    public void setQccMatchSummary(List qccMatchSummary) {
        this.qccMatchSummary = qccMatchSummary;
    }

    public List getQcc() {
        return qcc;
    }

    public void setQcc(List qcc) {
        this.qcc = qcc;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
