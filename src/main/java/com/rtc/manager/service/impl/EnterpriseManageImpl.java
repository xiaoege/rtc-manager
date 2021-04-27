package com.rtc.manager.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rtc.manager.dao.*;
import com.rtc.manager.entity.QccBusinessInformation;
import com.rtc.manager.entity.QccShareholder;
import com.rtc.manager.entity.dto.*;
import com.rtc.manager.entity.india.IndiaCharge;
import com.rtc.manager.entity.india.IndiaCin;
import com.rtc.manager.entity.india.IndiaLlpin;
import com.rtc.manager.entity.india.IndiaSignatory;
import com.rtc.manager.service.Elasticsearch;
import com.rtc.manager.service.EnterpriseManage;
import com.rtc.manager.service.UtilsService;
import com.rtc.manager.util.CommonUtils;
import com.rtc.manager.util.ElasticsearchUtils;
import com.rtc.manager.vo.QccShareholderVO;
import com.rtc.manager.vo.QccVO;
import com.rtc.manager.vo.ResultData;
import com.rtc.manager.vo.SearchEnterpriseListVO;
import com.rtc.manager.vo.india.*;
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
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author ChenHang
 */
@Service
public class EnterpriseManageImpl implements EnterpriseManage {
    Logger logger = LoggerFactory.getLogger(QccImpl.class);

    private final RestHighLevelClient client = ElasticsearchUtils.getClient();

    @Autowired
    private Elasticsearch elasticsearch;

    @Autowired
    private ElasticsearchUtils elasticsearchUtils;

    @Value("${rtc.timezone}")
    private List<String> timezone;

    @Value("${rtc.img-type}")
    private List<String> imgType;

    @Value("${rtc.url}")
    private String url;

    @Value("${rtc.image-path}")
    private String imagePath;

    @Autowired
    private QccImpl qccImpl;

    @Autowired
    private UtilsService utilsService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private QccMapper qccMapper;

    @Autowired
    private QccBusinessInformationMapper qccBusinessInformationMapper;

    @Autowired
    private QccShareholderMapper qccShareholderMapper;

    @Autowired
    private IndiaCinMapper indiaCinMapper;

    @Autowired
    private IndiaChargeMapper indiaChargeMapper;

    @Autowired
    private IndiaSignatoryMapper indiaSignatoryMapper;

    @Autowired
    private IndiaLlpinMapper indiaLlpinMapper;

