package com.rtc.manager.dao;

import com.rtc.manager.entity.QccQualification;

public interface QccQualificationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccQualification record);

    int insertSelective(QccQualification record);

    QccQualification selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccQualification record);

    int updateByPrimaryKey(QccQualification record);
}