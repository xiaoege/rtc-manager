package com.rtc.manager.dao.america.puertorico;

import com.rtc.manager.entity.america.puertorico.AmericaPuertoRicoAuthorizedPerson;

import java.util.List;

public interface AmericaPuertoRicoAuthorizedPersonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaPuertoRicoAuthorizedPerson record);

    int insertSelective(AmericaPuertoRicoAuthorizedPerson record);

    AmericaPuertoRicoAuthorizedPerson selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaPuertoRicoAuthorizedPerson record);

    int updateByPrimaryKey(AmericaPuertoRicoAuthorizedPerson record);

    void insertList(List<AmericaPuertoRicoAuthorizedPerson> authorizedPersonList);
}