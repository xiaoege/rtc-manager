package com.rtc.manager.dao;

import com.rtc.manager.entity.india.IndiaCin;
import com.rtc.manager.vo.india.IndiaCinEnterpriseVO;

public interface IndiaCinMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IndiaCin record);

    int insertSelective(IndiaCin record);

    IndiaCin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndiaCin record);

    int updateByPrimaryKey(IndiaCin record);

    IndiaCinEnterpriseVO selectEnterprise(String enterpriseId);
}