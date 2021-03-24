package com.rtc.manager.util;

import com.rtc.manager.service.UtilsService;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${rtc.es.max-result-window}")
    private Integer maxResultWindow;

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
     *
     * @param index index
     * @return
     * @throws IOException
     */
    public static boolean indexExists(String index) throws IOException {
        GetIndexRequest request = new GetIndexRequest();
        request.indices(index);
        return client.indices().exists(request, RequestOptions.DEFAULT);
    }

    /**
     * 检查查询的页数
     *
     * @param size size = pageNum * pageSize + pageSize，必须小于es的max-result-window
     * @return
     */
    public boolean checkMaxResultWindow(Integer size) {
        if (this.maxResultWindow.compareTo(size) > 0) {
            return true;
        }
        return false;
    }

    /**
     * 检查查询的页数，如果不小于maxResultWindow，则将其设置为maxResultWindow - pageSize
     * @param searchSourceBuilder
     * @param page 当前页数
     * @param pageSize 当前页大小
     */
    public void resetQueryPage(SearchSourceBuilder searchSourceBuilder, Integer page, Integer pageSize) {
        if (this.checkMaxResultWindow(page)) {
            searchSourceBuilder.size(pageSize);
            searchSourceBuilder.from(page);
        } else {
            searchSourceBuilder.size(pageSize);
            searchSourceBuilder.from(maxResultWindow - pageSize);
        }
    }

}
