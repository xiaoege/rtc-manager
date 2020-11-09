package com.rtc.manager.dao.america.delaware;

import com.rtc.manager.entity.america.delaware.AmericaDelaware;

import java.util.List;

public interface AmericaDelawareMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaDelaware record);

    int insertSelective(AmericaDelaware record);

    AmericaDelaware selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaDelaware record);

    int updateByPrimaryKey(AmericaDelaware record);

    void insertList(List<AmericaDelaware> americaDelawareList);

}