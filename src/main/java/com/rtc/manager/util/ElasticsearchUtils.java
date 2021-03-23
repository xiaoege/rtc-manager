package com.rtc.manager.util;

import com.rtc.manager.service.UtilsService;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * @author ChenHang
 */
@Component
public class ElasticsearchUtils {

    @Autowired
    private UtilsService utilsService;

    private ElasticsearchUtils() {
    }

    private static RestHighLevelClient client = new RestHighLevelClient(
            RestClient.builder(
                    new HttpHost("localhost", 9200, "http")));

    public static RestHighLevelClient getClient() {
        return client;
    }

    public String[] getEsIndices() {
        List<String> idx = utilsService.getRtcRefCountry("idx");
        return idx.toArray(new String[idx.size()]);
    }

    /**
     * 查看es是否存在该index
     * @param index index
     * @return
     * @throws IOException
     */
    public static boolean indexExists(String index) throws IOException {
        GetIndexRequest request = new GetIndexRequest();
        request.indices(index);
        return client.indices().exists(request, RequestOptions.DEFAULT);
    }

}
