package com.rtc.manager.vo.india;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author ChenHang
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IndiaLlpinLIstVO {
    private String e_type;

    @JsonAlias("enterprise_id")
    private String enterpriseId;
    @JsonAlias("llpin")
    private String llpin;
    @JsonAlias("llp_name")
    private String companyName;
    @JsonAlias("roc_code")
    private String rocCode;

    public String getE_type() {
        return e_type;
    }

    public void setE_type(String e_type) {
        this.e_type = e_type;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getLlpin() {
        return llpin;
    }

    public void setLlpin(String llpin) {
        this.llpin = llpin;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRocCode() {
        return rocCode;
    }

    public void setRocCode(String rocCode) {
        this.rocCode = rocCode;
    }
}
