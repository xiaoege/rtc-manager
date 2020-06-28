package com.rtc.manager.vo;

import lombok.Data;

@Data
public class QccQualificationCertificateVO {
    private Integer id;

    private String enterpriseId;

    private String certificateType;

    private String certificateName;

    private String certificateCode;

    private String issueDate;

    private String closingDate;

}