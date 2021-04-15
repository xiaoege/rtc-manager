package com.rtc.manager.dao;

import com.rtc.manager.entity.RtcNews;
import com.rtc.manager.vo.RtcNewsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RtcNewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RtcNews record);

    int insertSelective(RtcNews record);

    RtcNews selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RtcNews record);

    int updateByPrimaryKey(RtcNews record);

    /**
     * 查询新闻列表
     * @param startDate
     * @param endDate
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<RtcNewsVO> listNews(@Param("startDate") String startDate, @Param("endDate") String endDate,
                             @Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    int deleteNews(String newsId);
}