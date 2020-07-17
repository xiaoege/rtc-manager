package com.rtc.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rtc.manager.dao.QccMapper;
import com.rtc.manager.dao.QccSubDetailMapper;
import com.rtc.manager.service.Qcc;
import com.rtc.manager.vo.QccListVO;
import com.rtc.manager.vo.QccVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return new PageInfo<>(list);
    }

    @Override
    public QccVO getEnterprise(String enterpriseId) {
        QccVO qccVO = qccMapper.selectByEnterpriseId(enterpriseId);
        return qccVO;
    }

    @Override
    public List<Object> getEnterpriseDetail(String name, String enterpriseId) {
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
                break;
            case "client":
                list = qccMapper.listQccClienttVO(enterpriseId);
                break;
            case "generalTaxpayer":
                list = qccMapper.listQccGeneralTaxpayerVO(enterpriseId);
                break;
            case "administrativeSanction":
                list = qccMapper.listQccAdministrativeSanctionVO(enterpriseId);
                break;
            case "abnormalOperation":
                list = qccMapper.listQccAbnormalOperationVO(enterpriseId);
                break;
            case "annualReport":
                list = qccMapper.listQccAnnualReportVO(enterpriseId);
                break;
            case "financingConsultation":
                list = qccMapper.listQccFinancingConsultationVO(enterpriseId);
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
                list = new ArrayList<>();
        }

        return list;
    }

    @Override
    public List<Object> getEnterpriseSubDetail(String name, Integer id) {
        List list = null;
        switch (name) {
            case "judgmentDocument":
                list = qccSubDetailMapper.listQccJudgmentDocumentVO(id);
                break;
            case "administrativeLicense":
                list = qccSubDetailMapper.listQccAdministrativeLicenseVO(id);
                break;
            case "taxCredit":
                list = qccSubDetailMapper.listQccTaxCreditVO(id);
                break;
            case "bidding":
                list = qccSubDetailMapper.listQccBiddingVO(id);
                break;
            case "importExportCredit":
                list = qccSubDetailMapper.listQccImportExportCreditVO(id);
                break;
            case "landPurchaseInformation":
                list = qccSubDetailMapper.listQccLandPurchaseInformationVO(id);
                break;
            case "supplier":
                list = qccSubDetailMapper.listQccSupplierVO(id);
                break;
            case "client":
                list = qccSubDetailMapper.listQccClienttVO(id);
                break;
            case "generalTaxpayer":
                list = qccSubDetailMapper.listQccGeneralTaxpayerVO(id);
                break;
            case "administrativeSanction":
                list = qccSubDetailMapper.listQccAdministrativeSanctionVO(id);
                break;
            case "abnormalOperation":
                list = qccSubDetailMapper.listQccAbnormalOperationVO(id);
                break;
            case "annualReport":
                list = qccSubDetailMapper.listQccAnnualReportVO(id);
                break;
            case "financingConsultation":
                list = qccSubDetailMapper.listQccFinancingConsultationVO(id);
                break;
            case "keyman":
                list = qccSubDetailMapper.listQccKeymanVO(id);
                break;
            case "qualificationCertificate":
                list = qccSubDetailMapper.listQccQualificationCertificateVO(id);
                break;
            case "softwareCopyright":
                list = qccSubDetailMapper.listQccSoftwareCopyrightVO(id);
                break;
            case "websiteInformation":
                list = qccSubDetailMapper.listQccWebsiteInformationVO(id);
                break;
            case "app":
                list = qccSubDetailMapper.listQccAppVO(id);
                break;
            case "applet":
                list = qccSubDetailMapper.listQccAppletVO(id);
                break;
            case "wechat":
                list = qccSubDetailMapper.listQccWechatVO(id);
                break;
            case "weibo":
                list = qccSubDetailMapper.listQccWeiboVO(id);
                break;
            default:
                list = new ArrayList<>();
        }

        return list;
    }


}
