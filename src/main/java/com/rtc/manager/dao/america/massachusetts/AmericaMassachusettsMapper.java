package com.rtc.manager.dao.america.massachusetts;

import com.rtc.manager.entity.america.massachusetts.AmericaMassachusetts;

public interface AmericaMassachusettsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaMassachusetts record);

    int insertSelective(AmericaMassachusetts record);

    AmericaMassachusetts selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaMassachusetts record);

    int updateByPrimaryKey(AmericaMassachusetts record);
}