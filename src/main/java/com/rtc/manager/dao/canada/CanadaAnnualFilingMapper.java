package com.rtc.manager.dao.canada;

import com.rtc.manager.entity.canada.CanadaAnnualFiling;

public interface CanadaAnnualFilingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CanadaAnnualFiling record);

    int insertSelective(CanadaAnnualFiling record);

    CanadaAnnualFiling selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CanadaAnnualFiling record);

    int updateByPrimaryKey(CanadaAnnualFiling record);
}