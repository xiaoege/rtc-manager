package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;

public class QccFinancingConsultationVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;

    private String date;

    private String name;

    private String financingRound;

    private String amount;

    private String investor;

    private String source;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFinancingRound() {
        return financingRound;
    }

    public void setFinancingRound(String financingRound) {
        this.financingRound = financingRound;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getInvestor() {
        return investor;
    }

    public void setInvestor(String investor) {
        this.investor = investor;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}