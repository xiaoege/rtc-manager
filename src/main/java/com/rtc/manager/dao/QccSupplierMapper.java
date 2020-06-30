package com.rtc.manager.dao;

import com.rtc.manager.entity.QccSupplier;

public interface QccSupplierMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccSupplier record);

    int insertSelective(QccSupplier record);

    QccSupplier selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccSupplier record);

    int updateByPrimaryKey(QccSupplier record);
}