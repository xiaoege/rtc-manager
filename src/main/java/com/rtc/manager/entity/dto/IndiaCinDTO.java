package com.rtc.manager.entity.dto;

import com.rtc.manager.entity.india.IndiaCharge;
import com.rtc.manager.entity.india.IndiaCin;
import com.rtc.manager.entity.india.IndiaSignatory;

import java.util.List;

/**
 * @author ChenHang
 */
public class IndiaCinDTO {
    IndiaCin basic;

    List<IndiaCharge> charges;

    List<IndiaSignatory> signatory;

    public IndiaCin getBasic() {
        return basic;
    }

    public void setBasic(IndiaCin basic) {
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
