package com.rtc.manager.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author ChenHang
 */
@Data
public class RtcNewsVO {
    private String uuid;

    private String author;

    private String title;

    private String source;

    private String country;

    private Integer sequence;

    private Date gmtCreate;

    private Date gmtModify;

    private Integer status;

}
