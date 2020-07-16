package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

@Data
public class QccJudgmentDocumentVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;

    private String title;

    private String reason;

    private String releaseDate;

    private String caseCode;

    private String caseStatus;

    private String courtName;

}