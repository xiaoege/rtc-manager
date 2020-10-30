package com.rtc.manager.dao.canada;

import com.rtc.manager.entity.canada.CanadaDirector;

public interface CanadaDirectorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CanadaDirector record);

    int insertSelective(CanadaDirector record);

    CanadaDirector selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CanadaDirector record);

    int updateByPrimaryKey(CanadaDirector record);
}