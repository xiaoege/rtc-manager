package com.rtc.manager.dao.america.vermount;

import com.rtc.manager.entity.america.vermount.AmericaVermount;

public interface AmericaVermountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaVermount record);

    int insertSelective(AmericaVermount record);

    AmericaVermount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaVermount record);

    int updateByPrimaryKey(AmericaVermount record);
}