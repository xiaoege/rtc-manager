package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.rtc.manager.entity.QccShareholder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author ChenHang
 */
@ApiModel("企业详情")
public class QccVO {

    private Integer id;
    @ApiModelProperty("企业id")
    private String enterpriseId;
    @ApiModelProperty("企业名")
    private String name;
    @ApiModelProperty("注册资本")
    private String registeredCapital;
    @ApiModelProperty("法定代表人")
    private String legalRepresentative;
    @ApiModelProperty("成立日期")
    private String establishmentDate;
    @ApiModelProperty("地址")
    private String address;
    @ApiModelProperty("电话")
    private String telephone;
    @ApiModelProperty("官网")
    private String url;
    @ApiModelProperty("股东列表")
    private List<QccShareholderVO> shareholderList;
    @ApiModelProperty("简介")
    private String synopsis;
    @ApiModelProperty("省份")
    private String countryRegion;
    @ApiModelProperty("国家")
    private String nation;
    private int favourite;

    private String logo;

    private String logoName;

    private String logoColor;

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

    public String getName() {
        return name;
    }
    @JsonSetter("e_name")
    public void setName(String name) {
        this.name = name;
    }

    public String getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(String establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<QccShareholderVO> getShareholderList() {
        return shareholderList;
    }

    public void setShareholderList(List<QccShareholderVO> shareholderList) {
        this.shareholderList = shareholderList;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public int getFavourite() {
        return favourite;
    }

    public void setFavourite(int favourite) {
        this.favourite = favourite;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLogoName() {
        return logoName;
    }

    public void setLogoName(String logoName) {
        this.logoName = logoName;
    }

    public String getLogoColor() {
        return logoColor;
    }

    public void setLogoColor(String logoColor) {
        this.logoColor = logoColor;
    }
}
