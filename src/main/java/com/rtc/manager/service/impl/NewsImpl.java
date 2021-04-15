package com.rtc.manager.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rtc.manager.dao.RtcNewsDetailMapper;
import com.rtc.manager.dao.RtcNewsMapper;
import com.rtc.manager.entity.RtcNews;
import com.rtc.manager.entity.RtcNewsDetail;
import com.rtc.manager.entity.dto.RtcNewsDTO;
import com.rtc.manager.entity.dto.RtcNewsDetailDTO;
import com.rtc.manager.service.News;
import com.rtc.manager.util.CommonUtils;
import com.rtc.manager.vo.ResultData;
import com.rtc.manager.vo.RtcNewsDetailVO;
import com.rtc.manager.vo.RtcNewsVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

/**
 * @author ChenHang
 */
@Service
public class NewsImpl implements News {

    private final Logger logger = LoggerFactory.getLogger(NewsImpl.class);

    @Autowired
    private RtcNewsMapper rtcNewsMapper;

    @Autowired
    private RtcNewsDetailMapper rtcNewsDetailMapper;

    @Value("${rtc.url}")
    private String url;

    @Value("${rtc.timezone}")
    private List<String> timezone;

    @Value("${rtc.news-image-path}")
    private String newsImagePath;

    @Value("${rtc.img-type}")
    private List<String> imgType;

    @Value("${rtc.img-source}")
    private List<String> imgSource;

