package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QccFilingInformationVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;
    @JsonAlias("案号")
    private String code;
    @JsonAlias("公诉人/原告/上诉人/申请人")
    private String prosecutor;
    @JsonAlias("被告人/被告/被上诉人/被申请人")
    private String defendant;
    @JsonAlias("法院名称")
    private String courtName;
    @JsonAlias("立案日期")
    private String filingDate;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProsecutor() {
        return prosecutor;
    }

    public void setProsecutor(String prosecutor) {
        this.prosecutor = prosecutor;
    }

    public String getDefendant() {
        return defendant;
    }

    public void setDefendant(String defendant) {
        this.defendant = defendant;
    }

    public String getCourtName() {
        return courtName;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public String getFilingDate() {
        return filingDate;
    }

    public void setFilingDate(String filingDate) {
        this.filingDate = filingDate;
    }
}