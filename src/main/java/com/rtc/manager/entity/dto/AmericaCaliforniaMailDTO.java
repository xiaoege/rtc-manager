package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author ChenHang
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaCaliforniaMailDTO {
    @JsonAlias("Address")
    private String mailingAddress;
    @JsonAlias("City")
    private String mailingCity;
    @JsonAlias("State")
    private String mailingState;
    @JsonAlias("Zip")
    private String mailingZip;

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getMailingCity() {
        return mailingCity;
    }

    public void setMailingCity(String mailingCity) {
        this.mailingCity = mailingCity;
    }

    public String getMailingState() {
        return mailingState;
    }

    public void setMailingState(String mailingState) {
        this.mailingState = mailingState;
    }

    public String getMailingZip() {
        return mailingZip;
    }

    public void setMailingZip(String mailingZip) {
        this.mailingZip = mailingZip;
    }
}
