package com.rtc.manager.dao;

import com.rtc.manager.entity.QccWeibo;

public interface QccWeiboMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccWeibo record);

    int insertSelective(QccWeibo record);

    QccWeibo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccWeibo record);

    int updateByPrimaryKey(QccWeibo record);
}