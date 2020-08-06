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
@Data
public class QccVO {
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
}
