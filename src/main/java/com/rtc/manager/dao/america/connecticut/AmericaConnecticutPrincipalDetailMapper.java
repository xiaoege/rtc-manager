package com.rtc.manager.dao.america.connecticut;

import com.rtc.manager.entity.america.connecticut.AmericaConnecticutPrincipalDetail;

public interface AmericaConnecticutPrincipalDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaConnecticutPrincipalDetail record);

    int insertSelective(AmericaConnecticutPrincipalDetail record);

    AmericaConnecticutPrincipalDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaConnecticutPrincipalDetail record);

    int updateByPrimaryKey(AmericaConnecticutPrincipalDetail record);
}