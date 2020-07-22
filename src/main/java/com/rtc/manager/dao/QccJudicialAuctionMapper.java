package com.rtc.manager.dao;

import com.rtc.manager.entity.QccJudicialAuction;

public interface QccJudicialAuctionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccJudicialAuction record);

    int insertSelective(QccJudicialAuction record);

    QccJudicialAuction selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccJudicialAuction record);

    int updateByPrimaryKey(QccJudicialAuction record);
}