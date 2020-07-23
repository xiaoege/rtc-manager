package com.rtc.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rtc.manager.dao.QccMapper;
import com.rtc.manager.dao.QccSubDetailMapper;
import com.rtc.manager.service.Qcc;
import com.rtc.manager.util.CommonUtils;
import com.rtc.manager.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author ChenHang
 */
@Service
public class QccImpl implements Qcc {

    @Autowired
    private QccMapper qccMapper;

    @Autowired
    private QccSubDetailMapper qccSubDetailMapper;

    @Override
    public PageInfo<QccListVO> listEnterprise(String name, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List list = qccMapper.selectByName(name);
        if (!CollectionUtils.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                QccListVO qccListVO = (QccListVO) list.get(i);
                String transferMoney = CommonUtils.transferMoney(qccListVO.getRegisteredCapital());
                qccListVO.setRegisteredCapital(transferMoney);
            }
        }

        return new PageInfo<>(list);
    }

    @Override
    public QccVO getEnterprise(String enterpriseId) {
        QccVO qccVO = qccMapper.selectByEnterpriseId(enterpriseId);
        String transferMoney = CommonUtils.transferMoney(qccVO.getRegisteredCapital());
        qccVO.setRegisteredCapital(transferMoney);
        try {
            String translate = CommonUtils.translate(qccVO.getAddress(), "zh", "en");
            qccVO.setAddress(translate);
        } catch (Exception e) {
            e.printStackTrace();
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
                        qccSupplierVO.setPurchaseAmount(CommonUtils.transferMoney2(qccSupplierVO.getPurchaseAmount(), "-"));
                    }
                }
                break;
            case "client":
                list = qccMapper.listQccClientVO(enterpriseId);
                if (!CollectionUtils.isEmpty(list)) {
                    for (int i = 0; i < list.size(); i++) {
                        QccClientVO qccClientVO = (QccClientVO) list.get(i);
                        qccClientVO.setSaleAmount(CommonUtils.transferMoney2(qccClientVO.getSaleAmount(), "-"));
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
                        qccAnnualReportVO.setTotalAssets(CommonUtils.transferMoney2(qccAnnualReportVO.getTotalAssets(), "Enterprises choose not to publicize"));
                        qccAnnualReportVO.setTotalEquity(CommonUtils.transferMoney2(qccAnnualReportVO.getTotalEquity(), "Enterprises choose not to publicize"));
                        qccAnnualReportVO.setTotalOperatingIncome(CommonUtils.transferMoney2(qccAnnualReportVO.getTotalOperatingIncome(), "Enterprises choose not to publicize"));
                        qccAnnualReportVO.setTotalProfit(CommonUtils.transferMoney2(qccAnnualReportVO.getTotalProfit(), "Enterprises choose not to publicize"));
                        qccAnnualReportVO.setNetProfit(CommonUtils.transferMoney2(qccAnnualReportVO.getNetProfit(), "Enterprises choose not to publicize"));
                        qccAnnualReportVO.setMainBusinessIncome(CommonUtils.transferMoney2(qccAnnualReportVO.getMainBusinessIncome(), "Enterprises choose not to publicize"));
                        qccAnnualReportVO.setTotalTax(CommonUtils.transferMoney2(qccAnnualReportVO.getTotalTax(), "Enterprises choose not to publicize"));
                        qccAnnualReportVO.setTotalLiabilities(CommonUtils.transferMoney2(qccAnnualReportVO.getTotalLiabilities(), "Enterprises choose not to publicize"));
                        List<QccAnnualReportShareholderVO> qccAnnualReportShareholderVOList = qccAnnualReportVO.getQccAnnualReportShareholderVOList();
                        for (int j = 0; j < qccAnnualReportShareholderVOList.size(); j++) {
                            QccAnnualReportShareholderVO qccAnnualReportShareholderVO = qccAnnualReportShareholderVOList.get(j);
                            qccAnnualReportShareholderVO.setSubscribedCapital(CommonUtils.transferMoney2(qccAnnualReportShareholderVO.getSubscribedCapital(), "-"));
                            qccAnnualReportShareholderVO.setPaidCapital(CommonUtils.transferMoney2(qccAnnualReportShareholderVO.getPaidCapital(), "-"));
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
                    qccSupplierVO.setPurchaseAmount(CommonUtils.transferMoney2(qccSupplierVO.getPurchaseAmount(), "-"));
                }
                break;
            case "client":
                object = qccSubDetailMapper.getQccClientVO(id);
                if (object != null) {
                    QccClientVO qccClientVO = (QccClientVO) object;
                    qccClientVO.setSaleAmount(CommonUtils.transferMoney2(qccClientVO.getSaleAmount(), "-"));
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
                    qccAnnualReportVO.setTotalAssets(CommonUtils.transferMoney2(qccAnnualReportVO.getTotalAssets(), "Enterprises choose not to publicize"));
                    qccAnnualReportVO.setTotalEquity(CommonUtils.transferMoney2(qccAnnualReportVO.getTotalEquity(), "Enterprises choose not to publicize"));
                    qccAnnualReportVO.setTotalOperatingIncome(CommonUtils.transferMoney2(qccAnnualReportVO.getTotalOperatingIncome(), "Enterprises choose not to publicize"));
                    qccAnnualReportVO.setTotalProfit(CommonUtils.transferMoney2(qccAnnualReportVO.getTotalProfit(), "Enterprises choose not to publicize"));
                    qccAnnualReportVO.setNetProfit(CommonUtils.transferMoney2(qccAnnualReportVO.getNetProfit(), "Enterprises choose not to publicize"));
                    qccAnnualReportVO.setMainBusinessIncome(CommonUtils.transferMoney2(qccAnnualReportVO.getMainBusinessIncome(), "Enterprises choose not to publicize"));
                    qccAnnualReportVO.setTotalTax(CommonUtils.transferMoney2(qccAnnualReportVO.getTotalTax(), "Enterprises choose not to publicize"));
                    qccAnnualReportVO.setTotalLiabilities(CommonUtils.transferMoney2(qccAnnualReportVO.getTotalLiabilities(), "Enterprises choose not to publicize"));
                    List<QccAnnualReportShareholderVO> qccAnnualReportShareholderVOList = qccAnnualReportVO.getQccAnnualReportShareholderVOList();
                    for (int j = 0; j < qccAnnualReportShareholderVOList.size(); j++) {
                        QccAnnualReportShareholderVO qccAnnualReportShareholderVO = qccAnnualReportShareholderVOList.get(j);
                        qccAnnualReportShareholderVO.setSubscribedCapital(CommonUtils.transferMoney2(qccAnnualReportShareholderVO.getSubscribedCapital(), "-"));
                        qccAnnualReportShareholderVO.setPaidCapital(CommonUtils.transferMoney2(qccAnnualReportShareholderVO.getPaidCapital(), "-"));
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
