package com.rtc.manager.service.impl;

import com.rtc.manager.dao.utils.UtilsMapper;
import com.rtc.manager.service.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author ChenHang
 */
@Service
public class UtilsServiceImpl implements UtilsService {
    @Autowired
    private UtilsMapper utilsMapper;

    @Override
    public HashMap getAccessKey(String account) {
        return utilsMapper.selectAccessKey(account);
    }

    @Override
    public String[] getEsIndices() {
        return utilsMapper.selectEsIndices();
    }
}
