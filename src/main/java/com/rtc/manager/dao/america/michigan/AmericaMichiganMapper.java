package com.rtc.manager.dao.america.michigan;

import com.rtc.manager.entity.america.michigan.AmericaMichigan;

public interface AmericaMichiganMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaMichigan record);

    int insertSelective(AmericaMichigan record);

    AmericaMichigan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaMichigan record);

    int updateByPrimaryKey(AmericaMichigan record);
}