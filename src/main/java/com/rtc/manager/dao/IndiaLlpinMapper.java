package com.rtc.manager.dao;

import com.rtc.manager.entity.india.IndiaLlpin;
import com.rtc.manager.vo.india.IndiaLlpinEnterpriseVO;
import org.apache.ibatis.annotations.Param;

public interface IndiaLlpinMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IndiaLlpin record);

    int insertSelective(IndiaLlpin record);

    IndiaLlpin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndiaLlpin record);

    int updateByPrimaryKey(IndiaLlpin record);

    IndiaLlpinEnterpriseVO selectEnterprise(String enterpriseId);

    String checkFavouriteIndiaLlpin(@Param("enterpriseId") String enterpriseId, @Param("userId") String userId);
}