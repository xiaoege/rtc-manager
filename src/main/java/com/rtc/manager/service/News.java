package com.rtc.manager.service;

import com.github.pagehelper.PageInfo;
import com.rtc.manager.vo.ResultData;
import com.rtc.manager.vo.RtcNewsDetailVO;
import com.rtc.manager.vo.RtcNewsVO;
import org.springframework.web.multipart.MultipartFile;

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

    /**
     * 删除新闻
     *
     * @param newsId
     * @return
     */
    ResultData removeNews(String newsId);

    /**
     * 新增新闻
     *
     * @param body
     * @param source
     * @return
     */
    ResultData addNews(String body, String source) throws Exception;

    /**
     * 新闻修改
     *
     * @param body
     * @param source
     * @param newsId
     * @return
     */
    ResultData modifyNews(String body, String source, String newsId) throws Exception;

    /**
     * 新闻上传图片
     *
     * @return 可访问的临时地址
     */
    ResultData uploadImg(MultipartFile file, String source) throws Exception;

    /**
     * 审核新闻
     * @param newsId
     * @param examination
     * @return
     */
    ResultData examineNews(String newsId, Integer examination);
}
