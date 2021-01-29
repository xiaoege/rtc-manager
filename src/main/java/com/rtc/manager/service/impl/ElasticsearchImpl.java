package com.rtc.manager.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rtc.manager.service.Elasticsearch;
import com.rtc.manager.util.CommonUtils;
import com.rtc.manager.util.ElasticsearchUtils;
import com.rtc.manager.vo.QccListVO;
import com.rtc.manager.vo.ResultData;
import org.apache.lucene.search.TotalHits;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.script.Script;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.ScriptSortBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.*;

/**
 * @author ChenHang
 */
@Service
public class ElasticsearchImpl implements Elasticsearch {

    Logger logger = LoggerFactory.getLogger(ElasticsearchImpl.class);

    private final RestHighLevelClient client = ElasticsearchUtils.getClient();

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${rtc.esIndices}")
    private String[] esIndices;

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
        searchSourceBuilder.size(5);
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
//            resultList.add(sourceAsMap);
            resultList.add(sourceAsString);
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
        List qccList = new ArrayList();
        if (!CollectionUtils.isEmpty(resultList)) {
            for (int i = 0; i < resultList.size(); i++) {
                ObjectMapper objectMapper = new ObjectMapper();
                QccListVO qccListVO = objectMapper.readValue(resultList.get(i).toString(), QccListVO.class);
                qccList.add(qccListVO);
            }
        }


        logger.info("开启多线程");
        // todo
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L,
                TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        threadPoolExecutor.prestartAllCoreThreads();
        if (!CollectionUtils.isEmpty(qccList)) {
            final List<Future> futures = new ArrayList<>();
            for (int i = 0; i < qccList.size(); i++) {
                QccListVO qccListVO = (QccListVO) qccList.get(i);
                String transferMoney = CommonUtils.transferMoney(qccListVO.getRegisteredCapital());
                qccListVO.setRegisteredCapital(transferMoney);

                futures.add(threadPoolExecutor.submit(new Callable<Object>() {
                    @Override
                    public Object call() throws Exception {
                        CommonUtils.translate3(qccListVO.getName(), "zh", "en", qccListVO, "name");
                        CommonUtils.translate3(qccListVO.getAddress(), "zh", "en", qccListVO, "address");
                        CommonUtils.translate3(qccListVO.getLegalRepresentative(), "zh", "en", qccListVO, "legalRepresentative");
                        CommonUtils.translate3(qccListVO.getCountryRegion(), "zh", "en", qccListVO, "countryRegion");
                        return qccListVO;
                    }
                }));

            }

            for (Future<?> f :
                    futures) {
                f.get();
            }

        }
        logger.info("多线程结束");
        return qccList;
    }

    @Override
    public Object modify(String index, String document) throws Exception {
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("updated", Instant.now());
        jsonMap.put("reason", "daily update");
        jsonMap.put("name", "喵喵");
        UpdateRequest updateRequest = new UpdateRequest(index, document).doc(jsonMap);
        UpdateResponse updateResponse = client.update(updateRequest, RequestOptions.DEFAULT);
        String inde = updateResponse.getIndex();
        String id = updateResponse.getId();
        long version = updateResponse.getVersion();


        return null;
    }

    @Override
    public Object remove(String index, String document) throws Exception {
        DeleteRequest deleteRequest = new DeleteRequest(index, document);
        DeleteResponse deleteResponse = client.delete(deleteRequest, RequestOptions.DEFAULT);
        RestStatus status = deleteResponse.status();

        return null;
    }

    /**
     * 每周三下午2点（UTC+8）从es中随机选择5000加入到Redis的bulletin中，之后随机删除掉bulletin 3/4的数据
     *
     * @return
     */
    @Override
    @Scheduled(cron = "0 0 14 ? * WED")
    public ResultData initBulletin() {
        SearchRequest searchRequest = new SearchRequest(esIndices);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        MatchAllQueryBuilder matchAllQueryBuilder = new MatchAllQueryBuilder();
        searchSourceBuilder.query(matchAllQueryBuilder);
        searchSourceBuilder.size(5000);
        Script script = new Script("Math.random()");
        ScriptSortBuilder scriptSortBuilder = new ScriptSortBuilder(script, ScriptSortBuilder.ScriptSortType.NUMBER);
        searchSourceBuilder.sort(scriptSortBuilder);
        searchRequest.source(searchSourceBuilder);
        try {
            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
            SearchHit[] hits = searchResponse.getHits().getHits();
            Arrays.stream(hits).forEach(k -> stringRedisTemplate.opsForSet().add("bulletin", k.getSourceAsString()));
            if (hits.length > 0) {
                stringRedisTemplate.opsForSet().pop("bulletin", Math.round(hits.length * 0.75));
            }
            logger.info("bulletin配置成功");
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("bulletin配置失败:{}", CommonUtils.getExceptionInfo(e));
            return ResultData.FAIL(null, 500);
        }

        return ResultData.SUCCESS("bulletin配置成功");
    }

}
