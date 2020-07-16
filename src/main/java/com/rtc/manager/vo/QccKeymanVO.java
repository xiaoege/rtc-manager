package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

@Data
public class QccKeymanVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;

    private String name;

    private String duty;

    private String shareholdingRatio;

    private String ultimateBeneficialShares;

}