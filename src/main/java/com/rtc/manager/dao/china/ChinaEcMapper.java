package com.rtc.manager.dao.china;

import com.rtc.manager.entity.china.ChinaEc;

public interface ChinaEcMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChinaEc record);

    int insertSelective(ChinaEc record);

    ChinaEc selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChinaEc record);

    int updateByPrimaryKey(ChinaEc record);
}