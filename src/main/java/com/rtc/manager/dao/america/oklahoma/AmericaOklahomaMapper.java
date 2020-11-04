package com.rtc.manager.dao.america.oklahoma;

import com.rtc.manager.entity.america.oklahoma.AmericaOklahoma;
import com.rtc.manager.entity.dto.AmericaOklahomaDTO;

import java.util.List;

public interface AmericaOklahomaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaOklahoma record);

    int insertSelective(AmericaOklahoma record);

    AmericaOklahoma selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaOklahoma record);

    int updateByPrimaryKey(AmericaOklahoma record);

    void insertList(List<AmericaOklahomaDTO> list);
}