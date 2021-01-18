package com.rtc.manager.dao.canada;

import com.rtc.manager.entity.canada.Canada;
import com.rtc.manager.vo.canada.CanadaVO;
import org.apache.ibatis.annotations.Param;

public interface CanadaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Canada record);

    int insertSelective(Canada record);

    Canada selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Canada record);

    int updateByPrimaryKey(Canada record);

    CanadaVO selectCanadaEnterprise(String enterpriseId);

    String checkFavouriteCanada(@Param(("enterpriseId")) String enterpriseId, @Param("userId") String userId);
}