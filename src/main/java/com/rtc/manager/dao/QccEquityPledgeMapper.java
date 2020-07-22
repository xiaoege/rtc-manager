package com.rtc.manager.dao;

import com.rtc.manager.entity.QccEquityPledge;

public interface QccEquityPledgeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccEquityPledge record);

    int insertSelective(QccEquityPledge record);

    QccEquityPledge selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccEquityPledge record);

    int updateByPrimaryKey(QccEquityPledge record);
}