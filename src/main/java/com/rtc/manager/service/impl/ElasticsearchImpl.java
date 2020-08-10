package com.rtc.manager.service.impl;

import com.rtc.manager.service.Elasticsearch;
import org.apache.http.HttpHost;
import org.apache.lucene.search.TotalHits;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author ChenHang
 */
@Service
public class ElasticsearchImpl implements Elasticsearch {

    Logger logger = LoggerFactory.getLogger(ElasticsearchImpl.class);

    RestHighLevelClient client = new RestHighLevelClient(
            RestClient.builder(
                    new HttpHost("localhost", 9200, "http")));

    @Override
    public void addTest() throws Exception {
        IndexRequest request = new IndexRequest("posts");
        request.id("1");
        String jsonString = "{" +
                "\"user\":\"kimchy\"," +
                "\"postDate\":\"2013-01-30\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";
        request.source(jsonString, XContentType.JSON);
        IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
        String index = indexResponse.getIndex();
        String id = indexResponse.getId();

        client.close();
    }

    @Override
    public Object getTest() throws Exception {
        GetRequest request = new GetRequest(
                "posts111",
                "11");
        GetResponse getResponse = client.get(request, RequestOptions.DEFAULT);
        Map<String, Object> documentField = getResponse.getSource();
        boolean exists = client.exists(request, RequestOptions.DEFAULT);
//        GetSourceRequest getSourceRequest = new GetSourceRequest("bank", "1");
//        GetSourceResponse response = client.getSource(getSourceRequest, RequestOptions.DEFAULT);
//        Map<String, Object> source = response.getSource();

        return null;
    }

    @Override
    public Object removeTest() {
        return null;
    }


    @Override
    public Object search(String index, String field, String value) throws Exception {
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.sort(new FieldSortBuilder("_id").order(SortOrder.DESC));
//        searchSourceBuilder.from(5);
        searchSourceBuilder.size(20);
        searchSourceBuilder.timeout(new TimeValue(2, TimeUnit.SECONDS));
//        searchRequest.scroll(TimeValue.timeValueMillis(10));
        // 查所有
//        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
//        searchSourceBuilder.query(QueryBuilders.matchQuery("employer", "Xerex"));
//        searchSourceBuilder.query(QueryBuilders.termQuery("lastname", "duke"));
        MatchPhraseQueryBuilder matchPhraseQueryBuilder = new MatchPhraseQueryBuilder(field, value);


        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder(field, value);
        matchQueryBuilder.fuzziness(Fuzziness.AUTO);
        matchQueryBuilder.prefixLength(3);
        matchQueryBuilder.maxExpansions(10);
//        searchSourceBuilder.query(matchQueryBuilder);
        searchSourceBuilder.query(matchPhraseQueryBuilder);
        searchRequest.indices(index);
        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = searchResponse.getHits();
        String scrollId = searchResponse.getScrollId();
        TotalHits totalHits = hits.getTotalHits();
        SearchHit[] searchHits = hits.getHits();
        List resultList = new ArrayList();
        for (SearchHit s :
                searchHits) {
            Map<String, Object> sourceAsMap = s.getSourceAsMap();
            String sourceAsString = s.getSourceAsString();
            System.out.println(sourceAsMap);
            System.out.println(sourceAsString);
            resultList.add(sourceAsMap);
        }

        logger.info("searchRequest：{}", searchRequest);
        logger.info("searchSourceBuilder：{}", searchSourceBuilder);
        logger.info("matchQueryBuilder：{}", matchQueryBuilder);
        logger.info("searchResponse：{}", searchResponse);
        logger.info("hits：{}", hits);
        logger.info("totalHits：{}", totalHits);
        logger.info("scrollId：{}", scrollId);
        logger.info("searchHits：{}", searchHits);

//        ExplainRequest request = new ExplainRequest("bank", "1");
//        request.query(QueryBuilders.termQuery("user", "tanguy"));

        return resultList;
    }


}
