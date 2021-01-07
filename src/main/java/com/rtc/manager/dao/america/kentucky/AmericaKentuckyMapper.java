package com.rtc.manager.dao.america.kentucky;

import com.rtc.manager.entity.america.kentucky.AmericaKentucky;

public interface AmericaKentuckyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaKentucky record);

    int insertSelective(AmericaKentucky record);

    AmericaKentucky selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaKentucky record);

    int updateByPrimaryKey(AmericaKentucky record);
}