package com.rtc.manager.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rtc.manager.dao.*;
import com.rtc.manager.entity.QccAnnualReport;
import com.rtc.manager.entity.QccJudgmentDocument;
import com.rtc.manager.entity.dto.RtcUserDTO;
import com.rtc.manager.service.*;
import com.rtc.manager.util.CommonUtils;
import com.rtc.manager.util.ElasticsearchUtils;
import com.rtc.manager.util.QccCategoryEnum;
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
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.script.Script;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.ScriptSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @author ChenHang
 */
@Service
public class QccImpl implements Qcc {

    Logger logger = LoggerFactory.getLogger(QccImpl.class);

    private final RestHighLevelClient client = ElasticsearchUtils.getClient();

    @Autowired
    private Elasticsearch elasticsearch;

    @Autowired
    private QccMapper qccMapper;

    @Autowired
    private QccSubDetailMapper qccSubDetailMapper;

    @Autowired
    private India india;

    @Autowired
    private Vietnam vietnam;

    @Autowired
    private America america;

    @Autowired
    private Canada canada;

    @Autowired
    private RtcUserCommentMapper rtcUserCommentMapper;

    @Autowired
    private RtcUserMapper rtcUserMapper;

    @Value("${rtc.timezone}")
    private List<String> timezone;

    @Value("${rtc.es.max-result-window}")
    private Integer maxResultWindow;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ElasticsearchUtils elasticsearchUtils;

    @Autowired
    private UtilsService utilsService;

    @Autowired
    private IndiaCinMapper indiaCinMapper;

    @Autowired
    private IndiaChargeMapper indiaChargeMapper;

    @Autowired
    private IndiaSignatoryMapper indiaSignatoryMapper;

    @Autowired
    private IndiaLlpinMapper indiaLlpinMapper;

    @Autowired
    private QccBusinessInformationMapper qccBusinessInformationMapper;

    @Autowired
    private QccShareholderMapper qccShareholderMapper;

    @Autowired
    private QccKeymanMapper qccKeymanMapper;

    @Autowired
    private QccJudgmentDocumentMapper qccJudgmentDocumentMapper;

    @Autowired
    private QccAdministrativeLicenseMapper qccAdministrativeLicenseMapper;

    @Autowired
    private QccTaxCreditMapper qccTaxCreditMapper;

    @Autowired
    private QccImportExportCreditMapper qccImportExportCreditMapper;

    @Autowired
    private QccGeneralTaxpayerMapper qccGeneralTaxpayerMapper;

    @Autowired
    private QccQualificationCertificateMapper qccQualificationCertificateMapper;

    @Autowired
    private QccWebsiteInformationMapper qccWebsiteInformationMapper;

    @Autowired
    private QccAnnualReportMapper qccAnnualReportMapper;

    @Autowired
    private QccAnnualReportShareholderMapper qccAnnualReportShareholderMapper;

    @Autowired
    private QccBiddingMapper qccBiddingMapper;

    @Autowired
    private QccLandPurchaseInformationMapper qccLandPurchaseInformationMapper;

    @Autowired
    private QccSupplierMapper qccSupplierMapper;

    @Autowired
    private QccAdministrativeSanctionMapper qccAdministrativeSanctionMapper;

    @Autowired
    private QccFinancingConsultationMapper qccFinancingConsultationMapper;

    @Autowired
    private QccAppMapper qccAppMapper;

    @Autowired
    private QccAppletMapper qccAppletMapper;

    @Autowired
    private QccWechatMapper qccWechatMapper;

    @Autowired
    private QccWeiboMapper qccWeiboMapper;

    @Autowired
    private QccSoftwareCopyrightMapper qccSoftwareCopyrightMapper;

    @Autowired
    private QccRemoveExceptionMapper qccRemoveExceptionMapper;

    @Autowired
    private QccSaveExceptionMapper qccSaveExceptionMapper;

    @Autowired
    private QccClientMapper qccClientMapper;

    @Autowired
    private QccShareholderThreeMapper qccShareholderThreeMapper;

    @Autowired
    private QccQualificationMapper qccQualificationMapper;

    @Autowired
    private QccOutInvestmentMapper qccOutInvestmentMapper;

    @Autowired
    private QccShareholderInvestmentMapper qccShareholderInvestmentMapper;

    @Autowired
    private QccEquityChangeMapper qccEquityChangeMapper;

    @Autowired
    private QccChangeRecordMapper qccChangeRecordMapper;

    @Autowired
    private QccCourtNoticeMapper qccCourtNoticeMapper;

