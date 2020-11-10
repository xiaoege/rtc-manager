package com.rtc.manager.dao.america.alaska;

import com.rtc.manager.entity.america.alaska.AmericaAlaska;
import com.rtc.manager.entity.dto.AmericaAlaskaDTO;

import java.util.List;

public interface AmericaAlaskaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaAlaska record);

    int insertSelective(AmericaAlaska record);

    AmericaAlaska selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaAlaska record);

    int updateByPrimaryKey(AmericaAlaska record);

    void insertAlaskaExcel(List<AmericaAlaskaDTO> alaskaDTOList);
}