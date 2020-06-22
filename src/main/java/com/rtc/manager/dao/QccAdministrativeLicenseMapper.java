package com.rtc.manager.dao;

import com.rtc.manager.entity.QccAdministrativeLicense;

public interface QccAdministrativeLicenseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccAdministrativeLicense record);

    int insertSelective(QccAdministrativeLicense record);

    QccAdministrativeLicense selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccAdministrativeLicense record);

    int updateByPrimaryKey(QccAdministrativeLicense record);
}