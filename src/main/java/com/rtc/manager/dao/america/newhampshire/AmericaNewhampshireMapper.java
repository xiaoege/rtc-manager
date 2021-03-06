package com.rtc.manager.dao.america.newhampshire;

import com.rtc.manager.entity.america.newhampshire.AmericaNewhampshire;
import com.rtc.manager.vo.america.newhampshire.AmericaNewhampshireVO;
import org.apache.ibatis.annotations.Param;

public interface AmericaNewhampshireMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaNewhampshire record);

    int insertSelective(AmericaNewhampshire record);

    AmericaNewhampshire selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaNewhampshire record);

    int updateByPrimaryKey(AmericaNewhampshire record);

    AmericaNewhampshireVO selectNewhampshireEnterprise(String enterpriseId);

    String checkFavouriteNewhampshire(@Param("enterpriseId") String enterpriseId, @Param("userId") String userId);
}