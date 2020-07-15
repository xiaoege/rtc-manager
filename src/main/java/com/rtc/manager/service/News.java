package com.rtc.manager.service;

import com.github.pagehelper.PageInfo;
import com.rtc.manager.vo.RtcNewsDetatilVO;
import com.rtc.manager.vo.RtcNewsVO;

/**
 * @author ChenHang
 */
public interface News {
    PageInfo<RtcNewsVO> listNews(String startDate, String endDate, int pageNum, int pageSize, Integer sequence) throws Exception;

    RtcNewsDetatilVO getNews(String newsId) throws Exception;
}
