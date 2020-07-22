package com.rtc.manager.dao;

import com.rtc.manager.entity.QccEquityOutPledge;

public interface QccEquityOutPledgeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccEquityOutPledge record);

    int insertSelective(QccEquityOutPledge record);

    QccEquityOutPledge selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccEquityOutPledge record);

    int updateByPrimaryKey(QccEquityOutPledge record);
}