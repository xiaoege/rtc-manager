package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

@Data
public class QccQualificationCertificateVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;

    private String certificateType;

    private String certificateName;

    private String certificateCode;

    private String issueDate;

    private String closingDate;

}