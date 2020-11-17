package com.rtc.manager.dao.america.puertorico;

import com.rtc.manager.entity.america.puertorico.AmericaPuertoRicoAdministrator;

import java.util.List;

public interface AmericaPuertoRicoAdministratorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaPuertoRicoAdministrator record);

    int insertSelective(AmericaPuertoRicoAdministrator record);

    AmericaPuertoRicoAdministrator selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaPuertoRicoAdministrator record);

    int updateByPrimaryKey(AmericaPuertoRicoAdministrator record);

    void insertList(List<AmericaPuertoRicoAdministrator> administratorList);
}