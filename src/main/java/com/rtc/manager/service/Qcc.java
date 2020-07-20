package com.rtc.manager.service;

import com.github.pagehelper.PageInfo;
import com.rtc.manager.vo.QccListVO;
import com.rtc.manager.vo.QccVO;

import java.util.List;

/**
 * @author ChenHang
 */
public interface Qcc {
    /**
     * 搜索企业-列表
     * @param name 企业名
     * @return
     */
    PageInfo<QccListVO> listEnterprise(String name, int pageNum, int pageSize);

    QccVO getEnterprise(String enterpriseId);

    PageInfo<List> getEnterpriseDetail(String name, String enterpriseId, int pageNum, int pageSize);

    Object getEnterpriseSubDetail(String name, Integer id);
}
