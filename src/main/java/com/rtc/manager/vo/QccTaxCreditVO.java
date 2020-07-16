package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

@Data
public class QccTaxCreditVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;

    private String year;

    private String taxpayerIdentificationNumber;

    private String taxCreditRank;

}