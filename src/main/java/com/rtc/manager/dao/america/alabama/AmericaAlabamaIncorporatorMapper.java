package com.rtc.manager.dao.america.alabama;

import com.rtc.manager.entity.america.alabama.AmericaAlabamaIncorporator;

public interface AmericaAlabamaIncorporatorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaAlabamaIncorporator record);

    int insertSelective(AmericaAlabamaIncorporator record);

    AmericaAlabamaIncorporator selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaAlabamaIncorporator record);

    int updateByPrimaryKey(AmericaAlabamaIncorporator record);
}