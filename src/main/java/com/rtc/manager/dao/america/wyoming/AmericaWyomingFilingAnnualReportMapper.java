package com.rtc.manager.dao.america.wyoming;

import com.rtc.manager.entity.america.wyoming.AmericaWyomingFilingAnnualReport;

public interface AmericaWyomingFilingAnnualReportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaWyomingFilingAnnualReport record);

    int insertSelective(AmericaWyomingFilingAnnualReport record);

    AmericaWyomingFilingAnnualReport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaWyomingFilingAnnualReport record);

    int updateByPrimaryKey(AmericaWyomingFilingAnnualReport record);
}