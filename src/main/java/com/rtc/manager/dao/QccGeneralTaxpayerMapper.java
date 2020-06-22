package com.rtc.manager.dao;

import com.rtc.manager.entity.QccGeneralTaxpayer;

public interface QccGeneralTaxpayerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccGeneralTaxpayer record);

    int insertSelective(QccGeneralTaxpayer record);

    QccGeneralTaxpayer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccGeneralTaxpayer record);

    int updateByPrimaryKey(QccGeneralTaxpayer record);
}