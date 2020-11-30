package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

/**
 * @author ChenHang
 */
public class AmericaMississippiBusinessInformationDTO {
    @JsonAlias("Business Type")
    private String businessType;
    @JsonAlias("Business ID")
    private String businessId;
    @JsonAlias("Status")
    private String enterpriseStatus;
    @JsonAlias("Effective Date")
    private String effectiveDate;
    @JsonAlias("State of Incorporation")
    private String stateOfIncorporation;
    @JsonAlias("Principal Office Address")
    private String principalOfficeAddress;

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getStateOfIncorporation() {
        return stateOfIncorporation;
    }

    public void setStateOfIncorporation(String stateOfIncorporation) {
        this.stateOfIncorporation = stateOfIncorporation;
    }

    public String getPrincipalOfficeAddress() {
        return principalOfficeAddress;
    }

    public void setPrincipalOfficeAddress(String principalOfficeAddress) {
        this.principalOfficeAddress = principalOfficeAddress;
    }
}
