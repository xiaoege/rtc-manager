package com.rtc.manager.dao.america.newhampshire;

import com.rtc.manager.entity.america.newhampshire.AmericaNewhampshireTradenameOwnedby;

public interface AmericaNewhampshireTradenameOwnedbyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaNewhampshireTradenameOwnedby record);

    int insertSelective(AmericaNewhampshireTradenameOwnedby record);

    AmericaNewhampshireTradenameOwnedby selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaNewhampshireTradenameOwnedby record);

    int updateByPrimaryKey(AmericaNewhampshireTradenameOwnedby record);
}