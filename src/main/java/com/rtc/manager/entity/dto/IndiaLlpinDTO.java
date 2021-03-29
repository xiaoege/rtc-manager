package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rtc.manager.entity.india.IndiaCharge;
import com.rtc.manager.entity.india.IndiaLlpin;
import com.rtc.manager.entity.india.IndiaSignatory;

import java.util.List;

/**
 * @author ChenHang
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IndiaLlpinDTO {
    IndiaLlpinBasicDTO basic;

    List<IndiaChargeDTO> charges;

    List<IndiaSignatoryDTO> signatory;

    public IndiaLlpinBasicDTO getBasic() {
        return basic;
    }

    public void setBasic(IndiaLlpinBasicDTO basic) {
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
