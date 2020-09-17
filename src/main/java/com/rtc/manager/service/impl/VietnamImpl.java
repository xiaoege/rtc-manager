package com.rtc.manager.service.impl;

import com.rtc.manager.dao.RtcUserCommentMapper;
import com.rtc.manager.dao.VietnamEnterpriseMapper;
import com.rtc.manager.service.Vietnam;
import com.rtc.manager.util.CommonUtils;
import com.rtc.manager.vo.RtcUserCommentVO;
import com.rtc.manager.vo.vietnam.VietnamEnterpriseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

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
    public Object getIndiaEnterprise(String enterpriseId, String userId, String timeZone) {
        VietnamEnterpriseVO vo = vietnamEnterpriseMapper.selectIndiaEnterprise(enterpriseId);
        if (vo != null) {
            List<RtcUserCommentVO> commentList = rtcUserCommentMapper.selectCommentByEnterpriseId(enterpriseId);
            if (!ObjectUtils.isEmpty(commentList)) {
                for (int i = 0; i < commentList.size(); i++) {
                    RtcUserCommentVO commentVO = commentList.get(i);
                    commentVO.setIntervalTime(CommonUtils.compareTime(timeZone, commentVO.getGmtCreate()));
                }
            }
            vo.setCommentList(commentList);
            if (vietnamEnterpriseMapper.checkFavouriteVietnam(enterpriseId, userId) != null) {
                vo.setFavourite(1);
            }
        }
        return vo;
    }
}
