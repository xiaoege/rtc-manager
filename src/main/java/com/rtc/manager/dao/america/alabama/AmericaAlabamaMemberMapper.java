package com.rtc.manager.dao.america.alabama;

import com.rtc.manager.entity.america.alabama.AmericaAlabamaMember;

public interface AmericaAlabamaMemberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaAlabamaMember record);

    int insertSelective(AmericaAlabamaMember record);

    AmericaAlabamaMember selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaAlabamaMember record);

    int updateByPrimaryKey(AmericaAlabamaMember record);
}