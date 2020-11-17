package com.rtc.manager.dao.america.puertorico;

import com.rtc.manager.entity.america.puertorico.AmericaPuertoRicoOfficer;

import java.util.List;

public interface AmericaPuertoRicoOfficerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaPuertoRicoOfficer record);

    int insertSelective(AmericaPuertoRicoOfficer record);

    AmericaPuertoRicoOfficer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaPuertoRicoOfficer record);

    int updateByPrimaryKey(AmericaPuertoRicoOfficer record);

    void insertList(List<AmericaPuertoRicoOfficer> officerList);
}