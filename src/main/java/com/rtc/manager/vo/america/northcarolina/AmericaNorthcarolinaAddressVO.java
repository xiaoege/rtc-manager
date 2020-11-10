package com.rtc.manager.vo.america.northcarolina;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaNorthcarolinaAddressVO {
    private Integer id;
    private String enterpriseId;
    private String mailing;
    private String principalOffice;
    private String regOffice;
    private String regMailing;

    public Integer getId() {
        return id;
    }

    @JsonSetter("pid")
    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getMailing() {
        return mailing;
    }

    public void setMailing(String mailing) {
        this.mailing = mailing;
    }

    public String getPrincipalOffice() {
        return principalOffice;
    }

    public void setPrincipalOffice(String principalOffice) {
        this.principalOffice = principalOffice;
    }

    public String getRegOffice() {
        return regOffice;
    }

    public void setRegOffice(String regOffice) {
        this.regOffice = regOffice;
    }

    public String getRegMailing() {
        return regMailing;
    }

    public void setRegMailing(String regMailing) {
        this.regMailing = regMailing;
    }
}