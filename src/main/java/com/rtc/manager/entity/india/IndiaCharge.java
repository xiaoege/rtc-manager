package com.rtc.manager.entity.india;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IndiaCharge {
    private Integer id;

    private String enterpriseId;
    @JsonAlias("SRN")
    private String srn;
    @JsonAlias("Charge Id")
    private String chargeId;
    @JsonAlias("Charge Holder Name")
    private String chargeHolderName;
    @JsonAlias("Date of Creation")
    private String dateOfCreation;
    @JsonAlias("Date of Modification")
    private String dateOfModification;
    @JsonAlias("Date of Satisfaction")
    private String dateOfSatisfaction;
    @JsonAlias("Amount")
    private String amount;
    @JsonAlias("Address")
    private String address;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModify;

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

    public String getSrn() {
        return srn;
    }

    public void setSrn(String srn) {
        this.srn = srn == null ? null : srn.trim();
    }

    public String getChargeId() {
        return chargeId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId == null ? null : chargeId.trim();
    }

    public String getChargeHolderName() {
        return chargeHolderName;
    }

    public void setChargeHolderName(String chargeHolderName) {
        this.chargeHolderName = chargeHolderName == null ? null : chargeHolderName.trim();
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation == null ? null : dateOfCreation.trim();
    }

    public String getDateOfModification() {
        return dateOfModification;
    }

    public void setDateOfModification(String dateOfModification) {
        this.dateOfModification = dateOfModification == null ? null : dateOfModification.trim();
    }

    public String getDateOfSatisfaction() {
        return dateOfSatisfaction;
    }

    public void setDateOfSatisfaction(String dateOfSatisfaction) {
        this.dateOfSatisfaction = dateOfSatisfaction == null ? null : dateOfSatisfaction.trim();
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(LocalDateTime gmtModify) {
        this.gmtModify = gmtModify;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}