package com.rtc.manager.dao;

import com.rtc.manager.entity.QccClient;

public interface QccClientMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccClient record);

    int insertSelective(QccClient record);

    QccClient selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccClient record);

    int updateByPrimaryKey(QccClient record);
}