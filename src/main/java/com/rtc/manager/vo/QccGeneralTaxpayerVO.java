package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

@Data
public class QccGeneralTaxpayerVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;

    private String name;

    private String code;

    private String qualificationType;

    private String competentTaxAuthority;

    private String validFrom;

    private String validEnd;

}