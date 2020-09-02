package com.rtc.manager.vo.vietnam;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

import java.util.List;

@Data
public class VietnamEnterpriseVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;
    @JsonSetter("e_name")
    private String enterpriseName;

    private String enterpriseNameInForeignLanguage;

    private String enterpriseShortName;

    private String enterpirseStatus;

    private String enterpriseCode;

    private String legalType;
    @JsonSetter("establishmentDate")
    private String foundingDate;

    private String representativeFirstName;
    @JsonSetter("address")
    private String headOfficeAddress;

    private List<VietnamBusinessActivitiesVO> vsciList;
}