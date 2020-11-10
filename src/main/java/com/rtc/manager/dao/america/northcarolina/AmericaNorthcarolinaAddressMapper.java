package com.rtc.manager.dao.america.northcarolina;

import com.rtc.manager.entity.america.northcarolina.AmericaNorthcarolinaAddress;

public interface AmericaNorthcarolinaAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaNorthcarolinaAddress record);

    int insertSelective(AmericaNorthcarolinaAddress record);

    AmericaNorthcarolinaAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaNorthcarolinaAddress record);

    int updateByPrimaryKey(AmericaNorthcarolinaAddress record);
}