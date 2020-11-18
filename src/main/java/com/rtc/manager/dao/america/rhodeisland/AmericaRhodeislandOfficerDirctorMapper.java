package com.rtc.manager.dao.america.rhodeisland;

import com.rtc.manager.entity.america.rhodeisland.AmericaRhodeislandOfficerDirctor;

import java.util.List;

public interface AmericaRhodeislandOfficerDirctorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaRhodeislandOfficerDirctor record);

    int insertSelective(AmericaRhodeislandOfficerDirctor record);

    AmericaRhodeislandOfficerDirctor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaRhodeislandOfficerDirctor record);

    int updateByPrimaryKey(AmericaRhodeislandOfficerDirctor record);

    void insertList(List<AmericaRhodeislandOfficerDirctor> officerDirctorList);
}