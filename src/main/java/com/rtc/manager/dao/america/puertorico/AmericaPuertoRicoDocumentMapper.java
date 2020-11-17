package com.rtc.manager.dao.america.puertorico;

import com.rtc.manager.entity.america.puertorico.AmericaPuertoRicoDocument;

import java.util.List;

public interface AmericaPuertoRicoDocumentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AmericaPuertoRicoDocument record);

    int insertSelective(AmericaPuertoRicoDocument record);

    AmericaPuertoRicoDocument selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AmericaPuertoRicoDocument record);

    int updateByPrimaryKey(AmericaPuertoRicoDocument record);

    void insertList(List<AmericaPuertoRicoDocument> documentList);
}