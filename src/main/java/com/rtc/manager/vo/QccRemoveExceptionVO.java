package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

@Data
public class QccRemoveExceptionVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;

    private String saveReason;

    private String desicionAuthority;

    private String removeDate;

    private String removeReason;

}