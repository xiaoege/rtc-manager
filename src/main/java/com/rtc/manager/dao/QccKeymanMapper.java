package com.rtc.manager.dao;

import com.rtc.manager.entity.QccKeyman;

public interface QccKeymanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccKeyman record);

    int insertSelective(QccKeyman record);

    QccKeyman selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccKeyman record);

    int updateByPrimaryKey(QccKeyman record);
}