package com.rtc.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rtc.manager.dao.QccMapper;
import com.rtc.manager.dao.QccSubDetailMapper;
import com.rtc.manager.entity.QccAdministrativeLicenseChina;
import com.rtc.manager.entity.QccFilingInformation;
import com.rtc.manager.entity.QccShareholder;
import com.rtc.manager.entity.QccTaxArrearsNotice;
import com.rtc.manager.service.Qcc;
import com.rtc.manager.util.CommonUtils;
import com.rtc.manager.vo.*;
import lombok.SneakyThrows;
import org.elasticsearch.common.recycler.Recycler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author ChenHang
 */
@Service
public class QccImpl implements Qcc {

    Logger logger = LoggerFactory.getLogger(QccImpl.class);

    @Autowired
    private QccMapper qccMapper;

    @Autowired
    private QccSubDetailMapper qccSubDetailMapper;

    @Override
    public PageInfo<QccListVO> listEnterprise(String name, int pageNum, int pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List list = qccMapper.selectByName(name);

        logger.info("开启多线程");
        // todo
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 15, 30L,
//                TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
//        threadPoolExecutor.prestartAllCoreThreads();
//
//
//        if (!CollectionUtils.isEmpty(list)) {
//            final List<Future> futures = new ArrayList<>();
//            for (int i = 0; i < list.size(); i++) {
//                QccListVO qccListVO = (QccListVO) list.get(i);
//                Future<Object> future = threadPoolExecutor.submit(new Callable<Object>() {
//                    @Override
//                    public Object call() throws Exception {
////                        String transferMoney = CommonUtils.transferMoney(qccListVO.getRegisteredCapital());
////                        qccListVO.setRegisteredCapital(transferMoney);
//                        CommonUtils.translate3(qccListVO.getName(), "zh", "en", qccListVO, "name");
//                        CommonUtils.translate3(qccListVO.getCountryRegion(), "zh", "en", qccListVO, "countryRegion");
//                        CommonUtils.translate3(qccListVO.getAddress(), "zh", "en", qccListVO, "address");
//                        CommonUtils.translate3(qccListVO.getLegalRepresentative(), "zh", "en",qccListVO,"legalRepresentative");
//                        return null;
//                    }
//                });
//                futures.add(future);
//
//
////                while (true) {
////                    if (future.isDone()) {
////                        break;
////                    }
////                }
//            }
//            for (Future<?> f:
//                 futures) {
//                while (true) {
//                    if (f.isDone()) {
//                        break;
//                    }
//                }
//            }
//
//        }

        logger.info("多线程结束");


        if (!CollectionUtils.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                QccListVO qccListVO = (QccListVO) list.get(i);
                String transferMoney = CommonUtils.transferMoney(qccListVO.getRegisteredCapital());
                qccListVO.setRegisteredCapital(transferMoney);
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
            }
        }
//        threadPoolExecutor.shutdown();
        return new PageInfo<>(list);
    }

    @Override
    public QccVO getEnterprise(String enterpriseId) throws Exception {
        QccVO qccVO = qccMapper.selectByEnterpriseId(enterpriseId);
        String transferMoney = CommonUtils.transferMoney(qccVO.getRegisteredCapital());
        qccVO.setRegisteredCapital(transferMoney);
        String address = CommonUtils.translate(qccVO.getAddress(), "zh", "en");
        String name = CommonUtils.translate(qccVO.getName(), "zh", "en");
        name = CommonUtils.nameFormat(name);
        String legalRepresentative = CommonUtils.translate(qccVO.getLegalRepresentative(), "zh", "en");
        legalRepresentative = CommonUtils.nameFormat(legalRepresentative);
        String synopsis = CommonUtils.translate(qccVO.getSynopsis(), "zh", "en");
        String countryRegion = CommonUtils.translate(qccVO.getCountryRegion(), "zh", "en");
        qccVO.setAddress(address);
        qccVO.setName(name);
        qccVO.setLegalRepresentative(legalRepresentative);
        qccVO.setSynopsis(synopsis);
        qccVO.setCountryRegion(countryRegion);
        List<QccShareholderVO> shareholderVOList = qccVO.getShareholderList();
        if (!CollectionUtils.isEmpty(shareholderVOList)) {
            for (int i = 0; i < shareholderVOList.size(); i++) {
                QccShareholderVO qccShareholderVO = shareholderVOList.get(i);
                name = CommonUtils.translate(qccShareholderVO.getName(), "zh", "en");
                name = CommonUtils.nameFormat(name);
                qccShareholderVO.setName(name);
            }
        }

        return qccVO;
    }

    @Override
    public PageInfo<List> getEnterpriseDetail(String name, String enterpriseId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List list = null;
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
            default:
        }

        return new PageInfo<>(list);
    }

    @Override
    public Object getEnterpriseSubDetail(String name, Integer id) {
        Object object = null;
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
                QccTaxArrearsNoticeVO o = (QccTaxArrearsNoticeVO) object;
                o.setBalance(CommonUtils.transferMoney2(o.getBalance(), "-", 1d));
                o.setCurrentArrears(CommonUtils.transferMoney2(o.getCurrentArrears(), "-", 1d));
                break;
            default:

        }

        return object;
    }

    @Override
    public Object getEnterpriseSubDetailMuti(String name, String enterpriseId, Integer id, int pageNum, int pageSize) {
        Object o = null;
        if (null != enterpriseId) {
            PageInfo<List> listPageInfo = getEnterpriseDetail(name, enterpriseId, pageNum, pageSize);
            List list = listPageInfo.getList();
            if (!CollectionUtils.isEmpty(list) && list.size() > 0) {
                o = list.get(0);
            }
        } else if (null != id) {
            o = getEnterpriseSubDetail(name, id);
        }
        return o;
    }


}
