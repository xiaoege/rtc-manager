package com.rtc.manager.vo;

import lombok.Data;

import java.util.Date;

@Data
public class QccAdministrativeSanctionVO {
    private Integer id;

    private String enterpriseId;

    private Integer determineDocumentNumber;

    private String violationsType;

    private String content;

    private Date publicationDate;

    private String decisionMakingOrgan;

    private Date decisionDate;

}