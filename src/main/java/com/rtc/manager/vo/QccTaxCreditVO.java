package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;

public class QccTaxCreditVO {
    private Integer id;

    private String enterpriseId;

    private String year;

    private String taxpayerIdentificationNumber;

    private String taxCreditRank;

    public Integer getId() {
        return id;
    }
    @JsonSetter("pid")
    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTaxpayerIdentificationNumber() {
        return taxpayerIdentificationNumber;
    }

    public void setTaxpayerIdentificationNumber(String taxpayerIdentificationNumber) {
        this.taxpayerIdentificationNumber = taxpayerIdentificationNumber;
    }

    public String getTaxCreditRank() {
        return taxCreditRank;
    }

    public void setTaxCreditRank(String taxCreditRank) {
        this.taxCreditRank = taxCreditRank;
    }
}