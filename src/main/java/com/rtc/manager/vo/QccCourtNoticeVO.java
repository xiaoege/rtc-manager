package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QccCourtNoticeVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;
    @JsonAlias("案号")
    private String caseCode;
    @JsonAlias("开庭时间")
    private String courtDate;
    @JsonAlias("案由")
    private String reason;
    @JsonAlias("当事人")
    private String litigant;

}