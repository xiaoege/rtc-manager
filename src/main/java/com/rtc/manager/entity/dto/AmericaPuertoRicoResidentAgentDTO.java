package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author ChenHang
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaPuertoRicoResidentAgentDTO {
    @JsonAlias("Name")
    private String residentName;
    @JsonAlias("Street Address")
    private String residentStreetAddress;
    @JsonAlias("Mailing Address")
    private String residentMailingAddress;

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    public String getResidentStreetAddress() {
        return residentStreetAddress;
    }

    public void setResidentStreetAddress(String residentStreetAddress) {
        this.residentStreetAddress = residentStreetAddress;
    }

    public String getResidentMailingAddress() {
        return residentMailingAddress;
    }

    public void setResidentMailingAddress(String residentMailingAddress) {
        this.residentMailingAddress = residentMailingAddress;
    }
}
