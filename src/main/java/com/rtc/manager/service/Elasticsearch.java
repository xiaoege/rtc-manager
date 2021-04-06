package com.rtc.manager.service;

import com.rtc.manager.vo.ResultData;

/**
 * @author ChenHang
 */
public interface Elasticsearch {

    Object getTest() throws Exception;

    void addTest() throws Exception;

    Object removeTest();

    Object search(String index, String field, String value) throws Exception;

    Object modify(String index, String document) throws Exception;

    Object remove(String index, String document) throws Exception;

    ResultData initBulletin();

    /**
     * 企业删除-es/mysql-多个
     *
     * @return
     */
    ResultData delEnterprise(String body);

    int addEnterprise(Object object, String idx) throws Exception;

    /**
     * @param nation              国家
     * @param eType               类型(国家次一级)
     * @param pid                 mysql-id
     * @param enterpriseId        内部id
     * @param name                企业名
     * @param address             地址
     * @param establishmentDate   成立日期
     * @param enterpriseCode      企业编号
//     * @param legalRepresentative 法人代表
     * @param createTime          创建时间-pattern:yyyy-MM-dd HH:mm:ss
     * @param idx                 es-index
     * @return
     * @throws Exception
     */
    int addEnterprise(String nation, String eType, Integer pid, String enterpriseId,
                      String name, String address, String establishmentDate,
                      String enterpriseCode, String createTime, String idx) throws Exception;

    int modifyEnterprise(String nation, String eType, Integer pid, String enterpriseId,
                         String name, String address, String establishmentDate,
                         String enterpriseCode, String createTime, String idx, String esId) throws Exception;
}
