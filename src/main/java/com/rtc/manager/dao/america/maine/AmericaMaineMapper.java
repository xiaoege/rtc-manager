package com.rtc.manager.dao.america.maine;

import com.rtc.manager.entity.america.maine.AmericaMaine;

public interface AmericaMaineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaMaine record);

    int insertSelective(AmericaMaine record);

    AmericaMaine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaMaine record);

    int updateByPrimaryKey(AmericaMaine record);
}