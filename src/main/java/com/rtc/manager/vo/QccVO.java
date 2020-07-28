package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.rtc.manager.entity.QccShareholder;
import lombok.Data;

import java.util.List;

/**
 * @author ChenHang
 */
@Data
public class QccVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;

    private String name;

    private String registeredCapital;

    private String legalRepresentative;

    private String establishmentDate;

    private String address;

    private String telephone;

    private String url;

    private List<QccShareholderVO> shareholderList;

    private String synopsis;

    private String countryRegion;

    private String nation;
}
