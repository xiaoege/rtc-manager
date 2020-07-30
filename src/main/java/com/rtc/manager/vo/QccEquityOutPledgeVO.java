package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QccEquityOutPledgeVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;
    @JsonAlias("登记编号")
    private String code;
    @JsonAlias("出质人")
    private String pledgor;
    @JsonAlias("质权人")
    private String pledgee;
    @JsonAlias("出质股权标的企业")
    private String enterprise;
    @JsonAlias("出质股权数额(万元)")
    private String amount;
    @JsonAlias("登记日期")
    private String registrationDate;
    @JsonAlias("状态")
    private String pledgeStatus;

}