package com.rtc.manager.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rtc.manager.dao.*;
import com.rtc.manager.entity.*;
import com.rtc.manager.service.SaveJson;
import org.springframework.beans.BeanUtils;
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
    private SaveJsonMapper saveJsonMapper;

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

    @Override
    public String getTest() {
        return saveJsonMapper.getTest();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void readJson(File file) throws Exception {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        BufferedReader reader = new BufferedReader(new InputStreamReader(bis));

        StringBuilder sb = new StringBuilder();
        while (reader.ready()) {
            sb.append((char) reader.read());
        }
        /*byte[] bytes = new byte[1024];
        while (bis.read(bytes) != -1) {
            String s = new String(bytes, 0, bytes.length, "UTF-8");
            sb.append(s);
        }*/
//        String sss = new String(sb.toString().getBytes("UTF-8"), "UTF-8");
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

                // qcc-企业发展
                HashMap enterpriseDevelopment = qcc.getEnterpriseDevelopment();
                LinkedHashMap qccAnnualReport = (LinkedHashMap) enterpriseDevelopment.get("企业年报");
                Set qccAnnualReportKeySet = qccAnnualReport.entrySet();
                Iterator iterator = qccAnnualReportKeySet.iterator();
                while (iterator.hasNext()) {
                    QccAnnualReport qarTemp = new QccAnnualReport();
                    Map.Entry<String, LinkedHashMap> next = (Map.Entry<String, LinkedHashMap>) iterator.next();
                    String year = next.getKey();
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
                            qccAnnualReportShareholderMapper.insertSelective(qccAnnualReportShareholder);
                        }
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
            }
        }

    }

    public String getUUID() {
        return randomUUID().toString().replace("-", "");
    }
}
