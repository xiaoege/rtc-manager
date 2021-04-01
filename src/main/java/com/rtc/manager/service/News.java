package com.rtc.manager.service;

import com.github.pagehelper.PageInfo;
import com.rtc.manager.vo.RtcNewsDetailVO;
import com.rtc.manager.vo.RtcNewsVO;

/**
 * @author ChenHang
 */
public interface News {
    /**
     * 查询新闻列表
     *
     * @param startDate 按创建日期查询新闻-起始日期，参数类型：yyyy-MM-dd 或 yyyy-MM-dd HH:mm:ss
     * @param endDate   按创建日期查询新闻-结束日期，参数类型：yyyy-MM-dd 或 yyyy-MM-dd HH:mm:ss
     * @param pageNum   当前页数
     * @param pageSize  当前页面展示数量
     * @param timeZone  时区，参数示例：8或者-8, 范围: -18 to 18 的整数
     * @return PageInfo<RtcNewsVO>
     */
    PageInfo<RtcNewsVO> listNews(String startDate, String endDate, int pageNum, int pageSize, String timeZone) throws Exception;

    /**
     * 查询新闻详情
     *
     * @param newsId   新闻id
     * @param timeZone 时区，参数示例：8或者-8, 范围: -18 to 18 的整数
     * @return RtcNewsDetailVO
     * @throws Exception
     */
    RtcNewsDetailVO getNews(String newsId, String timeZone) throws Exception;
}
