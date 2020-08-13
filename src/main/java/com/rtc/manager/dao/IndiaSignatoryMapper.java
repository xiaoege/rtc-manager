package com.rtc.manager.dao;

import com.rtc.manager.entity.india.IndiaSignatory;

public interface IndiaSignatoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IndiaSignatory record);

    int insertSelective(IndiaSignatory record);

    IndiaSignatory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndiaSignatory record);

    int updateByPrimaryKey(IndiaSignatory record);
}