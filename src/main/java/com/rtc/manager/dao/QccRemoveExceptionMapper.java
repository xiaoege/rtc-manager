package com.rtc.manager.dao;

import com.rtc.manager.entity.QccRemoveException;

public interface QccRemoveExceptionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccRemoveException record);

    int insertSelective(QccRemoveException record);

    QccRemoveException selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccRemoveException record);

    int updateByPrimaryKey(QccRemoveException record);
}