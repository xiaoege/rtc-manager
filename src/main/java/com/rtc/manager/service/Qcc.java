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
     *
     * @param name 企业名
     * @return
     */
    ResultData listEnterprise(String name, String idx, int pageNum, int pageSize) throws Exception;

    Object getEnterprise(String enterpriseId, String nation, String eType, String timeZone) throws Exception;

    PageInfo<List> getEnterpriseDetail(String name, String enterpriseId, int pageNum, int pageSize, String nation, String eType);

    Object getEnterpriseSubDetail(String name, Integer id, String nation, String eType);

    Object getEnterpriseSubDetailMuti(String name, String enterpriseId, Integer id, int pageNum, int pageSize, String nation, String eType);

    /**
     * 查看企业的所有评论
     *
     * @param enterpriseId
     * @param timeZone
     * @param pageNum
     * @param pageSize
     * @return
     */
    ResultData listEnterpriseComment(String enterpriseId, String timeZone, int pageNum, int pageSize);

    /**
     * 查询企业列表-Bulletin，用于app主页企业列表展示
     *
     * @param size
     * @return 每次返回10个
     */
    ResultData<SearchEnterpriseListVO> listEnterprise4Bulletin(int size);

    /**
     * 搜索企业-企业推荐
     *
     * @param name 企业名
     * @return 默认返回10个
     */
    ResultData<SearchEnterpriseListVO> listRecommend(String name, int pageSize) throws Exception;

    /**
     * 获得最近在es中新增的企业名，默认10个
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    ResultData listNewlyAdded(int pageNum, int pageSize) throws Exception;

    /**
     * 中国企业-五大类-新增
     *
     * @param body         五大类详情数据
     * @param category     五大类栏目
     * @param enterpriseId 企业id
     * @return
     */
    ResultData addChinaCategory(String body, String category, String enterpriseId) throws Exception;

    /**
     * 中国企业-五大类-删除
     * 根据五大类的id来删除
     *
     * @param body     id的数组
     * @param category 五大类栏目
     * @return
     */
    ResultData delChinaCategory(String body, String category) throws Exception;

    /**
     * 中国企业-五大类-修改
     *
     * @param body         五大类详情数据
     * @param category     五大类栏目
     * @param enterpriseId 企业id
     * @param id           五大类id
     * @return
     */
    ResultData modifyChinaCategory(String body, String category, String enterpriseId, Integer id) throws Exception;
}
