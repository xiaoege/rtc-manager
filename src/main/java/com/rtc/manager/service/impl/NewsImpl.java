package com.rtc.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rtc.manager.dao.RtcNewsDetailMapper;
import com.rtc.manager.dao.RtcNewsMapper;
import com.rtc.manager.service.News;
import com.rtc.manager.vo.RtcNewsDetatilVO;
import com.rtc.manager.vo.RtcNewsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ChenHang
 */
@Service
public class NewsImpl implements News {

    @Autowired
    private RtcNewsMapper rtcNewsMapper;

    @Autowired
    private RtcNewsDetailMapper rtcNewsDetailMapper;

    @Override
    public PageInfo<RtcNewsVO> listNews(String startDate, String endDate, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<RtcNewsVO> list = rtcNewsMapper.listNews(startDate, endDate, pageNum, pageSize);
        return new PageInfo<>(list);
    }

    @Override
    public List<RtcNewsDetatilVO> getNews(String newsId) {
        List<RtcNewsDetatilVO> list = rtcNewsDetailMapper.getNewsDetail(newsId);
        return list;
    }
}
