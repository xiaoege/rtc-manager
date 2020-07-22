package com.rtc.manager.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QccJudgmentDocument {
    private Integer id;

    private String enterpriseId;

    @JsonAlias({"裁判文书标题", "文书标题"})
    private String title;

    @JsonAlias("案由")
    private String reason;

    @JsonAlias("发布日期")
    private String releaseDate;

    @JsonAlias("案号")
    private String caseCode;

    @JsonAlias("案件身份")
    private String caseStatus;

    @JsonAlias("法院名称")
    private String courtName;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModify;

    private Integer status;

    @JsonAlias("当事人")
    private String litigant;

    @JsonAlias("案件金额（元）")
    private String amount;

    @JsonAlias("裁判结果")
    private String result;

    @JsonAlias("裁判日期")
    private String judgmentDate;
}