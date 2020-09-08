package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QccEquityOutPledgeVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;
    @JsonAlias("登记编号")
    private String code;
    @JsonAlias("出质人")
    private String pledgor;
    @JsonAlias("质权人")
    private String pledgee;
    @JsonAlias("出质股权标的企业")
    private String enterprise;
    @JsonAlias("出质股权数额(万元)")
    private String amount;
    @JsonAlias("登记日期")
    private String registrationDate;
    @JsonAlias("状态")
    private String pledgeStatus;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPledgor() {
        return pledgor;
    }

    public void setPledgor(String pledgor) {
        this.pledgor = pledgor;
    }

    public String getPledgee() {
        return pledgee;
    }

    public void setPledgee(String pledgee) {
        this.pledgee = pledgee;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getPledgeStatus() {
        return pledgeStatus;
    }

    public void setPledgeStatus(String pledgeStatus) {
        this.pledgeStatus = pledgeStatus;
    }
}