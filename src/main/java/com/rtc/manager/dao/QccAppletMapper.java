package com.rtc.manager.dao;

import com.rtc.manager.entity.QccApplet;

public interface QccAppletMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccApplet record);

    int insertSelective(QccApplet record);

    QccApplet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccApplet record);

    int updateByPrimaryKey(QccApplet record);
}