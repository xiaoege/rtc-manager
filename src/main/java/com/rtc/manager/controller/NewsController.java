package com.rtc.manager.controller;

import com.github.pagehelper.PageInfo;
import com.rtc.manager.service.News;
import com.rtc.manager.vo.ResultData;
import com.rtc.manager.vo.RtcNewsDetatilVO;
import com.rtc.manager.vo.RtcNewsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 新闻模块
 *
 * @author ChenHang
 */
@RestController
@RequestMapping("news")
public class NewsController {

    @Autowired
    private News news;

    @GetMapping("listNews")
    public ResultData listNews(@RequestParam(name = "startDate", required = false) String startDate,
                               @RequestParam(name = "endDate", required = false) String endDate,
                               @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                               @RequestParam(name = "pageSize", required = false, defaultValue = "5") int pageSize){
        PageInfo<RtcNewsVO> resultData = news.listNews(startDate, endDate, pageNum, pageSize);


        return ResultData.SUCCESS(resultData);
    }

    @GetMapping("getNews")
    public ResultData getNews(@RequestParam(name = "newsId") String newsId) {
        List<RtcNewsDetatilVO> resultData = news.getNews(newsId);

        return ResultData.SUCCESS(resultData);
    }


}
