package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

/**
 * @author ChenHang
 */
@ApiModel(value = "新闻列表")
public class RtcNewsVO {
    private String uuid;
    @ApiModelProperty(value = "作者")
    private String author;
    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "来源")
    private String source;
    @ApiModelProperty(value = "国家")
    private String country;
    @JsonIgnore
    private Integer sequence;
    @ApiModelProperty(value = "描述")
    private String description;
    @ApiModelProperty(value = "预览图")
    private String preview;
    @ApiModelProperty(value = "预览图的宽(像素)")
    private Integer weight;
    @ApiModelProperty(value = "预览图的高(像素)")
    private Integer height;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtModified;

    @ApiModelProperty(value = "用户所在时区的时间和新闻发布所在时区的时间比较，1小时内显示分钟差，其次显示小时，时间，超过maxDay(当前3天)显示年月日时分秒")
    private String intervalTime;

    @ApiModelProperty(value = "浏览数，非即时更新")
    private Integer views;

    @ApiModelProperty(value = "来源url")
    private String sourceUrl;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
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

    public Integer getViews() {
        return views;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public void setViews(Integer views) {
        this.views = views;
    }
}
