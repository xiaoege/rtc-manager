package com.rtc.manager.dao.america.michigan;

import com.rtc.manager.entity.america.michigan.AmericaMichiganOfficer;

public interface AmericaMichiganOfficerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaMichiganOfficer record);

    int insertSelective(AmericaMichiganOfficer record);

    AmericaMichiganOfficer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaMichiganOfficer record);

    int updateByPrimaryKey(AmericaMichiganOfficer record);
}