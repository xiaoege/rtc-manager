package com.rtc.manager.dao.america.oregon;

import com.rtc.manager.entity.america.oregon.AmericaOregonSummaryHistory;

import java.util.List;

public interface AmericaOregonSummaryHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaOregonSummaryHistory record);

    int insertSelective(AmericaOregonSummaryHistory record);

    AmericaOregonSummaryHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaOregonSummaryHistory record);

    int updateByPrimaryKey(AmericaOregonSummaryHistory record);

    void insertList(List dataList);
}