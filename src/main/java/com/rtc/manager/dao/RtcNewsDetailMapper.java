package com.rtc.manager.dao;

import com.rtc.manager.entity.RtcNewsDetail;
import com.rtc.manager.vo.RtcNewsDetatilVO;

import java.util.List;

public interface RtcNewsDetailMapper {
    int deleteByPrimaryKey(Integer id);

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
    List<RtcNewsDetatilVO> getNewsDetail(String newsId);
}