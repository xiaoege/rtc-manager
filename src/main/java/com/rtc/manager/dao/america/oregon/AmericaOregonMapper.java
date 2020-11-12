package com.rtc.manager.dao.america.oregon;

import com.rtc.manager.entity.america.oregon.AmericaOregon;
import com.rtc.manager.entity.america.oregon.AmericaOregonAssociate;

import java.util.List;

public interface AmericaOregonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaOregon record);

    int insertSelective(AmericaOregon record);

    AmericaOregon selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaOregon record);

    int updateByPrimaryKey(AmericaOregon record);

}