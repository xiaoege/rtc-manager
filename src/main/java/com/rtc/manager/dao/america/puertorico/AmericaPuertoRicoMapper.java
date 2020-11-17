package com.rtc.manager.dao.america.puertorico;

import com.rtc.manager.entity.america.puertorico.AmericaPuertoRico;

public interface AmericaPuertoRicoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaPuertoRico record);

    int insertSelective(AmericaPuertoRico record);

    AmericaPuertoRico selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaPuertoRico record);

    int updateByPrimaryKey(AmericaPuertoRico record);
}