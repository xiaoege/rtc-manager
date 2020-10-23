package com.rtc.manager.dao.america.northcarolina;

import com.rtc.manager.entity.america.northcarolina.AmericaNorthcarolina;

public interface AmericaNorthcarolinaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaNorthcarolina record);

    int insertSelective(AmericaNorthcarolina record);

    AmericaNorthcarolina selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaNorthcarolina record);

    int updateByPrimaryKey(AmericaNorthcarolina record);
}