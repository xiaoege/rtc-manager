package com.rtc.manager.dao.america.iowa;

import com.rtc.manager.entity.america.iowa.AmericaIowa;

public interface AmericaIowaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaIowa record);

    int insertSelective(AmericaIowa record);

    AmericaIowa selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaIowa record);

    int updateByPrimaryKeyWithBLOBs(AmericaIowa record);

    int updateByPrimaryKey(AmericaIowa record);
}