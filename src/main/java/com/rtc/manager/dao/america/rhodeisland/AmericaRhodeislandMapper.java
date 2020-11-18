package com.rtc.manager.dao.america.rhodeisland;

import com.rtc.manager.entity.america.rhodeisland.AmericaRhodeisland;

public interface AmericaRhodeislandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaRhodeisland record);

    int insertSelective(AmericaRhodeisland record);

    AmericaRhodeisland selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaRhodeisland record);

    int updateByPrimaryKey(AmericaRhodeisland record);
}