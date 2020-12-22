package com.rtc.manager.dao.america.massachusetts;

import com.rtc.manager.entity.america.massachusetts.AmericaMassachusettsOtherManager;

import java.util.List;

public interface AmericaMassachusettsOtherManagerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaMassachusettsOtherManager record);

    int insertSelective(AmericaMassachusettsOtherManager record);

    AmericaMassachusettsOtherManager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaMassachusettsOtherManager record);

    int updateByPrimaryKey(AmericaMassachusettsOtherManager record);

    void insertList(List<AmericaMassachusettsOtherManager> o);
}