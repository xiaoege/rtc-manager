package com.rtc.manager.dao;

import com.github.pagehelper.PageInfo;
import com.rtc.manager.entity.Qcc;
import com.rtc.manager.vo.QccVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QccMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Qcc record);

    int insertSelective(Qcc record);

    Qcc selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Qcc record);

    int updateByPrimaryKey(Qcc record);

    List<QccVO> selectByName(@Param("name") String name, @Param("orderType") Integer orderType);

    QccVO selectByEnterpriseId(@Param("enterpriseId") String enterpriseId);
}