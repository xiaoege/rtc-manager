package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

/**
 * @author ChenHang
 */
@Data
public class QccListVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;

    private String name;

    private String registeredCapital;

    private String legalRepresentative;

    private String establishmentDate;

    private String address;

    private String countryRegion;

    private String nation;
}

