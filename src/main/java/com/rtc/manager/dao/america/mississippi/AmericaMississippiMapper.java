package com.rtc.manager.dao.america.mississippi;

import com.rtc.manager.entity.america.mississippi.AmericaMississippi;

public interface AmericaMississippiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaMississippi record);

    int insertSelective(AmericaMississippi record);

    AmericaMississippi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaMississippi record);

    int updateByPrimaryKey(AmericaMississippi record);
}