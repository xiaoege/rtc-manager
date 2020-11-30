package com.rtc.manager.dao.america.minnesota;

import com.rtc.manager.entity.america.minnesota.AmericaMinnesotaMarkholder;

import java.util.List;

public interface AmericaMinnesotaMarkholderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaMinnesotaMarkholder record);

    int insertSelective(AmericaMinnesotaMarkholder record);

    AmericaMinnesotaMarkholder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaMinnesotaMarkholder record);

    int updateByPrimaryKey(AmericaMinnesotaMarkholder record);

    void insertList(List<AmericaMinnesotaMarkholder> markholderList);

}