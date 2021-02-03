package com.rtc.manager.service;

import com.github.pagehelper.PageInfo;
import com.rtc.manager.vo.ResultData;
import com.rtc.manager.vo.SearchEnterpriseListVO;

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
    ResultData listEnterprise(String name, int pageNum, int pageSize) throws Exception;

    Object getEnterprise(String enterpriseId, String nation, String eType, String timeZone) throws Exception;

    PageInfo<List> getEnterpriseDetail(String name, String enterpriseId, int pageNum, int pageSize, String nation, String eType);

    Object getEnterpriseSubDetail(String name, Integer id, String nation, String eType);

    Object getEnterpriseSubDetailMuti(String name, String enterpriseId, Integer id, int pageNum, int pageSize, String nation, String eType);

    /**
     * 查看企业的所有评论
     * @param enterpriseId
     * @param timeZone
     * @param pageNum
     * @param pageSize
     * @return
     */
    ResultData listEnterpriseComment(String enterpriseId, String timeZone, int pageNum, int pageSize);

    /**
     * 查询企业列表-Bulletin，用于app主页企业列表展示
     * @return 每次返回10个
     * @param size
     */
    ResultData<SearchEnterpriseListVO> listEnterprise4Bulletin(int size);

    /**
     * 搜索企业-企业推荐
     *
     * @param name 企业名
     * @return 默认返回10个
     */
    ResultData<SearchEnterpriseListVO> listRecommend(String name, int pageSize) throws Exception;
}
