package com.rtc.manager.dao.america.puertorico;

import com.rtc.manager.entity.america.puertorico.AmericaPuertoRicoIncorporator;

import java.util.List;

public interface AmericaPuertoRicoIncorporatorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaPuertoRicoIncorporator record);

    int insertSelective(AmericaPuertoRicoIncorporator record);

    AmericaPuertoRicoIncorporator selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaPuertoRicoIncorporator record);

    int updateByPrimaryKey(AmericaPuertoRicoIncorporator record);

    void insertList(List<AmericaPuertoRicoIncorporator> incorporatorList);
}