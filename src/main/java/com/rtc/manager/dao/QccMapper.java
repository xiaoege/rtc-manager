package com.rtc.manager.dao;

import com.rtc.manager.entity.Qcc;
import com.rtc.manager.vo.QccListVO;
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

    List<QccListVO> selectByName(@Param("name") String name);

    QccVO selectByEnterpriseId(@Param("enterpriseId") String enterpriseId);
}