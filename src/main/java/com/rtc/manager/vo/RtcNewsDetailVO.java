package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

/**
 * @author ChenHang
 */
@ApiModel(value = "新闻详情")
public class RtcNewsDetailVO {
    private String newsId;
    @ApiModelProperty(value = "作者")
    private String author;
    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "来源")
    private String source;
    @ApiModelProperty(value = "国家")
    private String country;
    @ApiModelProperty(value = "浏览数，非即时更新")
    private Integer views;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtCreate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtModified;
    @ApiModelProperty(value = "用户所在时区的时间和新闻发布所在时区的时间比较，1小时内显示分钟差，其次显示小时，时间，超过maxDay(当前3天)显示年月日时分秒")
    private String intervalTime;

    @ApiModelProperty(value = "来源url")
    private String sourceUrl;

    @JsonIgnore
    private List<String> content;

    @ApiModelProperty(value = "新闻内容，字段类型：type:[img, title, em, content],em表示在原文中是加粗字体,content表示一段段落内容," +
            "img时额外提供url,width和height(像素)")
    private List<HashMap> resultList;

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(String intervalTime) {
        this.intervalTime = intervalTime;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public List<HashMap> getResultList() {
        return resultList;
    }

    public void setResultList(List<HashMap> resultList) {
        this.resultList = resultList;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }
}
