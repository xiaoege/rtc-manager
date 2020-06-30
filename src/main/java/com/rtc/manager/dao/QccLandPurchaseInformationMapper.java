package com.rtc.manager.dao;

import com.rtc.manager.entity.QccLandPurchaseInformation;

public interface QccLandPurchaseInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccLandPurchaseInformation record);

    int insertSelective(QccLandPurchaseInformation record);

    QccLandPurchaseInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccLandPurchaseInformation record);

    int updateByPrimaryKey(QccLandPurchaseInformation record);
}