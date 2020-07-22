package com.rtc.manager.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QccBidding {
    private Integer id;

    private String enterpriseId;

    @JsonAlias("项目名称")
    private String name;
    @JsonAlias("发布日期")
    private String releaseDate;
    @JsonAlias("省份地区")
    private String province;
    @JsonAlias("招标进度")
    private String progress;

    private Date gmtCreate;

    private Date gmtModify;

    private Integer status;

    @JsonAlias("公告类型")
    private String announcementType;
}