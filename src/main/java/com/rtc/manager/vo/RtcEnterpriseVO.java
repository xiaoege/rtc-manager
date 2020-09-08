package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * @author ChenHang
 */
public class RtcEnterpriseVO {
    @JsonSetter("pid")
    private Integer id;

    private String uuid;

    private String name;

    private String mainProducts;

    private String countryRegion;

    private String totalRevenue;

    private String top3Markets;

    private String trans6mTimes;

    private String trans6mAmount;

    private String url;

    private String qccMatch;

    private String qccSearchString;

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

    public String getQccMatch() {
        return qccMatch;
    }

    public void setQccMatch(String qccMatch) {
        this.qccMatch = qccMatch;
    }

    public String getQccSearchString() {
        return qccSearchString;
    }

    public void setQccSearchString(String qccSearchString) {
        this.qccSearchString = qccSearchString;
    }
}
