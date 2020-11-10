package com.rtc.manager.dao.america.newhampshire;

import com.rtc.manager.entity.america.newhampshire.AmericaNewhampshireTradenameInformation;

public interface AmericaNewhampshireTradenameInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaNewhampshireTradenameInformation record);

    int insertSelective(AmericaNewhampshireTradenameInformation record);

    AmericaNewhampshireTradenameInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaNewhampshireTradenameInformation record);

    int updateByPrimaryKey(AmericaNewhampshireTradenameInformation record);
}