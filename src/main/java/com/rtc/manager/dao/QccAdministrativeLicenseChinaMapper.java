package com.rtc.manager.dao;

import com.rtc.manager.entity.QccAdministrativeLicenseChina;

public interface QccAdministrativeLicenseChinaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccAdministrativeLicenseChina record);

    int insertSelective(QccAdministrativeLicenseChina record);

    QccAdministrativeLicenseChina selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccAdministrativeLicenseChina record);

    int updateByPrimaryKey(QccAdministrativeLicenseChina record);
}