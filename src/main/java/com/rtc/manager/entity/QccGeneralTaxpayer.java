package com.rtc.manager.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QccGeneralTaxpayer {
    private Integer id;

    private String enterpriseId;

    @JsonAlias("纳税人名称")
    private String name;

    @JsonAlias("纳税人识别号")
    private String code;

    @JsonAlias("纳税人资格类型")
    private String qualificationType;

    @JsonAlias("主管税务机关")
    private String competentTaxAuthority;

    @JsonAlias("有效期起")
    private String validFrom;

    @JsonAlias("有效期止")
    private String validEnd;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer status;

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
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getQualificationType() {
        return qualificationType;
    }

    public void setQualificationType(String qualificationType) {
        this.qualificationType = qualificationType == null ? null : qualificationType.trim();
    }

    public String getCompetentTaxAuthority() {
        return competentTaxAuthority;
    }

    public void setCompetentTaxAuthority(String competentTaxAuthority) {
        this.competentTaxAuthority = competentTaxAuthority == null ? null : competentTaxAuthority.trim();
    }

    public String getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom == null ? null : validFrom.trim();
    }

    public String getValidEnd() {
        return validEnd;
    }

    public void setValidEnd(String validEnd) {
        this.validEnd = validEnd == null ? null : validEnd.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}