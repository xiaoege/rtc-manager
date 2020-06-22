package com.rtc.manager.dao;

import com.rtc.manager.entity.QccShareholder;

public interface QccShareholderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccShareholder record);

    int insertSelective(QccShareholder record);

    QccShareholder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccShareholder record);

    int updateByPrimaryKey(QccShareholder record);
}