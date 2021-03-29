package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IndiaChargeDTO {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getSrn() {
        return srn;
    }

    public void setSrn(String srn) {
        this.srn = srn;
    }

    public String getChargeId() {
        return chargeId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId;
    }

    public String getChargeHolderName() {
        return chargeHolderName;
    }

    public void setChargeHolderName(String chargeHolderName) {
        this.chargeHolderName = chargeHolderName;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getDateOfModification() {
        return dateOfModification;
    }

    public void setDateOfModification(String dateOfModification) {
        this.dateOfModification = dateOfModification;
    }

    public String getDateOfSatisfaction() {
        return dateOfSatisfaction;
    }

    public void setDateOfSatisfaction(String dateOfSatisfaction) {
        this.dateOfSatisfaction = dateOfSatisfaction;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}