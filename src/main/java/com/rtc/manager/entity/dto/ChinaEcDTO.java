package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChinaEcDTO {
    private String enterpriseId;

    private String name;

    private String location;
    @JsonAlias("business type")
    private String businessType;
    @JsonAlias("year established")
    private String establishedYear;
    @JsonAlias("employees total")
    private String employeesTotal;
    @JsonAlias("annual revenue")
    private String annualRevenue;
    
    private String website;
    
    private String address;
    @JsonAlias("country/region")
    private String countryRegion;
    
    private String phone;
    
    private String fax;
    
    private String contact;
    @JsonAlias("membership class")
    private String membershipClass;
    @JsonAlias("membership year")
    private String membershipYear;
    @JsonAlias("last online")
    private String lastOnline;
    @JsonAlias("ec21 registered date")
    private String ecRegisteredDate;
    
    private String authentication;
    
    private String description;
    @JsonAlias("selling categories")
    private String[] sellingCategory;
    @JsonAlias("buying categories")
    private String[] buyingCategory;
    @JsonAlias("keyword")
    private String[] keyword;

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
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getEstablishedYear() {
        return establishedYear;
    }

    public void setEstablishedYear(String establishedYear) {
        this.establishedYear = establishedYear;
    }

    public String getEmployeesTotal() {
        return employeesTotal;
    }

    public void setEmployeesTotal(String employeesTotal) {
        this.employeesTotal = employeesTotal;
    }

    public String getAnnualRevenue() {
        return annualRevenue;
    }

    public void setAnnualRevenue(String annualRevenue) {
        this.annualRevenue = annualRevenue;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMembershipClass() {
        return membershipClass;
    }

    public void setMembershipClass(String membershipClass) {
        this.membershipClass = membershipClass;
    }

    public String getMembershipYear() {
        return membershipYear;
    }

    public void setMembershipYear(String membershipYear) {
        this.membershipYear = membershipYear;
    }

    public String getLastOnline() {
        return lastOnline;
    }

    public void setLastOnline(String lastOnline) {
        this.lastOnline = lastOnline;
    }

    public String getEcRegisteredDate() {
        return ecRegisteredDate;
    }

    public void setEcRegisteredDate(String ecRegisteredDate) {
        this.ecRegisteredDate = ecRegisteredDate;
    }

    public String getAuthentication() {
        return authentication;
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getSellingCategory() {
        return sellingCategory;
    }

    public void setSellingCategory(String[] sellingCategory) {
        this.sellingCategory = sellingCategory;
    }

    public String[] getBuyingCategory() {
        return buyingCategory;
    }

    public void setBuyingCategory(String[] buyingCategory) {
        this.buyingCategory = buyingCategory;
    }

    public String[] getKeyword() {
        return keyword;
    }

    public void setKeyword(String[] keyword) {
        this.keyword = keyword;
    }
}