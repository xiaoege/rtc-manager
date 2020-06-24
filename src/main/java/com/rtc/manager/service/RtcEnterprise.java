package com.rtc.manager.service;

import com.rtc.manager.vo.RtcEnterpriseVO;

import java.util.List;

/**
 * @author ChenHang
 */
public interface RtcEnterprise {
    /**
     * 搜索企业-列表
     * @param name 企业名
     */
    List<RtcEnterpriseVO> listEnterprise(String name);
}
