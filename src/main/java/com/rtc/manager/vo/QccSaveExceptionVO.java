package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

@Data
public class QccSaveExceptionVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;

    private String saveDate;

    private String desicionAuthority;

    private String saveReason;

}