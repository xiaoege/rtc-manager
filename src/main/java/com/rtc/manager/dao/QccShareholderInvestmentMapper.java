package com.rtc.manager.dao;

import com.rtc.manager.entity.QccShareholderInvestment;

public interface QccShareholderInvestmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccShareholderInvestment record);

    int insertSelective(QccShareholderInvestment record);

    QccShareholderInvestment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccShareholderInvestment record);

    int updateByPrimaryKey(QccShareholderInvestment record);
}