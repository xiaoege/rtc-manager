package com.rtc.manager.dao.america.mississippi;

import com.rtc.manager.entity.america.mississippi.AmericaMississippiNameHistory;

import java.util.List;

public interface AmericaMississippiNameHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaMississippiNameHistory record);

    int insertSelective(AmericaMississippiNameHistory record);

    AmericaMississippiNameHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaMississippiNameHistory record);

    int updateByPrimaryKey(AmericaMississippiNameHistory record);

    void insertList(List<AmericaMississippiNameHistory> nameHistoryList);
}