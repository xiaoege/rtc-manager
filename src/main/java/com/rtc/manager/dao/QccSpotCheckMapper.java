package com.rtc.manager.dao;

import com.rtc.manager.entity.QccSpotCheck;

public interface QccSpotCheckMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccSpotCheck record);

    int insertSelective(QccSpotCheck record);

    QccSpotCheck selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccSpotCheck record);

    int updateByPrimaryKey(QccSpotCheck record);
}