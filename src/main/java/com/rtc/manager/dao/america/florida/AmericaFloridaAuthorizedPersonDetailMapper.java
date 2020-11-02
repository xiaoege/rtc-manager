package com.rtc.manager.dao.america.florida;

import com.rtc.manager.entity.america.florida.AmericaFloridaAuthorizedPersonDetail;

import java.util.List;

public interface AmericaFloridaAuthorizedPersonDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaFloridaAuthorizedPersonDetail record);

    int insertSelective(AmericaFloridaAuthorizedPersonDetail record);

    AmericaFloridaAuthorizedPersonDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaFloridaAuthorizedPersonDetail record);

    int updateByPrimaryKey(AmericaFloridaAuthorizedPersonDetail record);

}