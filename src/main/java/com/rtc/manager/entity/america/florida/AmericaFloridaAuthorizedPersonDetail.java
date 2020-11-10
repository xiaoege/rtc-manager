package com.rtc.manager.entity.america.florida;

import java.time.LocalDateTime;

public class AmericaFloridaAuthorizedPersonDetail {
    private Integer id;

    private String enterpriseId;

    private String title;

    private String name;

    private String detailAddress;

    private String streetAddress;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private Integer status;

    public AmericaFloridaAuthorizedPersonDetail() {
    }

    public AmericaFloridaAuthorizedPersonDetail(String enterpriseId, String title, String name, String detailAddress, String streetAddress) {
        this.enterpriseId = enterpriseId;
        this.title = title;
        this.name = name;
        this.detailAddress = detailAddress;
        this.streetAddress = streetAddress;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress == null ? null : detailAddress.trim();
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress == null ? null : streetAddress.trim();
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

    @Override
    public String toString() {
        return "AmericaFloridaAuthorizedPersonDetail{" +
                "id=" + id +
                ", enterpriseId='" + enterpriseId + '\'' +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", detailAddress='" + detailAddress + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", status=" + status +
                '}';
    }
}