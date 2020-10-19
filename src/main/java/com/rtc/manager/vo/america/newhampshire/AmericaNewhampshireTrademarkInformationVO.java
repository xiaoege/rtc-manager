package com.rtc.manager.vo.america.newhampshire;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaNewhampshireTrademarkInformationVO {
    private Integer id;
    private String trademarkNumber;
    private String trademarkName;
    private String businessAddress;
    private String mailingAddress;

    public Integer getId() {
        return id;
    }
    @JsonSetter("pid")
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrademarkNumber() {
        return trademarkNumber;
    }

    public void setTrademarkNumber(String trademarkNumber) {
        this.trademarkNumber = trademarkNumber;
    }

    public String getTrademarkName() {
        return trademarkName;
    }

    public void setTrademarkName(String trademarkName) {
        this.trademarkName = trademarkName;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }
}