    @Value("${rtc.news-examination}")
    private List<String> newsExamination;

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
                }
                String url = rtcNewsVO.getPreview();
                if (url != null && !url.startsWith(this.url)) {
                    if (url.length() > newsImagePath.length()) {
                        // http://192.168.1.123/chinadaily/2020-07/14/1594717677-8073.jpeg
//                            BufferedImage sourceImg = ImageIO.read(new URL("file://" + url).openStream());
                        BufferedImage sourceImg = ImageIO.read(new FileInputStream(new File(url)));
                        // 单位：像素
                        int width = sourceImg.getWidth();
                        int height = sourceImg.getHeight();
                        rtcNewsVO.setWeight(width);
                        rtcNewsVO.setHeight(height);
                        url = this.url + url.substring(newsImagePath.length());
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
                        int width = 0;
                        int height = 0;
                        if (null != url && url.length() > newsImagePath.length()) {
//                            BufferedImage sourceImg = ImageIO.read(new URL("file://" + url).openStream());
                            BufferedImage sourceImg = ImageIO.read(new FileInputStream(new File(url)));
                            // 单位：像素
                            width = sourceImg.getWidth();
                            height = sourceImg.getHeight();
                        }
                        map.put("data", p.replaceAll("<[^>]*>", ""));
                        map.put("type", "img");
                        url = this.url + url.substring(newsImagePath.length());
                        map.put("url", url);
                        map.put("width", width);
                        map.put("height", height);
                        resultList.add(map);
                    }
                    /*else if (p.startsWith(this.url)) {
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
                    } */
                    else if (p.contains("<strong>")) {
                        map.put("data", p.replaceAll("<[^>]*>", ""));
                        map.put("type", "title");
                        resultList.add(map);
                    } else if (p.contains("<em>")) {
                        map.put("data", p.replaceAll("<[^>]*>", ""));
                        map.put("type", "em");
                        resultList.add(map);
                    } else if (!p.contains("<")) {
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

    /**
     * 删除新闻
     *
     * @param newsId
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultData removeNews(String newsId) {
        if (rtcNewsMapper.deleteNews(newsId) > 0) {
            rtcNewsDetailMapper.deleteNewsDetail(newsId);
            return ResultData.SUCCESS(null);
        }
        return ResultData.FAIL(null, 500, "删除失败");
    }

    /**
     * 新增新闻
     *
     * @param body
     * @param source
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultData addNews(String body, String source) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        RtcNewsDTO newsDTO = objectMapper.readValue(body, RtcNewsDTO.class);
        RtcNews rtcNews = newsDTO.getRtcNews();
        String newsId = UUID.randomUUID().toString();
        if (CommonUtils.checkJsonField(rtcNews)) {
            String description = rtcNews.getDescription();
            rtcNews.setUuid(newsId);
            rtcNews.setPreview(fileUrl2Location(rtcNews.getPreview(), source));
            if (rtcNewsMapper.insertSelective(rtcNews) > 0) {
                List<RtcNewsDetailDTO> newsDetailList = newsDTO.getNewsDetailList();
                if (!ObjectUtils.isEmpty(newsDetailList)) {
                    StringJoiner stringJoiner = new StringJoiner("");
                    for (int i = 0; i < newsDetailList.size(); i++) {
                        RtcNewsDetailDTO newsDetail = newsDetailList.get(i);
                        String data = newsDetail.getData();
                        String type = newsDetail.getType();
                        String url = newsDetail.getUrl();
                        url = fileUrl2Location(url, source);
                        if (type != null && (type.equals("strong") || type.equals("em"))) {
                            stringJoiner.add("<p><" + type + ">" + data + "</" + type + "></p>");
                        } else if (type != null && type.equals("img")) {
                            stringJoiner.add("<p><img src='" + url + "'><figcaption>" + data + "</figcaption></p>");
                        } else if (type != null && type.equals("content")) {
                            stringJoiner.add("<p>" + data + "</p>");
                        }
                    }
                    if (stringJoiner.length() > 0) {
                        RtcNewsDetail rtcNewsDetail = new RtcNewsDetail();
                        rtcNewsDetail.setNewsId(newsId);
                        rtcNewsDetail.setContent("[\"" + stringJoiner.toString() + "\"]");
                        rtcNewsDetailMapper.insertSelective(rtcNewsDetail);
                    }
                }
                return ResultData.SUCCESS(null, "新增新闻成功");
            }

        }
        return ResultData.FAIL(null, 500, "新闻新增失败");
    }

    /**
     * 新闻修改
     *
     * @param body
     * @param newsId
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultData modifyNews(String body, String source, String newsId) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        RtcNewsDTO newsDTO = objectMapper.readValue(body, RtcNewsDTO.class);
        RtcNews rtcNews = newsDTO.getRtcNews();
        if (CommonUtils.checkJsonField(rtcNews)) {
            String description = rtcNews.getDescription();
            rtcNews.setPreview(fileUrl2Location(rtcNews.getPreview(), source));
            if (rtcNewsMapper.updateByPrimaryKeySelective(rtcNews) > 0) {
                List<RtcNewsDetailDTO> newsDetailList = newsDTO.getNewsDetailList();
                rtcNewsDetailMapper.deleteByPrimaryKey(newsId);
                if (!ObjectUtils.isEmpty(newsDetailList)) {
                    StringJoiner stringJoiner = new StringJoiner("");
                    for (int i = 0; i < newsDetailList.size(); i++) {
                        RtcNewsDetailDTO newsDetail = newsDetailList.get(i);
                        String data = newsDetail.getData();
                        String type = newsDetail.getType();
                        String url = newsDetail.getUrl();
                        url = fileUrl2Location(url, source);
                        if (type != null && (type.equals("strong") || type.equals("em"))) {
                            stringJoiner.add("<p><" + type + ">" + data + "</" + type + "></p>");
                        } else if (type != null && type.equals("img")) {
                            stringJoiner.add("<p><img src='" + url + "'><figcaption>" + data + "</figcaption></p>");
                        } else if (type != null && type.equals("content")) {
                            stringJoiner.add("<p>" + data + "</p>");
                        }
                    }
                    if (stringJoiner.length() > 0) {
                        RtcNewsDetail rtcNewsDetail = new RtcNewsDetail();
                        rtcNewsDetail.setNewsId(newsId);
                        rtcNewsDetail.setContent("[" + stringJoiner.toString() + "]");
                        rtcNewsDetailMapper.insertSelective(rtcNewsDetail);
                    }
                }
                return ResultData.SUCCESS(null, "修改新闻成功");
            }

        }
        return ResultData.FAIL(null, 500, "修改新增失败");
    }

    /**
     * 新闻上传图片
     *
     * @param file
     * @param source
     * @return 可访问的临时地址
     */
    @Override
    public ResultData uploadImg(MultipartFile file, String source) throws Exception {
        String suffString = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        if (!imgType.contains(suffString)) {
            return ResultData.FAIL(null, 905, "文件格式错误");
        }
        if (!imgSource.contains(source)) {
            return ResultData.FAIL(null, 907, "图片来源错误");
        }

        LocalDateTime localDateTime = LocalDateTime.now();
        int year = localDateTime.getYear();
        int month = localDateTime.getMonth().getValue();
        int dayOfMonth = localDateTime.getDayOfMonth();
        long epochSecond = localDateTime.toEpochSecond(ZoneOffset.of("+8"));
        String sourcePath = "/" + source;
        String tempDirPath = newsImagePath + sourcePath + "/" + year + "-" + String.format("%02d", month) + "/" + dayOfMonth + "/";
        File tempDir = new File(tempDirPath);
        if (!tempDir.exists()) {
            tempDir.mkdirs();
        }
        Random random = new Random();
        String tempFilePath = tempDirPath + epochSecond + "-" + random.nextInt(9999) + "." + suffString;

        file.transferTo(new File(tempFilePath));

        // 将本地路径转换为网络路径
        tempFilePath = url + tempFilePath.substring(newsImagePath.length());

        return ResultData.SUCCESS(tempFilePath);
    }

    /**
     * 审核新闻
     *
     * @param newsId
     * @param examination
     * @return
     */
    @Override
    public ResultData examineNews(String newsId, Integer examination) {
        if (!newsExamination.contains(examination)) {
            throw new IllegalArgumentException();
        }
        RtcNews rtcNews = new RtcNews();
        rtcNews.setUuid(newsId);
        rtcNews.setExamination(examination);
        if (rtcNewsMapper.updateByPrimaryKeySelective(rtcNews) > 0) {
            return ResultData.SUCCESS(null);
        }
        return ResultData.FAIL(null, 500);
    }

    /**
     * 将news-temp的网络地址，转换为新闻图片的本地地址
     *
     * @param url
     * @return
     */
    String fileUrl2Location(String url, String source) {
        if (!StringUtils.isEmpty(url)) {
            try {
                url = newsImagePath + url.substring(this.url.length());
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("图片temp地址转换为实际地址异常:{},{}", CommonUtils.getExceptionInfo(e), url);
            }
        }
        return url;
    }
}
