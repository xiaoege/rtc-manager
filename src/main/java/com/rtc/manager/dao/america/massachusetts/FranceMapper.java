package com.rtc.manager.dao.america.massachusetts;

import com.rtc.manager.entity.america.massachusetts.France;

import java.util.List;

public interface FranceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(France record);

    int insertSelective(France record);

    France selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(France record);

    int updateByPrimaryKeyWithBLOBs(France record);

    int updateByPrimaryKey(France record);

    int insertList(List<France> dataList);
}