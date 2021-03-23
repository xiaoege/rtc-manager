package com.rtc.manager.dao;

import com.rtc.manager.entity.RtcRefCountry;

import java.util.List;

public interface RtcRefCountryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RtcRefCountry record);

    int insertSelective(RtcRefCountry record);

    RtcRefCountry selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RtcRefCountry record);

    int updateByPrimaryKey(RtcRefCountry record);

    List<RtcRefCountry> selectRtcRefCountries();

    String selectTb(String idx);
}