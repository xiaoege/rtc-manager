package com.rtc.manager.vo.india;

import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * @author ChenHang
 */
public class IndiaChargeVO {
    private Integer id;
    private String enterpriseId;
    private String srn;
    private String chargeId;
    private String chargeHolderName;
    private String dateOfCreation;
    private String dateOfModification;
    private String dateOfSatisfaction;
    private String amount;
    private String address;

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
