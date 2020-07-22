package com.rtc.manager.dao;

import com.rtc.manager.entity.QccTaxViolation;

public interface QccTaxViolationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccTaxViolation record);

    int insertSelective(QccTaxViolation record);

    QccTaxViolation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccTaxViolation record);

    int updateByPrimaryKey(QccTaxViolation record);
}