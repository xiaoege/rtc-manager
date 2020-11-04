package com.rtc.manager.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rtc.manager.dao.*;
import com.rtc.manager.dao.america.alabama.AmericaAlabamaDirectorMapper;
import com.rtc.manager.dao.america.alabama.AmericaAlabamaIncorporatorMapper;
import com.rtc.manager.dao.america.alabama.AmericaAlabamaMapper;
import com.rtc.manager.dao.america.alabama.AmericaAlabamaMemberMapper;
import com.rtc.manager.dao.america.alaska.AmericaAlaskaMapper;
import com.rtc.manager.dao.america.florida.AmericaFloridaAnnualReportFieldMapper;
import com.rtc.manager.dao.america.florida.AmericaFloridaAnnualReportYearMapper;
import com.rtc.manager.dao.america.florida.AmericaFloridaAuthorizedPersonDetailMapper;
import com.rtc.manager.dao.america.florida.AmericaFloridaMapper;
import com.rtc.manager.dao.america.newhampshire.*;
import com.rtc.manager.dao.america.northcarolina.*;
import com.rtc.manager.dao.america.ohio.AmericaOhioMapper;
import com.rtc.manager.dao.america.oklahoma.AmericaOklahomaMapper;
import com.rtc.manager.dao.america.oklahoma.AmericaOklahomaRegisteredAgentMapper;
import com.rtc.manager.dao.america.wyoming.AmericaWyomingFilingAnnualReportMapper;
import com.rtc.manager.dao.america.wyoming.AmericaWyomingMapper;
import com.rtc.manager.dao.america.wyoming.AmericaWyomingPartyMapper;
import com.rtc.manager.dao.canada.*;
import com.rtc.manager.entity.*;
import com.rtc.manager.entity.america.alabama.AmericaAlabama;
import com.rtc.manager.entity.america.alabama.AmericaAlabamaDirector;
import com.rtc.manager.entity.america.alabama.AmericaAlabamaIncorporator;
import com.rtc.manager.entity.america.alabama.AmericaAlabamaMember;
import com.rtc.manager.entity.america.alaska.AmericaAlaska;
import com.rtc.manager.entity.america.florida.AmericaFlorida;
import com.rtc.manager.entity.america.florida.AmericaFloridaAnnualReportField;
import com.rtc.manager.entity.america.florida.AmericaFloridaAnnualReportYear;
import com.rtc.manager.entity.america.florida.AmericaFloridaAuthorizedPersonDetail;
import com.rtc.manager.entity.america.newhampshire.*;
import com.rtc.manager.entity.america.northcarolina.*;
import com.rtc.manager.entity.america.ohio.AmericaOhio;
import com.rtc.manager.entity.america.oklahoma.AmericaOklahomaRegisteredAgent;
import com.rtc.manager.entity.america.wyoming.AmericaWyoming;
import com.rtc.manager.entity.america.wyoming.AmericaWyomingFilingAnnualReport;
import com.rtc.manager.entity.canada.*;
import com.rtc.manager.entity.dto.*;
import com.rtc.manager.entity.india.IndiaCharge;
import com.rtc.manager.entity.india.IndiaCin;
import com.rtc.manager.entity.india.IndiaLlpin;
import com.rtc.manager.entity.india.IndiaSignatory;
import com.rtc.manager.entity.vietnam.VietnamBusinessActivities;
import com.rtc.manager.entity.vietnam.VietnamEnterprise;
import com.rtc.manager.service.SaveJson;
import com.rtc.manager.util.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.io.*;
import java.util.*;

import static java.util.UUID.randomUUID;

/**
 * @author ChenHang
 */
@Service
public class SaveJsonImpl implements SaveJson {

    Logger logger = LoggerFactory.getLogger(SaveJsonImpl.class);

    @Autowired
    private RtcEnterpriseMapper rtcEnterpriseMapper;

    @Autowired
    private QccMatchSummaryMapper qccMatchSummaryMapper;

    @Autowired
    private QccMapper qccMapper;

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

    @Autowired
    private IndiaCinMapper indiaCinMapper;

    @Autowired
    private IndiaLlpinMapper indiaLlpinMapper;

    @Autowired
    private IndiaChargeMapper indiaChargeMapper;

    @Autowired
    private IndiaSignatoryMapper indiaSignatoryMapper;

    @Autowired
    private VietnamEnterpriseMapper vietnamEnterpriseMapper;

    @Autowired
    private VietnamBusinessActivitiesMapper vietnamBusinessActivitiesMapper;

    @Autowired
    private AmericaAlabamaMapper americaAlabamaMapper;

    @Autowired
    private AmericaAlabamaIncorporatorMapper americaAlabamaIncorporatorMapper;

    @Autowired
    private AmericaAlabamaMemberMapper americaAlabamaMemberMapper;

    @Autowired
    private AmericaAlabamaDirectorMapper americaAlabamaDirectorMapper;

    @Autowired
    private AmericaNewhampshireMapper americaNewhampshireMapper;

    @Autowired
    private AmericaNewhampshirePrincipalInformationMapper americaNewhampshirePrincipalInformationMapper;

    @Autowired
    private AmericaNewhampshirePrincipalPurposeMapper americaNewhampshirePrincipalPurposeMapper;

    @Autowired
    private AmericaNewhampshireTrademarkInformationMapper americaNewhampshireTrademarkInformationMapper;

    @Autowired
    private AmericaNewhampshireTradenameInformationMapper americaNewhampshireTradenameInformationMapper;

    @Autowired
    private AmericaNewhampshireTradenameOwnedbyMapper americaNewhampshireTradenameOwnedbyMapper;

    @Autowired
    private AmericaNewhampshireRegisteredAgentInformationMapper americaNewhampshireRegisteredAgentInformationMapper;

    @Autowired
    private AmericaNorthcarolinaMapper americaNorthcarolinaMapper;

    @Autowired
    private AmericaNorthcarolinaAddressMapper americaNorthcarolinaAddressMapper;

    @Autowired
    private AmericaNorthcarolinaOfficerMapper americaNorthcarolinaOfficerMapper;

    @Autowired
    private AmericaNorthcarolinaStockMapper americaNorthcarolinaStockMapper;

    @Autowired
    private AmericaNorthcarolinaCompanyOfficialMapper americaNorthcarolinaCompanyOfficialMapper;

    @Autowired
    private AmericaAlaskaMapper americaAlaskaMapper;

    @Autowired
    private AmericaWyomingMapper americaWyomingMapper;

    @Autowired
    private AmericaWyomingPartyMapper americaWyomingPartyMapper;

    @Autowired
    private AmericaWyomingFilingAnnualReportMapper americaWyomingFilingAnnualReportMapper;

    @Autowired
    private CanadaMapper canadaMapper;

    @Autowired
    private CanadaDirectorMapper canadaDirectorMapper;

    @Autowired
    private CanadaAnnualFilingMapper canadaAnnualFilingMapper;

    @Autowired
    private CanadaCorporateHistoryMapper canadaCorporateHistoryMapper;

    @Autowired
    private CanadaRegisteredOfficeAddressMapper canadaRegisteredOfficeAddressMapper;

    @Autowired
    private AmericaFloridaMapper americaFloridaMapper;

    @Autowired
    private AmericaFloridaAuthorizedPersonDetailMapper americaFloridaAuthorizedPersonDetailMapper;

    @Autowired
    private AmericaFloridaAnnualReportYearMapper americaFloridaAnnualReportYearMapper;

    @Autowired
    private AmericaFloridaAnnualReportFieldMapper americaFloridaAnnualReportFieldMapper;

    @Autowired
    private AmericaOhioMapper americaOhioMapper;

    @Autowired
    private AmericaOklahomaMapper americaOklahomaMapper;

