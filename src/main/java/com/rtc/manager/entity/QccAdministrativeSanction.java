package com.rtc.manager.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

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

    private Date gmtCreate;

    private Date gmtModify;

    private Integer status;

}