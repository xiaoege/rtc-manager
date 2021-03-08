package com.rtc.manager.dao.america.americaarkansas;

import com.rtc.manager.entity.america.americaarkansas.AmericaArkansas;

public interface AmericaArkansasMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaArkansas record);

    int insertSelective(AmericaArkansas record);

    AmericaArkansas selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaArkansas record);

    int updateByPrimaryKey(AmericaArkansas record);
}