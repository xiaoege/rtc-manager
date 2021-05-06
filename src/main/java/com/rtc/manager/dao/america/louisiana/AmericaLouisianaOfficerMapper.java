package com.rtc.manager.dao.america.louisiana;

import com.rtc.manager.entity.america.louisiana.AmericaLouisianaOfficer;

public interface AmericaLouisianaOfficerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaLouisianaOfficer record);

    int insertSelective(AmericaLouisianaOfficer record);

    AmericaLouisianaOfficer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaLouisianaOfficer record);

    int updateByPrimaryKey(AmericaLouisianaOfficer record);
}