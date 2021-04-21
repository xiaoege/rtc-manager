package com.rtc.manager.dao.america.washington;

import com.rtc.manager.entity.america.washington.AmericaWashingtonGovernor;

public interface AmericaWashingtonGovernorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaWashingtonGovernor record);

    int insertSelective(AmericaWashingtonGovernor record);

    AmericaWashingtonGovernor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaWashingtonGovernor record);

    int updateByPrimaryKey(AmericaWashingtonGovernor record);
}