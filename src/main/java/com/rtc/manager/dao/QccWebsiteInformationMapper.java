package com.rtc.manager.dao;

import com.rtc.manager.entity.QccWebsiteInformation;

public interface QccWebsiteInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccWebsiteInformation record);

    int insertSelective(QccWebsiteInformation record);

    QccWebsiteInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccWebsiteInformation record);

    int updateByPrimaryKey(QccWebsiteInformation record);
}