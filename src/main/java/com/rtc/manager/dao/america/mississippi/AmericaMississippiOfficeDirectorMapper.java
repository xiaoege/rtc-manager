package com.rtc.manager.dao.america.mississippi;

import com.rtc.manager.entity.america.mississippi.AmericaMississippiOfficeDirector;

import java.util.List;

public interface AmericaMississippiOfficeDirectorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaMississippiOfficeDirector record);

    int insertSelective(AmericaMississippiOfficeDirector record);

    AmericaMississippiOfficeDirector selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaMississippiOfficeDirector record);

    int updateByPrimaryKey(AmericaMississippiOfficeDirector record);

    void insertList(List<AmericaMississippiOfficeDirector> officeDirectorList);
}