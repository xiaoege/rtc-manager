package com.rtc.manager.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QccOutInvestment {
    private Integer id;

    private String enterpriseId;
    @JsonAlias("被投资企业名称")
    private String name;
    @JsonAlias("法定代表人")
    private String legalRepresentative;
    @JsonAlias("注册资本")
    private String registeredCapital;
    @JsonAlias("投资比例")
    private String ratio;
    @JsonAlias("投资数额")
    private String amount;
    @JsonAlias("成立日期")
    private String releaseDate;
    @JsonAlias("状态")
    private String investmentStatus;
    @JsonAlias("融资轮次")
    private String round;
    @JsonAlias("融资日期")
    private String financingDate;
    @JsonAlias("关联产品/机构")
    private String productsInstitutions;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative == null ? null : legalRepresentative.trim();
    }

    public String getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital == null ? null : registeredCapital.trim();
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio == null ? null : ratio.trim();
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate == null ? null : releaseDate.trim();
    }

    public String getInvestmentStatus() {
        return investmentStatus;
    }

    public void setInvestmentStatus(String investmentStatus) {
        this.investmentStatus = investmentStatus == null ? null : investmentStatus.trim();
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round == null ? null : round.trim();
    }

    public String getFinancingDate() {
        return financingDate;
    }

    public void setFinancingDate(String financingDate) {
        this.financingDate = financingDate == null ? null : financingDate.trim();
    }

    public String getProductsInstitutions() {
        return productsInstitutions;
    }

    public void setProductsInstitutions(String productsInstitutions) {
        this.productsInstitutions = productsInstitutions == null ? null : productsInstitutions.trim();
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getgmtModified() {
        return gmtModified;
    }

    public void setgmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}