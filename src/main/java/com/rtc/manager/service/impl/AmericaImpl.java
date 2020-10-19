package com.rtc.manager.service.impl;

import com.rtc.manager.dao.america.alabama.AmericaAlabamaMapper;
import com.rtc.manager.dao.america.newhampshire.AmericaNewhampshireMapper;
import com.rtc.manager.service.America;
import com.rtc.manager.vo.america.alabama.AmericaAlabamaVO;
import com.rtc.manager.vo.america.newhampshire.AmericaNewhampshireVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ChenHang
 */
@Service
public class AmericaImpl implements America {

    @Autowired
    private AmericaAlabamaMapper alabamaMapper;

    @Autowired
    private AmericaNewhampshireMapper newhampshireMapper;

    @Override
    public Object getAmericaEnterprise(String enterpriseId, String eType, String userId, String timeZone) {
        Object o = null;
        if ("Alabama".equals(eType)) {
            AmericaAlabamaVO vo = alabamaMapper.selectAlabamaEnterprise(enterpriseId);
            o = vo;
        }
        if ("NewHampshire".equals(eType)) {
            AmericaNewhampshireVO vo = newhampshireMapper.selectNewhampshireEnterprise(enterpriseId);
            o = vo;
        }
        return o;
    }
}
