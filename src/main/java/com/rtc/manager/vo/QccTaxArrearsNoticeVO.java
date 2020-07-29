package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QccTaxArrearsNoticeVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;
    @JsonAlias("欠税税种")
    private String type;
    @JsonAlias("欠税余额（元）")
    private String balance;
    @JsonAlias("当前新发生的欠税金额（元）")
    private String currentArrears;
    @JsonAlias("发布单位")
    private String releaseCompany;
    @JsonAlias("发布日期")
    private String releaseDate;

}