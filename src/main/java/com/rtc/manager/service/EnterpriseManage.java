package com.rtc.manager.service;

import com.rtc.manager.vo.ResultData;

/**
 * @author ChenHang
 */
public interface EnterpriseManage {
    /**
     * 搜索企业-列表
     * @param name
     * @param idx
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    ResultData listEnterprise(String name, String idx, int pageNum, int pageSize) throws Exception;
}
