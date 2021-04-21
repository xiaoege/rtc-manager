package com.rtc.manager.dao.america.virginia;

import com.rtc.manager.entity.america.virginia.AmericaVirginia;

public interface AmericaVirginiaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaVirginia record);

    int insertSelective(AmericaVirginia record);

    AmericaVirginia selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaVirginia record);

    int updateByPrimaryKey(AmericaVirginia record);
}