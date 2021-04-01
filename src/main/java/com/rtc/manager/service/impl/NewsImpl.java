package com.rtc.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rtc.manager.dao.RtcNewsDetailMapper;
import com.rtc.manager.dao.RtcNewsMapper;
import com.rtc.manager.service.News;
import com.rtc.manager.util.CommonUtils;
import com.rtc.manager.vo.RtcNewsDetailVO;
import com.rtc.manager.vo.RtcNewsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ChenHang
 */
@Service
public class NewsImpl implements News {

    @Autowired
    private RtcNewsMapper rtcNewsMapper;

    @Autowired
    private RtcNewsDetailMapper rtcNewsDetailMapper;

    @Value("${rtc.url}")
    private String url;

    @Value("${rtc.timezone}")
    private List<String> timezone;

    /**
     * 查询新闻列表
     *
     * @param startDate 按创建日期查询新闻-起始日期，参数类型：yyyy-MM-dd 或 yyyy-MM-dd HH:mm:ss
     * @param endDate   按创建日期查询新闻-结束日期，参数类型：yyyy-MM-dd 或 yyyy-MM-dd HH:mm:ss
     * @param pageNum   当前页数
     * @param pageSize  当前页面展示数量
     * @param timeZone  时区，参数示例：8或者-8, 范围: -18 to 18 的整数
     * @return
     */
    @Override
    public PageInfo<RtcNewsVO> listNews(String startDate, String endDate, int pageNum, int pageSize, String timeZone) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<RtcNewsVO> list = rtcNewsMapper.listNews(startDate, endDate, pageNum, pageSize);
        PageHelper.clearPage();
        if (!ObjectUtils.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                RtcNewsVO rtcNewsVO = list.get(i);
                if (null != rtcNewsVO.getDescription()) {
                    // 去除html标签
                    rtcNewsVO.setDescription(rtcNewsVO.getDescription().replaceAll("<[^>]*>", ""));
                    String url = rtcNewsVO.getPreview();
                    if (url != null && !url.startsWith(this.url)) {
                        if (url.length() > 12) {
                            // http://192.168.1.125/chinadaily/2020-07/14/1594717677-8073.jpeg
                            // 12 = /work/images
                            url = this.url + url.substring(12);
                            BufferedImage sourceImg = ImageIO.read(new URL(url).openStream());
                            // 单位：像素
                            int width = sourceImg.getWidth();
                            int height = sourceImg.getHeight();
                            rtcNewsVO.setWeight(width);
                            rtcNewsVO.setHeight(height);
                            rtcNewsVO.setPreview(url);
                        }
                    } else if (url != null && url.startsWith(this.url)) {
                        BufferedImage sourceImg = ImageIO.read(new URL(url).openStream());
                        // 单位：像素
                        int width = sourceImg.getWidth();
                        int height = sourceImg.getHeight();
                        rtcNewsVO.setWeight(width);
                        rtcNewsVO.setHeight(height);
                        rtcNewsVO.setPreview(url);
                    }
                }
                String author = rtcNewsVO.getAuthor();
                rtcNewsVO.setAuthor(modifyAuthor(author));
                if (!timezone.contains(timeZone)) {
                    timeZone = "0";
                }
                if (!timeZone.startsWith("-") && !timeZone.startsWith("+")) {
                    timeZone = "+" + timeZone;
                }
                String intervalTime = CommonUtils.compareTime(timeZone, rtcNewsVO.getGmtCreate());
                rtcNewsVO.setIntervalTime(intervalTime);
            }
        }

        return new PageInfo<>(list);
    }

    private String modifyAuthor(String author) {
        if (author != null) {
            if (author.contains(" | ")) {
                String[] authorArray = author.split(" \\| ");
                author = authorArray[0];
            }
            author = author.replace("By ", "");
            if (author.contains(" in ")) {
                author = author.substring(0, author.indexOf(" in "));
            }
        }
        return author;
    }

    /**
     * 查询新闻详情
     *
     * @param newsId   新闻id
     * @param timeZone 时区，参数示例：8或者-8, 范围: -18 to 18 的整数
     * @return RtcNewsDetatilVO
     * @throws Exception
     */
    @Override
    public RtcNewsDetailVO getNews(String newsId, String timeZone) throws Exception {
        RtcNewsDetailVO newsDetail = rtcNewsDetailMapper.getNewsDetail(newsId);
        if (newsDetail == null) {
            return null;
        }
        String author = newsDetail.getAuthor();
        newsDetail.setAuthor(modifyAuthor(author));
        List<String> contentList = newsDetail.getContent();
        List resultList = new ArrayList();
        if (!ObjectUtils.isEmpty(contentList)) {
            for (int i = 0; i < contentList.size(); i++) {
                String content = contentList.get(i);
                content = content.replaceAll("<(?!img|figcaption|/figcaption|strong|/strong|em|/em|p|/p).*?>", "");
                String[] split = content.split("</p>");
                int contentLength = split.length;
                if (split != null && contentLength != 1) {
                    contentLength -= 1;
                }
                for (int j = 0; j < contentLength; j++) {
                    String p = split[j];
                    if (p.contains("<p")) {
                        p = p.substring(p.indexOf("<p>") + 3).replace("\\n", "");
                    }
                    Map map = new HashMap();
                    String url = "";
                    if (p.contains("figcaption") || p.contains("<img")) {
                        url = p.substring(p.indexOf("'") + 1, p.indexOf("'", p.indexOf("'") + 1));
                        //                        "http://192.168.1.125/chinadaily/2020-07/14/1594717677-8073.jpeg"
                        // 12 = /work/images
                        if (null != url && url.length() > 12) {
                            url = this.url + url.substring(12);
                        }
//                            File picture = new File(url);
                        //                        BufferedImage sourceImg = ImageIO.read(new FileInputStream(picture));
                        BufferedImage sourceImg = ImageIO.read(new URL(url).openStream());
                        // 单位：像素
                        int width = sourceImg.getWidth();
                        int height = sourceImg.getHeight();
                        map.put("data", p.replaceAll("<[^>]*>", ""));
                        map.put("type", "img");
                        map.put("url", url);
                        map.put("width", width);
                        map.put("height", height);
                        resultList.add(map);
                    } else if (p.startsWith(this.url)) {
//                            File picture = new File(p);
                        //                        BufferedImage sourceImg = ImageIO.read(new FileInputStream(picture));
                        BufferedImage sourceImg = ImageIO.read(new URL(p).openStream());
                        // 单位：像素
                        int width = sourceImg.getWidth();
                        int height = sourceImg.getHeight();
                        map.put("data", p.replaceAll("<[^>]*>", ""));
                        map.put("type", "img");
                        map.put("url", p);
                        map.put("width", width);
                        map.put("height", height);
                        resultList.add(map);
                    } else if (p.contains("<strong>")) {
                        map.put("data", p.replaceAll("<[^>]*>", ""));
                        map.put("type", "title");
                        resultList.add(map);
                    } else if (p.contains("<em>")) {
                        map.put("data", p.replaceAll("<[^>]*>", ""));
                        map.put("type", "em");
                        resultList.add(map);
                    } else {
                        map.put("data", p);
                        map.put("type", "content");
                        resultList.add(map);
                    }

                }
            }
            newsDetail.setResultList(resultList);
            newsDetail.setContent(null);
            if (!timezone.contains(timeZone)) {
                timeZone = "0";
            }
            if (!timeZone.startsWith("-") && !timeZone.startsWith("+")) {
                timeZone = "+" + timeZone;
            }
            String intervalTime = CommonUtils.compareTime(timeZone, newsDetail.getGmtCreate());
            newsDetail.setIntervalTime(intervalTime);
        }

        return newsDetail;
    }
}
