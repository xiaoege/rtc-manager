package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rtc.manager.entity.vietnam.VietnamBusinessActivities;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class VietnamJsonDTO {
    private Integer id;

    private String enterpriseId;
    @JsonAlias("Enterprise name")
    private String enterpriseName;
    @JsonAlias("Enterprise name in foreign language")
    private String enterpriseNameInForeignLanguage;
    @JsonAlias("Enterprise short name")
    private String enterpriseShortName;
    @JsonAlias("Enterpirse_status")
    private String enterpirseStatus;
    @JsonAlias("Enterprise code")
    private String enterpriseCode;
    @JsonAlias("Legal type")
    private String legalType;
    @JsonAlias("Founding date")
    private String foundingDate;
    @JsonAlias("Representative first name")
    private String representativeFirstName;
    @JsonAlias("Head office address")
    private String headOfficeAddress;
    @JsonAlias("business activities")
    private List<VietnamBusinessActivities> vietnamBusinessActivitiesList;

}