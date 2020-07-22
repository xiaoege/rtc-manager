package com.rtc.manager.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QccAdministrativeSanction {
    private Integer id;

    private String enterpriseId;

    @JsonAlias("决定文书号")
    private String determineDocumentNumber;

    @JsonAlias({"违法行为类型", "处罚事由/违法行为类型"})
    private String violationsType;

    @JsonAlias({"行政处罚内容", "处罚结果/内容"})
    private String content;

    @JsonAlias("公示日期")
    private String publicationDate;

    @JsonAlias("决定机关")
    private String decisionMakingOrgan;

    @JsonAlias("决定日期")
    private String decisionDate;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModify;

    private Integer status;

    @JsonAlias("处罚单位")
    private String punishmentUnit;

    @JsonAlias("数据来源")
    private String source;

    @JsonAlias("处罚日期")
    private String punishmentDate;

}