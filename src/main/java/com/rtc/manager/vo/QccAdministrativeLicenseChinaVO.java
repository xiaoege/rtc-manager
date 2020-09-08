package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QccAdministrativeLicenseChinaVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;
    @JsonAlias("决定文书号")
    private String code;
    @JsonAlias("许可机关")
    private String authority;
    @JsonAlias("决定日期")
    private String decidedDate;

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

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getDecidedDate() {
        return decidedDate;
    }

    public void setDecidedDate(String decidedDate) {
        this.decidedDate = decidedDate;
    }
}