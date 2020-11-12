package com.rtc.manager.entity.america.oregon;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaOregonAssociate {
    private Integer id;

    private String enterpriseId;
    @JsonAlias("CSZ")
    private String csz;
    @JsonAlias("Country")
    private String country;
    @JsonAlias("Addr 1")
    private String addrFirst;
    @JsonAlias("Addr 2")
    private String addrSecond;
    @JsonAlias("Type")
    private String type;
    @JsonAlias("City, State")
    private String cityState;
    @JsonAlias("Zipcode")
    private String zipcode;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

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
        this.enterpriseId = enterpriseId == null ? null : enterpriseId.trim();
    }

    public String getCsz() {
        return csz;
    }

    public void setCsz(String csz) {
        this.csz = csz == null ? null : csz.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getAddrFirst() {
        return addrFirst;
    }

    public void setAddrFirst(String addrFirst) {
        this.addrFirst = addrFirst == null ? null : addrFirst.trim();
    }

    public String getAddrSecond() {
        return addrSecond;
    }

    public void setAddrSecond(String addrSecond) {
        this.addrSecond = addrSecond == null ? null : addrSecond.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getCityState() {
        return cityState;
    }

    public void setCityState(String cityState) {
        this.cityState = cityState == null ? null : cityState.trim();
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode == null ? null : zipcode.trim();
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}