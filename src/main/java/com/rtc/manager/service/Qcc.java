package com.rtc.manager.service;

import com.github.pagehelper.PageInfo;
import com.rtc.manager.vo.QccVO;

/**
 * @author ChenHang
 */
public interface Qcc {
    /**
     * 搜索企业-列表
     * @param name 企业名
     * @param orderType 排列规则-国别/字母
     * @return
     */
    PageInfo<QccVO> listEnterprise(String name, Integer orderType, int pageNum, int pageSize);

    PageInfo<QccVO> getEnterprise(String enterpriseId, int pageNum, int pageSize);
}
