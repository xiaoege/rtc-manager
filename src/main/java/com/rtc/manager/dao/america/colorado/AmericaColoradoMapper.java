package com.rtc.manager.dao.america.colorado;

import com.rtc.manager.entity.america.colorado.AmericaColorado;

import java.util.List;

public interface AmericaColoradoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaColorado record);

    int insertSelective(AmericaColorado record);

    AmericaColorado selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaColorado record);

    int updateByPrimaryKey(AmericaColorado record);

    int insertList(List<AmericaColorado> dataList);
}