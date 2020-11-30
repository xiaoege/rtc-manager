package com.rtc.manager.dao.america.mississippi;

import com.rtc.manager.entity.america.mississippi.AmericaMississippiRegisteredAgent;

import java.util.List;

public interface AmericaMississippiRegisteredAgentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaMississippiRegisteredAgent record);

    int insertSelective(AmericaMississippiRegisteredAgent record);

    AmericaMississippiRegisteredAgent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaMississippiRegisteredAgent record);

    int updateByPrimaryKey(AmericaMississippiRegisteredAgent record);

    void insertList(List<AmericaMississippiRegisteredAgent> registeredAgentList);
}