package com.rtc.manager.dao.america.northcarolina;

import com.rtc.manager.entity.america.northcarolina.AmericaNorthcarolinaCompanyOfficial;

public interface AmericaNorthcarolinaCompanyOfficialMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaNorthcarolinaCompanyOfficial record);

    int insertSelective(AmericaNorthcarolinaCompanyOfficial record);

    AmericaNorthcarolinaCompanyOfficial selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaNorthcarolinaCompanyOfficial record);

    int updateByPrimaryKey(AmericaNorthcarolinaCompanyOfficial record);
}