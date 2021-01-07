package com.rtc.manager.dao.america.kentucky;

import com.rtc.manager.entity.america.kentucky.AmericaKentuckyHistory;

public interface AmericaKentuckyHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaKentuckyHistory record);

    int insertSelective(AmericaKentuckyHistory record);

    AmericaKentuckyHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaKentuckyHistory record);

    int updateByPrimaryKey(AmericaKentuckyHistory record);
}