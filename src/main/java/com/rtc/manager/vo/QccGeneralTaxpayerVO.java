package com.rtc.manager.vo;

import lombok.Data;

@Data
public class QccGeneralTaxpayerVO {
    private Integer id;

    private String enterpriseId;

    private String name;

    private String code;

    private String qualificationType;

    private String competentTaxAuthority;

    private String validFrom;

    private String validEnd;

}