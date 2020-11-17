package com.rtc.manager.dao.america.puertorico;

import com.rtc.manager.entity.america.puertorico.AmericaPuertoRicoStock;

import java.util.List;

public interface AmericaPuertoRicoStockMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaPuertoRicoStock record);

    int insertSelective(AmericaPuertoRicoStock record);

    AmericaPuertoRicoStock selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaPuertoRicoStock record);

    int updateByPrimaryKey(AmericaPuertoRicoStock record);

    void insertList(List<AmericaPuertoRicoStock> stockList);
}