package com.rtc.manager.dao.america.alabama;

import com.rtc.manager.entity.america.alabama.AmericaAlabamaDirector;

public interface AmericaAlabamaDirectorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaAlabamaDirector record);

    int insertSelective(AmericaAlabamaDirector record);

    AmericaAlabamaDirector selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaAlabamaDirector record);

    int updateByPrimaryKey(AmericaAlabamaDirector record);
}