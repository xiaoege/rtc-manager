package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * @author ChenHang
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IndiaCinDTO {
    IndiaCinBasicDTO basic;

    List<IndiaChargeDTO> charges;

    List<IndiaSignatoryDTO> signatory;

    public IndiaCinBasicDTO getBasic() {
        return basic;
    }

    public void setBasic(IndiaCinBasicDTO basic) {
        this.basic = basic;
    }

    public List<IndiaChargeDTO> getCharges() {
        return charges;
    }

    public void setCharges(List<IndiaChargeDTO> charges) {
        this.charges = charges;
    }

    public List<IndiaSignatoryDTO> getSignatory() {
        return signatory;
    }

    public void setSignatory(List<IndiaSignatoryDTO> signatory) {
        this.signatory = signatory;
    }

}
