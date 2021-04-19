package com.rtc.manager.dao.america.utah;

import com.rtc.manager.entity.america.utah.AmericaUtah;

public interface AmericaUtahMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaUtah record);

    int insertSelective(AmericaUtah record);

    AmericaUtah selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaUtah record);

    int updateByPrimaryKey(AmericaUtah record);
}