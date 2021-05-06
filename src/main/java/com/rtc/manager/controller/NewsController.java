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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

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
     * @return ResultData<PageInfo < RtcNewsVO>>
     */
    @GetMapping("listNews")
    @ApiOperation("查询新闻列表")
    @ApiImplicitParams({
//            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer xxxxx", paramType = "header", required = true, example = SwaggerConfig.BEARER_TOKEN),
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
     * 同一用户，每分钟内重复点击不增加新闻查看数
     * 新闻每周三下午3点更新到mysql
     *
     * @param newsId   新闻id
     * @param timeZone 时区，参数示例：8或者-8, 范围: -18 to 18 的整数
     * @return ResultData<RtcNewsDetatilVO>
     * @throws Exception
     */
    @GetMapping("getNews")
    @ApiOperation(value = "查询新闻详情", notes = "所有新闻详情页必须著名来源，来源链接，原作者，原标题")
    @ApiImplicitParams({
//            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer xxxxx", paramType = "header", required = true, example = SwaggerConfig.BEARER_TOKEN),
            @ApiImplicitParam(name = "newsId", value = "新闻id", required = true),
            @ApiImplicitParam(name = "timeZone", value = "时区，参数示例：8或者-8, 范围: -18 to 18 的整数", required = false)
    })
    public ResultData<RtcNewsDetailVO> getNews(@RequestParam(name = "newsId") String newsId,
                                               @RequestParam(name = "timeZone", required = false, defaultValue = "+0") String timeZone) throws Exception {
        RtcNewsDetailVO resultData = news.getNews(newsId, timeZone);

        return ResultData.SUCCESS(resultData);
    }

    /**
     * 新增新增
     */
    @ApiIgnore
    @PostMapping("addNews")
    @ApiOperation(value = "新增新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer xxxxx", paramType = "header", required = true, example = SwaggerConfig.BEARER_TOKEN),
            @ApiImplicitParam(name = "body", value = "参数示例：{\n" +
                    "    \"rtcNews\": {\n" +
                    "        \"author\": \"author\",\n" +
                    "        \"title\": \"title\",\n" +
                    "        \"source\": \"source\",\n" +
                    "        \"sourceUrl\": \"sourceUrl\",\n" +
                    "        \"country\": \"country\",\n" +
                    "        \"preview\": \"http://384051d027.eicp.vip/chinadaily/2021-04/15/1618468710-8254.png\",\n" +
                    "        \"description\": \"description\"\n" +
                    "    },\n" +
                    "    \"newsDetailList\": [\n" +
                    "        {\n" +
                    "            \"data\": \"1\",\n" +
                    "            \"type\": \"content\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"data\": \"2\",\n" +
                    "            \"type\": \"em\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"data\": \"3\",\n" +
                    "            \"type\": \"strong\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"data\": \"图片描述\",\n" +
                    "            \"type\": \"img\",\n" +
                    "            \"url\": \"http://384051d027.eicp.vip/chinadaily/2021-04/15/1618468710-8254.png\"\n" +
                    "        }\n" +
                    "    ]\n" +
                    "}", paramType = "body", required = true),
            @ApiImplicitParam(name = "source", value = "新闻来源/版式，参数示例：chinadaily", paramType = "header", required = true, example = "chinadaily"),
    })
    public ResultData addNews(@RequestBody String body,
                              @RequestParam String source) throws Exception {
        return news.addNews(body, source);
    }

    /**
     * 新闻修改
     */
    @ApiIgnore
    @PostMapping("modifyNews")
    @ApiOperation(value = "新闻修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer xxxxx", paramType = "header", required = true, example = SwaggerConfig.BEARER_TOKEN),
            @ApiImplicitParam(name = "body", value = "参数示例：{\n" +
                    "    \"rtcNews\": {\n" +
                    "        \"author\": \"author\",\n" +
                    "        \"title\": \"title\",\n" +
                    "        \"source\": \"source\",\n" +
                    "        \"sourceUrl\": \"sourceUrl\",\n" +
                    "        \"country\": \"country\",\n" +
                    "        \"preview\": \"http://384051d027.eicp.vip/chinadaily/2021-04/15/1618468710-8254.png\",\n" +
                    "        \"description\": \"description\"\n" +
                    "    },\n" +
                    "    \"newsDetailList\": [\n" +
                    "        {\n" +
                    "            \"data\": \"1\",\n" +
                    "            \"type\": \"content\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"data\": \"2\",\n" +
                    "            \"type\": \"em\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"data\": \"3\",\n" +
                    "            \"type\": \"strong\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"data\": \"图片描述\",\n" +
                    "            \"type\": \"img\",\n" +
                    "            \"url\": \"http://384051d027.eicp.vip/chinadaily/2021-04/15/1618468710-8254.png\"\n" +
                    "        }\n" +
                    "    ]\n" +
                    "}", paramType = "body", required = true),
            @ApiImplicitParam(name = "source", value = "新闻来源/版式，参数示例：chinadaily", paramType = "header", required = true, example = "chinadaily"),
            @ApiImplicitParam(name = "newsId", value = "新闻id", paramType = "header", required = true)

    })
    public ResultData modifyNews(@RequestBody String body,
                                 @RequestParam String source,
                                 @RequestParam String newsId) throws Exception {
        return news.modifyNews(body, source, newsId);
    }

    /**
     * 删除新闻
     *
     * @param newsId
     * @return
     */
    @ApiIgnore
    @PostMapping("removeNews")
    @ApiOperation(value = "删除新闻")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer xxxxx", paramType = "header", required = true, example = SwaggerConfig.BEARER_TOKEN),
            @ApiImplicitParam(name = "newsId", value = "新闻id", paramType = "header", required = true)
    })
    public ResultData removeNews(@RequestParam(name = "newsId") String newsId) {
        return news.removeNews(newsId);
    }

    /**
     * 新闻上传图片
     *
     * @return 可访问的临时地址
     */
    @ApiIgnore
    @PostMapping("uploadImg")
    @ApiOperation(value = "新闻上传图片", notes = "返回可访问的临时地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer xxxxx", paramType = "header", required = true, example = SwaggerConfig.BEARER_TOKEN),
            @ApiImplicitParam(name = "file", value = "后缀名是jpg,jpeg,png,bmp格式的图片,大小在2MB以内", paramType = "form", dataType = "__file", required = true),
            @ApiImplicitParam(name = "source", value = "新闻来源/版式，参数示例：chinadaily", paramType = "header", required = true, example = "chinadaily")
    })
    public ResultData uploadImg(@RequestParam MultipartFile file,
                                @RequestParam String source) throws Exception {
        return news.uploadImg(file, source);
    }

    /**
     * 审核新闻,等新闻正式启用审核模式再使用
     *
     * @param newsId
     * @return
     */
    @ApiIgnore
    @PostMapping("examineNews")
    @ApiOperation(value = "审核新闻", notes = "等新闻正式启用审核模式再使用")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "参数示例：Bearer xxxxx", paramType = "header", required = true, example = SwaggerConfig.BEARER_TOKEN),
            @ApiImplicitParam(name = "examination", value = "0未审核, 1审核通过, 2审核不通过", paramType = "header", required = true)
    })
    public ResultData examineNews(@RequestParam String newsId,
                                  @RequestParam Integer examination) {
        return news.examineNews(newsId, examination);
    }
}
