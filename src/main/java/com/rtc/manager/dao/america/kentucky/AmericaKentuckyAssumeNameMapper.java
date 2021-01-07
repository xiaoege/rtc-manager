package com.rtc.manager.dao.america.kentucky;

import com.rtc.manager.entity.america.kentucky.AmericaKentuckyAssumeName;

public interface AmericaKentuckyAssumeNameMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaKentuckyAssumeName record);

    int insertSelective(AmericaKentuckyAssumeName record);

    AmericaKentuckyAssumeName selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaKentuckyAssumeName record);

    int updateByPrimaryKey(AmericaKentuckyAssumeName record);
}