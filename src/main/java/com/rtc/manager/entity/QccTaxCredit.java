package com.rtc.manager.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QccTaxCredit {
    private Integer id;

    private String enterpriseId;

    @JsonAlias("评价年度")
    private String year;

    @JsonAlias("纳税人识别号")
    private String taxpayerIdentificationNumber;

    @JsonAlias("纳税信用等级")
    private String taxCreditRank;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private Integer status;

    @JsonAlias("评价单位")
    private String evaluationCop;

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

    public String getEvaluationCop() {
        return evaluationCop;
    }

    public void setEvaluationCop(String evaluationCop) {
        this.evaluationCop = evaluationCop;
    }
}