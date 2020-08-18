package com.rtc.manager.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rtc.manager.dao.IndiaCinMapper;
import com.rtc.manager.dao.IndiaLlpinMapper;
import com.rtc.manager.service.India;
import com.rtc.manager.util.CommonUtils;
import com.rtc.manager.vo.india.*;
import org.apache.http.HttpHost;
import org.elasticsearch.action.search.MultiSearchRequest;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChenHang
 */
@Service
public class IndiaImpl implements India {

    Logger logger = LoggerFactory.getLogger(ElasticsearchImpl.class);

    RestHighLevelClient client = new RestHighLevelClient(
            RestClient.builder(
                    new HttpHost("localhost", 9200, "http")));

    @Autowired
    private IndiaCinMapper indiaCinMapper;

    @Autowired
    private IndiaLlpinMapper indiaLlpinMapper;

    @Override
    public List listIndiaEnterprise(String name, int pageNum, int pageSize) throws Exception {

        SearchRequest searchRequest = new SearchRequest("india-cin");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.size(pageSize);
        searchSourceBuilder.from(pageNum * pageSize);
        MatchPhraseQueryBuilder matchPhraseQueryBuilder = new MatchPhraseQueryBuilder("company_name", name);
        searchSourceBuilder.query(matchPhraseQueryBuilder);
        searchRequest.source(searchSourceBuilder);

        SearchRequest searchRequest1 = new SearchRequest("india-llpin");
        SearchSourceBuilder searchSourceBuilder1 = new SearchSourceBuilder();
        searchSourceBuilder1.size(pageSize);
        searchSourceBuilder1.from(pageNum * pageSize);
        MatchPhraseQueryBuilder matchPhraseQueryBuilder1 = new MatchPhraseQueryBuilder("llp_name", name);
        searchSourceBuilder1.query(matchPhraseQueryBuilder1);
        searchRequest1.source(searchSourceBuilder1);

        MultiSearchRequest multiSearchRequest = new MultiSearchRequest();
        multiSearchRequest.add(searchRequest);
        multiSearchRequest.add(searchRequest1);
        MultiSearchResponse multiSearchResponse = client.msearch(multiSearchRequest, RequestOptions.DEFAULT);
        MultiSearchResponse.Item cin = multiSearchResponse.getResponses()[0];
        List resultList = new ArrayList();
        if (cin != null) {
            SearchHit[] hits = cin.getResponse().getHits().getHits();
            if (!ObjectUtils.isEmpty(hits)) {
                ObjectMapper objectMapper = new ObjectMapper();
                for (int i = 0; i < hits.length; i++) {
                    SearchHit hit = hits[i];
                    IndiaCinListVO listVO = objectMapper.readValue(hit.getSourceAsString(), IndiaCinListVO.class);
                    resultList.add(listVO);
                }
            }
        }
        MultiSearchResponse.Item llpin = multiSearchResponse.getResponses()[1];
        if (llpin != null) {
            SearchHit[] hits = llpin.getResponse().getHits().getHits();
            if (!ObjectUtils.isEmpty(hits)) {
                ObjectMapper objectMapper = new ObjectMapper();
                for (int i = 0; i < hits.length; i++) {
                    SearchHit hit = hits[i];
                    IndiaLlpinLIstVO listVO = objectMapper.readValue(hit.getSourceAsString(), IndiaLlpinLIstVO.class);
                    resultList.add(listVO);
                }
            }
        }

        return resultList;
    }

    @Override
    public Object getIndiaEnterprise(String enterpriseId, String eType) {
        Object o = null;
        if ("cin".equals(eType)) {
            IndiaCinEnterpriseVO indiaCinEnterpriseVO = indiaCinMapper.selectEnterprise(enterpriseId);
            List<IndiaChargeVO> chargeList = indiaCinEnterpriseVO.getChargeList();
            if (!ObjectUtils.isEmpty(chargeList)) {
                for (int i = 0; i < chargeList.size(); i++) {
                    IndiaChargeVO indiaChargeVO = chargeList.get(i);
                    indiaChargeVO.setAddress(CommonUtils.formatIndiaChargeAddress(indiaChargeVO.getAddress()));
                }
            }
            o = indiaCinEnterpriseVO;
        } else if ("llpin".equals(eType)) {
            IndiaLlpinEnterpriseVO indiaLlpinEnterpriseVO = indiaLlpinMapper.selectEnterprise(enterpriseId);
            List<IndiaChargeVO> chargeList = indiaLlpinEnterpriseVO.getChargeList();
            if (!ObjectUtils.isEmpty(chargeList)) {
                for (int i = 0; i < chargeList.size(); i++) {
                    IndiaChargeVO indiaChargeVO = chargeList.get(i);
                    indiaChargeVO.setAddress(CommonUtils.formatIndiaChargeAddress(indiaChargeVO.getAddress()));
                }
            }
            o = indiaLlpinEnterpriseVO;
        }
        return o;
    }

}
