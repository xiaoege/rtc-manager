package com.rtc.manager.service;

import com.github.pagehelper.PageInfo;
import com.rtc.manager.vo.RtcNewsDetatilVO;
import com.rtc.manager.vo.RtcNewsVO;

import java.util.List;

/**
 * @author ChenHang
 */
public interface News {
    PageInfo<RtcNewsVO> listNews(String startDate, String endDate, int pageNum, int pageSize);

    List<RtcNewsDetatilVO> getNews(String newsId);
}
