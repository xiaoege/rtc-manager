package com.rtc.manager.dao;

import com.rtc.manager.entity.QccBusinessInformation;

public interface QccBusinessInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccBusinessInformation record);

    int insertSelective(QccBusinessInformation record);

    QccBusinessInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccBusinessInformation record);

    int updateByPrimaryKey(QccBusinessInformation record);
}