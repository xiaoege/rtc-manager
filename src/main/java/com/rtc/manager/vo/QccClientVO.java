package com.rtc.manager.vo;

import lombok.Data;

@Data
public class QccClientVO {
    private Integer id;

    private String enterpriseId;
    private String name;
    private String saleProportion;
    private String saleAmount;
    private String reportDate;
    private String source;
    private String relationship;

}