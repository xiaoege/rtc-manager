package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

@Data
public class QccLandPurchaseInformationVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;

    private String location;

    private String purpose;

    private String area;

    private String administrativeRegion;

    private String landSupplyMode;

    private String contractSigningDate;

}