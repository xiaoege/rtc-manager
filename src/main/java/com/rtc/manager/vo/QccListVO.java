package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

/**
 * @author ChenHang
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class QccListVO {
    @JsonSetter("pid")
    private Integer id;

    @JsonSetter(value = "enterprise")
    @JsonAlias("enterprise")
    private String enterpriseId;
    @JsonSetter(value = "name")
    @JsonAlias("name")
    private String name;
    @JsonSetter(value = "registered")
    @JsonAlias("registered")
    private String registeredCapital;
    @JsonSetter(value = "legal")
    @JsonAlias("legal")
    private String legalRepresentative;
    @JsonSetter(value = "establishment")
    @JsonAlias("establishment")
    private String establishmentDate;
    @JsonSetter(value = "address")
    @JsonAlias("address")
    private String address;
    @JsonSetter(value = "country")
    @JsonAlias("country")
    private String countryRegion;
    @JsonSetter(value = "nation")
    @JsonAlias("nation")
    private String nation;
}

