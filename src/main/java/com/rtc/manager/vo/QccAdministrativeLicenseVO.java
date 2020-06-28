package com.rtc.manager.vo;

import lombok.Data;

@Data
public class QccAdministrativeLicenseVO {
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