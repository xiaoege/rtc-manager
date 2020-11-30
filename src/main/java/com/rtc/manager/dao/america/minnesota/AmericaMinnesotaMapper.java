package com.rtc.manager.dao.america.minnesota;

import com.rtc.manager.entity.america.minnesota.AmericaMinnesota;

public interface AmericaMinnesotaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaMinnesota record);

    int insertSelective(AmericaMinnesota record);

    AmericaMinnesota selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaMinnesota record);

    int updateByPrimaryKey(AmericaMinnesota record);
}