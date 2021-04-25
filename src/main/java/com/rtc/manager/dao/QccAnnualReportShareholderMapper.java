package com.rtc.manager.dao;

import com.rtc.manager.entity.QccAnnualReportShareholder;

public interface QccAnnualReportShareholderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccAnnualReportShareholder record);

    int insertSelective(QccAnnualReportShareholder record);

    QccAnnualReportShareholder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccAnnualReportShareholder record);

    int updateByPrimaryKey(QccAnnualReportShareholder record);

    void deleteByAnnualReportUuid(String uuid);
}