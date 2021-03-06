package com.rtc.manager.service.impl;

import com.rtc.manager.dao.RtcUserCommentMapper;
import com.rtc.manager.dao.VietnamEnterpriseMapper;
import com.rtc.manager.service.Vietnam;
import com.rtc.manager.util.CommonUtils;
import com.rtc.manager.vo.vietnam.VietnamEnterpriseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ChenHang
 */
@Service
public class VietnamImpl implements Vietnam {
    @Autowired
    private VietnamEnterpriseMapper vietnamEnterpriseMapper;

    @Autowired
    private RtcUserCommentMapper rtcUserCommentMapper;

    @Override
    public Object getVietnamEnterprise(String enterpriseId, String userId, String timeZone) {
        VietnamEnterpriseVO vo = vietnamEnterpriseMapper.selectVietnamEnterprise(enterpriseId);
        if (vo != null) {
            CommonUtils.setLogoNameAndColor(vo);
            if (vietnamEnterpriseMapper.checkFavouriteVietnam(enterpriseId, userId) != null) {
                vo.setFavourite(1);
            }
        }
        return vo;
    }
}
