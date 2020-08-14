package com.rtc.manager.vo.india;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

/**
 * @author ChenHang
 */
@Data
public class IndiaChargeVO {
    @JsonSetter("pid")
    private Integer id;
    private String enterpriseId;
    private String srn;
    private String chargeId;
    private String chargeHolderName;
    private String dateOfCreation;
    private String dateOfModification;
    private String dateOfSatisfaction;
    private String amount;
    private String address;
}
