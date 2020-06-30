package com.rtc.manager.dao;

import com.rtc.manager.entity.QccApp;

public interface QccAppMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccApp record);

    int insertSelective(QccApp record);

    QccApp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccApp record);

    int updateByPrimaryKey(QccApp record);
}