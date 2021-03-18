package com.rtc.manager.util;

import com.rtc.manager.service.UtilsService;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author ChenHang
 */
@Component
public class ElasticsearchUtils {

    @Autowired
    private UtilsService utilsService;

//    private ElasticsearchUtils() {
//    }

    private static RestHighLevelClient client = new RestHighLevelClient(
            RestClient.builder(
                    new HttpHost("localhost", 9200, "http")));

    public static RestHighLevelClient getClient() {
        return client;
    }

    public String[] getEsIndices() {
        String[] esIndices = utilsService.getEsIndices();
        return esIndices;
    }
}
