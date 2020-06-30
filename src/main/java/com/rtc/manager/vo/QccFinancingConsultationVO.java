package com.rtc.manager.vo;

import lombok.Data;

@Data
public class QccFinancingConsultationVO {
    private Integer id;

    private String enterpriseId;

    private String date;

    private String name;

    private String financingRound;

    private String amount;

    private String investor;

    private String source;

}