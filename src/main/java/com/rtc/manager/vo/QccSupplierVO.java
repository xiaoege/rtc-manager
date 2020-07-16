package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

@Data
public class QccSupplierVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;

    private String name;

    private String proportionOfProcurement;

    private String purchaseAmount;

    private String reportPeriod;

    private String source;

    private String relationship;

}