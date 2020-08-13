package com.rtc.manager.entity.dto;

import com.rtc.manager.entity.india.IndiaCharge;
import com.rtc.manager.entity.india.IndiaLlpin;
import com.rtc.manager.entity.india.IndiaSignatory;
import lombok.Data;

import java.util.List;

/**
 * @author ChenHang
 */
@Data
public class IndiaLlpinDTO {
    IndiaLlpin basic;

    List<IndiaCharge> charges;

    List<IndiaSignatory> signatory;

}
