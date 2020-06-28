package com.rtc.manager.vo;

import lombok.Data;

@Data
public class QccJudgmentDocumentVO {
    private Integer id;

    private String enterpriseId;

    private String title;

    private String reason;

    private String releaseDate;

    private String caseCode;

    private String caseStatus;

    private String courtName;

}