package com.rtc.manager.dao;

import com.rtc.manager.entity.QccTaxArrearsNotice;

public interface QccTaxArrearsNoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccTaxArrearsNotice record);

    int insertSelective(QccTaxArrearsNotice record);

    QccTaxArrearsNotice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccTaxArrearsNotice record);

    int updateByPrimaryKey(QccTaxArrearsNotice record);
}