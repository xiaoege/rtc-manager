package com.rtc.manager.entity.dto;

import com.rtc.manager.entity.RtcNews;

import java.util.List;

/**
 * @author ChenHang
 */
public class RtcNewsDTO {
    private RtcNews rtcNews;
    private List<RtcNewsDetailDTO> newsDetailList;

    public RtcNews getRtcNews() {
        return rtcNews;
    }

    public void setRtcNews(RtcNews rtcNews) {
        this.rtcNews = rtcNews;
    }

    public List<RtcNewsDetailDTO> getNewsDetailList() {
        return newsDetailList;
    }

    public void setNewsDetailList(List<RtcNewsDetailDTO> newsDetailList) {
        this.newsDetailList = newsDetailList;
    }
}
