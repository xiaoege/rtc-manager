package com.rtc.manager.dao;

import com.rtc.manager.entity.QccEnvironmentalPunishment;

public interface QccEnvironmentalPunishmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccEnvironmentalPunishment record);

    int insertSelective(QccEnvironmentalPunishment record);

    QccEnvironmentalPunishment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccEnvironmentalPunishment record);

    int updateByPrimaryKey(QccEnvironmentalPunishment record);
}