    @Autowired
    private QccFilingInformationMapper qccFilingInformationMapper;

    @Autowired
    private QccAdministrativeLicenseChinaMapper qccAdministrativeLicenseChinaMapper;

    @Autowired
    private QccSpotCheckMapper qccSpotCheckMapper;

    @Autowired
    private QccEquityPledgeMapper qccEquityPledgeMapper;

    @Autowired
    private QccTaxArrearsNoticeMapper qccTaxArrearsNoticeMapper;

    @Autowired
    private QccJudicialAuctionMapper qccJudicialAuctionMapper;

    @Autowired
    private QccTaxViolationMapper qccTaxViolationMapper;

    @Autowired
    private QccEnvironmentalPunishmentMapper qccEnvironmentalPunishmentMapper;

    @Autowired
    private QccEquityOutPledgeMapper qccEquityOutPledgeMapper;

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

        List resultList = new ArrayList();
        long total = 0;

        if (!StringUtils.isEmpty(name)) {
            MatchPhraseQueryBuilder matchPhraseQueryBuilder = new MatchPhraseQueryBuilder("e_name", name);
            searchSourceBuilder.query(matchPhraseQueryBuilder);
            searchRequest.source(searchSourceBuilder);

            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

            if (searchResponse != null) {
                TotalHits totalHits = searchResponse.getHits().getTotalHits();
                total += totalHits.value;
                SearchHit[] hits = searchResponse.getHits().getHits();
                if (!ObjectUtils.isEmpty(hits)) {
                    ObjectMapper objectMapper = new ObjectMapper();
                    for (int i = 0; i < hits.length; i++) {
                        SearchHit hit = hits[i];
                        SearchEnterpriseListVO vo = objectMapper.readValue(hit.getSourceAsString(), SearchEnterpriseListVO.class);
                        vo.setEsId(hit.getId());
                        vo.setIdx(hit.getIndex());
                        CommonUtils.setLogoNameAndColor(vo);
                        vo.setEstablishmentDate(CommonUtils.dateFormat(vo.getEstablishmentDate()));
                        resultList.add(vo);
                    }
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


    public EnterpriseListResultData listEnterprise2(String name, int pageNum, int pageSize) throws Exception {
        SearchRequest searchRequest = new SearchRequest("china");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.size(pageSize);
//        searchSourceBuilder.from(pageNum * pageSize);
        // 校验查询页数是否小于es的max-result-window
        elasticsearchUtils.resetQueryPage(searchSourceBuilder, pageNum * pageSize, pageSize);
        MatchPhraseQueryBuilder matchPhraseQueryBuilder = new MatchPhraseQueryBuilder("name", name);
        searchSourceBuilder.query(matchPhraseQueryBuilder);
        searchRequest.source(searchSourceBuilder);

        SearchRequest searchRequest1 = new SearchRequest("india-cin");
        SearchSourceBuilder searchSourceBuilder1 = new SearchSourceBuilder();
//        searchSourceBuilder1.size(pageSize);
//        searchSourceBuilder1.from(pageNum * pageSize);
        // 校验查询页数是否小于es的max-result-window
        elasticsearchUtils.resetQueryPage(searchSourceBuilder1, pageNum * pageSize, pageSize);
        MatchPhraseQueryBuilder matchPhraseQueryBuilder1 = new MatchPhraseQueryBuilder("company_name", name);
        searchSourceBuilder1.query(matchPhraseQueryBuilder1);
        searchRequest1.source(searchSourceBuilder1);

        SearchRequest searchRequest2 = new SearchRequest("india-llpin");
        SearchSourceBuilder searchSourceBuilder2 = new SearchSourceBuilder();
//        searchSourceBuilder2.size(pageSize);
//        searchSourceBuilder2.from(pageNum * pageSize);
        // 校验查询页数是否小于es的max-result-window
        elasticsearchUtils.resetQueryPage(searchSourceBuilder2, pageNum * pageSize, pageSize);
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
//                    String name = qccVO.getName();
//                    name = CommonUtils.nameFormat(name);
//                    String legalRepresentative = CommonUtils.translate(qccVO.getLegalRepresentative(), "zh", "en");
                    String legalRepresentative = qccVO.getLegalRepresentative();
                    legalRepresentative = CommonUtils.nameFormat(legalRepresentative);
//                    String synopsis = CommonUtils.translate(qccVO.getSynopsis(), "zh", "en");
//                    String countryRegion = CommonUtils.translate(qccVO.getCountryRegion(), "zh", "en");
//                    qccVO.setAddress(address);
//                    qccVO.setName(name);
                    qccVO.setLegalRepresentative(legalRepresentative);
//                    qccVO.setSynopsis(synopsis);
//                    qccVO.setCountryRegion(countryRegion);
                    qccVO.setEstablishmentDate(CommonUtils.dateFormat(qccVO.getEstablishmentDate()));
                    List<QccShareholderVO> shareholderVOList = qccVO.getShareholderList();
                    if (!CollectionUtils.isEmpty(shareholderVOList)) {
                        for (int i = 0; i < shareholderVOList.size(); i++) {
                            QccShareholderVO qccShareholderVO = shareholderVOList.get(i);
//                            name = CommonUtils.translate(qccShareholderVO.getName(), "zh", "en");
                            qccShareholderVO.setName(CommonUtils.nameFormat(qccShareholderVO.getName()));
                        }
                    }
                    if (qccMapper.checkFavouriteQcc(userId, enterpriseId) != null) {
                        qccVO.setFavourite(1);
                    }

                    CommonUtils.setLogoNameAndColor(qccVO);

                    o = qccVO;
                }
                return o;
            case "India":
                return india.getIndiaEnterprise(enterpriseId, eType, userId, timeZone);
            case "Vietnam":
                return vietnam.getVietnamEnterprise(enterpriseId, userId, timeZone);
            case "America":
                return america.getAmericaEnterprise(enterpriseId, eType, userId, timeZone);
            case "Canada":
                return canada.getCanadaEnterprise(enterpriseId, userId, timeZone);
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
            // 基本信息-start
            // 股东信息3
            case "shareholderThree":
                list = qccMapper.listQccShareholderThreeVO(enterpriseId);
                break;
            // 资质资格
            case "qualification":
                list = qccMapper.listQccQualificationVO(enterpriseId);
                break;
            // 对外投资
            case "outInvestment":
                list = qccMapper.listQccOutInvestmentVO(enterpriseId);
                if (!CollectionUtils.isEmpty(list)) {
                    for (int i = 0; i < list.size(); i++) {
                        QccOutInvestmentVO o = (QccOutInvestmentVO) list.get(i);
                        o.setRegisteredCapital(CommonUtils.transferMoney(o.getRegisteredCapital()));
                        o.setAmount(CommonUtils.transferMoney(o.getAmount()));
                    }
                }
                break;
            // 股东及出资信息
            case "shareholderInvestment":
                list = qccMapper.listQccShareholderInvestmentVO(enterpriseId);
                break;
            // 股权变更信息
            case "equityChange":
                list = qccMapper.listQccEquityChangeVO(enterpriseId);
                break;
            // 变更记录
            case "changeRecord":
                list = qccMapper.listQccChangeRecordVO(enterpriseId);
                break;
            // 基本信息-end
            // 经营状况 - 抽查检查
            case "spotCheck":
                list = qccMapper.listQccSpotCheckVO(enterpriseId);
                break;
            // 经营风险 - 司法拍卖
            case "judicialAuction":
                list = qccMapper.listQccJudicialAuctionVO(enterpriseId);
                if (!CollectionUtils.isEmpty(list)) {
                    for (int i = 0; i < list.size(); i++) {
                        QccJudicialAuctionVO o = (QccJudicialAuctionVO) list.get(i);
                        try {
                            BigDecimal bigDecimal = null;
                            bigDecimal = CommonUtils.numberFormat(new BigDecimal(CommonUtils.CNY), o.getStartPrice(), 1);
                            DecimalFormat decimalFormat = new DecimalFormat("$,###");
                            o.setStartPrice(decimalFormat.format(bigDecimal));
                        } catch (Exception e) {
                            e.printStackTrace();
                            logger.info("JudicialAuction:{}", CommonUtils.getExceptionInfo(e));
                        }
                    }
                }
                break;
            // 经营风险 - 环保处罚
            case "environmentalPunishment":
                list = qccMapper.listQccEnvironmentalPunishmentVO(enterpriseId);
                break;
            // 经营风险 - 税收违法
            case "taxViolation":
                list = qccMapper.listQccTaxViolationVO(enterpriseId);
                break;
            default:
        }

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
            // 基本信息-start
            // 股东信息3
            case "shareholderThree":
                object = qccSubDetailMapper.getQccShareholderThreeVO(id);
                break;
            // 资质资格
            case "qualification":
                object = qccSubDetailMapper.getQccQualificationVO(id);
                break;
            // 对外投资
            case "outInvestment":
                object = (QccOutInvestmentVO) qccSubDetailMapper.getQccOutInvestmentVO(id);
                if (object != null) {
                    QccOutInvestmentVO qccOutInvestmentVO = (QccOutInvestmentVO) object;
                    qccOutInvestmentVO.setRegisteredCapital(CommonUtils.transferMoney(qccOutInvestmentVO.getRegisteredCapital()));
                    qccOutInvestmentVO.setAmount(CommonUtils.transferMoney(qccOutInvestmentVO.getAmount()));
                }
                break;
            // 股东及出资信息
            case "shareholderInvestment":
                object = qccSubDetailMapper.getQccShareholderInvestmentVO(id);
                break;
            // 股权变更信息
            case "equityChange":
                object = qccSubDetailMapper.getQccEquityChangeVO(id);
                break;
            // 变更记录
            case "changeRecord":
                object = qccSubDetailMapper.getQccChangeRecordVO(id);
                break;
            // 基本信息-end
            // 经营状况 - 抽查检查
            case "spotCheck":
                object = qccSubDetailMapper.getQccSpotCheckVO(id);
                break;
            // 经营风险 - 司法拍卖
            case "judicialAuction":
                object = qccSubDetailMapper.getQccJudicialAuctionVO(id);
                if (object != null) {
                    try {
                        QccJudicialAuctionVO o = (QccJudicialAuctionVO) object;
                        BigDecimal bigDecimal = CommonUtils.numberFormat(new BigDecimal(CommonUtils.CNY), o.getStartPrice(), 1);
                        DecimalFormat decimalFormat = new DecimalFormat("$,###");
                        o.setStartPrice(decimalFormat.format(bigDecimal));
                    } catch (Exception e) {
                        e.printStackTrace();
                        logger.info("JudicialAuction:{}", CommonUtils.getExceptionInfo(e));
                    }
                }
                break;
            // 经营风险 - 环保处罚
            case "environmentalPunishment":
                object = qccSubDetailMapper.getQccEnvironmentalPunishmentVO(id);
                break;
            // 经营风险 - 税收违法
            case "taxViolation":
                object = qccSubDetailMapper.getQccTaxViolationVO(id);
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
        if (!timeZone.startsWith("-") && !timeZone.startsWith("+")) {
            timeZone = "+" + timeZone;
        }
        if (!CollectionUtils.isEmpty(commentList)) {
            for (int i = 0; i < commentList.size(); i++) {
                RtcUserCommentVO vo = commentList.get(i);
                vo.setCreateTime(CommonUtils.transfer2LocalTime(timeZone, vo.getGmtCreate()));
            }
        }

        return ResultData.SUCCESS(new PageInfo(commentList));
    }

    /**
     * 查询企业列表-Bulletin，用于app主页企业列表展示
     * Redis存放enterpriseId，每次取随机相应数量去es里获得企业列表详情
     *
     * @param size 默认10
     * @return 每次返回{size}个
     */
    @Override
    public ResultData<SearchEnterpriseListVO> listEnterprise4Bulletin(int size) {
        List<SearchEnterpriseListVO> dataList = new ArrayList<>();
        if (stringRedisTemplate.hasKey("bulletin")) {
            Set<String> bulletinSet = new HashSet(stringRedisTemplate.opsForSet().randomMembers("bulletin", size));
            try {
                String jsonString = objectMapper.writeValueAsString(bulletinSet);
                for (String s : bulletinSet) {
                    SearchEnterpriseListVO vo = objectMapper.readValue(s, SearchEnterpriseListVO.class);
                    CommonUtils.setLogoNameAndColor(vo);
                    dataList.add(vo);
                }
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                logger.info("JsonProcessingException:{}", CommonUtils.getExceptionInfo(e));
            }
        }

        return ResultData.SUCCESS(dataList);
    }

    /**
     * 搜索企业-企业推荐
     *
     * @param name     企业名
     * @param pageSize 默认返回10个
     * @return
     */
    @Override
    public ResultData<SearchEnterpriseListVO> listRecommend(String name, int pageSize) throws Exception {
        // 使用es分词器对name进行分词获得token, 取前3
//        AnalyzeRequest analyzeRequest = AnalyzeRequest.withGlobalAnalyzer("english", name);
//        AnalyzeResponse analyzeResponse = client.indices().analyze(analyzeRequest, RequestOptions.DEFAULT);
//        List<AnalyzeResponse.AnalyzeToken> tokenList = analyzeResponse.getTokens();
//        if (tokenList.size() > 3) {
//        name = tokenList.get(0) + " " + tokenList.get(1) + " " + tokenList.get(2);
//        }

        SearchRequest searchRequest = new SearchRequest(elasticsearchUtils.getEsIndices());
        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("e_name", name);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(matchQueryBuilder);
        searchSourceBuilder.size(pageSize);
        Script script = new Script("Math.random()");
        ScriptSortBuilder scriptSortBuilder = new ScriptSortBuilder(script, ScriptSortBuilder.ScriptSortType.NUMBER);
        searchSourceBuilder.sort(scriptSortBuilder);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        SearchHit[] hits = searchResponse.getHits().getHits();
        List<SearchEnterpriseListVO> dataList = new ArrayList<>();
        for (SearchHit hit : hits) {
            SearchEnterpriseListVO vo = objectMapper.readValue(hit.getSourceAsString(), SearchEnterpriseListVO.class);
            CommonUtils.setLogoNameAndColor(vo);
            vo.setEsId(hit.getId());
            vo.setIdx(hit.getIndex());
            dataList.add(vo);
        }

        return ResultData.SUCCESS(dataList);
    }

    /**
     * 获得最近在es中新增的企业名，默认10个
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ResultData listNewlyAdded(int pageNum, int pageSize) throws Exception {
        SearchRequest searchRequest = new SearchRequest(elasticsearchUtils.getEsIndices());
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // 校验查询页数是否小于es的max-result-window
        elasticsearchUtils.resetQueryPage(searchSourceBuilder, pageNum * pageSize, pageSize);
        searchSourceBuilder.sort("timestamp", SortOrder.DESC);
        MatchAllQueryBuilder matchAllQueryBuilder = new MatchAllQueryBuilder();
        searchSourceBuilder.query(matchAllQueryBuilder);
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

    /**
     * 中国企业-五大类-新增
     *
     * @param body         五大类详情数据
     * @param category     五大类栏目
     * @param enterpriseId 企业id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultData addChinaCategory(String body, String category, String enterpriseId) throws Exception {
//        objectMapper.registerModule(new JavaTimeModule());
        switch (category) {
            case "judgmentDocument":
                QccJudgmentDocument judgmentDocument = objectMapper.readValue(body, QccJudgmentDocument.class);
                setFieldNull(judgmentDocument);
                judgmentDocument.setEnterpriseId(enterpriseId);
                if (qccJudgmentDocumentMapper.insertSelective(judgmentDocument) > 0) {
                    return ResultData.SUCCESS("新增成功");
                }
                break;
            case "":
                break;
            default:
        }
        return null;
    }

    /**
     * 中国企业-五大类-删除
     * 根据五大类的id来删除
     *
     * @param body     id的数组
     * @param category 五大类栏目
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultData delChinaCategory(String body, String category) throws Exception {
        List<Integer> pidList = objectMapper.readValue(body, List.class);
        // 如果category是ANNUALREPORT，则删除qcc_annual_report以及相应的qcc_annual_report_shareholder
        // 如果category是ABNORMALOPERATION(经营异常)，查询时参数为abnormalOperation，显示经营异常（移入）和经营异常（移出），删除时则分开为qcc_save_exception和qcc_remove_exception
        String tableName = QccCategoryEnum.getTableName(category);
        if (tableName == null) {
            throw new IllegalArgumentException();
        }
        for (Integer pid : pidList) {
            if ("qcc_annual_report".equals(tableName)) {
                QccAnnualReport qccAnnualReport = qccAnnualReportMapper.selectByPrimaryKey(pid);
                qccAnnualReportShareholderMapper.deleteByAnnualReportUuid(qccAnnualReport.getUuid());
            }
            qccMapper.deleteCategory(tableName, pid);
        }
        return ResultData.SUCCESS(null);
    }

    /**
     * 将对象的id,enterpriseId,gmtCreate,gmtModified,status设为NULL
     *
     * @param obj
     * @return
     */
    private boolean setFieldNull(Object obj) {
        try {
            Class clazz = obj.getClass();
            Method[] declaredMethods = clazz.getDeclaredMethods();
            Object nullData = null;
            for (Method declaredMethod : declaredMethods) {
                String methodName = declaredMethod.getName();
                switch (methodName) {
                    case "setId":
                        declaredMethod.invoke(obj, nullData);
                        break;
//                    case "setEnterpriseId":
//                        declaredMethod.invoke(obj, nullData);
//                        break;
                    case "setGmtCreate":
                        declaredMethod.invoke(obj, nullData);
                        break;
                    case "setGmtModified":
                        declaredMethod.invoke(obj, nullData);
                        break;
                    case "setStatus":
                        declaredMethod.invoke(obj, nullData);
                        break;
                    default:
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}

