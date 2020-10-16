package com.rtc.manager.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rtc.manager.dao.QccMapper;
import com.rtc.manager.dao.QccSubDetailMapper;
import com.rtc.manager.dao.RtcUserCommentMapper;
import com.rtc.manager.dao.RtcUserMapper;
import com.rtc.manager.entity.dto.RtcUserDTO;
import com.rtc.manager.service.India;
import com.rtc.manager.service.Qcc;
import com.rtc.manager.service.Vietnam;
import com.rtc.manager.util.CommonUtils;
import com.rtc.manager.util.ElasticsearchUtils;
import com.rtc.manager.vo.*;
import com.rtc.manager.vo.india.IndiaCinListVO;
import com.rtc.manager.vo.india.IndiaLlpinLIstVO;
import org.apache.lucene.search.TotalHits;
import org.elasticsearch.action.search.MultiSearchRequest;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ChenHang
 */
@Service
public class QccImpl implements Qcc {

    Logger logger = LoggerFactory.getLogger(QccImpl.class);

    private final RestHighLevelClient client = ElasticsearchUtils.getClient();

    @Autowired
    private QccMapper qccMapper;

    @Autowired
    private QccSubDetailMapper qccSubDetailMapper;

    @Autowired
    private India india;

    @Autowired
    private Vietnam vietnam;

    @Autowired
    private RtcUserCommentMapper rtcUserCommentMapper;

    @Autowired
    private RtcUserMapper rtcUserMapper;

    @Value("${rtc.timezone}")
    private List<String> timezone;

    @Value("${rtc.esIndices}")
    private String[] esIndices;

