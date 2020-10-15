package com.rtc.manager.dao.america.newhampshire;

import com.rtc.manager.entity.america.newhampshire.AmericaNewhampshirePrincipalPurpose;

public interface AmericaNewhampshirePrincipalPurposeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaNewhampshirePrincipalPurpose record);

    int insertSelective(AmericaNewhampshirePrincipalPurpose record);

    AmericaNewhampshirePrincipalPurpose selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaNewhampshirePrincipalPurpose record);

    int updateByPrimaryKey(AmericaNewhampshirePrincipalPurpose record);
}