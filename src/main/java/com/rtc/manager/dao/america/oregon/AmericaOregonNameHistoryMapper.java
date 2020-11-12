package com.rtc.manager.dao.america.oregon;

import com.rtc.manager.entity.america.oregon.AmericaOregonNameHistory;

import java.util.List;

public interface AmericaOregonNameHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaOregonNameHistory record);

    int insertSelective(AmericaOregonNameHistory record);

    AmericaOregonNameHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaOregonNameHistory record);

    int updateByPrimaryKey(AmericaOregonNameHistory record);

    void insertList(List dataList);
}