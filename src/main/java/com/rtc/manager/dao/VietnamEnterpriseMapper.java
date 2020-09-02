package com.rtc.manager.dao;

import com.rtc.manager.entity.vietnam.VietnamEnterprise;

public interface VietnamEnterpriseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VietnamEnterprise record);

    int insertSelective(VietnamEnterprise record);

    VietnamEnterprise selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VietnamEnterprise record);

    int updateByPrimaryKey(VietnamEnterprise record);

    Object selectIndiaEnterprise(String enterpriseId);
}