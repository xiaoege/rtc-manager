package com.rtc.manager.dao.america.massachusetts;

import com.rtc.manager.entity.america.massachusetts.AmericaMassachusettsPerson;

import java.util.List;

public interface AmericaMassachusettsPersonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaMassachusettsPerson record);

    int insertSelective(AmericaMassachusettsPerson record);

    AmericaMassachusettsPerson selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaMassachusettsPerson record);

    int updateByPrimaryKey(AmericaMassachusettsPerson record);

    void insertList(List<AmericaMassachusettsPerson> o);
}