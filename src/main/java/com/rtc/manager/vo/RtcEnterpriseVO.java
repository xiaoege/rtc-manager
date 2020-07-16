package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

import java.util.Date;

/**
 * @author ChenHang
 */
@Data
public class RtcEnterpriseVO {
    @JsonSetter("pid")
    private Integer id;

    private String uuid;

    private String name;

    private String mainProducts;

    private String countryRegion;

    private String totalRevenue;

    private String top3Markets;

    private String trans6mTimes;

    private String trans6mAmount;

    private String url;

    private String qccMatch;

    private String qccSearchString;

}
