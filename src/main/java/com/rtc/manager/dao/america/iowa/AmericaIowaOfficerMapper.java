package com.rtc.manager.dao.america.iowa;

import com.rtc.manager.entity.america.iowa.AmericaIowaOfficer;

public interface AmericaIowaOfficerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaIowaOfficer record);

    int insertSelective(AmericaIowaOfficer record);

    AmericaIowaOfficer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaIowaOfficer record);

    int updateByPrimaryKey(AmericaIowaOfficer record);
}