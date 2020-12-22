package com.rtc.manager.dao.america.massachusetts;

import com.rtc.manager.entity.america.massachusetts.AmericaMassachusettsOfficer;

import java.util.List;

public interface AmericaMassachusettsOfficerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaMassachusettsOfficer record);

    int insertSelective(AmericaMassachusettsOfficer record);

    AmericaMassachusettsOfficer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaMassachusettsOfficer record);

    int updateByPrimaryKey(AmericaMassachusettsOfficer record);

    void insertList(List<AmericaMassachusettsOfficer> officerList);
}