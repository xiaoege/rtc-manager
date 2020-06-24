package com.rtc.manager.dao;

import com.rtc.manager.entity.RtcEnterprise;
import com.rtc.manager.vo.RtcEnterpriseVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RtcEnterpriseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RtcEnterprise record);

    int insertSelective(RtcEnterprise record);

    RtcEnterprise selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RtcEnterprise record);

    int updateByPrimaryKey(RtcEnterprise record);

    List<RtcEnterpriseVO> selectByName(@Param("name") String name);
}