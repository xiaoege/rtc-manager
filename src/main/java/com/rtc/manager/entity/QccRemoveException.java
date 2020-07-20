package com.rtc.manager.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QccRemoveException {
    private Integer id;

    private String enterpriseId;

    @JsonAlias("列入经营异常名录原因")
    private String saveReason;

    @JsonAlias("作出决定机关")
    private String desicionAuthority;

    @JsonAlias("移出日期")
    private String removeDate;

    @JsonAlias("移出经营异常名录原因")
    private String removeReason;

    @JsonAlias("列入日期")
    private String saveDate;

    private Date gmtCreate;

    private Date gmtModify;

    private Integer status;

}