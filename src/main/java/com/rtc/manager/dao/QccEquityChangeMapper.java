package com.rtc.manager.dao;

import com.rtc.manager.entity.QccEquityChange;

public interface QccEquityChangeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccEquityChange record);

    int insertSelective(QccEquityChange record);

    QccEquityChange selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccEquityChange record);

    int updateByPrimaryKey(QccEquityChange record);
}