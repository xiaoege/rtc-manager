package com.rtc.manager.service;

import com.rtc.manager.vo.ResultData;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ChenHang
 */
public interface EnterpriseManage {
    /**
     * 搜索企业-列表
     *
     * @param name
     * @param idx
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    ResultData listEnterprise(String name, String idx, int pageNum, int pageSize) throws Exception;

    /**
     * 上传logo图片
     *
     * @return 可访问的临时地址
     */
    ResultData uploadLogo(MultipartFile file) throws Exception;

    /**
     * 新增企业-单个
     * @param body
     * @param nation 国家
     * @param eType 地区
     * @return
     */
    ResultData addEnterprise(String body, String nation, String eType) throws Exception;

    /**
     * 企业修改-es/mysql
     * @param body
     * @param nation
     * @param eType
     * @return
     * @throws Exception
     */
    ResultData modifyEnterprise(String body, String nation, String eType, String esId, String enterpriseId, String timezone) throws Exception;

}
