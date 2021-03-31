package com.rtc.manager.entity.dto;

import com.rtc.manager.entity.QccBusinessInformation;
import com.rtc.manager.entity.QccShareholder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChenHang
 */
public class QccDTO {

    private String enterpriseId;

    private String rtcEnterpriseUuid;

    private String name;

    private String telephone;

    private String url;

    private String email;

    private String address;

    private String countryRegion;

    private String synopsis;

    private String nation;

    private QccBusinessInformation businessInformation;

    private List<QccShareholder> shareholderList;

    public QccDTO() {
        this.businessInformation = new QccBusinessInformation();
        this.shareholderList = new ArrayList<>();
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getRtcEnterpriseUuid() {
        return rtcEnterpriseUuid;
    }

    public void setRtcEnterpriseUuid(String rtcEnterpriseUuid) {
        this.rtcEnterpriseUuid = rtcEnterpriseUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public QccBusinessInformation getBusinessInformation() {
        return businessInformation;
    }

    public void setBusinessInformation(QccBusinessInformation businessInformation) {
        this.businessInformation = businessInformation;
    }

    public List<QccShareholder> getShareholderList() {
        return shareholderList;
    }

    public void setShareholderList(List<QccShareholder> shareholderList) {
        this.shareholderList = shareholderList;
    }
}
