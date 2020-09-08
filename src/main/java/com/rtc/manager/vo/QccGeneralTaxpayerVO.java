package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;

public class QccGeneralTaxpayerVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;

    private String name;

    private String code;

    private String qualificationType;

    private String competentTaxAuthority;

    private String validFrom;

    private String validEnd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getQualificationType() {
        return qualificationType;
    }

    public void setQualificationType(String qualificationType) {
        this.qualificationType = qualificationType;
    }

    public String getCompetentTaxAuthority() {
        return competentTaxAuthority;
    }

    public void setCompetentTaxAuthority(String competentTaxAuthority) {
        this.competentTaxAuthority = competentTaxAuthority;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    public String getValidEnd() {
        return validEnd;
    }

    public void setValidEnd(String validEnd) {
        this.validEnd = validEnd;
    }
}