package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

@Data
public class QccImportExportCreditVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;

    private String registeredCustoms;

    private String businessCategory;

    private String registrationDate;

    private String content;

}