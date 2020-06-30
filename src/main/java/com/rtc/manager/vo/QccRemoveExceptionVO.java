package com.rtc.manager.vo;

import lombok.Data;

@Data
public class QccRemoveExceptionVO {
    private Integer id;

    private String enterpriseId;

    private String saveReason;

    private String desicionAuthority;

    private String removeDate;

    private String removeReason;

}