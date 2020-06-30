package com.rtc.manager.dao;

import com.rtc.manager.entity.QccAdministrativeSanction;

public interface QccAdministrativeSanctionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccAdministrativeSanction record);

    int insertSelective(QccAdministrativeSanction record);

    QccAdministrativeSanction selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccAdministrativeSanction record);

    int updateByPrimaryKey(QccAdministrativeSanction record);
}