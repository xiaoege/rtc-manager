package com.rtc.manager.dao;

import com.rtc.manager.entity.RtcNewsDetail;
import com.rtc.manager.vo.RtcNewsDetailVO;
import org.apache.ibatis.annotations.Param;

public interface RtcNewsDetailMapper {
    int deleteByPrimaryKey(String newId);

    int insert(RtcNewsDetail record);

    int insertSelective(RtcNewsDetail record);

    RtcNewsDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RtcNewsDetail record);

    int updateByPrimaryKeyWithBLOBs(RtcNewsDetail record);

    int updateByPrimaryKey(RtcNewsDetail record);

    /**
     * 查询单个新闻内容
     * @param newsId
     * @return
     */
    RtcNewsDetailVO getNewsDetail(String newsId);

    int deleteNewsDetail(String newsId);

    int getNewsRead(String newsId);

    int updateNewsRead(@Param("newsId") String newsId, @Param("newsRead") Integer newsRead);
}