package com.rtc.manager.dao.america.louisiana;

import com.rtc.manager.entity.america.louisiana.AmericaLouisianaRegisteredAgent;

public interface AmericaLouisianaRegisteredAgentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaLouisianaRegisteredAgent record);

    int insertSelective(AmericaLouisianaRegisteredAgent record);

    AmericaLouisianaRegisteredAgent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaLouisianaRegisteredAgent record);

    int updateByPrimaryKey(AmericaLouisianaRegisteredAgent record);
}