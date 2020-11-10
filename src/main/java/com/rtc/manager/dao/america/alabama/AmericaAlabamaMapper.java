package com.rtc.manager.dao.america.alabama;

import com.rtc.manager.entity.america.alabama.AmericaAlabama;
import com.rtc.manager.vo.america.alabama.AmericaAlabamaVO;
import org.apache.ibatis.annotations.Param;

public interface AmericaAlabamaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaAlabama record);

    int insertSelective(AmericaAlabama record);

    AmericaAlabama selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaAlabama record);

    int updateByPrimaryKey(AmericaAlabama record);

    AmericaAlabamaVO selectAlabamaEnterprise(String enterpriseId);

    String checkFavouriteAmericaAlabama(@Param("enterpriseId") String enterpriseId, @Param("userId") String userId);
}