    @Override
    public ResultData listEnterprise(String name, int pageNum, int pageSize) throws Exception {
        SearchRequest searchRequest = new SearchRequest(esIndices);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.size(pageSize);
        searchSourceBuilder.from(pageNum * pageSize);
        MatchPhraseQueryBuilder matchPhraseQueryBuilder = new MatchPhraseQueryBuilder("e_name", name);
        searchSourceBuilder.query(matchPhraseQueryBuilder);
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
//                    if (vo != null && vo.getRegisteredCapital() != null) {
//                        String registeredCapital = vo.getRegisteredCapital();
//                        vo.setRegisteredCapital(CommonUtils.transferMoney(registeredCapital));
//                    }
                    resultList.add(vo);
                }
            }
        }
        Map map = new HashMap();
        map.put("list", resultList);
        map.put("total", total);
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        return ResultData.SUCCESS(map);
    }


    public EnterpriseListResultData listEnterprise2(String name, int pageNum, int pageSize) throws Exception {
        SearchRequest searchRequest = new SearchRequest("china");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.size(pageSize);
        searchSourceBuilder.from(pageNum * pageSize);
        MatchPhraseQueryBuilder matchPhraseQueryBuilder = new MatchPhraseQueryBuilder("name", name);
        searchSourceBuilder.query(matchPhraseQueryBuilder);
        searchRequest.source(searchSourceBuilder);

        SearchRequest searchRequest1 = new SearchRequest("india-cin");
        SearchSourceBuilder searchSourceBuilder1 = new SearchSourceBuilder();
        searchSourceBuilder1.size(pageSize);
        searchSourceBuilder1.from(pageNum * pageSize);
        MatchPhraseQueryBuilder matchPhraseQueryBuilder1 = new MatchPhraseQueryBuilder("company_name", name);
        searchSourceBuilder1.query(matchPhraseQueryBuilder1);
        searchRequest1.source(searchSourceBuilder1);

        SearchRequest searchRequest2 = new SearchRequest("india-llpin");
        SearchSourceBuilder searchSourceBuilder2 = new SearchSourceBuilder();
        searchSourceBuilder2.size(pageSize);
        searchSourceBuilder2.from(pageNum * pageSize);
        MatchPhraseQueryBuilder matchPhraseQueryBuilder2 = new MatchPhraseQueryBuilder("llp_name", name);
        searchSourceBuilder2.query(matchPhraseQueryBuilder2);
        searchRequest2.source(searchSourceBuilder2);

        MultiSearchRequest multiSearchRequest = new MultiSearchRequest();
        multiSearchRequest.add(searchRequest);
        multiSearchRequest.add(searchRequest1);
        multiSearchRequest.add(searchRequest2);
        MultiSearchResponse multiSearchResponse = client.msearch(multiSearchRequest, RequestOptions.DEFAULT);

        MultiSearchResponse.Item china = multiSearchResponse.getResponses()[0];
        List resultList = new ArrayList();
        long total = 0;
        if (china.getResponse() != null) {
            TotalHits totalHits = china.getResponse().getHits().getTotalHits();
            total += totalHits.value;
            SearchHit[] hits = china.getResponse().getHits().getHits();
            if (!ObjectUtils.isEmpty(hits)) {
                ObjectMapper objectMapper = new ObjectMapper();
                for (int i = 0; i < hits.length; i++) {
                    SearchHit hit = hits[i];
                    QccListVO listVO = objectMapper.readValue(hit.getSourceAsString(), QccListVO.class);
                    resultList.add(listVO);
                }
            }
        }
        MultiSearchResponse.Item cin = multiSearchResponse.getResponses()[1];
        if (cin.getResponse() != null) {
            TotalHits totalHits = cin.getResponse().getHits().getTotalHits();
            total += totalHits.value;
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
        MultiSearchResponse.Item llpin = multiSearchResponse.getResponses()[2];
        if (llpin.getResponse() != null) {
            TotalHits totalHits = llpin.getResponse().getHits().getTotalHits();
            total += totalHits.value;
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

        return EnterpriseListResultData.SUCCESS(resultList, total, pageNum, pageSize);
    }

    /*@Override
    public PageInfo<QccListVO> listEnterprise(String name, int pageNum, int pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List list = qccMapper.selectByName(name);

        logger.info("开启多线程");
        // todo
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L,
                TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        threadPoolExecutor.prestartAllCoreThreads();

        List result = new ArrayList();
        if (!CollectionUtils.isEmpty(list)) {
            final List<Future> futures = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                QccListVO qccListVO = (QccListVO) list.get(i);
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


//        if (!CollectionUtils.isEmpty(list)) {
//            for (int i = 0; i < list.size(); i++) {
//                QccListVO qccListVO = (QccListVO) list.get(i);
//                String transferMoney = CommonUtils.transferMoney(qccListVO.getRegisteredCapital());
//                qccListVO.setRegisteredCapital(transferMoney);
//                String qccName = CommonUtils.translate(qccListVO.getName(), "zh", "en");
//                String countryRegion = CommonUtils.translate(qccListVO.getCountryRegion(), "zh", "en");
//                String address = CommonUtils.translate(qccListVO.getAddress(), "zh", "en");
//                String legalRepresentative = CommonUtils.translate(qccListVO.getLegalRepresentative(), "zh", "en");
//                legalRepresentative = CommonUtils.nameFormat(legalRepresentative);
//                qccName = CommonUtils.nameFormat(qccName);
//                qccListVO.setLegalRepresentative(legalRepresentative);
//                qccListVO.setCountryRegion(countryRegion);
//                qccListVO.setName(qccName);
//                qccListVO.setAddress(address);
//            }
//        }
        return new PageInfo<>(list);
    }*/

    @Override
    public Object getEnterprise(String enterpriseId, String nation, String eType, String timeZone) throws Exception {
        Object o = null;
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        RtcUserDTO rtcUserDTO = rtcUserMapper.selectByPhoneOrAccount(userDetails.getUsername());
        String userId = rtcUserDTO.getUuid();
        switch (nation) {
            case "China":
                QccVO qccVO = qccMapper.selectByEnterpriseId(enterpriseId);
                if (qccVO != null) {
                    String transferMoney = CommonUtils.transferMoney(qccVO.getRegisteredCapital());
                    qccVO.setRegisteredCapital(transferMoney);
//                    String address = CommonUtils.translate(qccVO.getAddress(), "zh", "en");
//                    String name = CommonUtils.translate(qccVO.getName(), "zh", "en");
                    String name = qccVO.getName();
                    name = CommonUtils.nameFormat(name);
//                    String legalRepresentative = CommonUtils.translate(qccVO.getLegalRepresentative(), "zh", "en");
                    String legalRepresentative = qccVO.getLegalRepresentative();
                    legalRepresentative = CommonUtils.nameFormat(legalRepresentative);
//                    String synopsis = CommonUtils.translate(qccVO.getSynopsis(), "zh", "en");
//                    String countryRegion = CommonUtils.translate(qccVO.getCountryRegion(), "zh", "en");
//                    qccVO.setAddress(address);
                    qccVO.setName(name);
                    qccVO.setLegalRepresentative(legalRepresentative);
//                    qccVO.setSynopsis(synopsis);
//                    qccVO.setCountryRegion(countryRegion);
                    List<QccShareholderVO> shareholderVOList = qccVO.getShareholderList();
                    if (!CollectionUtils.isEmpty(shareholderVOList)) {
                        for (int i = 0; i < shareholderVOList.size(); i++) {
                            QccShareholderVO qccShareholderVO = shareholderVOList.get(i);
//                            name = CommonUtils.translate(qccShareholderVO.getName(), "zh", "en");
                            name = CommonUtils.nameFormat(name);
                            qccShareholderVO.setName(name);
                        }
                    }
                    if (qccMapper.checkFavouriteQcc(userId, enterpriseId) != null) {
                        qccVO.setFavourite(1);
                    }
                    o = qccVO;
                }
                return o;
            case "India":
                return india.getIndiaEnterprise(enterpriseId, eType, userId, timeZone);
            case "Vietnam":
                return vietnam.getIndiaEnterprise(enterpriseId, userId, timeZone);
        }
        return null;
    }

    @Override
    public PageInfo<List> getEnterpriseDetail(String name, String enterpriseId, int pageNum, int pageSize, String nation, String eType) {
        List list = new ArrayList();
//        if ("China".equals(nation) && "China".equals(eType)) {
        PageHelper.startPage(pageNum, pageSize);
        switch (name) {
            case "judgmentDocument":
                list = qccMapper.listQccJudgmentDocumentVO(enterpriseId);
                break;
            case "administrativeLicense":
                list = qccMapper.listQccAdministrativeLicenseVO(enterpriseId);
                break;
            case "taxCredit":
                list = qccMapper.listQccTaxCreditVO(enterpriseId);
                break;
            case "bidding":
                list = qccMapper.listQccBiddingVO(enterpriseId);
                break;
            case "importExportCredit":
                list = qccMapper.listQccImportExportCreditVO(enterpriseId);
                break;
            case "landPurchaseInformation":
                list = qccMapper.listQccLandPurchaseInformationVO(enterpriseId);
                break;
            case "supplier":
                list = qccMapper.listQccSupplierVO(enterpriseId);
                if (!CollectionUtils.isEmpty(list)) {
                    for (int i = 0; i < list.size(); i++) {
                        QccSupplierVO qccSupplierVO = (QccSupplierVO) list.get(i);
                        qccSupplierVO.setPurchaseAmount(CommonUtils.transferMoney2(qccSupplierVO.getPurchaseAmount(), "-", Math.pow(10, 4)));
                    }
                }
                break;
            case "client":
                list = qccMapper.listQccClientVO(enterpriseId);
                if (!CollectionUtils.isEmpty(list)) {
                    for (int i = 0; i < list.size(); i++) {
                        QccClientVO qccClientVO = (QccClientVO) list.get(i);
                        qccClientVO.setSaleAmount(CommonUtils.transferMoney2(qccClientVO.getSaleAmount(), "-", Math.pow(10, 4)));
                    }
                }
                break;
            case "generalTaxpayer":
                list = qccMapper.listQccGeneralTaxpayerVO(enterpriseId);
                break;
            case "abnormalOperation":
                list = qccMapper.listQccAbnormalOperationVO(enterpriseId);
                break;
            case "administrativeSanction":
                list = qccMapper.listQccAdministrativeSanctionVO(enterpriseId);
                break;
            case "annualReport":
                list = qccMapper.listQccAnnualReportVO(enterpriseId);
                if (!CollectionUtils.isEmpty(list)) {
                    for (int i = 0; i < list.size(); i++) {
                        QccAnnualReportVO qccAnnualReportVO = (QccAnnualReportVO) list.get(i);
                        qccAnnualReportVO.setTotalAssets(CommonUtils.transferMoney2(qccAnnualReportVO.getTotalAssets(), "Enterprises choose not to publicize", Math.pow(10, 4)));
                        qccAnnualReportVO.setTotalEquity(CommonUtils.transferMoney2(qccAnnualReportVO.getTotalEquity(), "Enterprises choose not to publicize", Math.pow(10, 4)));
                        qccAnnualReportVO.setTotalOperatingIncome(CommonUtils.transferMoney2(qccAnnualReportVO.getTotalOperatingIncome(), "Enterprises choose not to publicize", Math.pow(10, 4)));
                        qccAnnualReportVO.setTotalProfit(CommonUtils.transferMoney2(qccAnnualReportVO.getTotalProfit(), "Enterprises choose not to publicize", Math.pow(10, 4)));
                        qccAnnualReportVO.setNetProfit(CommonUtils.transferMoney2(qccAnnualReportVO.getNetProfit(), "Enterprises choose not to publicize", Math.pow(10, 4)));
                        qccAnnualReportVO.setMainBusinessIncome(CommonUtils.transferMoney2(qccAnnualReportVO.getMainBusinessIncome(), "Enterprises choose not to publicize", Math.pow(10, 4)));
                        qccAnnualReportVO.setTotalTax(CommonUtils.transferMoney2(qccAnnualReportVO.getTotalTax(), "Enterprises choose not to publicize", Math.pow(10, 4)));
                        qccAnnualReportVO.setTotalLiabilities(CommonUtils.transferMoney2(qccAnnualReportVO.getTotalLiabilities(), "Enterprises choose not to publicize", Math.pow(10, 4)));
                        List<QccAnnualReportShareholderVO> qccAnnualReportShareholderVOList = qccAnnualReportVO.getQccAnnualReportShareholderVOList();
                        for (int j = 0; j < qccAnnualReportShareholderVOList.size(); j++) {
                            QccAnnualReportShareholderVO qccAnnualReportShareholderVO = qccAnnualReportShareholderVOList.get(j);
                            qccAnnualReportShareholderVO.setSubscribedCapital(CommonUtils.transferMoney2(qccAnnualReportShareholderVO.getSubscribedCapital(), "-", Math.pow(10, 4)));
                            qccAnnualReportShareholderVO.setPaidCapital(CommonUtils.transferMoney2(qccAnnualReportShareholderVO.getPaidCapital(), "-", Math.pow(10, 4)));
                        }
                    }
                }
                break;
            case "financingConsultation":
                list = qccMapper.listQccFinancingConsultationVO(enterpriseId);
                if (!CollectionUtils.isEmpty(list)) {
                    for (int i = 0; i < list.size(); i++) {
                        QccFinancingConsultationVO qccFinancingConsultationVO = (QccFinancingConsultationVO) list.get(i);
                        qccFinancingConsultationVO.setAmount(CommonUtils.transferMoney(qccFinancingConsultationVO.getAmount()));
                    }
                }
                break;
            case "keyman":
                list = qccMapper.listQccKeymanVO(enterpriseId);
                break;
            case "qualificationCertificate":
                list = qccMapper.listQccQualificationCertificateVO(enterpriseId);
                break;
            case "softwareCopyright":
                list = qccMapper.listQccSoftwareCopyrightVO(enterpriseId);
                break;
            case "websiteInformation":
                list = qccMapper.listQccWebsiteInformationVO(enterpriseId);
                break;
            case "app":
                list = qccMapper.listQccAppVO(enterpriseId);
                break;
            case "applet":
                list = qccMapper.listQccAppletVO(enterpriseId);
                break;
            case "wechat":
                list = qccMapper.listQccWechatVO(enterpriseId);
                break;
            case "weibo":
                list = qccMapper.listQccWeiboVO(enterpriseId);
                break;
            // 法律诉讼 - 开庭公告
            case "courtNotice":
                list = qccMapper.listQccCourtNoticeVO(enterpriseId);
                break;
            // 法律诉讼 - 立案信息
            case "filingInformation":
                list = qccMapper.listQccFilingInformationVO(enterpriseId);
                break;
            // 经营状况 - 行政许可 [信用中国]
            case "administrativeLicenseChina":
                list = qccMapper.listQccAdministrativeLicenseChinaVO(enterpriseId);
                break;
            // 经营风险 - 欠税公告
            case "taxArrearsNotice":
                list = qccMapper.listQccTaxArrearsNoticeVO(enterpriseId);
                if (!CollectionUtils.isEmpty(list)) {
                    for (int i = 0; i < list.size(); i++) {
                        QccTaxArrearsNoticeVO o = (QccTaxArrearsNoticeVO) list.get(i);
                        o.setBalance(CommonUtils.transferMoney2(o.getBalance(), "-", 1d));
                        o.setCurrentArrears(CommonUtils.transferMoney2(o.getCurrentArrears(), "-", 1d));
                    }
                }
                break;
            // 经营风险 - 股权质押
            case "equityPledge":
                list = qccMapper.listQccEquityPledgeVO(enterpriseId);
                if (!CollectionUtils.isEmpty(list)) {
                    for (int i = 0; i < list.size(); i++) {
                        QccEquityPledgeVO o = (QccEquityPledgeVO) list.get(i);
                        o.setShares(CommonUtils.transferMoney2(o.getShares(), "-", Math.pow(10, 4)));
                        o.setValue(CommonUtils.transferMoney2(o.getValue(), "-", Math.pow(10, 4)));
                    }
                }
                break;
            // 经营风险 - 股权出质
            case "equityOutPledge":
                list = qccMapper.listQccEquityOutPledgeVO(enterpriseId);
                if (!CollectionUtils.isEmpty(list)) {
                    for (int i = 0; i < list.size(); i++) {
                        QccEquityOutPledgeVO o = (QccEquityOutPledgeVO) list.get(i);
                        o.setAmount(CommonUtils.transferMoney2(o.getAmount(), "-", Math.pow(10, 4)));
                    }
                }
                break;
            default:
        }
//        }

        return new PageInfo<>(list);
    }

    @Override
    public Object getEnterpriseSubDetail(String name, Integer id, String nation, String eType) {
        Object object = null;
//        if ("China".equals(nation) && "China".equals(eType)) {
        switch (name) {
            case "judgmentDocument":
                object = qccSubDetailMapper.getQccJudgmentDocumentVO(id);
                break;
            case "administrativeLicense":
                object = qccSubDetailMapper.getQccAdministrativeLicenseVO(id);
                break;
            case "taxCredit":
                object = qccSubDetailMapper.getQccTaxCreditVO(id);
                break;
            case "bidding":
                object = qccSubDetailMapper.getQccBiddingVO(id);
                break;
            case "importExportCredit":
                object = qccSubDetailMapper.getQccImportExportCreditVO(id);
                break;
            case "landPurchaseInformation":
                object = qccSubDetailMapper.getQccLandPurchaseInformationVO(id);
                break;
            case "supplier":
                object = qccSubDetailMapper.getQccSupplierVO(id);
                if (object != null) {
                    QccSupplierVO qccSupplierVO = (QccSupplierVO) object;
                    qccSupplierVO.setPurchaseAmount(CommonUtils.transferMoney2(qccSupplierVO.getPurchaseAmount(), "-", Math.pow(10, 4)));
                }
                break;
            case "client":
                object = qccSubDetailMapper.getQccClientVO(id);
                if (object != null) {
                    QccClientVO qccClientVO = (QccClientVO) object;
                    qccClientVO.setSaleAmount(CommonUtils.transferMoney2(qccClientVO.getSaleAmount(), "-", Math.pow(10, 4)));
                }
                break;
            case "generalTaxpayer":
                object = qccSubDetailMapper.getQccGeneralTaxpayerVO(id);
                break;
            case "abnormalOperation":
                object = qccSubDetailMapper.getQccAbnormalOperationVO(id);
                break;
            case "administrativeSanction":
                object = qccSubDetailMapper.getQccAdministrativeSanctionVO(id);
                break;
            case "annualReport":
                object = qccSubDetailMapper.getQccAnnualReportVO(id);
                if (object != null) {
                    QccAnnualReportVO qccAnnualReportVO = (QccAnnualReportVO) object;
                    qccAnnualReportVO.setTotalAssets(CommonUtils.transferMoney2(qccAnnualReportVO.getTotalAssets(), "Enterprises choose not to publicize", Math.pow(10, 4)));
                    qccAnnualReportVO.setTotalEquity(CommonUtils.transferMoney2(qccAnnualReportVO.getTotalEquity(), "Enterprises choose not to publicize", Math.pow(10, 4)));
                    qccAnnualReportVO.setTotalOperatingIncome(CommonUtils.transferMoney2(qccAnnualReportVO.getTotalOperatingIncome(), "Enterprises choose not to publicize", Math.pow(10, 4)));
                    qccAnnualReportVO.setTotalProfit(CommonUtils.transferMoney2(qccAnnualReportVO.getTotalProfit(), "Enterprises choose not to publicize", Math.pow(10, 4)));
                    qccAnnualReportVO.setNetProfit(CommonUtils.transferMoney2(qccAnnualReportVO.getNetProfit(), "Enterprises choose not to publicize", Math.pow(10, 4)));
                    qccAnnualReportVO.setMainBusinessIncome(CommonUtils.transferMoney2(qccAnnualReportVO.getMainBusinessIncome(), "Enterprises choose not to publicize", Math.pow(10, 4)));
                    qccAnnualReportVO.setTotalTax(CommonUtils.transferMoney2(qccAnnualReportVO.getTotalTax(), "Enterprises choose not to publicize", Math.pow(10, 4)));
                    qccAnnualReportVO.setTotalLiabilities(CommonUtils.transferMoney2(qccAnnualReportVO.getTotalLiabilities(), "Enterprises choose not to publicize", Math.pow(10, 4)));
                    List<QccAnnualReportShareholderVO> qccAnnualReportShareholderVOList = qccAnnualReportVO.getQccAnnualReportShareholderVOList();
                    for (int j = 0; j < qccAnnualReportShareholderVOList.size(); j++) {
                        QccAnnualReportShareholderVO qccAnnualReportShareholderVO = qccAnnualReportShareholderVOList.get(j);
                        qccAnnualReportShareholderVO.setSubscribedCapital(CommonUtils.transferMoney2(qccAnnualReportShareholderVO.getSubscribedCapital(), "-", Math.pow(10, 4)));
                        qccAnnualReportShareholderVO.setPaidCapital(CommonUtils.transferMoney2(qccAnnualReportShareholderVO.getPaidCapital(), "-", Math.pow(10, 4)));
                    }
                }
                break;
            case "financingConsultation":
                object = qccSubDetailMapper.getQccFinancingConsultationVO(id);
                if (object != null) {
                    QccFinancingConsultationVO qccFinancingConsultationVO = (QccFinancingConsultationVO) object;
                    qccFinancingConsultationVO.setAmount(CommonUtils.transferMoney(qccFinancingConsultationVO.getAmount()));
                }
                break;
            case "keyman":
                object = qccSubDetailMapper.getQccKeymanVO(id);
                break;
            case "qualificationCertificate":
                object = qccSubDetailMapper.getQccQualificationCertificateVO(id);
                break;
            case "softwareCopyright":
                object = qccSubDetailMapper.getQccSoftwareCopyrightVO(id);
                break;
            case "websiteInformation":
                object = qccSubDetailMapper.getQccWebsiteInformationVO(id);
                break;
            case "app":
                object = qccSubDetailMapper.getQccAppVO(id);
                break;
            case "applet":
                object = qccSubDetailMapper.getQccAppletVO(id);
                break;
            case "wechat":
                object = qccSubDetailMapper.getQccWechatVO(id);
                break;
            case "weibo":
                object = qccSubDetailMapper.getQccWeiboVO(id);
                break;
            // 法律诉讼 - 开庭公告
            case "courtNotice":
                object = qccSubDetailMapper.getQccCourtNoticeVO(id);
                break;
            // 法律诉讼 - 立案信息
            case "filingInformation":
                object = qccSubDetailMapper.getQccFilingInformationVO(id);
                break;
            // 经营状况 - 行政许可 [信用中国]
            case "administrativeLicenseChina":
                object = qccSubDetailMapper.getQccAdministrativeLicenseChinaVO(id);
                break;
            // 经营风险 - 欠税公告
            case "taxArrearsNotice":
                object = qccSubDetailMapper.getQccTaxArrearsNoticeVO(id);
                QccTaxArrearsNoticeVO qccTaxArrearsNoticeVO = (QccTaxArrearsNoticeVO) object;
                qccTaxArrearsNoticeVO.setBalance(CommonUtils.transferMoney2(qccTaxArrearsNoticeVO.getBalance(), "-", 1d));
                qccTaxArrearsNoticeVO.setCurrentArrears(CommonUtils.transferMoney2(qccTaxArrearsNoticeVO.getCurrentArrears(), "-", 1d));
                break;
            // 经营风险 - 股权质押
            case "equityPledge":
                object = qccSubDetailMapper.getQccEquityPledgeVO(id);
                QccEquityPledgeVO qccEquityPledgeVO = (QccEquityPledgeVO) object;
                qccEquityPledgeVO.setShares(CommonUtils.transferMoney2(qccEquityPledgeVO.getShares(), "-", Math.pow(10, 4)));
                qccEquityPledgeVO.setValue(CommonUtils.transferMoney2(qccEquityPledgeVO.getValue(), "-", Math.pow(10, 4)));
                break;
            // 经营风险 - 股权出质
            case "equityOutPledge":
                object = qccSubDetailMapper.getQccEquityOutPledgeVO(id);
                QccEquityOutPledgeVO qccEquityOutPledgeVO = (QccEquityOutPledgeVO) object;
                qccEquityOutPledgeVO.setAmount(CommonUtils.transferMoney2(qccEquityOutPledgeVO.getAmount(), "-", Math.pow(10, 4)));
                break;
            default:

        }
//        }

        return object;
    }

    @Override
    public Object getEnterpriseSubDetailMuti(String name, String enterpriseId, Integer id, int pageNum, int pageSize, String nation, String eType) {
        Object o = null;
//        if ("China".equals(nation) && "China".equals(eType)) {
        if (null != enterpriseId) {
            PageInfo<List> listPageInfo = getEnterpriseDetail(name, enterpriseId, pageNum, pageSize, nation, eType);
            List list = listPageInfo.getList();
            if (!CollectionUtils.isEmpty(list) && list.size() > 0) {
                o = list.get(0);
            }
        } else if (null != id) {
            o = getEnterpriseSubDetail(name, id, nation, eType);
        }
//        }
        return o;
    }

    /**
     * 查看企业的所有评论
     *
     * @param enterpriseId
     * @param timeZone
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ResultData listEnterpriseComment(String enterpriseId, String timeZone, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<RtcUserCommentVO> commentList = rtcUserCommentMapper.selectCommentByEnterpriseId(enterpriseId);
        PageHelper.clearPage();
        if (!timezone.contains(timeZone)) {
            timeZone = "0";
        }
        if (!CollectionUtils.isEmpty(commentList)) {
            for (int i = 0; i < commentList.size(); i++) {
                RtcUserCommentVO vo = commentList.get(i);
                vo.setCreateTime(CommonUtils.transfer2LocalTime(timeZone, vo.getGmtCreate()));
            }
        }

        return ResultData.SUCCESS(new PageInfo(commentList));
    }


}
