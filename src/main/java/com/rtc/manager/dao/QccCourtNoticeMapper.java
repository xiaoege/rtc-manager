package com.rtc.manager.dao;

import com.rtc.manager.entity.QccCourtNotice;

public interface QccCourtNoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccCourtNotice record);

    int insertSelective(QccCourtNotice record);

    QccCourtNotice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccCourtNotice record);

    int updateByPrimaryKey(QccCourtNotice record);
}