package com.rtc.manager.dao.america.oregon;

import com.rtc.manager.entity.america.oregon.AmericaOregonAssociate;

import java.util.List;

public interface AmericaOregonAssociateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaOregonAssociate record);

    int insertSelective(AmericaOregonAssociate record);

    AmericaOregonAssociate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaOregonAssociate record);

    int updateByPrimaryKey(AmericaOregonAssociate record);

    void insertList(List<AmericaOregonAssociate> q);
}