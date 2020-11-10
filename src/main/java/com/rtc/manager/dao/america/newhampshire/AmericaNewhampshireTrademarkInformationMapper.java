package com.rtc.manager.dao.america.newhampshire;

import com.rtc.manager.entity.america.newhampshire.AmericaNewhampshireTrademarkInformation;

public interface AmericaNewhampshireTrademarkInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaNewhampshireTrademarkInformation record);

    int insertSelective(AmericaNewhampshireTrademarkInformation record);

    AmericaNewhampshireTrademarkInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaNewhampshireTrademarkInformation record);

    int updateByPrimaryKey(AmericaNewhampshireTrademarkInformation record);
}