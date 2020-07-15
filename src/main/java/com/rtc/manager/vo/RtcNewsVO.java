package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

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

    private Integer weight;

    private Integer height;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtCreate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtModify;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String intervalTime;

    private Integer views;
}
