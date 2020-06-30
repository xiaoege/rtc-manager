package com.rtc.manager.dao;

import com.rtc.manager.entity.QccFinancingConsultation;

public interface QccFinancingConsultationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccFinancingConsultation record);

    int insertSelective(QccFinancingConsultation record);

    QccFinancingConsultation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccFinancingConsultation record);

    int updateByPrimaryKey(QccFinancingConsultation record);
}