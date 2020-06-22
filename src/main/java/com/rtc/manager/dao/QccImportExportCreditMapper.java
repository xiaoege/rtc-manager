package com.rtc.manager.dao;

import com.rtc.manager.entity.QccImportExportCredit;

public interface QccImportExportCreditMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccImportExportCredit record);

    int insertSelective(QccImportExportCredit record);

    QccImportExportCredit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccImportExportCredit record);

    int updateByPrimaryKey(QccImportExportCredit record);
}