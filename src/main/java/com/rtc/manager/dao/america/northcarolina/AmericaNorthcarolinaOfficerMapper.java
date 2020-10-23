package com.rtc.manager.dao.america.northcarolina;

import com.rtc.manager.entity.america.northcarolina.AmericaNorthcarolinaOfficer;

public interface AmericaNorthcarolinaOfficerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaNorthcarolinaOfficer record);

    int insertSelective(AmericaNorthcarolinaOfficer record);

    AmericaNorthcarolinaOfficer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaNorthcarolinaOfficer record);

    int updateByPrimaryKey(AmericaNorthcarolinaOfficer record);
}