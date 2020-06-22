package com.rtc.manager.dao;

import com.rtc.manager.entity.QccQualificationCertificate;

public interface QccQualificationCertificateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccQualificationCertificate record);

    int insertSelective(QccQualificationCertificate record);

    QccQualificationCertificate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccQualificationCertificate record);

    int updateByPrimaryKey(QccQualificationCertificate record);
}