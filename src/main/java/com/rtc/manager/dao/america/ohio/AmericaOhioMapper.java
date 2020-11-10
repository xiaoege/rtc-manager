package com.rtc.manager.dao.america.ohio;

import com.rtc.manager.entity.america.ohio.AmericaOhio;

import java.util.List;

public interface AmericaOhioMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaOhio record);

    int insertSelective(AmericaOhio record);

    AmericaOhio selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaOhio record);

    int updateByPrimaryKey(AmericaOhio record);

    void insertList(List<AmericaOhio> dataList);
}