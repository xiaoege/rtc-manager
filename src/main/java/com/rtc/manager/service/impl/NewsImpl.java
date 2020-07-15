package com.rtc.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rtc.manager.dao.RtcNewsDetailMapper;
import com.rtc.manager.dao.RtcNewsMapper;
import com.rtc.manager.service.News;
import com.rtc.manager.vo.RtcNewsDetatilVO;
import com.rtc.manager.vo.RtcNewsVO;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
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

    @SneakyThrows
    @Override
    public PageInfo<RtcNewsVO> listNews(String startDate, String endDate, int pageNum, int pageSize, Integer sequence) {
        PageHelper.startPage(pageNum, pageSize);
        List<RtcNewsVO> list = rtcNewsMapper.listNews(startDate, endDate, pageNum, pageSize, sequence);
        if (!ObjectUtils.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                RtcNewsVO rtcNewsVO = list.get(i);
                if (null != rtcNewsVO.getDescription()) {
                    // 去除html标签
                    rtcNewsVO.setDescription(rtcNewsVO.getDescription().replaceAll("<[^>]*>", ""));
                    String url = rtcNewsVO.getPreview();
                    if (null != url) {
                        url = this.url + url.substring(24);
//                        url = this.url + "/chinadaily/2020-07/14/1594716726-1799.jpeg";
                        BufferedImage sourceImg=ImageIO.read(new URL(url).openStream());
                        // 单位：像素
                        int width = sourceImg.getWidth();
                        int height = sourceImg.getHeight();
                        rtcNewsVO.setWeight(width);
                        rtcNewsVO.setHeight(height);
                        rtcNewsVO.setPreview(url);
                    }
                }
            }
        }
        return new PageInfo<>(list);
    }

    @SneakyThrows
    @Override
    public RtcNewsDetatilVO getNews(String newsId) {
        RtcNewsDetatilVO newsDetail = rtcNewsDetailMapper.getNewsDetail(newsId);
        List<String> contentList = newsDetail.getContent();
        List resultList = new ArrayList();
        if (!ObjectUtils.isEmpty(contentList)) {
            for (int i = 0; i < contentList.size(); i++) {
                String content = contentList.get(i);
                content = content.replaceAll("<(?!img|figcaption|/figcaption|strong|/strong|em|/em|p|/p).*?>", "");
                String[] split = content.split("</p>");
                for (int j = 0; j < split.length - 1; j++) {
                    String p = split[j];
                    p = p.substring(p.indexOf("<p>") + 3);
                    Map map = new HashMap();
                    if (p.contains("figcaption") || p.contains("<img")) {
                        String url = p.substring(p.indexOf("'") + 1, p.indexOf("'", p.indexOf("'") + 1));
//                        url = "http://192.168.1.125/" + url.substring(7);
                        url = this.url + url.substring(24);
                        File picture = new File(url);
//                        BufferedImage sourceImg = ImageIO.read(new FileInputStream(picture));
                        BufferedImage sourceImg=ImageIO.read(new URL(url).openStream());
                        // 单位：像素
                        int width = sourceImg.getWidth();
                        int height = sourceImg.getHeight();
                        map.put("data", p.replaceAll("<[^>]*>", ""));
                        map.put("type", "img");
                        map.put("url", url);
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
        }

        return newsDetail;
    }
}
