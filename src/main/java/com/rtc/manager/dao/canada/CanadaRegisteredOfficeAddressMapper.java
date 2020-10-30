package com.rtc.manager.dao.canada;

import com.rtc.manager.entity.canada.CanadaRegisteredOfficeAddress;

public interface CanadaRegisteredOfficeAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CanadaRegisteredOfficeAddress record);

    int insertSelective(CanadaRegisteredOfficeAddress record);

    CanadaRegisteredOfficeAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CanadaRegisteredOfficeAddress record);

    int updateByPrimaryKey(CanadaRegisteredOfficeAddress record);
}