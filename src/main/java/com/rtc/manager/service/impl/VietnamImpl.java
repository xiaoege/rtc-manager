package com.rtc.manager.service.impl;

import com.rtc.manager.dao.VietnamEnterpriseMapper;
import com.rtc.manager.service.Vietnam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ChenHang
 */
@Service
public class VietnamImpl implements Vietnam {
    @Autowired
    private VietnamEnterpriseMapper vietnamEnterpriseMapper;

    @Override
    public Object getIndiaEnterprise(String enterpriseId) {
        return vietnamEnterpriseMapper.selectIndiaEnterprise(enterpriseId);
    }
}
