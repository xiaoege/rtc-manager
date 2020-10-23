package com.rtc.manager.dao.america.northcarolina;

import com.rtc.manager.entity.america.northcarolina.AmericaNorthcarolinaStock;

public interface AmericaNorthcarolinaStockMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaNorthcarolinaStock record);

    int insertSelective(AmericaNorthcarolinaStock record);

    AmericaNorthcarolinaStock selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaNorthcarolinaStock record);

    int updateByPrimaryKey(AmericaNorthcarolinaStock record);
}