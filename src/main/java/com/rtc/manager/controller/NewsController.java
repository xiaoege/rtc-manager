package com.rtc.manager.controller;

import com.github.pagehelper.PageInfo;
import com.rtc.manager.config.SwaggerConfig;
import com.rtc.manager.service.News;
import com.rtc.manager.vo.ResultData;
import com.rtc.manager.vo.RtcNewsDetailVO;
import com.rtc.manager.vo.RtcNewsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 新闻模块
 *
 * @author ChenHang
 */
@Api(tags = "新闻接口")
@RestController
@RequestMapping("news")
public class NewsController {

    @Autowired
    private News news;

    /**
     * 查询新闻列表
     *
     * @param startDate 按创建日期查询新闻-起始日期，参数类型：yyyy-MM-dd 或 yyyy-MM-dd HH:mm:ss
     * @param endDate   按创建日期查询新闻-结束日期，参数类型：yyyy-MM-dd 或 yyyy-MM-dd HH:mm:ss
     * @param pageNum   当前页数
     * @param pageSize  当前页面展示数量
     * @param timeZone  时区，参数示例：8或者-8, 范围: -18 to 18 的整数
     * @return ResultData<PageInfo<RtcNewsVO>>
     */
    @GetMapping("listNews")
    @ApiOperation("查询新闻列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer xxxxx", paramType = "header", required = true, example = SwaggerConfig.BEARER_TOKEN),
            @ApiImplicitParam(name = "startDate", value = "按创建日期查询新闻-起始日期，参数类型：yyyy-MM-dd 或 yyyy-MM-dd HH:mm:ss", required = false),
            @ApiImplicitParam(name = "endDate", value = "按创建日期查询新闻-结束日期，参数类型：yyyy-MM-dd 或 yyyy-MM-dd HH:mm:ss", required = false),
            @ApiImplicitParam(name = "pageNum", value = "当前页数，此接口的pageNum从1开始", required = false, defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "当前页大小", required = false, defaultValue = "10"),
            @ApiImplicitParam(name = "timeZone", value = "时区，参数示例：8或者-8, 范围: -18 to 18 的整数", required = false)
    })
    public ResultData<PageInfo<RtcNewsVO>> listNews(@RequestParam(name = "startDate", required = false) String startDate,
                                                    @RequestParam(name = "endDate", required = false) String endDate,
                                                    @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                                    @RequestParam(name = "pageSize", required = false, defaultValue = "5") int pageSize,
                                                    @RequestParam(name = "timeZone", required = false, defaultValue = "+0") String timeZone) throws Exception {
        PageInfo<RtcNewsVO> resultData = news.listNews(startDate, endDate, pageNum, pageSize, timeZone);


        return ResultData.SUCCESS(resultData);
    }

    /**
     * 查询新闻详情
     *
     * @param newsId   新闻id
     * @param timeZone 时区，参数示例：8或者-8, 范围: -18 to 18 的整数
     * @return ResultData<RtcNewsDetatilVO>
     * @throws Exception
     */
    @GetMapping("getNews")
    @ApiOperation(value = "查询新闻详情", notes = "所有新闻详情页必须著名来源，来源链接，原作者，原标题")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer xxxxx", paramType = "header", required = true, example = SwaggerConfig.BEARER_TOKEN),
            @ApiImplicitParam(name = "newsId", value = "新闻id", required = true),
            @ApiImplicitParam(name = "timeZone", value = "时区，参数示例：8或者-8, 范围: -18 to 18 的整数", required = false)
    })
    public ResultData<RtcNewsDetailVO> getNews(@RequestParam(name = "newsId") String newsId,
                                               @RequestParam(name = "timeZone", required = false, defaultValue = "+0") String timeZone) throws Exception {
        RtcNewsDetailVO resultData = news.getNews(newsId, timeZone);

        return ResultData.SUCCESS(resultData);
    }


}
