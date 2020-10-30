package com.rtc.manager.dao.canada;

import com.rtc.manager.entity.canada.CanadaCorporateHistory;

public interface CanadaCorporateHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CanadaCorporateHistory record);

    int insertSelective(CanadaCorporateHistory record);

    CanadaCorporateHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CanadaCorporateHistory record);

    int updateByPrimaryKey(CanadaCorporateHistory record);
}