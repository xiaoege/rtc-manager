package com.rtc.manager.dao.america.wyoming;

import com.rtc.manager.entity.america.wyoming.AmericaWyomingParty;

public interface AmericaWyomingPartyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaWyomingParty record);

    int insertSelective(AmericaWyomingParty record);

    AmericaWyomingParty selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaWyomingParty record);

    int updateByPrimaryKey(AmericaWyomingParty record);
}