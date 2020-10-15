package com.rtc.manager.dao.america.newhampshire;

import com.rtc.manager.entity.america.newhampshire.AmericaNewhampshirePrincipalInformation;

public interface AmericaNewhampshirePrincipalInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaNewhampshirePrincipalInformation record);

    int insertSelective(AmericaNewhampshirePrincipalInformation record);

    AmericaNewhampshirePrincipalInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaNewhampshirePrincipalInformation record);

    int updateByPrimaryKey(AmericaNewhampshirePrincipalInformation record);
}