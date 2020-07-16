package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

@Data
public class QccFinancingConsultationVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;

    private String date;

    private String name;

    private String financingRound;

    private String amount;

    private String investor;

    private String source;

}