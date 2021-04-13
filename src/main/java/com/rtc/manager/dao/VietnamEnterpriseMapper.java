package com.rtc.manager.dao;

import com.rtc.manager.entity.vietnam.VietnamEnterprise;
import com.rtc.manager.vo.vietnam.VietnamEnterpriseVO;
import org.apache.ibatis.annotations.Param;

public interface VietnamEnterpriseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VietnamEnterprise record);

    int insertSelective(VietnamEnterprise record);

    VietnamEnterprise selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VietnamEnterprise record);

    int updateByPrimaryKey(VietnamEnterprise record);

    VietnamEnterpriseVO selectVietnamEnterprise(String enterpriseId);

    String checkFavouriteVietnam(@Param("enterpriseId") String enterpriseId, @Param("userId") String userId);
}