package com.rtc.manager.dao.america.maine;

import com.rtc.manager.entity.america.maine.AmericaMaineFiling;

public interface AmericaMaineFilingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaMaineFiling record);

    int insertSelective(AmericaMaineFiling record);

    AmericaMaineFiling selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaMaineFiling record);

    int updateByPrimaryKey(AmericaMaineFiling record);
}