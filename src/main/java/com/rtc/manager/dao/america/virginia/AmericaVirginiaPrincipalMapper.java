package com.rtc.manager.dao.america.virginia;

import com.rtc.manager.entity.america.virginia.AmericaVirginiaPrincipal;

public interface AmericaVirginiaPrincipalMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaVirginiaPrincipal record);

    int insertSelective(AmericaVirginiaPrincipal record);

    AmericaVirginiaPrincipal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaVirginiaPrincipal record);

    int updateByPrimaryKey(AmericaVirginiaPrincipal record);
}