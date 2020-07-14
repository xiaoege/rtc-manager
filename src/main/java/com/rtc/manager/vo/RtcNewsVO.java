package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    private String description;

    private String preview;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtModify;

}
