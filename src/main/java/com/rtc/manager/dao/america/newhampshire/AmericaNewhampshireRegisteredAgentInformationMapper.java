package com.rtc.manager.dao.america.newhampshire;

import com.rtc.manager.entity.america.newhampshire.AmericaNewhampshireRegisteredAgentInformation;

public interface AmericaNewhampshireRegisteredAgentInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaNewhampshireRegisteredAgentInformation record);

    int insertSelective(AmericaNewhampshireRegisteredAgentInformation record);

    AmericaNewhampshireRegisteredAgentInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaNewhampshireRegisteredAgentInformation record);

    int updateByPrimaryKey(AmericaNewhampshireRegisteredAgentInformation record);
}