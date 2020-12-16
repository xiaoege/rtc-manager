package com.rtc.manager.dao.america.michigan;

import com.rtc.manager.entity.america.michigan.AmericaMichiganShare;

public interface AmericaMichiganShareMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaMichiganShare record);

    int insertSelective(AmericaMichiganShare record);

    AmericaMichiganShare selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaMichiganShare record);

    int updateByPrimaryKey(AmericaMichiganShare record);
}