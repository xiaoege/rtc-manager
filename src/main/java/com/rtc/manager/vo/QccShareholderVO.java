package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author ChenHang
 */
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
        this.enterpriseId = enterpriseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    public String getSubscribedCapital() {
        return subscribedCapital;
    }

    public void setSubscribedCapital(String subscribedCapital) {
        this.subscribedCapital = subscribedCapital;
    }

    public String getSubscribedCapitalDate() {
        return subscribedCapitalDate;
    }

    public void setSubscribedCapitalDate(String subscribedCapitalDate) {
        this.subscribedCapitalDate = subscribedCapitalDate;
    }
}
