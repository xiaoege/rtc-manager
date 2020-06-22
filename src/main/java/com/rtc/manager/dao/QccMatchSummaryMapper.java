package com.rtc.manager.dao;

import com.rtc.manager.entity.QccMatchSummary;

public interface QccMatchSummaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccMatchSummary record);

    int insertSelective(QccMatchSummary record);

    QccMatchSummary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccMatchSummary record);

    int updateByPrimaryKey(QccMatchSummary record);
}