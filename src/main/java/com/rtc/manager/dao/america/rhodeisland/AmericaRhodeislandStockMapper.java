package com.rtc.manager.dao.america.rhodeisland;

import com.rtc.manager.entity.america.rhodeisland.AmericaRhodeislandStock;

import java.util.List;

public interface AmericaRhodeislandStockMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaRhodeislandStock record);

    int insertSelective(AmericaRhodeislandStock record);

    AmericaRhodeislandStock selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaRhodeislandStock record);

    int updateByPrimaryKey(AmericaRhodeislandStock record);

    void insertList(List<AmericaRhodeislandStock> stockList);
}