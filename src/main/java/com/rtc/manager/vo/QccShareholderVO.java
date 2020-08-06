package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ChenHang
 */
@Data
@ApiModel("股东")
public class QccShareholderVO {
    @JsonSetter("pid")
    private Integer id;
    @ApiModelProperty("企业id")
    private String enterpriseId;
    @ApiModelProperty("股东及出资信息")
    private String name;
    @ApiModelProperty("持股比例")
    private String ratio;
    @ApiModelProperty("认缴出资额")
    private String subscribedCapital;
    @ApiModelProperty("认缴出资日期")
    private String subscribedCapitalDate;

}
