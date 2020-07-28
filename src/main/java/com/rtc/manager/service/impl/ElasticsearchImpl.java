package com.rtc.manager.service.impl;

import com.rtc.manager.service.Elasticsearch;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Service;

/**
 * @author ChenHang
 */
@Service
public class ElasticsearchImpl implements Elasticsearch {

    @Override
    public Object getTest() {
        return null;
    }

    @Override
    public void addTest() {
        IndexRequest request = new IndexRequest("twitter");
        request.id("1");
        String jsonString = "{" +
                "\"field1\":\"kimchy\"" +
                "}";
        request.source(jsonString, XContentType.JSON);
    }

    @Override
    public Object removeTest() {
        return null;
    }


}
