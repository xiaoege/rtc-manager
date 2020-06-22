package com.rtc.manager.dao;

import com.rtc.manager.entity.QccTaxCredit;

public interface QccTaxCreditMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccTaxCredit record);

    int insertSelective(QccTaxCredit record);

    QccTaxCredit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccTaxCredit record);

    int updateByPrimaryKey(QccTaxCredit record);
}