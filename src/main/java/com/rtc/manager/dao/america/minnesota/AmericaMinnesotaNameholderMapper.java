package com.rtc.manager.dao.america.minnesota;

import com.rtc.manager.entity.america.minnesota.AmericaMinnesotaNameholder;

import java.util.List;

public interface AmericaMinnesotaNameholderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaMinnesotaNameholder record);

    int insertSelective(AmericaMinnesotaNameholder record);

    AmericaMinnesotaNameholder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaMinnesotaNameholder record);

    int updateByPrimaryKey(AmericaMinnesotaNameholder record);

    void insertList(List<AmericaMinnesotaNameholder> nameholderList);

}