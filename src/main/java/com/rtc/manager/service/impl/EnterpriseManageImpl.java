package com.rtc.manager.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rtc.manager.service.EnterpriseManage;
import com.rtc.manager.util.CommonUtils;
import com.rtc.manager.util.ElasticsearchUtils;
import com.rtc.manager.vo.ResultData;
import com.rtc.manager.vo.SearchEnterpriseListVO;
import org.apache.lucene.search.TotalHits;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @author ChenHang
 */
@Service
public class EnterpriseManageImpl implements EnterpriseManage {
    Logger logger = LoggerFactory.getLogger(QccImpl.class);

    private final RestHighLevelClient client = ElasticsearchUtils.getClient();

    @Autowired
    private ElasticsearchUtils elasticsearchUtils;

    @Value("${rtc.es.max-result-window}")
    private Integer maxResultWindow;

    @Value("${rtc.timezone}")
    private List<String> timezone;

    /**
     * 搜索企业-列表
     * @param name
     * @param idx
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @Override
    public ResultData listEnterprise(String name, String idx, int pageNum, int pageSize) throws Exception {
        SearchRequest searchRequest = null;
        String[] esIndices = elasticsearchUtils.getEsIndices();
        if (!StringUtils.isEmpty(idx) && Arrays.asList(esIndices).contains(idx)) {
            searchRequest = new SearchRequest(idx);
        } else {
            searchRequest = new SearchRequest(esIndices);
        }

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        // 校验查询页数是否小于es的max-result-window
        elasticsearchUtils.resetQueryPage(searchSourceBuilder, pageNum * pageSize, pageSize);

        if (!StringUtils.isEmpty(name)) {
            MatchPhraseQueryBuilder matchPhraseQueryBuilder = new MatchPhraseQueryBuilder("e_name", name);
            searchSourceBuilder.query(matchPhraseQueryBuilder);
        } else {
            MatchAllQueryBuilder matchAllQueryBuilder = new MatchAllQueryBuilder();
            searchSourceBuilder.query(matchAllQueryBuilder);
        }
        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        List resultList = new ArrayList();
        long total = 0;
        if (searchResponse != null) {
            TotalHits totalHits = searchResponse.getHits().getTotalHits();
            total += totalHits.value;
            SearchHit[] hits = searchResponse.getHits().getHits();
            if (!ObjectUtils.isEmpty(hits)) {
                ObjectMapper objectMapper = new ObjectMapper();
                for (int i = 0; i < hits.length; i++) {
                    SearchHit hit = hits[i];
                    SearchEnterpriseListVO vo = objectMapper.readValue(hit.getSourceAsString(), SearchEnterpriseListVO.class);
                    CommonUtils.setLogoNameAndColor(vo);
                    vo.setEsId(hit.getId());
                    vo.setIdx(hit.getIndex());
                    resultList.add(vo);
                }
            }
        }
        Map map = new HashMap();
        map.put("list", resultList);
        map.put("total", total);
        map.put("pageNum", pageNum + 1);
        map.put("pageSize", pageSize);
        return ResultData.SUCCESS(map);
    }
}
