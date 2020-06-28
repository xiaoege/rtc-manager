package com.rtc.manager.vo;

import lombok.Data;

@Data
public class QccTaxCreditVO {
    private Integer id;

    private String enterpriseId;

    private String year;

    private String taxpayerIdentificationNumber;

    private String taxCreditRank;

}