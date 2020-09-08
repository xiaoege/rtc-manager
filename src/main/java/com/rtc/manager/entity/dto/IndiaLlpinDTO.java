package com.rtc.manager.entity.dto;

import com.rtc.manager.entity.india.IndiaCharge;
import com.rtc.manager.entity.india.IndiaLlpin;
import com.rtc.manager.entity.india.IndiaSignatory;

import java.util.List;

/**
 * @author ChenHang
 */
public class IndiaLlpinDTO {
    IndiaLlpin basic;

    List<IndiaCharge> charges;

    List<IndiaSignatory> signatory;

    public IndiaLlpin getBasic() {
        return basic;
    }

    public void setBasic(IndiaLlpin basic) {
        this.basic = basic;
    }

    public List<IndiaCharge> getCharges() {
        return charges;
    }

    public void setCharges(List<IndiaCharge> charges) {
        this.charges = charges;
    }

    public List<IndiaSignatory> getSignatory() {
        return signatory;
    }

    public void setSignatory(List<IndiaSignatory> signatory) {
        this.signatory = signatory;
    }
}
