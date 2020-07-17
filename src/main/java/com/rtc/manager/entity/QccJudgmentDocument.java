package com.rtc.manager.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QccJudgmentDocument {
    private Integer id;

    private String enterpriseId;

    @JsonAlias({"裁判文书标题","文书标题"})
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

    private Date gmtCreate;

    private Date gmtModify;

    private Integer status;

}