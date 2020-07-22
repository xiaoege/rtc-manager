package com.rtc.manager.dao;

import com.rtc.manager.entity.QccShareholderThree;

public interface QccShareholderThreeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccShareholderThree record);

    int insertSelective(QccShareholderThree record);

    QccShareholderThree selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccShareholderThree record);

    int updateByPrimaryKey(QccShareholderThree record);
}