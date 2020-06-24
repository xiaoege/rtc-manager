package com.rtc.manager.service.impl;

import com.rtc.manager.dao.RtcEnterpriseMapper;
import com.rtc.manager.service.RtcEnterprise;
import com.rtc.manager.vo.RtcEnterpriseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ChenHang
 */
@Service
public class RtcEnterpriseImpl implements RtcEnterprise {
    @Autowired
    private RtcEnterpriseMapper rtcEnterpriseMapper;

    @Override
    public List<RtcEnterpriseVO> listEnterprise(String name) {
        return rtcEnterpriseMapper.selectByName(name);
    }
}
