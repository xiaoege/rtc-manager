package com.rtc.manager.service.impl;

import com.rtc.manager.dao.SaveJsonMapper;
import com.rtc.manager.service.SaveJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ChenHang
 */
@Service
public class SaveJsonImpl implements SaveJson {

    @Autowired
    private SaveJsonMapper saveJsonMapper;

    @Override
    public String getTest() {
        return saveJsonMapper.getTest();
    }
}
