package com.rtc.manager.dao.america.washington;

import com.rtc.manager.entity.america.washington.AmericaWashington;

public interface AmericaWashingtonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaWashington record);

    int insertSelective(AmericaWashington record);

    AmericaWashington selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaWashington record);

    int updateByPrimaryKey(AmericaWashington record);
}