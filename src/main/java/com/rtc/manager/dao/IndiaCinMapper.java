package com.rtc.manager.dao;

import com.rtc.manager.entity.india.IndiaCin;

public interface IndiaCinMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IndiaCin record);

    int insertSelective(IndiaCin record);

    IndiaCin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndiaCin record);

    int updateByPrimaryKey(IndiaCin record);

    Object selectEnterprise(String enterpriseId);
}