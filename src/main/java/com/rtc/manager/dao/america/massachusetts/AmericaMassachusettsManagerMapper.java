package com.rtc.manager.dao.america.massachusetts;

import com.rtc.manager.entity.america.massachusetts.AmericaMassachusettsManager;

import java.util.List;

public interface AmericaMassachusettsManagerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaMassachusettsManager record);

    int insertSelective(AmericaMassachusettsManager record);

    AmericaMassachusettsManager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaMassachusettsManager record);

    int updateByPrimaryKey(AmericaMassachusettsManager record);

    void insertList(List<AmericaMassachusettsManager> o);
}