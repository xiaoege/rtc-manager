package com.rtc.manager.service;

/**
 * @author ChenHang
 */
public interface Elasticsearch {

    Object getTest() throws Exception;

    void addTest() throws Exception;

    Object removeTest();

    Object search(String index, String field, String value) throws Exception;
}
