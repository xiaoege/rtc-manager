package com.rtc.manager.dao.america.california;

import com.rtc.manager.entity.america.california.AmericaCalifornia;

import java.util.List;

public interface AmericaCaliforniaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaCalifornia record);

    int insertSelective(AmericaCalifornia record);

    AmericaCalifornia selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaCalifornia record);

    int updateByPrimaryKey(AmericaCalifornia record);

    int insertList(List<AmericaCalifornia> dataList);

}