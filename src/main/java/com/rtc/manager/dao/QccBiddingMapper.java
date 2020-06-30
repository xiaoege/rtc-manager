package com.rtc.manager.dao;

import com.rtc.manager.entity.QccBidding;

public interface QccBiddingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccBidding record);

    int insertSelective(QccBidding record);

    QccBidding selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccBidding record);

    int updateByPrimaryKey(QccBidding record);
}