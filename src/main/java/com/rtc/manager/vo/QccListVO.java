package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ChenHang
 */
@ApiModel("搜索企业-列表")
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class QccListVO {
    @JsonSetter("pid")
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
    @ApiModelProperty("省份")
    private String countryRegion;
    @ApiModelProperty("国家")
    private String nation;

}

