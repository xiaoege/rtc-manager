package com.rtc.manager.dao.america.louisiana;

import com.rtc.manager.entity.america.louisiana.AmericaLouisiana;

public interface AmericaLouisianaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaLouisiana record);

    int insertSelective(AmericaLouisiana record);

    AmericaLouisiana selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaLouisiana record);

    int updateByPrimaryKey(AmericaLouisiana record);
}