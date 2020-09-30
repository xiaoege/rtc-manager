package com.rtc.manager.entity.america.alabama;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaAlabamaDirector {
    private Integer id;

    private String enterpriseId;
    @JsonAlias("Director Name")
    private String directorName;
    @JsonAlias("Director Street Address")
    private String directorStreetAddress;
    @JsonAlias("Director Mailing Address")
    private String directorMailingAddress;

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

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName == null ? null : directorName.trim();
    }

    public String getDirectorStreetAddress() {
        return directorStreetAddress;
    }

    public void setDirectorStreetAddress(String directorStreetAddress) {
        this.directorStreetAddress = directorStreetAddress == null ? null : directorStreetAddress.trim();
    }

    public String getDirectorMailingAddress() {
        return directorMailingAddress;
    }

    public void setDirectorMailingAddress(String directorMailingAddress) {
        this.directorMailingAddress = directorMailingAddress == null ? null : directorMailingAddress.trim();
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