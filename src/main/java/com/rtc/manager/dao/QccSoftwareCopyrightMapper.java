package com.rtc.manager.dao;

import com.rtc.manager.entity.QccSoftwareCopyright;

public interface QccSoftwareCopyrightMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccSoftwareCopyright record);

    int insertSelective(QccSoftwareCopyright record);

    QccSoftwareCopyright selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccSoftwareCopyright record);

    int updateByPrimaryKey(QccSoftwareCopyright record);
}