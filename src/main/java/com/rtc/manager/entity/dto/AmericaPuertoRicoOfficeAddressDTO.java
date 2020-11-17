package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author ChenHang
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaPuertoRicoOfficeAddressDTO {
    @JsonAlias("Street Address")
    private String officeStreetAddress;
    @JsonAlias("Mailing Address")
    private String officeMailingAddress;

    public String getOfficeStreetAddress() {
        return officeStreetAddress;
    }

    public void setOfficeStreetAddress(String officeStreetAddress) {
        this.officeStreetAddress = officeStreetAddress;
    }

    public String getOfficeMailingAddress() {
        return officeMailingAddress;
    }

    public void setOfficeMailingAddress(String officeMailingAddress) {
        this.officeMailingAddress = officeMailingAddress;
    }
}
