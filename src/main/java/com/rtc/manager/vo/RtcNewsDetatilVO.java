package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author ChenHang
 */
@Data
public class RtcNewsDetatilVO {
    private String newsId;

    private String author;

    private String title;

    private String source;

    private String country;

    private Integer views;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtCreate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtModify;

    private String intervalTime;

    private List<String> content;

    private List<HashMap> resultList;

}
