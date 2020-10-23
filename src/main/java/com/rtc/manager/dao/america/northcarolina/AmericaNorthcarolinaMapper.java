package com.rtc.manager.dao.america.northcarolina;

import com.rtc.manager.entity.america.northcarolina.AmericaNorthcarolina;
import com.rtc.manager.vo.america.northcarolina.AmericaNorthcarolinaVO;
import org.apache.ibatis.annotations.Param;

public interface AmericaNorthcarolinaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaNorthcarolina record);

    int insertSelective(AmericaNorthcarolina record);

    AmericaNorthcarolina selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaNorthcarolina record);

    int updateByPrimaryKey(AmericaNorthcarolina record);

    AmericaNorthcarolinaVO selectNorthcarolinaEnterprise(String enterpriseId);

    String checkFavouriteNorthcarolina(@Param("enterpriseId") String enterpriseId, @Param("userId") String userId);
}