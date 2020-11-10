package com.rtc.manager.dao.america.oklahoma;

import com.rtc.manager.entity.america.oklahoma.AmericaOklahomaRegisteredAgent;

public interface AmericaOklahomaRegisteredAgentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaOklahomaRegisteredAgent record);

    int insertSelective(AmericaOklahomaRegisteredAgent record);

    AmericaOklahomaRegisteredAgent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaOklahomaRegisteredAgent record);

    int updateByPrimaryKey(AmericaOklahomaRegisteredAgent record);
}