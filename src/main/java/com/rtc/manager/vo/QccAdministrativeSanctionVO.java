package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

@Data
public class QccAdministrativeSanctionVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;

    private String determineDocumentNumber;

    private String violationsType;

    private String content;

    private String publicationDate;

    private String decisionMakingOrgan;

    private String decisionDate;

}