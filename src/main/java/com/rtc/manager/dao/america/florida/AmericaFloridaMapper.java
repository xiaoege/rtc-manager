package com.rtc.manager.dao.america.florida;

import com.rtc.manager.entity.america.florida.AmericaFlorida;

public interface AmericaFloridaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaFlorida record);

    int insertSelective(AmericaFlorida record);

    AmericaFlorida selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaFlorida record);

    int updateByPrimaryKey(AmericaFlorida record);
}