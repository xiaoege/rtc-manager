package com.rtc.manager.vo;

import lombok.Data;

import java.util.Date;

@Data
public class QccWechatVO {
    private Integer id;

    private String enterpriseId;

    private String name;

    private String account;

    private String briefIntroduction;

    private Date gmtCreate;

    private Date gmtModify;

    private Integer status;

}