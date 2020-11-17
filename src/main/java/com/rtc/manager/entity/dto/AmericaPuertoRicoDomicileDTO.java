package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author ChenHang
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaPuertoRicoDomicileDTO {
    @JsonAlias("Home State")
    private String homeState;
    @JsonAlias("Domicile Address")
    private String domicileAddress;
    @JsonAlias("Date of Incorporation")
    private String incorporationDate;
    @JsonAlias("Expiration Date")
    private String domicileExpirationDate;

    public String getHomeState() {
        return homeState;
    }

    public void setHomeState(String homeState) {
        this.homeState = homeState;
    }

    public String getDomicileAddress() {
        return domicileAddress;
    }

    public void setDomicileAddress(String domicileAddress) {
        this.domicileAddress = domicileAddress;
    }

    public String getIncorporationDate() {
        return incorporationDate;
    }

    public void setIncorporationDate(String incorporationDate) {
        this.incorporationDate = incorporationDate;
    }

    public String getDomicileExpirationDate() {
        return domicileExpirationDate;
    }

    public void setDomicileExpirationDate(String domicileExpirationDate) {
        this.domicileExpirationDate = domicileExpirationDate;
    }
}