    /**
     * 搜索企业-列表
     *
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
                    vo.setEstablishmentDate(CommonUtils.dateFormat(vo.getEstablishmentDate()));
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
     * 新增企业-单个
     * 新增中国企业-基本信息时，category为null或""：基本信息qcc + 工商信息qcc_business_information + 股东qcc_shareholder
     * 新增中国企业-五大类时，category为特定栏目
     *
     * @param body
     * @param nation 国家
     * @param eType  地区
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultData addEnterprise(String body, String nation, String eType) throws Exception {
        List<String> esIndices = utilsService.getRtcRefCountry("area");
        if (esIndices.contains(eType)) {
            String enterpriseId = CommonUtils.getUUID();
            String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            switch (eType) {
                case "China":
                    // 中国企业基本信息：基本信息qcc + 工商信息qcc_business_information + 股东qcc_shareholder
                    QccDTO qccDTO = objectMapper.readValue(body, QccDTO.class);
                    if (CommonUtils.checkJsonFieldNotSub(qccDTO)) {
                        com.rtc.manager.entity.Qcc qcc = new com.rtc.manager.entity.Qcc();
                        BeanUtils.copyProperties(qccDTO, qcc);
                        qcc.setEnterpriseId(enterpriseId);
                        qcc.setLogo(fileUrl2Location(qcc.getLogo(), enterpriseId));
                        if (qccMapper.insertSelective(qcc) > 0) {
                            QccBusinessInformation businessInformation = qccDTO.getBusinessInformation();
                            String establishmentDate = null;
                            // 统一社会信用代码
                            String unifiedSocialCreditCode = null;
                            if (setFieldNull(businessInformation) && CommonUtils.checkJsonField(businessInformation)) {
                                businessInformation.setEnterpriseId(enterpriseId);
                                qccBusinessInformationMapper.insertSelective(businessInformation);
                                establishmentDate = businessInformation.getEstablishmentDate();
                                unifiedSocialCreditCode = businessInformation.getUnifiedSocialCreditCode();
                            }
                            List<QccShareholder> shareholderList = qccDTO.getShareholderList();
                            for (QccShareholder shareholder : shareholderList) {
                                if (setFieldNull(shareholder) && CommonUtils.checkJsonField(shareholder)) {
                                    shareholder.setEnterpriseId(enterpriseId);
                                    qccShareholderMapper.insertSelective(shareholder);
                                }
                            }
                            int flag = elasticsearch.addEnterprise("China", "China", qcc.getId(),
                                    qcc.getEnterpriseId(), qcc.getName(), qcc.getAddress(),
                                    establishmentDate, unifiedSocialCreditCode, qcc.getLogo(), createTime, "china");
                            if (flag > 0) {
                                return ResultData.SUCCESS(null, "新增" + eType + "成功");
                            } else {
                                throw new RuntimeException();
                            }
                        }
                    }
                    break;
                case "cin":
                    IndiaCinDTO indiaCinDTO = objectMapper.readValue(body, IndiaCinDTO.class);
                    IndiaCinBasicDTO basicDTO = indiaCinDTO.getBasic();
                    if (CommonUtils.checkJsonField(basicDTO)) {
                        IndiaCin basic = new IndiaCin();
                        BeanUtils.copyProperties(basicDTO, basic);
                        basic.setEnterpriseId(enterpriseId);
                        basic.setLogo(fileUrl2Location(basic.getLogo(), enterpriseId));
                        if (indiaCinMapper.insertSelective(basic) > 0) {
                            List<IndiaChargeDTO> charges = indiaCinDTO.getCharges();
                            Optional.ofNullable(charges).ifPresent(k -> k.stream().forEach(j -> {
                                if (CommonUtils.checkJsonField(j)) {
                                    IndiaCharge indiaCharge = new IndiaCharge();
                                    BeanUtils.copyProperties(j, indiaCharge);
                                    indiaCharge.setEnterpriseId(enterpriseId);
                                    indiaChargeMapper.insertSelective(indiaCharge);
                                }
                            }));
                            List<IndiaSignatoryDTO> signatory = indiaCinDTO.getSignatory();
                            Optional.ofNullable(signatory).ifPresent(k -> k.stream().forEach(j -> {
                                if (CommonUtils.checkJsonField(j)) {
                                    IndiaSignatory indiaSignatory = new IndiaSignatory();
                                    BeanUtils.copyProperties(j, indiaSignatory);
                                    indiaSignatory.setEnterpriseId(enterpriseId);
                                    indiaSignatoryMapper.insertSelective(indiaSignatory);
                                }
                            }));
                            int flag = elasticsearch.addEnterprise("India", "cin", basic.getId(),
                                    basic.getEnterpriseId(), basic.getCompanyName(), basic.getRegisteredAddress(),
                                    basic.getDateOfIncorporation(), basic.getCin(), basic.getLogo(), createTime, "india-cin");
                            if (flag > 0) {
                                return ResultData.SUCCESS(null, "新增" + eType + "成功");
                            } else {
                                throw new RuntimeException();
                            }
                        }
                    }
                    break;
                case "llpin":
                    IndiaLlpinDTO indiaLlpinDTO = objectMapper.readValue(body, IndiaLlpinDTO.class);
                    IndiaLlpinBasicDTO llpinBasicDTO = indiaLlpinDTO.getBasic();
                    if (CommonUtils.checkJsonField(llpinBasicDTO)) {
                        IndiaLlpin basic = new IndiaLlpin();
                        BeanUtils.copyProperties(llpinBasicDTO, basic);
                        basic.setEnterpriseId(enterpriseId);
                        basic.setLogo(fileUrl2Location(basic.getLogo(), enterpriseId));
                        if (indiaLlpinMapper.insertSelective(basic) > 0) {
                            List<IndiaChargeDTO> charges = indiaLlpinDTO.getCharges();
                            Optional.ofNullable(charges).ifPresent(k -> k.stream().forEach(j -> {
                                if (CommonUtils.checkJsonField(j)) {
                                    IndiaCharge indiaCharge = new IndiaCharge();
                                    BeanUtils.copyProperties(j, indiaCharge);
                                    indiaCharge.setEnterpriseId(enterpriseId);
                                    indiaChargeMapper.insertSelective(indiaCharge);
                                }
                            }));
                            List<IndiaSignatoryDTO> signatory = indiaLlpinDTO.getSignatory();
                            Optional.ofNullable(signatory).ifPresent(k -> k.stream().forEach(j -> {
                                if (CommonUtils.checkJsonField(j)) {
                                    IndiaSignatory indiaSignatory = new IndiaSignatory();
                                    BeanUtils.copyProperties(j, indiaSignatory);
                                    indiaSignatory.setEnterpriseId(enterpriseId);
                                    indiaSignatoryMapper.insertSelective(indiaSignatory);
                                }
                            }));
                            int flag = elasticsearch.addEnterprise("India", "cin", basic.getId(),
                                    basic.getEnterpriseId(), basic.getLlpName(), basic.getRegistratedAddress(),
                                    basic.getDateOfIncorporation(), basic.getLlpin(), basic.getLogo(), createTime, "india-llpin");
                            if (flag > 0) {
                                return ResultData.SUCCESS(null, "新增" + eType + "成功");
                            } else {
                                throw new RuntimeException();
                            }
                        }
                    }
                    break;
                case "Vietnam":
                    VietnamJsonDTO vietnamJsonDTO = objectMapper.readValue(body, VietnamJsonDTO.class);
                    break;
                case "Canada":
                    CanadaDTO canadaDTO = objectMapper.readValue(body, CanadaDTO.class);
                    break;
                case "France":
                    break;

            }
        }
        return ResultData.SUCCESS(null, "新增" + eType + "失败");
    }

    /**
     * 企业修改-es/mysql
     * mysql:修改企业基本信息，删除关联信息，新增关联信息。es:修改企业基本信息
     *
     * @param body
     * @param nation
     * @param eType
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultData modifyEnterprise(String body, String nation, String eType, String esId, String enterpriseId, String timezone) throws Exception {
        List<String> esIndices = utilsService.getRtcRefCountry("area");
        if (esIndices.contains(eType)) {
            String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            switch (eType) {
                case "China":
                    // 中国企业基本信息：基本信息qcc + 工商信息qcc_business_information + 股东qcc_shareholder
                    QccDTO qccDTO = objectMapper.readValue(body, QccDTO.class);
                    if (CommonUtils.checkJsonFieldNotSub(qccDTO)) {
                        com.rtc.manager.entity.Qcc qcc = new com.rtc.manager.entity.Qcc();
                        BeanUtils.copyProperties(qccDTO, qcc);
                        QccVO oldQcc = (QccVO) qccImpl.getEnterprise(enterpriseId, nation, eType, timezone);
                        if (oldQcc == null) {
                            return ResultData.FAIL(null, 1101);
                        }
                        qcc.setId(oldQcc.getId());
                        qcc.setEnterpriseId(oldQcc.getEnterpriseId());
                        qcc.setLogo(fileUrl2Location(qcc.getLogo(), oldQcc.getEnterpriseId()));
                        qccMapper.updateByPrimaryKeySelective(qcc);
                        String establishmentDate = null;
                        // 统一社会信用代码
                        String unifiedSocialCreditCode = null;
//                        establishmentDate = businessInformation.getEstablishmentDate();
//                        unifiedSocialCreditCode = businessInformation.getUnifiedSocialCreditCode();
                        QccBusinessInformation businessInformation = qccDTO.getBusinessInformation();
                        int id = qccBusinessInformationMapper.selectIdByEnterpriseId(enterpriseId);
                        qccBusinessInformationMapper.deleteByPrimaryKey(id);
                        if (setFieldNull(businessInformation) && CommonUtils.checkJsonField(businessInformation)) {
                            businessInformation.setEnterpriseId(enterpriseId);
                            qccBusinessInformationMapper.insertSelective(businessInformation);
                        }
                        List<QccShareholder> shareholderList = qccDTO.getShareholderList();
                        List<QccShareholderVO> oldQccShareholderList = oldQcc.getShareholderList();
                        Optional.ofNullable(oldQccShareholderList).ifPresent(j -> j.forEach(k -> qccShareholderMapper.deleteByPrimaryKey(k.getId())));
                        for (QccShareholder shareholder : shareholderList) {
                            if (setFieldNull(shareholder) && CommonUtils.checkJsonField(shareholder)) {
                                shareholder.setEnterpriseId(enterpriseId);
                                qccShareholderMapper.insertSelective(shareholder);
                            }
                        }
                        int flag = elasticsearch.modifyEnterprise("China", "China", qcc.getId(),
                                qcc.getEnterpriseId(), qcc.getName(), qcc.getAddress(),
                                establishmentDate, unifiedSocialCreditCode, qcc.getLogo(), createTime, "china", esId);
                        if (flag > 0) {
                            return ResultData.SUCCESS(null, "esId:" + esId + "修改成功");
                        } else {
                            throw new RuntimeException();
                        }
                    }
                    break;
                case "cin":
                    IndiaCinEnterpriseVO oldCin = (IndiaCinEnterpriseVO) qccImpl.getEnterprise(enterpriseId, nation, eType, timezone);
                    if (oldCin == null) {
                        return ResultData.FAIL(null, 1101);
                    }
                    IndiaCinDTO newCin = objectMapper.readValue(body, IndiaCinDTO.class);
                    IndiaCinVO oldCinBasic = oldCin.getIndiaCin();
                    IndiaCinBasicDTO newBasicDTO = newCin.getBasic();

                    if (CommonUtils.checkJsonField(newBasicDTO)) {
                        IndiaCin cinBasic = new IndiaCin();
                        BeanUtils.copyProperties(newBasicDTO, cinBasic);
                        cinBasic.setId(oldCinBasic.getId());
                        cinBasic.setEnterpriseId(oldCinBasic.getEnterpriseId());
                        cinBasic.setLogo(fileUrl2Location(cinBasic.getLogo(), oldCinBasic.getEnterpriseId()));
                        indiaCinMapper.updateByPrimaryKeySelective(cinBasic);
                        List<IndiaChargeVO> chargeList = oldCin.getChargeList();
                        if (chargeList != null) {
                            for (IndiaChargeVO indiaChargeVO : chargeList) {
                                indiaChargeMapper.deleteByPrimaryKey(indiaChargeVO.getId());
                            }
                        }
                        List<IndiaChargeDTO> charges = newCin.getCharges();
                        Optional.ofNullable(charges).ifPresent(k -> k.stream().forEach(j -> {
                            if (CommonUtils.checkJsonField(j)) {
                                IndiaCharge indiaCharge = new IndiaCharge();
                                BeanUtils.copyProperties(j, indiaCharge);
                                indiaCharge.setEnterpriseId(enterpriseId);
                                indiaChargeMapper.insertSelective(indiaCharge);
                            }
                        }));
                        List<IndiaSignatoryVO> signatoryList = oldCin.getSignatoryList();
                        if (signatoryList != null) {
                            for (IndiaSignatoryVO indiaSignatoryVO : signatoryList) {
                                indiaSignatoryMapper.deleteByPrimaryKey(indiaSignatoryVO.getId());
                            }
                        }
                        List<IndiaSignatoryDTO> signatory = newCin.getSignatory();
                        Optional.ofNullable(signatory).ifPresent(k -> k.stream().forEach(j -> {
                            if (CommonUtils.checkJsonField(j)) {
                                IndiaSignatory indiaSignatory = new IndiaSignatory();
                                BeanUtils.copyProperties(j, indiaSignatory);
                                indiaSignatory.setEnterpriseId(enterpriseId);
                                indiaSignatoryMapper.insertSelective(indiaSignatory);
                            }
                        }));

                        int flag = elasticsearch.modifyEnterprise("India", "cin", oldCinBasic.getId(),
                                oldCinBasic.getEnterpriseId(), cinBasic.getCompanyName(), cinBasic.getRegisteredAddress(),
                                cinBasic.getDateOfIncorporation(), cinBasic.getCin(), cinBasic.getLogo(), createTime, "india-cin", esId);
                        if (flag > 0) {
                            return ResultData.SUCCESS(null, "esId:" + esId + "修改成功");
                        } else {
                            throw new RuntimeException();
                        }
                    }
                    break;
                case "llpin":
                    IndiaLlpinEnterpriseVO oldLlpin = (IndiaLlpinEnterpriseVO) qccImpl.getEnterprise(enterpriseId, nation, eType, timezone);
                    if (oldLlpin == null) {
                        return ResultData.FAIL(null, 1101);
                    }
                    IndiaLlpinVO oldLlpinBasic = oldLlpin.getIndiaLlpinVO();
                    IndiaLlpinDTO newLlpin = objectMapper.readValue(body, IndiaLlpinDTO.class);
                    IndiaLlpinBasicDTO newLlpinBasic = newLlpin.getBasic();
                    if (CommonUtils.checkJsonField(newLlpinBasic)) {
                        IndiaLlpin basic = new IndiaLlpin();
                        BeanUtils.copyProperties(newLlpinBasic, basic);
                        basic.setId(oldLlpinBasic.getId());
                        basic.setEnterpriseId(oldLlpinBasic.getEnterpriseId());
                        basic.setLogo(fileUrl2Location(basic.getLogo(), oldLlpinBasic.getEnterpriseId()));
                        indiaLlpinMapper.updateByPrimaryKeySelective(basic);
                        List<IndiaChargeVO> chargeList = oldLlpin.getChargeList();
                        if (chargeList != null) {
                            for (IndiaChargeVO indiaChargeVO : chargeList) {
                                indiaChargeMapper.deleteByPrimaryKey(indiaChargeVO.getId());
                            }
                        }
                        List<IndiaChargeDTO> charges = newLlpin.getCharges();
                        Optional.ofNullable(charges).ifPresent(k -> k.stream().forEach(j -> {
                            if (CommonUtils.checkJsonField(j)) {
                                IndiaCharge indiaCharge = new IndiaCharge();
                                BeanUtils.copyProperties(j, indiaCharge);
                                indiaCharge.setEnterpriseId(enterpriseId);
                                indiaChargeMapper.insertSelective(indiaCharge);
                            }
                        }));
                        List<IndiaSignatoryVO> signatoryList = oldLlpin.getSignatoryList();
                        if (signatoryList != null) {
                            for (IndiaSignatoryVO indiaSignatoryVO : signatoryList) {
                                indiaSignatoryMapper.deleteByPrimaryKey(indiaSignatoryVO.getId());
                            }
                        }

                        List<IndiaSignatoryDTO> signatory = newLlpin.getSignatory();
                        Optional.ofNullable(signatory).ifPresent(k -> k.stream().forEach(j -> {
                            if (CommonUtils.checkJsonField(j)) {
                                IndiaSignatory indiaSignatory = new IndiaSignatory();
                                BeanUtils.copyProperties(j, indiaSignatory);
                                indiaSignatory.setEnterpriseId(enterpriseId);
                                indiaSignatoryMapper.insertSelective(indiaSignatory);
                            }
                        }));
                        int flag = elasticsearch.modifyEnterprise("India", "llpin", basic.getId(),
                                basic.getEnterpriseId(), basic.getLlpName(), basic.getRegistratedAddress(),
                                basic.getDateOfIncorporation(), basic.getLlpin(), basic.getLogo(), createTime, "india-llpin", esId);
                        if (flag > 0) {
                            return ResultData.SUCCESS(null, "esId:" + esId + "修改成功");
                        } else {
                            throw new RuntimeException();
                        }
                    }
                    break;
                case "Vietnam":
                    VietnamJsonDTO vietnamJsonDTO = objectMapper.readValue(body, VietnamJsonDTO.class);
                    break;
                case "Canada":
                    CanadaDTO canadaDTO = objectMapper.readValue(body, CanadaDTO.class);
                    break;
                case "France":
                    break;

            }
        }
        return ResultData.SUCCESS(null, "esId:" + esId + "修改失败");
    }


    /**
     * 上传logo图片
     *
     * @param file
     * @return 可访问的临时地址
     */
    @Override
    public ResultData uploadLogo(MultipartFile file) throws Exception {
        String sufString = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        if (!imgType.contains(sufString)) {
            return ResultData.FAIL(null, 905, "文件格式错误");
        }
        String logoTempDirPath = imagePath + "/logo-temp";
        File logoTempDir = new File(logoTempDirPath);
        if (!logoTempDir.exists()) {
            logoTempDir.mkdirs();
        }

        LocalDateTime localDateTime = LocalDateTime.now();
        long epochSecond = localDateTime.toEpochSecond(ZoneOffset.of("+8"));
        Random random = new Random();
        String tempFileName = logoTempDirPath + "/" + epochSecond + "-" + random.nextInt(9999) + "." + sufString;

        file.transferTo(new File(tempFileName));

        // 将本地路径转换为网络路径
        tempFileName = this.url + tempFileName.substring(imagePath.length());

        return ResultData.SUCCESS(tempFileName);
    }

    /**
     * 将网络地址的图片，从logo-temp转移到相应企业id的logo文件夹下，返回本地路径
     *
     * @param url
     * @param enterpriseId
     * @return 成功返回本地路径，失败返回原url
     */
    String fileUrl2Location(String url, String enterpriseId) {
        if (!StringUtils.isEmpty(url)) {
            try {
                url = imagePath + url.substring(this.url.length());
                File file = new File(url);
                File fileDir = new File(imagePath + "/logo/" + enterpriseId + "/");
                if (!fileDir.exists()) {
                    fileDir.mkdirs();
                }
                String destPath = fileDir + url.substring(imagePath.length() + "/logo-temp".length());
                File destFile = new File(destPath);
                if (file.renameTo(destFile)) {
                    return destPath;
                }
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("图片temp地址转换为实际地址异常:{},{}", CommonUtils.getExceptionInfo(e), url);
            }
        }
        return url;
    }

    /**
     * 将对象的id,gmtCreate,gmtModified,status设为NULL
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
