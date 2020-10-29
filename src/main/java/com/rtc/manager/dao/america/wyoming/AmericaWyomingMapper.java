package com.rtc.manager.dao.america.wyoming;

import com.rtc.manager.entity.america.wyoming.AmericaWyoming;

public interface AmericaWyomingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaWyoming record);

    int insertSelective(AmericaWyoming record);

    AmericaWyoming selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaWyoming record);

    int updateByPrimaryKey(AmericaWyoming record);
}