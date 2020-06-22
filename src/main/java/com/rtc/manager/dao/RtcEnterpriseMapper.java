package com.rtc.manager.dao;

import com.rtc.manager.entity.RtcEnterprise;

public interface RtcEnterpriseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RtcEnterprise record);

    int insertSelective(RtcEnterprise record);

    RtcEnterprise selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RtcEnterprise record);

    int updateByPrimaryKey(RtcEnterprise record);
}