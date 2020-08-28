package com.rtc.manager.dao;

import com.rtc.manager.entity.vietnam.VietnamBusinessActivities;

public interface VietnamBusinessActivitiesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VietnamBusinessActivities record);

    int insertSelective(VietnamBusinessActivities record);

    VietnamBusinessActivities selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VietnamBusinessActivities record);

    int updateByPrimaryKey(VietnamBusinessActivities record);
}