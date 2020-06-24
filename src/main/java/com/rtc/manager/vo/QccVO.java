package com.rtc.manager.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author ChenHang
 */
@Data
public class QccVO {
    private Integer id;

    private String enterpriseId;

    private String name;

    private String telephone;

    private String url;

    private String email;

    private String address;

    private String countryRegion;

    private Date gmtCreate;

    private Date gmtModify;

    private Integer status;


}

