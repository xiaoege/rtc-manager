package com.rtc.manager.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rtc.manager.dao.RtcEnterpriseMapper;
import com.rtc.manager.dao.SaveJsonMapper;
import com.rtc.manager.entity.*;
import com.rtc.manager.service.SaveJson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.*;

/**
 * @author ChenHang
 */
@Service
public class SaveJsonImpl implements SaveJson {

    @Autowired
    private SaveJsonMapper saveJsonMapper;

    @Autowired
    private RtcEnterpriseMapper rtcEnterpriseMapper;

    @Override
    public String getTest() {
        return saveJsonMapper.getTest();
    }

    @Override
    @Transactional
    public void readJson() throws Exception {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("/Users/chenhang/work/ali_qcc_1/output_7_8.json"));
        StringBuilder sb = new StringBuilder();
        byte[] bytes = new byte[1024];
        while (bis.read(bytes) != -1) {
            String s = new String(bytes, 0, bytes.length, "UTF-8");
            sb.append(s);
        }
        String sss = sb.toString();
        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(sss);
        //总的数据，下面开始分开对每个对象（表）进行操作
        List<RtcEnterpriseDTO> contentList = objectMapper.readValue(sss, new TypeReference<List<RtcEnterpriseDTO>>() {
        });

        for (RtcEnterpriseDTO temp :
                contentList) {
            //todo 基本信息insert  rtc_enterprise
            RtcEnterprise base = new RtcEnterprise();
            BeanUtils.copyProperties(temp, base);
            String uuid = getUUID();
            temp.setUuid(uuid);
            List qccMatchSummaryList = temp.getQccMatchSummary();
            for (int i = 0; i < qccMatchSummaryList.size(); i++) {
                //todo qccMatchSummary insert  qcc_match_summary
            }
            List qccList = temp.getQcc();
            for (int i = 0; i < qccList.size(); i++) {
                Object o = qccList.get(i);
                if (o == null) {
                    continue;
                }
                String str = objectMapper.writeValueAsString(o);
                Qcc qcc = objectMapper.readValue(str, Qcc.class);
                //todo qcc insert

                //qcc-基本信息
                HashMap basicInformation = qcc.getBasicInformation();
                HashMap basicInformationMap = (HashMap) basicInformation.get("工商信息");
                String basicInformationJsonString = objectMapper.writeValueAsString(basicInformationMap);
                QccBusinessInformation qccBusinessInformation = objectMapper.readValue(basicInformationJsonString, QccBusinessInformation.class);
                //todo insert qcc_business_information

                List<HashMap> qccShareholderList = (List<HashMap>) basicInformation.get("股东信息");
                for (int j = 0; j < qccShareholderList.size(); j++) {
                    String qccShareholderJsonString = objectMapper.writeValueAsString(qccShareholderList.get(j));
                    QccShareholder qccShareholder = objectMapper.readValue(qccShareholderJsonString, QccShareholder.class);
                    //todo insert qcc_shareholder
                }


                List<HashMap> qccKeymanList = (List<HashMap>) basicInformation.get("主要人员");
                for (int j = 0; j < qccKeymanList.size(); j++) {
                    String qccKeymanJsonString = objectMapper.writeValueAsString(qccKeymanList.get(j));
                    QccKeyman qccKeyman = objectMapper.readValue(qccKeymanJsonString, QccKeyman.class);
                    //todo insert qcc_keyman
                }


                // qcc-法律诉讼
                HashMap legalProceeding = qcc.getLegalProceeding();
                List<HashMap> qccJudgmentDocument = (List<HashMap>) legalProceeding.get("裁判文书");
                String qccJudgmentDocumentJsonString = objectMapper.writeValueAsString(qccJudgmentDocument);
                List<QccJudgmentDocument> qccJudgmentDocumentList = objectMapper.readValue(qccJudgmentDocumentJsonString, new TypeReference<List<QccJudgmentDocument>>() {
                });
                for (int j = 0; j < qccJudgmentDocumentList.size(); j++) {
                    //todo insert qcc_judgment_document
                }

                // qcc-经营状况
                HashMap businessStatus = qcc.getBusinessStatus();
                List<HashMap> qccAdministrativeLicense = (List<HashMap>) businessStatus.get("行政许可");
                String qccAdministrativeLicenseJsonString = objectMapper.writeValueAsString(qccAdministrativeLicense);
                List<QccAdministrativeLicense> qccAdministrativeLicenseList = objectMapper.readValue(qccAdministrativeLicenseJsonString, new TypeReference<List<QccAdministrativeLicense>>() {
                });
                for (int j = 0; j < qccAdministrativeLicenseList.size(); j++) {
                    //todo insert qcc_administrative_license
                }

                List<HashMap> qccTaxCredit = (List<HashMap>) businessStatus.get("税务信用");
                String qccTaxCreditJsonString = objectMapper.writeValueAsString(qccTaxCredit);
                List<QccTaxCredit> qccTaxCreditList = objectMapper.readValue(qccTaxCreditJsonString, new TypeReference<List<com.rtc.manager.entity.QccTaxCredit>>() {
                });
                for (int j = 0; j < qccTaxCreditList.size(); j++) {
                    //todo insert qcc_tax_credit
                }

                List<HashMap> qccImportExportCredit = (List<HashMap>) businessStatus.get("进出口信用");
                String qccImportExportCreditJsonString = objectMapper.writeValueAsString(qccImportExportCredit);
                List<QccImportExportCredit> qccImportExportCreditList = objectMapper.readValue(qccImportExportCreditJsonString, new TypeReference<List<QccImportExportCredit>>() {
                });
                for (int j = 0; j < qccImportExportCreditList.size(); j++) {
                    //todo insert qcc_import_export_credit
                }

                List<HashMap> qccGeneralTaxpayer = (List<HashMap>) businessStatus.get("一般纳税人");
                String qccGeneralTaxpayerJsonString = objectMapper.writeValueAsString(qccGeneralTaxpayer);
                List<QccGeneralTaxpayer> qccGeneralTaxpayerList = objectMapper.readValue(qccGeneralTaxpayerJsonString, new TypeReference<List<QccGeneralTaxpayer>>() {
                });
                for (int j = 0; j < qccGeneralTaxpayerList.size(); j++) {
                    //todo insert qcc_general_taxpayer
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
                    //todo insert qarTemp into qcc_annual_report
                    /*List a = (List) value.get("股东（发起人）出资信息");
                    if (null == a) {
                        continue;
                    }
                    for (int j = 0; j < a.size(); j++) {
                        //todo 这里使用update
                    }*/
                    System.out.println(1);
                }

                // qcc-知识产权
                HashMap intellectualProperty = qcc.getIntellectualProperty();
                List<HashMap> qccQualificationCertificate = (List<HashMap>) intellectualProperty.get("资质证书");
                String qccQualificationCertificateJsonString = objectMapper.writeValueAsString(qccQualificationCertificate);
                List<QccQualificationCertificate> qccQualificationCertificateList = objectMapper.readValue(qccQualificationCertificateJsonString, new TypeReference<List<QccQualificationCertificate>>() {
                });
                for (int j = 0; j < qccQualificationCertificateList.size(); j++) {
                    //todo insert qcc_qualification_certificate
                }

                List<HashMap> websiteInformation = (List<HashMap>) intellectualProperty.get("网站信息");
                String websiteInformationJsonString = objectMapper.writeValueAsString(websiteInformation);
                List<QccWebsiteInformation> qccWebsiteInformationList = objectMapper.readValue(websiteInformationJsonString, new TypeReference<List<QccWebsiteInformation>>() {
                });
                for (int j = 0; j < qccWebsiteInformationList.size(); j++) {
                    //todo insert qcc_website_information
                }

                System.out.println(1);
            }
        }

        System.out.println(1);
    }

    public String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
