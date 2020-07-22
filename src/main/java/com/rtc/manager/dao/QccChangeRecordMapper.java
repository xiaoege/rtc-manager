package com.rtc.manager.dao;

import com.rtc.manager.entity.QccChangeRecord;

public interface QccChangeRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccChangeRecord record);

    int insertSelective(QccChangeRecord record);

    QccChangeRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccChangeRecord record);

    int updateByPrimaryKey(QccChangeRecord record);
}