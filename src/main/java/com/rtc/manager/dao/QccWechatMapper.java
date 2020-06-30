package com.rtc.manager.dao;

import com.rtc.manager.entity.QccWechat;

public interface QccWechatMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccWechat record);

    int insertSelective(QccWechat record);

    QccWechat selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccWechat record);

    int updateByPrimaryKey(QccWechat record);
}