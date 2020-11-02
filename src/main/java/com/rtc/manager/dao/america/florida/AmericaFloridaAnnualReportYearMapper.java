package com.rtc.manager.dao.america.florida;

import com.rtc.manager.entity.america.florida.AmericaFloridaAnnualReportYear;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AmericaFloridaAnnualReportYearMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaFloridaAnnualReportYear record);

    int insertSelective(AmericaFloridaAnnualReportYear record);

    AmericaFloridaAnnualReportYear selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaFloridaAnnualReportYear record);

    int updateByPrimaryKey(AmericaFloridaAnnualReportYear record);

    void insertList(@Param("dtoList") List dtoList , @Param("enterpriseId") String enterpriseId);
}