package com.rtc.manager.dao.america.idaho;

import com.rtc.manager.entity.america.idaho.AmericaIdaho;

import java.util.List;

public interface AmericaIdahoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaIdaho record);

    int insertSelective(AmericaIdaho record);

    AmericaIdaho selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaIdaho record);

    int updateByPrimaryKey(AmericaIdaho record);

    int insertList(List<AmericaIdaho> dataList);
}