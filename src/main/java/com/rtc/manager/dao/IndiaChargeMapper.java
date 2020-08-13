package com.rtc.manager.dao;

import com.rtc.manager.entity.india.IndiaCharge;

public interface IndiaChargeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IndiaCharge record);

    int insertSelective(IndiaCharge record);

    IndiaCharge selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndiaCharge record);

    int updateByPrimaryKey(IndiaCharge record);
}