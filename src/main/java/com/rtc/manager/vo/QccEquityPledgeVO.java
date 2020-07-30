package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QccEquityPledgeVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;
    @JsonAlias("股东名称")
    private String name;
    @JsonAlias("质押股份总数（股）")
    private String shares;
    @JsonAlias("质押股份市值（元）")
    private String value;
    @JsonAlias("状态")
    private String pledgeStatus;
    @JsonAlias("公告日期")
    private String announcementDate;


}