package com.rtc.manager.dao;

import com.rtc.manager.entity.QccFilingInformation;

public interface QccFilingInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccFilingInformation record);

    int insertSelective(QccFilingInformation record);

    QccFilingInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccFilingInformation record);

    int updateByPrimaryKey(QccFilingInformation record);
}