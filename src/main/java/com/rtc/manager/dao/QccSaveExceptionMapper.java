package com.rtc.manager.dao;

import com.rtc.manager.entity.QccSaveException;

public interface QccSaveExceptionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccSaveException record);

    int insertSelective(QccSaveException record);

    QccSaveException selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccSaveException record);

    int updateByPrimaryKey(QccSaveException record);
}