    @Autowired
    private AmericaOklahomaRegisteredAgentMapper americaOklahomaRegisteredAgentMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void readJson(File filePath) throws Exception {
        List<String> fileList = new ArrayList();
        CommonUtils.readJsonFiles(filePath, fileList);
        for (int z = 0; z < fileList.size(); z++) {
            File file = new File(fileList.get(z));

            // 忽略mac的隐藏文件
            if (file.getName().contains(".DS_Store")) {
                continue;
            }
            logger.info("开始解析json文件，文件是{}，总文件{}个,正在处理第{}个", file.getPath(), fileList.size(), z + 1);

            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(bis));

            StringBuilder sb = new StringBuilder();
            while (reader.ready()) {
                sb.append((char) reader.read());
            }
            String sss = sb.toString();
            sss = sss.replace("\uFeFF", "");
            ObjectMapper objectMapper = new ObjectMapper();
            String result = objectMapper.writeValueAsString(sss);
            //总的数据，下面开始分开对每个对象（表）进行操作
            List<RtcEnterpriseDTO> contentList = null;
            try {
                contentList = objectMapper.readValue(sss, new TypeReference<List<RtcEnterpriseDTO>>() {
                });
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                logger.info("json序列化出现问题:{}", file.getName());
                logger.info("exception:{}", CommonUtils.getExceptionInfo(e));
//                continue;
                throw new Exception();
            }

            for (RtcEnterpriseDTO temp :
                    contentList) {
                // 基本信息insert  rtc_enterprise
                String uuid = getUUID();
                RtcEnterprise rtcEnterprise = new RtcEnterprise();
                temp.setUuid(uuid);
                BeanUtil.copyProperties(temp, rtcEnterprise);
//            BeanUtils.copyProperties(temp, rtcEnterprise);
                String nation = rtcEnterprise.getCountryRegion();
                rtcEnterpriseMapper.insertSelective(rtcEnterprise);
                List qccMatchSummaryList = temp.getQccMatchSummary();

                List<String> enterpriseIdList = new ArrayList();
                for (int i = 0; i < temp.getQccMatch(); i++) {
                    String enterpriseId = getUUID();
                    enterpriseIdList.add(enterpriseId);
                }

                for (int i = 0; i < qccMatchSummaryList.size(); i++) {
                    // qccMatchSummary insert  qcc_match_summary
                    HashMap qccMatchSummaryMap = (HashMap) qccMatchSummaryList.get(i);
                    String qccMatchSummaryJson = objectMapper.writeValueAsString(qccMatchSummaryMap);
                    QccMatchSummary qccMatchSummary = objectMapper.readValue(qccMatchSummaryJson, QccMatchSummary.class);
                    qccMatchSummary.setEnterpriseId(enterpriseIdList.get(i));
                    qccMatchSummaryMapper.insertSelective(qccMatchSummary);
                }
                List qccList = temp.getQcc();
                for (int i = 0; i < qccList.size(); i++) {
                    Object o = qccList.get(i);
                    if (o == null) {
                        continue;
                    }
                    String str = objectMapper.writeValueAsString(o);
                    Qcc qcc = objectMapper.readValue(str, Qcc.class);
                    // qcc insert
                    qcc.setRtcEnterpriseUuid(uuid);
                    qcc.setEnterpriseId(enterpriseIdList.get(i));
                    qcc.setNation(nation);
                    qccMapper.insertSelective(qcc);
                    //qcc-基本信息
                    HashMap basicInformation = qcc.getBasicInformation();
                    if (null != basicInformation && basicInformation.size() > 0) {
                        HashMap basicInformationMap = (HashMap) basicInformation.get("工商信息");
                        if (basicInformationMap != null && basicInformationMap.size() > 0) {
                            String basicInformationJsonString = objectMapper.writeValueAsString(basicInformationMap);
                            QccBusinessInformation qccBusinessInformation = objectMapper.readValue(basicInformationJsonString, QccBusinessInformation.class);
                            // insert qcc_business_information
                            qccBusinessInformation.setEnterpriseId(enterpriseIdList.get(i));
                            qccBusinessInformationMapper.insertSelective(qccBusinessInformation);
                        }

                        List<HashMap> qccShareholderList = (List<HashMap>) basicInformation.get("股东信息1");
                        if (!CollectionUtils.isEmpty(qccShareholderList)) {
                            for (int j = 0; j < qccShareholderList.size(); j++) {
                                String qccShareholderJsonString = objectMapper.writeValueAsString(qccShareholderList.get(j));
                                QccShareholder qccShareholder = objectMapper.readValue(qccShareholderJsonString, QccShareholder.class);
                                // insert qcc_shareholder
                                qccShareholder.setEnterpriseId(enterpriseIdList.get(i));
                                qccShareholderMapper.insertSelective(qccShareholder);
                            }
                        }

                        List<HashMap> qccShareholder3List = (List<HashMap>) basicInformation.get("股东信息3");
                        if (!CollectionUtils.isEmpty(qccShareholder3List)) {
                            for (int j = 0; j < qccShareholder3List.size(); j++) {
                                String qccShareholder3JsonString = objectMapper.writeValueAsString(qccShareholder3List.get(j));
                                QccShareholderThree qccShareholder = objectMapper.readValue(qccShareholder3JsonString, QccShareholderThree.class);
                                // insert qcc_shareholder3
                                qccShareholder.setEnterpriseId(enterpriseIdList.get(i));
                                qccShareholderThreeMapper.insertSelective(qccShareholder);
                            }
                        }

                        List<HashMap> qccQualificationList = (List<HashMap>) basicInformation.get("资质资格");
                        if (!CollectionUtils.isEmpty(qccQualificationList)) {
                            for (int j = 0; j < qccQualificationList.size(); j++) {
                                String qccQualificationJsonString = objectMapper.writeValueAsString(qccQualificationList.get(j));
                                QccQualification qccQualification = objectMapper.readValue(qccQualificationJsonString, QccQualification.class);
                                // insert qcc_qualification
                                qccQualification.setEnterpriseId(enterpriseIdList.get(i));
                                qccQualificationMapper.insertSelective(qccQualification);
                            }
                        }

                        List<HashMap> qccOutInvestmentList = (List<HashMap>) basicInformation.get("对外投资");
                        if (!CollectionUtils.isEmpty(qccOutInvestmentList)) {
                            for (int j = 0; j < qccOutInvestmentList.size(); j++) {
                                String qccOutInvestmentJsonString = objectMapper.writeValueAsString(qccOutInvestmentList.get(j));
                                QccOutInvestment qccOutInvestment = objectMapper.readValue(qccOutInvestmentJsonString, QccOutInvestment.class);
                                // insert qcc_out_investment
                                qccOutInvestment.setEnterpriseId(enterpriseIdList.get(i));
                                qccOutInvestmentMapper.insertSelective(qccOutInvestment);
                            }
                        }

                        List<HashMap> qccShareholderInvestmentList = (List<HashMap>) basicInformation.get("股东及出资信息");
                        if (!CollectionUtils.isEmpty(qccShareholderInvestmentList)) {
                            for (int j = 0; j < qccShareholderInvestmentList.size(); j++) {
                                String qccShareholderInvestmentJsonString = objectMapper.writeValueAsString(qccShareholderInvestmentList.get(j));
                                QccShareholderInvestment qccShareholderInvestment = objectMapper.readValue(qccShareholderInvestmentJsonString, QccShareholderInvestment.class);
                                // insert qcc_shareholder_investment
                                qccShareholderInvestment.setEnterpriseId(enterpriseIdList.get(i));
                                qccShareholderInvestmentMapper.insertSelective(qccShareholderInvestment);
                            }
                        }

                        List<HashMap> qccEquityChangeList = (List<HashMap>) basicInformation.get("股权变更信息");
                        if (!CollectionUtils.isEmpty(qccEquityChangeList)) {
                            for (int j = 0; j < qccEquityChangeList.size(); j++) {
                                String qccEquityChangeJsonString = objectMapper.writeValueAsString(qccEquityChangeList.get(j));
                                QccEquityChange qccEquityChange = objectMapper.readValue(qccEquityChangeJsonString, QccEquityChange.class);
                                // insert qcc_equity_change
                                qccEquityChange.setEnterpriseId(enterpriseIdList.get(i));
                                qccEquityChangeMapper.insertSelective(qccEquityChange);
                            }
                        }

                        List<HashMap> qccChangeRecordList = (List<HashMap>) basicInformation.get("变更记录");
                        if (!CollectionUtils.isEmpty(qccChangeRecordList)) {
                            for (int j = 0; j < qccChangeRecordList.size(); j++) {
                                String qccChangeRecordJsonString = objectMapper.writeValueAsString(qccChangeRecordList.get(j));
                                QccChangeRecord qccChangeRecord = objectMapper.readValue(qccChangeRecordJsonString, QccChangeRecord.class);
                                // insert qcc_change_record
                                qccChangeRecord.setEnterpriseId(enterpriseIdList.get(i));
                                qccChangeRecordMapper.insertSelective(qccChangeRecord);
                            }
                        }

                        List<HashMap> qccKeymanList = (List<HashMap>) basicInformation.get("主要人员");
                        if (!CollectionUtils.isEmpty(qccKeymanList)) {
                            for (int j = 0; j < qccKeymanList.size(); j++) {
                                String qccKeymanJsonString = objectMapper.writeValueAsString(qccKeymanList.get(j));
                                QccKeyman qccKeyman = objectMapper.readValue(qccKeymanJsonString, QccKeyman.class);
                                // insert qcc_keyman
                                qccKeyman.setEnterpriseId(enterpriseIdList.get(i));
                                qccKeymanMapper.insertSelective(qccKeyman);
                            }
                        }
                    }


                    // qcc-法律诉讼
                    HashMap legalProceeding = qcc.getLegalProceeding();
                    List<HashMap> qccJudgmentDocument = (List<HashMap>) legalProceeding.get("裁判文书");
                    if (!CollectionUtils.isEmpty(qccJudgmentDocument)) {
                        String qccJudgmentDocumentJsonString = objectMapper.writeValueAsString(qccJudgmentDocument);
                        List<QccJudgmentDocument> qccJudgmentDocumentList = objectMapper.readValue(qccJudgmentDocumentJsonString, new TypeReference<List<QccJudgmentDocument>>() {
                        });
                        for (int j = 0; j < qccJudgmentDocumentList.size(); j++) {
                            // insert qcc_judgment_document
                            QccJudgmentDocument qccJudgmentDocument1 = qccJudgmentDocumentList.get(j);
                            qccJudgmentDocument1.setEnterpriseId(enterpriseIdList.get(i));
                            qccJudgmentDocumentMapper.insertSelective(qccJudgmentDocument1);
                        }
                    }

                    List<HashMap> qccCourtNoticeList = (List<HashMap>) legalProceeding.get("开庭公告");
                    if (!CollectionUtils.isEmpty(qccCourtNoticeList)) {
                        String qccCourtNoticeJsonString = objectMapper.writeValueAsString(qccCourtNoticeList);
                        List<QccCourtNotice> qccCourtNoticeList1 = objectMapper.readValue(qccCourtNoticeJsonString, new TypeReference<List<QccCourtNotice>>() {
                        });
                        for (int j = 0; j < qccCourtNoticeList1.size(); j++) {
                            // insert qcc_court_notice
                            QccCourtNotice qccCourtNotice = qccCourtNoticeList1.get(j);
                            qccCourtNotice.setEnterpriseId(enterpriseIdList.get(i));
                            qccCourtNoticeMapper.insertSelective(qccCourtNotice);
                        }
                    }

                    List<HashMap> qccFilingInformationList = (List<HashMap>) legalProceeding.get("立案信息");
                    if (!CollectionUtils.isEmpty(qccFilingInformationList)) {
                        String qccFilingInformationJsonString = objectMapper.writeValueAsString(qccFilingInformationList);
                        List<QccFilingInformation> qccFilingInformationList1 = objectMapper.readValue(qccFilingInformationJsonString, new TypeReference<List<QccFilingInformation>>() {
                        });
                        for (int j = 0; j < qccFilingInformationList1.size(); j++) {
                            // insert qcc_filing_information
                            QccFilingInformation qccFilingInformation = qccFilingInformationList1.get(j);
                            qccFilingInformation.setEnterpriseId(enterpriseIdList.get(i));
                            qccFilingInformationMapper.insertSelective(qccFilingInformation);
                        }
                    }

                    // qcc-经营状况
                    HashMap businessStatus = qcc.getBusinessStatus();
                    List<HashMap> qccAdministrativeLicense = (List<HashMap>) businessStatus.get("行政许可 [工商局]");
                    if (!CollectionUtils.isEmpty(qccAdministrativeLicense)) {
                        String qccAdministrativeLicenseJsonString = objectMapper.writeValueAsString(qccAdministrativeLicense);
                        List<QccAdministrativeLicense> qccAdministrativeLicenseList = objectMapper.readValue(qccAdministrativeLicenseJsonString, new TypeReference<List<QccAdministrativeLicense>>() {
                        });
                        for (int j = 0; j < qccAdministrativeLicenseList.size(); j++) {
                            // insert qcc_administrative_license
                            QccAdministrativeLicense qccAdministrativeLicense1 = qccAdministrativeLicenseList.get(j);
                            qccAdministrativeLicense1.setEnterpriseId(enterpriseIdList.get(i));
                            qccAdministrativeLicenseMapper.insertSelective(qccAdministrativeLicense1);
                        }
                    }

                    List<HashMap> qccTaxCredit = (List<HashMap>) businessStatus.get("税务信用");
                    if (!CollectionUtils.isEmpty(qccTaxCredit)) {
                        String qccTaxCreditJsonString = objectMapper.writeValueAsString(qccTaxCredit);
                        List<QccTaxCredit> qccTaxCreditList = objectMapper.readValue(qccTaxCreditJsonString, new TypeReference<List<com.rtc.manager.entity.QccTaxCredit>>() {
                        });
                        for (int j = 0; j < qccTaxCreditList.size(); j++) {
                            // insert qcc_tax_credit
                            QccTaxCredit qccTaxCredit1 = qccTaxCreditList.get(j);
                            qccTaxCredit1.setEnterpriseId(enterpriseIdList.get(i));
                            qccTaxCreditMapper.insertSelective(qccTaxCredit1);
                        }
                    }

                    List<HashMap> qccImportExportCredit = (List<HashMap>) businessStatus.get("进出口信用");
                    if (!CollectionUtils.isEmpty(qccImportExportCredit)) {
                        String qccImportExportCreditJsonString = objectMapper.writeValueAsString(qccImportExportCredit);
                        List<QccImportExportCredit> qccImportExportCreditList = objectMapper.readValue(qccImportExportCreditJsonString, new TypeReference<List<QccImportExportCredit>>() {
                        });
                        for (int j = 0; j < qccImportExportCreditList.size(); j++) {
                            // insert qcc_import_export_credit
                            QccImportExportCredit qccImportExportCredit1 = qccImportExportCreditList.get(j);
                            qccImportExportCredit1.setEnterpriseId(enterpriseIdList.get(i));
                            qccImportExportCreditMapper.insertSelective(qccImportExportCredit1);
                        }
                    }

                    List<HashMap> qccGeneralTaxpayer = (List<HashMap>) businessStatus.get("一般纳税人");
                    if (!CollectionUtils.isEmpty(qccGeneralTaxpayer)) {
                        String qccGeneralTaxpayerJsonString = objectMapper.writeValueAsString(qccGeneralTaxpayer);
                        List<QccGeneralTaxpayer> qccGeneralTaxpayerList = objectMapper.readValue(qccGeneralTaxpayerJsonString, new TypeReference<List<QccGeneralTaxpayer>>() {
                        });
                        for (int j = 0; j < qccGeneralTaxpayerList.size(); j++) {
                            // insert qcc_general_taxpayer
                            QccGeneralTaxpayer qccGeneralTaxpayer1 = qccGeneralTaxpayerList.get(j);
                            qccGeneralTaxpayer1.setEnterpriseId(enterpriseIdList.get(i));
                            qccGeneralTaxpayerMapper.insertSelective(qccGeneralTaxpayer1);
                        }
                    }

                    List<HashMap> qccBidding = (List<HashMap>) businessStatus.get("招投标动态");
                    if (!CollectionUtils.isEmpty(qccBidding)) {
                        String qccBiddingJsonString = objectMapper.writeValueAsString(qccBidding);
                        List<QccBidding> qccBiddingList = objectMapper.readValue(qccBiddingJsonString, new TypeReference<List<QccBidding>>() {
                        });
                        for (int j = 0; j < qccBiddingList.size(); j++) {
                            // insert qcc_bidding
                            QccBidding qccBidding1 = qccBiddingList.get(j);
                            qccBidding1.setEnterpriseId(enterpriseIdList.get(i));
                            qccBiddingMapper.insertSelective(qccBidding1);
                        }
                    }

                    List<HashMap> landPurchaseInformation = (List<HashMap>) businessStatus.get("购地信息");
                    if (!CollectionUtils.isEmpty(landPurchaseInformation)) {
                        String landPurchaseInformationJsonString = objectMapper.writeValueAsString(landPurchaseInformation);
                        List<QccLandPurchaseInformation> qccLandPurchaseInformationList = objectMapper.readValue(landPurchaseInformationJsonString, new TypeReference<List<QccLandPurchaseInformation>>() {
                        });
                        for (int j = 0; j < qccLandPurchaseInformationList.size(); j++) {
                            QccLandPurchaseInformation qccLandPurchaseInformation = qccLandPurchaseInformationList.get(j);
                            qccLandPurchaseInformation.setEnterpriseId(enterpriseIdList.get(i));
                            qccLandPurchaseInformationMapper.insertSelective(qccLandPurchaseInformation);
                        }
                    }

                    List<HashMap> qccSupplier = (List<HashMap>) businessStatus.get("供应商");
                    if (!CollectionUtils.isEmpty(qccSupplier)) {
                        String qccSupplierJsonString = objectMapper.writeValueAsString(qccSupplier);
                        List<QccSupplier> qccSupplierList = objectMapper.readValue(qccSupplierJsonString, new TypeReference<List<QccSupplier>>() {
                        });
                        for (int j = 0; j < qccSupplierList.size(); j++) {
                            QccSupplier qccSupplier1 = qccSupplierList.get(j);
                            qccSupplier1.setEnterpriseId(enterpriseIdList.get(i));
                            qccSupplierMapper.insertSelective(qccSupplier1);
                        }
                    }

                    List<HashMap> qccClient = (List<HashMap>) businessStatus.get("客户");
                    if (!CollectionUtils.isEmpty(qccClient)) {
                        String qccClientJsonString = objectMapper.writeValueAsString(qccClient);
                        List<QccClient> qccClientList = objectMapper.readValue(qccClientJsonString, new TypeReference<List<QccClient>>() {
                        });
                        for (int j = 0; j < qccClientList.size(); j++) {
                            QccClient qccClient1 = qccClientList.get(j);
                            qccClient1.setEnterpriseId(enterpriseIdList.get(i));
                            qccClientMapper.insertSelective(qccClient1);
                        }
                    }

                    List<HashMap> qccAdministrativeLicenseChinaList = (List<HashMap>) businessStatus.get("行政许可 [信用中国]");
                    if (!CollectionUtils.isEmpty(qccAdministrativeLicenseChinaList)) {
                        String qccAdministrativeLicenseChinaJsonString = objectMapper.writeValueAsString(qccAdministrativeLicenseChinaList);
                        List<QccAdministrativeLicenseChina> qccAdministrativeLicenseChinaList1 = (List<QccAdministrativeLicenseChina>) objectMapper
                                .readValue(qccAdministrativeLicenseChinaJsonString, new TypeReference<List<QccAdministrativeLicenseChina>>() {
                                });
                        for (int j = 0; j < qccAdministrativeLicenseChinaList1.size(); j++) {
                            QccAdministrativeLicenseChina qccAdministrativeLicenseChina = qccAdministrativeLicenseChinaList1.get(j);
                            qccAdministrativeLicenseChina.setEnterpriseId(enterpriseIdList.get(i));
                            qccAdministrativeLicenseChinaMapper.insertSelective(qccAdministrativeLicenseChina);
                        }
                    }

                    List<HashMap> qccSpotCheckList = (List<HashMap>) businessStatus.get("抽查检查");
                    if (!CollectionUtils.isEmpty(qccSpotCheckList)) {
                        String qccSpotCheckJsonString = objectMapper.writeValueAsString(qccSpotCheckList);
                        List<QccSpotCheck> qccSpotCheckList1 = (List<QccSpotCheck>) objectMapper.readValue(qccSpotCheckJsonString, new TypeReference<List<QccSpotCheck>>() {
                        });
                        for (int j = 0; j < qccSpotCheckList1.size(); j++) {
                            QccSpotCheck qccSpotCheck = qccSpotCheckList1.get(j);
                            qccSpotCheck.setEnterpriseId(enterpriseIdList.get(i));
                            qccSpotCheckMapper.insertSelective(qccSpotCheck);
                        }
                    }

                    // qcc-企业发展
                    HashMap enterpriseDevelopment = qcc.getEnterpriseDevelopment();
                    LinkedHashMap qccAnnualReport = (LinkedHashMap) enterpriseDevelopment.get("企业年报");
                    Set qccAnnualReportKeySet = qccAnnualReport.entrySet();
                    Iterator iterator = qccAnnualReportKeySet.iterator();
                    while (iterator.hasNext()) {
                        QccAnnualReport qarTemp = new QccAnnualReport();
                        Map.Entry<String, LinkedHashMap> next = (Map.Entry<String, LinkedHashMap>) iterator.next();
                        String year = next.getKey();
                        String annualReportUuid = getUUID();
                        qarTemp.setUuid(annualReportUuid);
                        qarTemp.setYear(year);
                        LinkedHashMap value = next.getValue();
                        HashMap basicInfo = (HashMap) value.get("企业基本信息");
                        String qccAnnualReportJson1 = objectMapper.writeValueAsString(basicInfo);
                        QccAnnualReport qccAnnualReport1 = objectMapper.readValue(qccAnnualReportJson1, QccAnnualReport.class);
                        BeanUtil.copyProperties(qccAnnualReport1, qarTemp, true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
                        HashMap assetStatus = (HashMap) value.get("企业资产状况信息");
                        String qccAnnualReportJson2 = objectMapper.writeValueAsString(assetStatus);
                        QccAnnualReport qccAnnualReport2 = objectMapper.readValue(qccAnnualReportJson2, QccAnnualReport.class);
                        BeanUtil.copyProperties(qccAnnualReport2, qarTemp, true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
                        HashMap socialInsurance = (HashMap) value.get("社保信息");
                        String qccAnnualReportJson3 = objectMapper.writeValueAsString(socialInsurance);
                        QccAnnualReport qccAnnualReport3 = objectMapper.readValue(qccAnnualReportJson3, QccAnnualReport.class);
                        BeanUtil.copyProperties(qccAnnualReport3, qarTemp, true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
                        // insert qarTemp into qcc_annual_report
                        qarTemp.setEnterpriseId(enterpriseIdList.get(i));
                        qccAnnualReportMapper.insertSelective(qarTemp);

                        List annualReportShareholderlist = (ArrayList) value.get("股东（发起人）出资信息");
                        if (!CollectionUtils.isEmpty(annualReportShareholderlist)) {
                            String annualReportShareholderJsonString = objectMapper.writeValueAsString(annualReportShareholderlist);
                            List<QccAnnualReportShareholder> qccAnnualReportShareholderList = objectMapper.readValue(annualReportShareholderJsonString, new TypeReference<List<QccAnnualReportShareholder>>() {
                            });
                            for (int j = 0; j < qccAnnualReportShareholderList.size(); j++) {
                                QccAnnualReportShareholder qccAnnualReportShareholder = (QccAnnualReportShareholder) qccAnnualReportShareholderList.get(j);
                                qccAnnualReportShareholder.setEnterpriseId(enterpriseIdList.get(i));
                                qccAnnualReportShareholder.setAnnualReportUuid(annualReportUuid);
                                qccAnnualReportShareholderMapper.insertSelective(qccAnnualReportShareholder);
                            }
                        }
                    }

                    List<HashMap> qccFinancingConsultation = (List<HashMap>) enterpriseDevelopment.get("融资信息");
                    if (!CollectionUtils.isEmpty(qccFinancingConsultation)) {
                        String qccFinancingConsultationJsonString = objectMapper.writeValueAsString(qccFinancingConsultation);
                        List<QccFinancingConsultation> qccFinancingConsultationList = objectMapper.readValue(qccFinancingConsultationJsonString, new TypeReference<List<QccFinancingConsultation>>() {
                        });
                        for (int j = 0; j < qccFinancingConsultationList.size(); j++) {
                            QccFinancingConsultation qccFinancingConsultation1 = qccFinancingConsultationList.get(j);
                            qccFinancingConsultation1.setEnterpriseId(enterpriseIdList.get(i));
                            qccFinancingConsultationMapper.insertSelective(qccFinancingConsultation1);
                        }
                    }

                    // qcc-知识产权
                    HashMap intellectualProperty = qcc.getIntellectualProperty();
                    List<HashMap> qccQualificationCertificate = (List<HashMap>) intellectualProperty.get("资质证书");
                    if (!CollectionUtils.isEmpty(qccQualificationCertificate)) {
                        String qccQualificationCertificateJsonString = objectMapper.writeValueAsString(qccQualificationCertificate);
                        List<QccQualificationCertificate> qccQualificationCertificateList = objectMapper.readValue(qccQualificationCertificateJsonString, new TypeReference<List<QccQualificationCertificate>>() {
                        });
                        for (int j = 0; j < qccQualificationCertificateList.size(); j++) {
                            // insert qcc_qualification_certificate
                            QccQualificationCertificate qccQualificationCertificate1 = qccQualificationCertificateList.get(j);
                            qccQualificationCertificate1.setEnterpriseId(enterpriseIdList.get(i));
                            qccQualificationCertificateMapper.insertSelective(qccQualificationCertificate1);
                        }
                    }


                    List<HashMap> websiteInformation = (List<HashMap>) intellectualProperty.get("网站信息");
                    if (!CollectionUtils.isEmpty(websiteInformation)) {
                        String websiteInformationJsonString = objectMapper.writeValueAsString(websiteInformation);
                        List<QccWebsiteInformation> qccWebsiteInformationList = objectMapper.readValue(websiteInformationJsonString, new TypeReference<List<QccWebsiteInformation>>() {
                        });
                        for (int j = 0; j < qccWebsiteInformationList.size(); j++) {
                            // insert qcc_website_information
                            QccWebsiteInformation qccWebsiteInformation = qccWebsiteInformationList.get(j);
                            qccWebsiteInformation.setEnterpriseId(enterpriseIdList.get(i));
                            qccWebsiteInformationMapper.insertSelective(qccWebsiteInformation);
                        }
                    }

                    List<HashMap> qccSoftwareCopyright = (List<HashMap>) intellectualProperty.get("软件著作权");
                    if (!CollectionUtils.isEmpty(qccSoftwareCopyright)) {
                        String qccSoftwareCopyrightJsonString = objectMapper.writeValueAsString(qccSoftwareCopyright);
                        List<QccSoftwareCopyright> qccSoftwareCopyrightList = objectMapper.readValue(qccSoftwareCopyrightJsonString, new TypeReference<List<QccSoftwareCopyright>>() {
                        });
                        for (int j = 0; j < qccSoftwareCopyrightList.size(); j++) {
                            QccSoftwareCopyright qccSoftwareCopyright1 = qccSoftwareCopyrightList.get(j);
                            qccSoftwareCopyright1.setEnterpriseId(enterpriseIdList.get(i));
                            qccSoftwareCopyrightMapper.insertSelective(qccSoftwareCopyright1);
                        }
                    }

                    List<HashMap> qccApp = (List<HashMap>) intellectualProperty.get("App");
                    if (!CollectionUtils.isEmpty(qccApp)) {
                        String qccAppJsonString = objectMapper.writeValueAsString(qccApp);
                        List<QccApp> qccAppList = objectMapper.readValue(qccAppJsonString, new TypeReference<List<QccApp>>() {
                        });
                        for (int j = 0; j < qccAppList.size(); j++) {
                            QccApp qccApp1 = qccAppList.get(j);
                            qccApp1.setEnterpriseId(enterpriseIdList.get(i));
                            qccAppMapper.insertSelective(qccApp1);
                        }
                    }

                    List<HashMap> qccApplet = (List<HashMap>) intellectualProperty.get("小程序");
                    if (!CollectionUtils.isEmpty(qccApplet)) {
                        String qccAppletJsonString = objectMapper.writeValueAsString(qccApplet);
                        List<QccApplet> qccAppletList = objectMapper.readValue(qccAppletJsonString, new TypeReference<List<QccApplet>>() {
                        });
                        for (int j = 0; j < qccAppletList.size(); j++) {
                            QccApplet qccApplet1 = qccAppletList.get(j);
                            qccApplet1.setEnterpriseId(enterpriseIdList.get(i));
                            qccAppletMapper.insertSelective(qccApplet1);
                        }
                    }

                    List<HashMap> qccWechat = (List<HashMap>) intellectualProperty.get("微信公众号");
                    if (!CollectionUtils.isEmpty(qccWechat)) {
                        String qccWechatJsonString = objectMapper.writeValueAsString(qccWechat);
                        List<QccWechat> qccWechatList = objectMapper.readValue(qccWechatJsonString, new TypeReference<List<QccWechat>>() {
                        });
                        for (int j = 0; j < qccWechatList.size(); j++) {
                            QccWechat qccWechat1 = qccWechatList.get(j);
                            qccWechat1.setEnterpriseId(enterpriseIdList.get(i));
                            qccWechatMapper.insertSelective(qccWechat1);
                        }
                    }

                    List<HashMap> qccWeibo = (List<HashMap>) intellectualProperty.get("微博");
                    if (!CollectionUtils.isEmpty(qccWeibo)) {
                        String qccWeiboJsonString = objectMapper.writeValueAsString(qccWeibo);
                        List<QccWeibo> qccWeiboList = objectMapper.readValue(qccWeiboJsonString, new TypeReference<List<QccWeibo>>() {
                        });
                        for (int j = 0; j < qccWeiboList.size(); j++) {
                            QccWeibo qccWeibo1 = qccWeiboList.get(j);
                            qccWeibo1.setEnterpriseId(enterpriseIdList.get(i));
                            qccWeiboMapper.insertSelective(qccWeibo1);
                        }
                    }

                    // qcc-经营风险
                    HashMap businessRisk = qcc.getBusinessRisk();
                    List<HashMap> qccAdministrativeSanction = (List<HashMap>) businessRisk.get("行政处罚");
                    if (!CollectionUtils.isEmpty(qccAdministrativeSanction)) {
                        String qccAdministrativeSanctionJsonString = objectMapper.writeValueAsString(qccAdministrativeSanction);
                        List<QccAdministrativeSanction> qccAdministrativeSanctionList = objectMapper.readValue(qccAdministrativeSanctionJsonString, new TypeReference<List<QccAdministrativeSanction>>() {
                        });
                        for (int j = 0; j < qccAdministrativeSanctionList.size(); j++) {
                            QccAdministrativeSanction qccAdministrativeSanction1 = qccAdministrativeSanctionList.get(j);
                            qccAdministrativeSanction1.setEnterpriseId(enterpriseIdList.get(i));
                            qccAdministrativeSanctionMapper.insertSelective(qccAdministrativeSanction1);
                        }
                    }

                    List<QccRemoveException> qccRemoveExceptions = (List<QccRemoveException>) businessRisk.get("经营异常/移出异常");
                    if (!CollectionUtils.isEmpty(qccRemoveExceptions)) {
                        String qccRemoveExceptionJsonString = objectMapper.writeValueAsString(qccRemoveExceptions);
                        List<QccRemoveException> qccRemoveExceptionList = objectMapper.readValue(qccRemoveExceptionJsonString, new TypeReference<List<QccRemoveException>>() {
                        });
                        for (int j = 0; j < qccRemoveExceptionList.size(); j++) {
                            QccRemoveException qccRemoveException = qccRemoveExceptionList.get(j);
                            qccRemoveException.setEnterpriseId(enterpriseIdList.get(i));
                            qccRemoveExceptionMapper.insertSelective(qccRemoveException);
                        }
                    }

                    List<QccSaveException> qccSaveExceptions = (List<QccSaveException>) businessRisk.get("经营异常/移入异常");
                    if (!CollectionUtils.isEmpty(qccSaveExceptions)) {
                        String qccSaveExceptionJsonString = objectMapper.writeValueAsString(qccSaveExceptions);
                        List<QccSaveException> qccSaveExceptionList = objectMapper.readValue(qccSaveExceptionJsonString, new TypeReference<List<QccSaveException>>() {
                        });
                        for (int j = 0; j < qccSaveExceptionList.size(); j++) {
                            QccSaveException qccSaveException = qccSaveExceptionList.get(j);
                            qccSaveException.setEnterpriseId(enterpriseIdList.get(i));
                            qccSaveExceptionMapper.insertSelective(qccSaveException);
                        }
                    }

                    List<HashMap> qccEquityPledgeList = (List<HashMap>) businessRisk.get("股权质押");
                    if (!CollectionUtils.isEmpty(qccEquityPledgeList)) {
                        String qccEquityPledgeJsonString = objectMapper.writeValueAsString(qccEquityPledgeList);
                        List<QccEquityPledge> qccEquityPledgeList1 = objectMapper.readValue(qccEquityPledgeJsonString, new TypeReference<List<QccEquityPledge>>() {
                        });
                        for (int j = 0; j < qccEquityPledgeList1.size(); j++) {
                            // insert qcc_equity_pledge
                            QccEquityPledge qccEquityPledge = qccEquityPledgeList1.get(j);
                            qccEquityPledge.setEnterpriseId(enterpriseIdList.get(i));
                            qccEquityPledgeMapper.insertSelective(qccEquityPledge);
                        }
                    }

                    List<HashMap> qccTaxArrearsNoticeList = (List<HashMap>) businessRisk.get("欠税公告");
                    if (!CollectionUtils.isEmpty(qccTaxArrearsNoticeList)) {
                        String qccTaxArrearsNoticeJsonString = objectMapper.writeValueAsString(qccTaxArrearsNoticeList);
                        List<QccTaxArrearsNotice> qccTaxArrearsNoticeList1 = objectMapper.readValue(qccTaxArrearsNoticeJsonString, new TypeReference<List<QccTaxArrearsNotice>>() {
                        });
                        for (int j = 0; j < qccTaxArrearsNoticeList1.size(); j++) {
                            // insert qcc_tax_arrears_notice
                            QccTaxArrearsNotice qccTaxArrearsNotice = qccTaxArrearsNoticeList1.get(j);
                            qccTaxArrearsNotice.setEnterpriseId(enterpriseIdList.get(i));
                            qccTaxArrearsNoticeMapper.insertSelective(qccTaxArrearsNotice);
                        }
                    }

                    List<HashMap> qccJudicialAuctionList = (List<HashMap>) businessRisk.get("司法拍卖");
                    if (!CollectionUtils.isEmpty(qccJudicialAuctionList)) {
                        String qccJudicialAuctionJsonString = objectMapper.writeValueAsString(qccJudicialAuctionList);
                        List<QccJudicialAuction> qccJudicialAuctionList1 = objectMapper.readValue(qccJudicialAuctionJsonString, new TypeReference<List<QccJudicialAuction>>() {
                        });
                        for (int j = 0; j < qccJudicialAuctionList1.size(); j++) {
                            // insert qcc_judicial_auction
                            QccJudicialAuction qccJudicialAuction = qccJudicialAuctionList1.get(j);
                            qccJudicialAuction.setEnterpriseId(enterpriseIdList.get(i));
                            qccJudicialAuctionMapper.insertSelective(qccJudicialAuction);
                        }
                    }

                    List<HashMap> qccTaxViolationList = (List<HashMap>) businessRisk.get("税收违法");
                    if (!CollectionUtils.isEmpty(qccTaxViolationList)) {
                        String qccTaxViolationJsonString = objectMapper.writeValueAsString(qccTaxViolationList);
                        List<QccTaxViolation> qccTaxViolationList1 = objectMapper.readValue(qccTaxViolationJsonString, new TypeReference<List<QccTaxViolation>>() {
                        });
                        for (int j = 0; j < qccTaxViolationList1.size(); j++) {
                            // insert qcc_tax_violation
                            QccTaxViolation qccTaxViolation = qccTaxViolationList1.get(j);
                            qccTaxViolation.setEnterpriseId(enterpriseIdList.get(i));
                            qccTaxViolationMapper.insertSelective(qccTaxViolation);
                        }
                    }

                    List<HashMap> qccEnvironmentalPunishmentList = (List<HashMap>) businessRisk.get("环保处罚");
                    if (!CollectionUtils.isEmpty(qccEnvironmentalPunishmentList)) {
                        String qccEnvironmentalPunishmentJsonString = objectMapper.writeValueAsString(qccEnvironmentalPunishmentList);
                        List<QccEnvironmentalPunishment> qccEnvironmentalPunishmentList1 = objectMapper.readValue(qccEnvironmentalPunishmentJsonString, new TypeReference<List<QccEnvironmentalPunishment>>() {
                        });
                        for (int j = 0; j < qccEnvironmentalPunishmentList1.size(); j++) {
                            // insert qcc_environmental_punishment
                            QccEnvironmentalPunishment qccEnvironmentalPunishment = qccEnvironmentalPunishmentList1.get(j);
                            qccEnvironmentalPunishment.setEnterpriseId(enterpriseIdList.get(i));
                            qccEnvironmentalPunishmentMapper.insertSelective(qccEnvironmentalPunishment);
                        }
                    }

                    List<HashMap> qccEquityOutPledgeList = (List<HashMap>) businessRisk.get("股权出质");
                    if (!CollectionUtils.isEmpty(qccEquityOutPledgeList)) {
                        String qccEquityOutPledgeJsonString = objectMapper.writeValueAsString(qccEquityOutPledgeList);
                        List<QccEquityOutPledge> qccEquityOutPledgeList1 = objectMapper.readValue(qccEquityOutPledgeJsonString, new TypeReference<List<QccEquityOutPledge>>() {
                        });
                        for (int j = 0; j < qccEquityOutPledgeList1.size(); j++) {
                            // insert qcc_equity_out_pledge
                            QccEquityOutPledge qccEquityOutPledge = qccEquityOutPledgeList1.get(j);
                            qccEquityOutPledge.setEnterpriseId(enterpriseIdList.get(i));
                            qccEquityOutPledgeMapper.insertSelective(qccEquityOutPledge);
                        }
                    }

                }

            }
            logger.info("json文件导入成功，文件是{}", file.getName());
            reader.close();
            bis.close();
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void readJsonIndia(File filePath) throws Exception {
        List<String> fileList = new ArrayList();
        CommonUtils.readJsonFiles(filePath, fileList);
        for (int z = 0; z < fileList.size(); z++) {
            File file = new File(fileList.get(z));

            // 忽略mac的隐藏文件
            if (file.getName().contains(".DS_Store")) {
                continue;
            }
            logger.info("开始解析json文件，文件是{}，总文件{}个,正在处理第{}个", file.getPath(), fileList.size(), z + 1);

            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(bis));

            StringBuilder sb = new StringBuilder();
            while (reader.ready()) {
                sb.append((char) reader.read());
            }
            String sss = sb.toString();
//            sss = sss.replace("\uFeFF", "");
            ObjectMapper objectMapper = new ObjectMapper();
            List<HashMap> list = null;
            try {
                list = (List<HashMap>) objectMapper.readValue(sss, Object.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                logger.info("json序列化出现问题:{}", file.getName());
                logger.info("exception:{}", CommonUtils.getExceptionInfo(e));
//                continue;
                throw new Exception();
            }
            int cin = 0;
            int llpin = 0;
            if (!CollectionUtils.isEmpty(list)) {
                for (int i = 0; i < list.size(); i++) {
                    HashMap hashMap = list.get(i);
                    if (!CollectionUtils.isEmpty(hashMap)) {
                        String hashMapString = objectMapper.writeValueAsString(hashMap);
                        List keys = CommonUtils.getKeys((Map) hashMap.get("basic"));
                        if (keys.contains("CIN")) {
                            IndiaCinDTO indiaCinDTO = objectMapper.readValue(hashMapString, IndiaCinDTO.class);
                            String enterpriseId = getUUID();
                            IndiaCin basic = indiaCinDTO.getBasic();
                            List<IndiaCharge> charges = indiaCinDTO.getCharges();
                            List<IndiaSignatory> signatoryList = indiaCinDTO.getSignatory();
                            basic.setEnterpriseId(enterpriseId);
                            indiaCinMapper.insertSelective(basic);
                            for (IndiaCharge indiaCharge :
                                    charges) {
                                indiaCharge.setEnterpriseId(enterpriseId);
                                indiaChargeMapper.insertSelective(indiaCharge);
                            }
                            for (IndiaSignatory indiaSignatory :
                                    signatoryList) {
                                indiaSignatory.setEnterpriseId(enterpriseId);
                                indiaSignatoryMapper.insertSelective(indiaSignatory);
                            }
                            cin++;
                        } else if (keys.contains("LLPIN")) {
                            IndiaLlpinDTO indiaLlpinDTO = objectMapper.readValue(hashMapString, IndiaLlpinDTO.class);
                            String enterpriseId = getUUID();
                            IndiaLlpin basic = indiaLlpinDTO.getBasic();
                            List<IndiaCharge> charges = indiaLlpinDTO.getCharges();
                            List<IndiaSignatory> signatoryList = indiaLlpinDTO.getSignatory();
                            basic.setEnterpriseId(enterpriseId);
                            indiaLlpinMapper.insertSelective(basic);
                            for (IndiaCharge indiaCharge :
                                    charges) {
                                indiaCharge.setEnterpriseId(enterpriseId);
                                indiaChargeMapper.insertSelective(indiaCharge);
                            }
                            for (IndiaSignatory indiaSignatory :
                                    signatoryList) {
                                indiaSignatory.setEnterpriseId(enterpriseId);
                                indiaSignatoryMapper.insertSelective(indiaSignatory);
                            }
                        }

                    }
                }
                logger.info("json文件导入成功，文件是{}", file.getName());
                reader.close();
                bis.close();
            }
        }
    }

    /**
     * 解析json文件导入到数据库
     * 越南企业
     *
     * @param dirPath json文件上一级文件夹路径，里面只能有json文件
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void readJsonVietnam(File fileDirPath) throws Exception {
        List<String> fileList = new ArrayList();
        CommonUtils.readJsonFiles(fileDirPath, fileList);
        ObjectMapper objectMapper = new ObjectMapper();
        for (int z = 0; z < fileList.size(); z++) {
            File file = new File(fileList.get(z));

            // 忽略mac的隐藏文件
            if (file.getName().contains(".DS_Store")) {
                continue;
            }
            logger.info("开始解析json文件，文件是{}，总文件{}个,正在处理第{}个", file.getPath(), fileList.size(), z + 1);

            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(bis));

            StringBuilder sb = new StringBuilder();
            while (reader.ready()) {
                sb.append((char) reader.read());
            }
            String sss = sb.toString();
//            sss = sss.replace("\uFeFF", "");
            List<VietnamJsonDTO> list = null;
            try {
                list = objectMapper.readValue(sss, new TypeReference<List<VietnamJsonDTO>>() {
                });
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                logger.info("json序列化出现问题:{}", file.getName());
                logger.info("exception:{}", CommonUtils.getExceptionInfo(e));
//                continue;
                throw e;
            }
            if (!CollectionUtils.isEmpty(list)) {
                for (int i = 0; i < list.size(); i++) {
                    VietnamJsonDTO vietnamJsonDTO = list.get(i);
                    String uuid = getUUID();
                    vietnamJsonDTO.setEnterpriseId(uuid);
                    VietnamEnterprise vietnamEnterprise = new VietnamEnterprise();
                    BeanUtils.copyProperties(vietnamJsonDTO, vietnamEnterprise);
                    vietnamEnterpriseMapper.insertSelective(vietnamEnterprise);
                    List<VietnamBusinessActivities> vietnamBusinessActivitiesList = vietnamJsonDTO.getVietnamBusinessActivitiesList();
                    if (!CollectionUtils.isEmpty(vietnamBusinessActivitiesList)) {
                        for (int j = 0; j < vietnamBusinessActivitiesList.size(); j++) {
                            VietnamBusinessActivities vietnamBusinessActivities = vietnamBusinessActivitiesList.get(j);
                            vietnamBusinessActivities.setEnterpriseId(uuid);
                            vietnamBusinessActivitiesMapper.insertSelective(vietnamBusinessActivities);
                        }
                    }

                }
                logger.info("json文件导入成功，文件是{}", file.getName());
                reader.close();
                bis.close();
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveJsonAmerica4Alabama(File fileDirPath) throws Exception {
        List<String> fileList = new ArrayList();
        CommonUtils.readJsonFiles(fileDirPath, fileList);
        ObjectMapper objectMapper = new ObjectMapper();
        for (int z = 0; z < fileList.size(); z++) {
            File file = new File(fileList.get(z));

            // 忽略mac的隐藏文件
            if (file.getName().contains(".DS_Store")) {
                continue;
            }
            logger.info("开始解析json文件，文件是{}，总文件{}个,正在处理第{}个", file.getPath(), fileList.size(), z + 1);

            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(bis));

            StringBuilder sb = new StringBuilder();
            while (reader.ready()) {
                sb.append((char) reader.read());
            }
            String sss = sb.toString();
//            sss = sss.replace("\uFeFF", "");
            List<AmericaAlabamaDTO> list = null;
            try {
                list = objectMapper.readValue(sss, new TypeReference<List<AmericaAlabamaDTO>>() {
                });
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                logger.info("json序列化出现问题:{}", file.getName());
                logger.info("exception:{}", CommonUtils.getExceptionInfo(e));
//                continue;
                throw new Exception();
            }
            if (!CollectionUtils.isEmpty(list)) {
                for (int i = 0; i < list.size(); i++) {
                    AmericaAlabamaDTO alabamaDTO = list.get(i);
                    String uuid = getUUID();
                    AmericaAlabama alabama = new AmericaAlabama();
                    BeanUtils.copyProperties(alabamaDTO, alabama);
                    alabama.setEnterpriseId(uuid);
                    americaAlabamaMapper.insertSelective(alabama);
                    List<AmericaAlabamaIncorporator> incorporatorList = alabamaDTO.getIncorporatorList();
                    if (!ObjectUtils.isEmpty(incorporatorList)) {
                        for (int j = 0; j < incorporatorList.size(); j++) {
                            AmericaAlabamaIncorporator incorporator = incorporatorList.get(j);
                            incorporator.setEnterpriseId(uuid);
                            americaAlabamaIncorporatorMapper.insertSelective(incorporator);
                        }
                    }
                    List<AmericaAlabamaMember> memberList = alabamaDTO.getMemberList();
                    if (!ObjectUtils.isEmpty(memberList)) {
                        for (int j = 0; j < memberList.size(); j++) {
                            AmericaAlabamaMember member = memberList.get(j);
                            member.setEnterpriseId(uuid);
                            americaAlabamaMemberMapper.insertSelective(member);
                        }
                    }
                    List<AmericaAlabamaDirector> directorList = alabamaDTO.getDirectorList();
                    if (!ObjectUtils.isEmpty(directorList)) {
                        for (int j = 0; j < directorList.size(); j++) {
                            AmericaAlabamaDirector director = directorList.get(j);
                            director.setEnterpriseId(uuid);
                            americaAlabamaDirectorMapper.insertSelective(director);
                        }
                    }
                }
                logger.info("json文件导入成功，文件是{}", file.getName());
                reader.close();
                bis.close();
            }
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveJsonAmerica4NewHampshire(File fileDirPath) throws Exception {
        List<String> fileList = new ArrayList();
        CommonUtils.readJsonFiles(fileDirPath, fileList);
        ObjectMapper objectMapper = new ObjectMapper();
        for (int z = 0; z < fileList.size(); z++) {
            File file = new File(fileList.get(z));

            // 忽略mac的隐藏文件
            if (file.getName().contains(".DS_Store")) {
                continue;
            }
            logger.info("开始解析json文件，文件是{}，总文件{}个,正在处理第{}个", file.getPath(), fileList.size(), z + 1);

            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(bis));

            StringBuilder sb = new StringBuilder();
            while (reader.ready()) {
                sb.append((char) reader.read());
            }
            String sss = sb.toString();
//            sss = sss.replace("\uFeFF", "");
            List<AmericaNewhampshireDTO> list = null;
            try {
                list = objectMapper.readValue(sss, new TypeReference<List<AmericaNewhampshireDTO>>() {
                });
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                logger.info("json序列化出现问题:{}", file.getName());
                logger.info("exception:{}", CommonUtils.getExceptionInfo(e));
//                continue;
                throw e;
            }
            if (!CollectionUtils.isEmpty(list)) {
                for (int i = 0; i < list.size(); i++) {
                    AmericaNewhampshireDTO americaNewHampshireDTO = list.get(i);
                    String uuid = getUUID();
                    AmericaNewhampshire americaNewhampshire = new AmericaNewhampshire();
                    BeanUtils.copyProperties(americaNewHampshireDTO, americaNewhampshire);
                    americaNewhampshire.setEnterpriseId(uuid);
                    americaNewhampshireMapper.insertSelective(americaNewhampshire);

                    List<AmericaNewhampshirePrincipalPurpose> principalPurposeList = americaNewHampshireDTO.getPrincipalPurposeList();
                    if (!ObjectUtils.isEmpty(principalPurposeList)) {
                        for (int j = 0; j < principalPurposeList.size(); j++) {
                            AmericaNewhampshirePrincipalPurpose principalPurpose = principalPurposeList.get(j);
                            if (principalPurpose != null) {
                                principalPurpose.setEnterpriseId(uuid);
                                americaNewhampshirePrincipalPurposeMapper.insertSelective(principalPurpose);
                            }
                        }
                    }

                    AmericaNewhampshireRegisteredAgentInformation registeredAgentInformation = americaNewHampshireDTO.getRegisteredAgentInformation();
                    if (!ObjectUtils.isEmpty(registeredAgentInformation)) {
                        if (registeredAgentInformation != null) {
                            registeredAgentInformation.setEnterpriseId(uuid);
                            americaNewhampshireRegisteredAgentInformationMapper.insertSelective(registeredAgentInformation);
                        }
                    }

                    List<AmericaNewhampshireTradenameInformation> tradenameInformationList = americaNewHampshireDTO.getTradenameInformationList();
                    if (!ObjectUtils.isEmpty(tradenameInformationList)) {
                        for (int j = 0; j < tradenameInformationList.size(); j++) {
                            AmericaNewhampshireTradenameInformation newhampshireTradenameInformation = tradenameInformationList.get(j);
                            if (newhampshireTradenameInformation != null) {
                                newhampshireTradenameInformation.setEnterpriseId(uuid);
                                americaNewhampshireTradenameInformationMapper.insertSelective(newhampshireTradenameInformation);
                            }
                        }
                    }

                    List<AmericaNewhampshireTradenameOwnedby> tradenameOwnedbyList = americaNewHampshireDTO.getTradenameOwnedbyList();
                    if (!ObjectUtils.isEmpty(tradenameOwnedbyList)) {
                        for (int j = 0; j < tradenameOwnedbyList.size(); j++) {
                            AmericaNewhampshireTradenameOwnedby newhampshireTradenameOwnedby = tradenameOwnedbyList.get(j);
                            if (newhampshireTradenameOwnedby != null) {
                                newhampshireTradenameOwnedby.setEnterpriseId(uuid);
                                americaNewhampshireTradenameOwnedbyMapper.insertSelective(newhampshireTradenameOwnedby);
                            }
                        }
                    }

                    List<AmericaNewhampshireTrademarkInformation> trademarkInformationList = americaNewHampshireDTO.getTrademarkInformationList();
                    if (!ObjectUtils.isEmpty(trademarkInformationList)) {
                        for (int j = 0; j < trademarkInformationList.size(); j++) {
                            AmericaNewhampshireTrademarkInformation newhampshireTrademarkInformation = trademarkInformationList.get(j);
                            if (newhampshireTrademarkInformation != null) {
                                newhampshireTrademarkInformation.setEnterpriseId(uuid);
                                americaNewhampshireTrademarkInformationMapper.insertSelective(newhampshireTrademarkInformation);
                            }
                        }
                    }

                    List<AmericaNewhampshirePrincipalInformation> principalInformationList = americaNewHampshireDTO.getPrincipalInformationList();
                    if (!ObjectUtils.isEmpty(principalInformationList)) {
                        for (int j = 0; j < principalInformationList.size(); j++) {
                            AmericaNewhampshirePrincipalInformation newhampshirePrincipalInformation = principalInformationList.get(j);
                            if (newhampshirePrincipalInformation != null) {
                                newhampshirePrincipalInformation.setEnterpriseId(uuid);
                                americaNewhampshirePrincipalInformationMapper.insertSelective(newhampshirePrincipalInformation);
                            }
                        }
                    }

                }
                logger.info("json文件导入成功，文件是{}", file.getName());
                reader.close();
                bis.close();
            }
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveJsonAmerica4NorthCarolina(File fileDirPath) throws Exception {
        List<String> fileList = new ArrayList();
        CommonUtils.readJsonFiles(fileDirPath, fileList);
        ObjectMapper objectMapper = new ObjectMapper();
        for (int z = 0; z < fileList.size(); z++) {
            File file = new File(fileList.get(z));

            // 忽略mac的隐藏文件
            if (file.getName().contains(".DS_Store")) {
                continue;
            }
            logger.info("开始解析json文件，文件是{}，总文件{}个,正在处理第{}个", file.getPath(), fileList.size(), z + 1);

            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(bis));

            StringBuilder sb = new StringBuilder();
            while (reader.ready()) {
                sb.append((char) reader.read());
            }
            String sss = sb.toString();
//            sss = sss.replace("\uFeFF", "");
            List<AmericaNorthcarolinaDTO> list = null;
            try {
                list = objectMapper.readValue(sss, new TypeReference<List<AmericaNorthcarolinaDTO>>() {
                });
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                logger.info("json序列化出现问题:{}", file.getName());
                logger.info("exception:{}", CommonUtils.getExceptionInfo(e));
//                continue;
                throw new Exception();
            }
            if (!CollectionUtils.isEmpty(list)) {
                for (int i = 0; i < list.size(); i++) {
                    AmericaNorthcarolinaDTO americaNorthcarolinaDTO = list.get(i);
                    String uuid = getUUID();
                    americaNorthcarolinaDTO.setEnterpriseId(uuid);
                    AmericaNorthcarolina americaNorthcarolina = new AmericaNorthcarolina();
                    BeanUtils.copyProperties(americaNorthcarolinaDTO, americaNorthcarolina);
                    americaNorthcarolinaMapper.insertSelective(americaNorthcarolina);

                    AmericaNorthcarolinaAddress northcarolinaAddress = americaNorthcarolinaDTO.getNorthcarolinaAddress();
                    if (northcarolinaAddress != null) {
                        northcarolinaAddress.setEnterpriseId(uuid);
                        americaNorthcarolinaAddressMapper.insertSelective(northcarolinaAddress);
                    }

                    List<AmericaNorthcarolinaCompanyOfficial> northcarolinaCompanyOfficialList = americaNorthcarolinaDTO.getNorthcarolinaCompanyOfficialList();
                    if (!ObjectUtils.isEmpty(northcarolinaCompanyOfficialList)) {
                        for (int j = 0; j < northcarolinaCompanyOfficialList.size(); j++) {
                            AmericaNorthcarolinaCompanyOfficial americaNorthcarolinaCompanyOfficial = northcarolinaCompanyOfficialList.get(j);
                            americaNorthcarolinaCompanyOfficial.setEnterpriseId(uuid);
                            americaNorthcarolinaCompanyOfficialMapper.insertSelective(americaNorthcarolinaCompanyOfficial);
                        }
                    }

                    List<AmericaNorthcarolinaOfficer> northcarolinaOfficerList = americaNorthcarolinaDTO.getNorthcarolinaOfficerList();
                    if (!ObjectUtils.isEmpty(northcarolinaOfficerList)) {
                        for (int j = 0; j < northcarolinaOfficerList.size(); j++) {
                            AmericaNorthcarolinaOfficer americaNorthcarolinaOfficer = northcarolinaOfficerList.get(j);
                            americaNorthcarolinaOfficer.setEnterpriseId(uuid);
                            americaNorthcarolinaOfficerMapper.insertSelective(americaNorthcarolinaOfficer);
                        }
                    }

                    AmericaNorthcarolinaStock northcarolinaStock = americaNorthcarolinaDTO.getNorthcarolinaStock();
                    if (northcarolinaStock != null) {
                        northcarolinaStock.setEnterpriseId(uuid);
                        americaNorthcarolinaStockMapper.insertSelective(northcarolinaStock);
                    }

                }
                logger.info("json文件导入成功，文件是{}", file.getName());
                reader.close();
                bis.close();
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveJsonAmerica4Alaska(File fileDirPath) throws Exception {
        List<String> fileList = new ArrayList();
        CommonUtils.readJsonFiles(fileDirPath, fileList);
        ObjectMapper objectMapper = new ObjectMapper();
        for (int z = 0; z < fileList.size(); z++) {
            File file = new File(fileList.get(z));

            // 忽略mac的隐藏文件
            if (file.getName().contains(".DS_Store")) {
                continue;
            }
            logger.info("开始解析json文件，文件是{}，总文件{}个,正在处理第{}个", file.getPath(), fileList.size(), z + 1);

            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(bis));

            StringBuilder sb = new StringBuilder();
            while (reader.ready()) {
                sb.append((char) reader.read());
            }
            String sss = sb.toString();
//            sss = sss.replace("\uFeFF", "");
            List<AmericaAlaskaDTO> list = null;
            try {
                list = objectMapper.readValue(sss, new TypeReference<List<AmericaAlaskaDTO>>() {
                });
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                logger.info("json序列化出现问题:{}", file.getName());
                logger.info("exception:{}", CommonUtils.getExceptionInfo(e));
                throw new Exception();
//                continue;
            }
            if (!CollectionUtils.isEmpty(list)) {
                for (int i = 0; i < list.size(); i++) {
                    AmericaAlaskaDTO americaAlaskaDTO = list.get(i);
                    americaAlaskaDTO.setEnterpriseId(getUUID());
                    AmericaAlaska alaska = new AmericaAlaska();
                    BeanUtils.copyProperties(americaAlaskaDTO, alaska);

                    List<String> nextBiennialReportDue = americaAlaskaDTO.getNextBiennialReportDue();
                    StringBuilder nextBiennialReportDueSb = new StringBuilder();
                    if (!ObjectUtils.isEmpty(nextBiennialReportDue)) {
                        for (int j = 0; j < nextBiennialReportDue.size(); j++) {
                            String strip = nextBiennialReportDue.get(j).replace("\n", "").replace(" ", "").strip();
                            if (!strip.isBlank()) {
                                nextBiennialReportDueSb.append(strip + "#rtc#");
                            }
                        }
                        alaska.setNextBiennialReportDue(nextBiennialReportDueSb.toString());
                    }


                    List<String> officialEntity = americaAlaskaDTO.getOfficialEntity();
                    StringBuilder officialEntitySb = new StringBuilder();
                    if (!ObjectUtils.isEmpty(officialEntity)) {
                        for (int j = 0; j < officialEntity.size(); j++) {
                            officialEntitySb.append(officialEntity.get(j) + "#rtc#");
                        }
                        alaska.setOfficialEntity(officialEntitySb.toString());
                    }


                    List<String> officialName = americaAlaskaDTO.getOfficialName();
                    StringBuilder officialNameSb = new StringBuilder();
                    if (!ObjectUtils.isEmpty(officialName)) {
                        for (int j = 0; j < officialName.size(); j++) {
                            officialNameSb.append(officialName.get(j) + "#rtc#");
                        }
                        alaska.setOfficialName(officialNameSb.toString());
                    }


                    List<String> officialOwned = americaAlaskaDTO.getOfficialOwned();
                    StringBuilder officialOwnedSb = new StringBuilder();
                    if (!ObjectUtils.isEmpty(officialOwned)) {
                        for (int j = 0; j < officialOwned.size(); j++) {
                            officialOwnedSb.append(officialOwned.get(j) + "#rtc#");
                        }
                        alaska.setOfficialOwned(officialOwnedSb.toString());
                    }

                    List<String> officialTite = americaAlaskaDTO.getOfficialTite();
                    StringBuilder officialTiteSb = new StringBuilder();
                    if (!ObjectUtils.isEmpty(officialTite)) {
                        for (int j = 0; j < officialTite.size(); j++) {
                            officialTiteSb.append(officialTite.get(j) + "#rtc#");
                        }
                        alaska.setOfficialTite(officialTiteSb.toString());
                    }
                    americaAlaskaMapper.insertSelective(alaska);
                }
                logger.info("json文件导入成功，文件是{}", file.getName());
                reader.close();
                bis.close();
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveJsonAmerica4AlaskaCSV(File fileDirPath) throws Exception {
        List<String> fileList = new ArrayList();
        CommonUtils.readFiles(fileDirPath, fileList);
        ObjectMapper objectMapper = new ObjectMapper();
        for (int z = 0; z < fileList.size(); z++) {
            File file = new File(fileList.get(z));

            // 忽略mac的隐藏文件
            if (file.getName().contains(".DS_Store")) {
                continue;
            }
            logger.info("开始解析json文件，文件是{}，总文件{}个,正在处理第{}个", file.getPath(), fileList.size(), z + 1);
            try {
                //(文件完整路径),编码格式
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                String line = null;

                List<String[]> dataList = new ArrayList();
                String csvSplitBy = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";

                while ((line = reader.readLine()) != null) {
                    String[] item = line.split(csvSplitBy, 35);
                    dataList.add(item);
                }
                if (dataList.size() > 1) {
                    StringBuilder sb = new StringBuilder();
                    String[] title = dataList.get(0);

                    List<AmericaAlaskaDTO> alaskaDTOList = new ArrayList<>();
                    for (int i = 1; i < dataList.size(); i++) {
//                    for (int i = 1; i < (sizeMarker <= dataList.size() ? sizeMarker : dataList.size()); i++) {
                        String[] rows = dataList.get(i);
                        if (title.length == rows.length) {
                            sb.append("{");
                            for (int j = 0; j < rows.length; j++) {
                                String row = "\"\"";
                                String replace = rows[j].replace("\"", "'").replace("\t", "");
                                if (replace.length() > 1) {
                                    row = "\"" + replace.substring(1, replace.length() - 1) + "\"";
                                }
                                sb.append("\"enterprise_id\":\"" + getUUID() + "\",").append(title[j] + ":" + row).append(",");
                            }
                            sb.delete(sb.length() - 1, sb.length());
                            sb.append("}");
                            AmericaAlaskaDTO alaskaDTO = objectMapper.readValue(sb.toString(), AmericaAlaskaDTO.class);
                            alaskaDTOList.add(alaskaDTO);
                            sb.setLength(0);
                        }
                    }
                    System.out.println("ready to insert");
                    americaAlaskaMapper.insertAlaskaExcel(alaskaDTOList);
                }

            } catch (Exception e) {
                e.printStackTrace();
                throw new Exception();
            }

        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveJsonAmerica4WyomingCSV(File fileDirPath, String pojoType) throws Exception {
        List<String> fileList = new ArrayList();
        CommonUtils.readFiles(fileDirPath, fileList);
        ObjectMapper objectMapper = new ObjectMapper();
        for (int z = 0; z < fileList.size(); z++) {
            File file = new File(fileList.get(z));

            // 忽略mac的隐藏文件
            if (file.getName().contains(".DS_Store")) {
                continue;
            }
            logger.info("开始解析json文件，文件是{}，总文件{}个,正在处理第{}个", file.getPath(), fileList.size(), z + 1);
            try {
                //(文件完整路径),编码格式
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                String line = null;

                List<String[]> dataList = new ArrayList();
                String csvSplitBy = "\\|(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
//                String csvSplitBy = "\\|";

                while ((line = reader.readLine()) != null) {
                    String[] item = line.split(csvSplitBy, 100);
                    dataList.add(item);
                }
                if (!ObjectUtils.isEmpty(dataList)) {
                    List wyomingList = new ArrayList();
                    String[] title = dataList.get(0);
                    for (int i = 0; i < title.length; i++) {
                        title[i] = "\"" + title[i] + "\"";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int i = 1; i < dataList.size(); i++) {
                        String[] row = dataList.get(i);
                        sb.append("{");
                        for (int j = 0; j < row.length; j++) {
                            String rowStr = row[j];
                            if (rowStr.length() > 2) {
                                rowStr = "\"" + rowStr.substring(1, rowStr.length()).replace("\"", "")
                                        .replace("\t", "").replace("\\", "")
                                        .replace("\r", "").replace("\n", "") + "\"";
                            }
                            if (j < title.length) {
                                sb.append(title[j] + ":" + rowStr + ",");
                            }
                        }
                        sb.delete(sb.length() - 1, sb.length()).append("}");
                        String enterpriseId = getUUID();
//                        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
//                        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
                        if ("filing".equals(pojoType) && sb.toString().length() > 150) {
                            AmericaWyomingDTO wyomingDTO = objectMapper.readValue(sb.toString(), AmericaWyomingDTO.class);
                            wyomingDTO.setEnterpriseId(enterpriseId);
                            wyomingList.add(wyomingDTO);
                        }
//                        if ("party".equals(pojoType) && sb.toString().length() > 150) {
//                            AmericaWyomingPartyDTO wyomingPartyDTO = objectMapper.readValue(sb.toString(), AmericaWyomingPartyDTO.class);
//                            wyomingPartyDTO.setEnterpriseId(enterpriseId);
//                            wyomingList.add(wyomingPartyDTO);
//                        }
                        if ("annual_report".equals(pojoType) && sb.toString().length() > 150) {
                            AmericaWyomingFilingAnnualReportDTO wyomingFilingAnnualReportDTO = objectMapper.readValue(sb.toString(), AmericaWyomingFilingAnnualReportDTO.class);
                            wyomingFilingAnnualReportDTO.setEnterpriseId(enterpriseId);
                            wyomingList.add(wyomingFilingAnnualReportDTO);
                        }
                        sb.setLength(0);
                    }
                    logger.info("cat:{}", wyomingList.size());
                    if ("filing".equals(pojoType)) {
                        for (int i = 0; i < wyomingList.size(); i++) {
                            AmericaWyomingDTO americaWyomingDTO = (AmericaWyomingDTO) wyomingList.get(i);
                            AmericaWyoming americaWyoming = new AmericaWyoming();
                            BeanUtils.copyProperties(americaWyomingDTO, americaWyoming);
                            americaWyomingMapper.insertSelective(americaWyoming);
                        }
//                        americaWyomingMapper.insertList(wyomingList);
                    }
                    if ("party".equals(pojoType)) {
                    }
                    if ("annual_report".equals(pojoType)) {
                        for (int i = 0; i < wyomingList.size(); i++) {
                            AmericaWyomingFilingAnnualReportDTO annualReportDTO = (AmericaWyomingFilingAnnualReportDTO) wyomingList.get(i);
                            AmericaWyomingFilingAnnualReport annualReport = new AmericaWyomingFilingAnnualReport();
                            BeanUtils.copyProperties(annualReportDTO, annualReport);
                            americaWyomingFilingAnnualReportMapper.insertSelective(annualReport);
                        }
//                        americaWyomingFilingAnnualReportMapper.insertList(wyomingList);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void readJsonCanada(File fileDirPath) throws Exception {
        List<String> fileList = new ArrayList();
        CommonUtils.readJsonFiles(fileDirPath, fileList);
        ObjectMapper objectMapper = new ObjectMapper();
        for (int z = 0; z < fileList.size(); z++) {
            File file = new File(fileList.get(z));

            // 忽略mac的隐藏文件
            if (file.getName().contains(".DS_Store")) {
                continue;
            }
            logger.info("开始解析json文件，文件是{}，总文件{}个,正在处理第{}个", file.getPath(), fileList.size(), z + 1);

            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(bis));

            StringBuilder sb = new StringBuilder();
            while (reader.ready()) {
                sb.append((char) reader.read());
            }
            String sss = sb.toString();
//            sss = sss.replace("\uFeFF", "");
            List<CanadaDTO> list = null;
            try {
                list = objectMapper.readValue(sss, new TypeReference<List<CanadaDTO>>() {
                });
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                logger.info("json序列化出现问题:{}", file.getName());
                logger.info("exception:{}", CommonUtils.getExceptionInfo(e));
//                continue;
                throw e;
            }
            if (!ObjectUtils.isEmpty(list)) {
                for (int i = 0; i < list.size(); i++) {
                    CanadaDTO canadaDTO = list.get(i);
                    Canada canada = new Canada();
                    BeanUtils.copyProperties(canadaDTO, canada);
                    String enterpriseId = getUUID();
                    canada.setEnterpriseId(enterpriseId);
                    canadaMapper.insertSelective(canada);

                    CanadaRegisteredOfficeAddress registeredOfficeAddress = canadaDTO.getRegisteredOfficeAddress();
                    if (registeredOfficeAddress != null) {
                        registeredOfficeAddress.setEnterpriseId(enterpriseId);
                        canadaRegisteredOfficeAddressMapper.insertSelective(registeredOfficeAddress);
                    }

                    List<CanadaDirector> directorList = canadaDTO.getCanadaDirectorList();
                    if (!ObjectUtils.isEmpty(directorList)) {
                        for (int j = 0; j < directorList.size(); j++) {
                            CanadaDirector director = directorList.get(j);
                            director.setEnterpriseId(enterpriseId);
                            canadaDirectorMapper.insertSelective(director);
                        }
                    }

                    CanadaAnnualFiling annualFiling = canadaDTO.getAnnualFiling();
                    if (annualFiling != null) {
                        annualFiling.setEnterpriseId(enterpriseId);
                        canadaAnnualFilingMapper.insertSelective(annualFiling);
                    }

                    List<CanadaCorporateHistory> corporateHistoryList = canadaDTO.getCorporateHistoryList();
                    if (!ObjectUtils.isEmpty(corporateHistoryList)) {
                        for (int j = 0; j < corporateHistoryList.size(); j++) {
                            CanadaCorporateHistory canadaCorporateHistory = corporateHistoryList.get(j);
                            canadaCorporateHistory.setEnterpriseId(enterpriseId);
                            canadaCorporateHistoryMapper.insertSelective(canadaCorporateHistory);
                        }
                    }
                }
            }
            logger.info("json文件导入成功，文件是{}", file.getName());
            reader.close();
            bis.close();
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveJsonAmerica4Florida(File fileDirPath) throws Exception {
        List<String> fileList = new ArrayList();
        CommonUtils.readJsonFiles(fileDirPath, fileList);
        ObjectMapper objectMapper = new ObjectMapper();
        for (int z = 0; z < fileList.size(); z++) {
            File file = new File(fileList.get(z));

            // 忽略mac的隐藏文件
            if (file.getName().contains(".DS_Store")) {
                continue;
            }
            logger.info("开始解析json文件，文件是{}，总文件{}个,正在处理第{}个", file.getPath(), fileList.size(), z + 1);

            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(bis));

            StringBuilder sb = new StringBuilder();
            while (reader.ready()) {
                sb.append((char) reader.read());
            }
            String sss = sb.toString();
//            sss = sss.replace("\uFeFF", "");
            List<AmericaFloridaDTO> list = null;
            try {
                list = objectMapper.readValue(sss, new TypeReference<List<AmericaFloridaDTO>>() {
                });
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                logger.info("json序列化出现问题:{}", file.getName());
                logger.info("exception:{}", CommonUtils.getExceptionInfo(e));
//                continue;
                throw e;
            }
            if (!ObjectUtils.isEmpty(list)) {
                String splitBy = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
                for (int i = 0; i < list.size(); i++) {
                    AmericaFloridaDTO americaFloridaDTO = list.get(i);
                    String enterpriseId = getUUID();
                    americaFloridaDTO.setEnterpriseId(enterpriseId);
                    AmericaFlorida americaFlorida = new AmericaFlorida();
                    BeanUtils.copyProperties(americaFloridaDTO, americaFlorida);
                    americaFlorida.setEnterpriseId(enterpriseId);
//                    americaFloridaMapper.insertSelective(americaFlorida);

                    List<String> authorizedPersonDetailList = americaFloridaDTO.getAuthorizedPersonDetailList();
                    if (authorizedPersonDetailList != null && authorizedPersonDetailList.size() > 2) {
                        List dtoList = new ArrayList();
                        for (int j = 2; j < authorizedPersonDetailList.size() - 3; j += 4) {
                            String title = authorizedPersonDetailList.get(j);
                            String name = authorizedPersonDetailList.get(j + 1);
                            String detailAddress = authorizedPersonDetailList.get(j + 2);
                            String streetAddress = authorizedPersonDetailList.get(j + 3);
                            dtoList.add(new AmericaFloridaAuthorizedPersonDetail(enterpriseId, title, name, detailAddress, streetAddress));
                            americaFloridaAuthorizedPersonDetailMapper.insertSelective(new AmericaFloridaAuthorizedPersonDetail(enterpriseId, title, name, detailAddress, streetAddress));
                        }
                    }
                    List<String> annualReportYearList = americaFloridaDTO.getAnnualReportYearList();
                    if (annualReportYearList != null && annualReportYearList.size() > 1) {
                        List dtoList = new ArrayList();
                        for (int j = 1; j < annualReportYearList.size(); j++) {
                            String year = annualReportYearList.get(j);
                            dtoList.add(year);
                            AmericaFloridaAnnualReportYear annualReportYear = new AmericaFloridaAnnualReportYear();
                            annualReportYear.setEnterpriseId(enterpriseId);
                            annualReportYear.setReportYear(year);
                            americaFloridaAnnualReportYearMapper.insertSelective(annualReportYear);
                        }
                    }

                    List<String> annualReportFieldList = americaFloridaDTO.getAnnualReportFieldList();
                    if (annualReportFieldList != null && annualReportFieldList.size() > 1) {
                        List dtoList = new ArrayList();
                        for (int j = 1; j < annualReportFieldList.size(); j++) {
                            String field = annualReportFieldList.get(j);
                            dtoList.add(field);
                            AmericaFloridaAnnualReportField annualReportField = new AmericaFloridaAnnualReportField();
                            annualReportField.setEnterpriseId(enterpriseId);
                            annualReportField.setFiledDate(field);
                            americaFloridaAnnualReportFieldMapper.insertSelective(annualReportField);
                        }
                    }
                }
            }
            logger.info("json文件导入成功，文件是{}", file.getName());
            reader.close();
            bis.close();
        }

    }

    @Override
    public void saveJsonAmerica4Ohio(File fileDirPath) throws Exception {
        List<String> fileList = new ArrayList();
        CommonUtils.readJsonFiles(fileDirPath, fileList);
        ObjectMapper objectMapper = new ObjectMapper();
        for (int z = 0; z < fileList.size(); z++) {
            File file = new File(fileList.get(z));

            // 忽略mac的隐藏文件
            if (file.getName().contains(".DS_Store")) {
                continue;
            }
            logger.info("开始解析json文件，文件是{}，总文件{}个,正在处理第{}个", file.getPath(), fileList.size(), z + 1);

            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(bis));

            StringBuilder sb = new StringBuilder();
            while (reader.ready()) {
                sb.append((char) reader.read());
            }
            String sss = sb.toString();
//            sss = sss.replace("\uFeFF", "");
            List<AmericaOhioDTO> list = null;
            try {
                list = objectMapper.readValue(sss, new TypeReference<List<AmericaOhioDTO>>() {
                });
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                logger.info("json序列化出现问题:{}", file.getName());
                logger.info("exception:{}", CommonUtils.getExceptionInfo(e));
//                continue;
                throw e;
            }
            if (!ObjectUtils.isEmpty(list)) {
                List<AmericaOhio> dataList = new ArrayList();
                for (int i = 0; i < list.size(); i++) {
                    AmericaOhioDTO americaOhioDTO = list.get(i);
                    AmericaOhio americaOhio = new AmericaOhio();
                    BeanUtils.copyProperties(americaOhioDTO, americaOhio);
                    americaOhio.setEnterpriseId(getUUID());
                    dataList.add(americaOhio);
//                    americaOhioMapper.insertSelective(americaOhio);
                }
                americaOhioMapper.insertList(dataList);
            }
            logger.info("json文件导入成功，文件是{}", file.getName());
            reader.close();
            bis.close();
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveJsonAmerica4Oklahoma(File fileDirPath) throws Exception {
        List<String> fileList = new ArrayList();
        CommonUtils.readJsonFiles(fileDirPath, fileList);
        ObjectMapper objectMapper = new ObjectMapper();
        for (int z = 0; z < fileList.size(); z++) {
            File file = new File(fileList.get(z));

            // 忽略mac的隐藏文件
            if (file.getName().contains(".DS_Store")) {
                continue;
            }
            logger.info("开始解析json文件，文件是{}，总文件{}个,正在处理第{}个", file.getPath(), fileList.size(), z + 1);

            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(bis));

            StringBuilder sb = new StringBuilder();
            while (reader.ready()) {
                sb.append((char) reader.read());
            }
            String sss = sb.toString();
//            sss = sss.replace("\uFeFF", "");
            List<AmericaOklahomaDTO> list = null;
            try {
                list = objectMapper.readValue(sss, new TypeReference<List<AmericaOklahomaDTO>>() {
                });
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                logger.info("json序列化出现问题:{}", file.getName());
                logger.info("exception:{}", CommonUtils.getExceptionInfo(e));
//                continue;
                throw e;
            }
            if (!ObjectUtils.isEmpty(list)) {
                List<AmericaOhio> dataList = new ArrayList();
                for (int i = 0; i < list.size(); i++) {
                    AmericaOklahomaDTO oklahomaDTO = list.get(i);
                    String enterpriseId = getUUID();
                    oklahomaDTO.setEnterpriseId(enterpriseId);
                    AmericaOklahomaRegisteredAgent registeredAgent = oklahomaDTO.getRegisteredAgent();
                    registeredAgent.setEnterpriseId(enterpriseId);
                    americaOklahomaRegisteredAgentMapper.insertSelective(registeredAgent);
                }
                americaOklahomaMapper.insertList(list);
            }
            logger.info("json文件导入成功，文件是{}", file.getName());
            reader.close();
            bis.close();
        }
    }

    public String getUUID() {
        return randomUUID().toString().replace("-", "");
    }
}