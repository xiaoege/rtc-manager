package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

@Data
public class QccWeiboVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;

    private String nickname;

    private String industryCategory;

    private String briefIntroduction;

}