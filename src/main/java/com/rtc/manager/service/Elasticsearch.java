package com.rtc.manager.service;

import java.io.IOException;

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
}
