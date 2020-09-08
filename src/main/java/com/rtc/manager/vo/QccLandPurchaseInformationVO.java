package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;

public class QccLandPurchaseInformationVO {
    private Integer id;

    private String enterpriseId;

    private String location;

    private String purpose;

    private String area;

    private String administrativeRegion;

    private String landSupplyMode;

    private String contractSigningDate;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAdministrativeRegion() {
        return administrativeRegion;
    }

    public void setAdministrativeRegion(String administrativeRegion) {
        this.administrativeRegion = administrativeRegion;
    }

    public String getLandSupplyMode() {
        return landSupplyMode;
    }

    public void setLandSupplyMode(String landSupplyMode) {
        this.landSupplyMode = landSupplyMode;
    }

    public String getContractSigningDate() {
        return contractSigningDate;
    }

    public void setContractSigningDate(String contractSigningDate) {
        this.contractSigningDate = contractSigningDate;
    }
}