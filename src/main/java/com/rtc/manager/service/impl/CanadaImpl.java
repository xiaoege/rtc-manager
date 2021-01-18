package com.rtc.manager.service.impl;

import com.rtc.manager.dao.canada.CanadaMapper;
import com.rtc.manager.service.Canada;
import com.rtc.manager.vo.canada.CanadaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ChenHang
 */
@Service
public class CanadaImpl implements Canada {
    @Autowired
    private CanadaMapper canadaMapper;

    @Override
    public Object getCanadaEnterprise(String enterpriseId, String userId, String timeZone) {
        CanadaVO vo = canadaMapper.selectCanadaEnterprise(enterpriseId);
        if (vo != null) {
            if (canadaMapper.checkFavouriteCanada(enterpriseId, userId) != null) {
                vo.setFavourite(1);
            }
        }
        return vo;
    }
}
