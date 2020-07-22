package com.rtc.manager.dao;

import com.rtc.manager.entity.QccOutInvestment;

public interface QccOutInvestmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccOutInvestment record);

    int insertSelective(QccOutInvestment record);

    QccOutInvestment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccOutInvestment record);

    int updateByPrimaryKey(QccOutInvestment record);
}