package com.rtc.manager.dao.america.florida;

import com.rtc.manager.entity.america.florida.AmericaFloridaAnnualReportField;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AmericaFloridaAnnualReportFieldMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaFloridaAnnualReportField record);

    int insertSelective(AmericaFloridaAnnualReportField record);

    AmericaFloridaAnnualReportField selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaFloridaAnnualReportField record);

    int updateByPrimaryKey(AmericaFloridaAnnualReportField record);

}