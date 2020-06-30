package com.rtc.manager.vo;

import lombok.Data;

@Data
public class QccSaveExceptionVO {
    private Integer id;

    private String enterpriseId;

    private String saveDate;

    private String desicionAuthority;

    private String saveReason;

}