package com.rtc.manager.dao;

import com.rtc.manager.entity.QccAnnualReport;

public interface QccAnnualReportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccAnnualReport record);

    int insertSelective(QccAnnualReport record);

    QccAnnualReport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccAnnualReport record);

    int updateByPrimaryKey(QccAnnualReport record);
}