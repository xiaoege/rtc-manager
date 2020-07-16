package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

@Data
public class QccAppVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;

    private String name;

    private String sort;

    private String currentVersion;

    private String briefIntroduction;

}