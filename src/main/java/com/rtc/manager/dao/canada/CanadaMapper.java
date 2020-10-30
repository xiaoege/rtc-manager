package com.rtc.manager.dao.canada;

import com.rtc.manager.entity.canada.Canada;

public interface CanadaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Canada record);

    int insertSelective(Canada record);

    Canada selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Canada record);

    int updateByPrimaryKey(Canada record);
}