package com.rtc.manager.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author ChenHang
 */
@Data
public class RtcNewsDetatilVO {
    private String uuid;

    private String author;

    private String title;

    private String source;

    private String country;

    private Integer sequence;

    private Date gmtCreate;

    private Date gmtModify;

    private Integer status;

    private List<String> content;

}
