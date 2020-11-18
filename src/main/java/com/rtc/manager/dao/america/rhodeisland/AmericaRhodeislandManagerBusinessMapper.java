package com.rtc.manager.dao.america.rhodeisland;

import com.rtc.manager.entity.america.rhodeisland.AmericaRhodeislandManagerBusiness;

import java.util.List;

public interface AmericaRhodeislandManagerBusinessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaRhodeislandManagerBusiness record);

    int insertSelective(AmericaRhodeislandManagerBusiness record);

    AmericaRhodeislandManagerBusiness selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaRhodeislandManagerBusiness record);

    int updateByPrimaryKey(AmericaRhodeislandManagerBusiness record);

    void insertList(List<AmericaRhodeislandManagerBusiness> managerBusinessList);

}