package com.rtc.manager.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rtc.manager.dao.*;
import com.rtc.manager.entity.*;
import com.rtc.manager.service.SaveJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.util.*;

import static java.util.UUID.randomUUID;

/**
 * @author ChenHang
 */
@Service
public class SaveJsonImpl implements SaveJson {

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

    @Override
    @Transactional(rollbackFor = Exception.class)

    public void readJson(File file) throws Exception {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        BufferedReader reader = new BufferedReader(new InputStreamReader(bis));

        StringBuilder sb = new StringBuilder();
        while (reader.ready()) {
            sb.append((char) reader.read());
        }
        String sss = sb.toString();
        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(sss);
        //总的数据，下面开始分开对每个对象（表）进行操作
        List<RtcEnterpriseDTO> contentList = objectMapper.readValue(sss, new TypeReference<List<RtcEnterpriseDTO>>() {
        });

        for (RtcEnterpriseDTO temp :
                contentList) {
            // 基本信息insert  rtc_enterprise
            String uuid = getUUID();
            RtcEnterprise rtcEnterprise = new RtcEnterprise();
            temp.setUuid(uuid);
            BeanUtil.copyProperties(temp, rtcEnterprise);
//            BeanUtils.copyProperties(temp, rtcEnterprise);
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
                qccMapper.insertSelective(qcc);
                //qcc-基本信息
                HashMap basicInformation = qcc.getBasicInformation();
                HashMap basicInformationMap = (HashMap) basicInformation.get("工商信息");
                String basicInformationJsonString = objectMapper.writeValueAsString(basicInformationMap);
                QccBusinessInformation qccBusinessInformation = objectMapper.readValue(basicInformationJsonString, QccBusinessInformation.class);
                // insert qcc_business_information
                qccBusinessInformation.setEnterpriseId(enterpriseIdList.get(i));
                qccBusinessInformationMapper.insertSelective(qccBusinessInformation);

                List<HashMap> qccShareholderList = (List<HashMap>) basicInformation.get("股东信息");
                if (!CollectionUtils.isEmpty(qccShareholderList)) {
                    for (int j = 0; j < qccShareholderList.size(); j++) {
                        String qccShareholderJsonString = objectMapper.writeValueAsString(qccShareholderList.get(j));
                        QccShareholder qccShareholder = objectMapper.readValue(qccShareholderJsonString, QccShareholder.class);
                        // insert qcc_shareholder
                        qccShareholder.setEnterpriseId(enterpriseIdList.get(i));
                        qccShareholderMapper.insertSelective(qccShareholder);
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

                // qcc-经营状况
                HashMap businessStatus = qcc.getBusinessStatus();
                List<HashMap> qccAdministrativeLicense = (List<HashMap>) businessStatus.get("行政许可");
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
                        // insert qcc_general_taxpayer
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

                HashMap abnormalOperation = (HashMap) businessRisk.get("经营异常");
                if (abnormalOperation != null && abnormalOperation.size() > 0) {
                    List<QccRemoveException> qccRemoveExceptions = (List<QccRemoveException>) abnormalOperation.get("移除异常");
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

                    List<QccSaveException> qccSaveExceptions = (List<QccSaveException>) abnormalOperation.get("移入异常");
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
                }
            }
        }
        reader.close();
        bis.close();
    }

    public String getUUID() {
        return randomUUID().toString().replace("-", "");
    }
}
