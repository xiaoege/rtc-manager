package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

@Data
public class QccAdministrativeLicenseVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;

    private String decisionDocumentNo;

    private String licenseAuthority;

    private String licenseDate;

    private String content;

    private String validFrom;

    private String validUntil;

    private String decisionDocumentName;

}