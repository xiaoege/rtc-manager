package com.rtc.manager.service;

import com.github.pagehelper.PageInfo;
import com.rtc.manager.vo.EnterpriseListResultData;

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
    EnterpriseListResultData listEnterprise(String name, int pageNum, int pageSize) throws Exception;

    Object getEnterprise(String enterpriseId, String nation, String eType) throws Exception;

    PageInfo<List> getEnterpriseDetail(String name, String enterpriseId, int pageNum, int pageSize, String nation, String eType);

    Object getEnterpriseSubDetail(String name, Integer id, String nation, String eType);

    Object getEnterpriseSubDetailMuti(String name, String enterpriseId, Integer id, int pageNum, int pageSize, String nation, String eType);
}
