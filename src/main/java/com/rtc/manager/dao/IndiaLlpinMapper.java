package com.rtc.manager.dao;

import com.rtc.manager.entity.india.IndiaLlpin;

public interface IndiaLlpinMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IndiaLlpin record);

    int insertSelective(IndiaLlpin record);

    IndiaLlpin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndiaLlpin record);

    int updateByPrimaryKey(IndiaLlpin record);
}