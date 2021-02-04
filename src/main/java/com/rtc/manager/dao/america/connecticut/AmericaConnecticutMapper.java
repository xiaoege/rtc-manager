package com.rtc.manager.dao.america.connecticut;

import com.rtc.manager.entity.america.connecticut.AmericaConnecticut;

public interface AmericaConnecticutMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaConnecticut record);

    int insertSelective(AmericaConnecticut record);

    AmericaConnecticut selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaConnecticut record);

    int updateByPrimaryKey(AmericaConnecticut record);
}