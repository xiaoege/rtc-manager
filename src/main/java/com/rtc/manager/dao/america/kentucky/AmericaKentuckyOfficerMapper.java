package com.rtc.manager.dao.america.kentucky;

import com.rtc.manager.entity.america.kentucky.AmericaKentuckyOfficer;

public interface AmericaKentuckyOfficerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaKentuckyOfficer record);

    int insertSelective(AmericaKentuckyOfficer record);

    AmericaKentuckyOfficer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaKentuckyOfficer record);

    int updateByPrimaryKey(AmericaKentuckyOfficer record);
}