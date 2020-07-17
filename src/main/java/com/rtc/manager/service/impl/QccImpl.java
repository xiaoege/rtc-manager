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
                list = qccMapper.listQccClientVO(enterpriseId);
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
                break;
            case "client":
                object = qccSubDetailMapper.getQccClientVO(id);
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
                break;
            case "financingConsultation":
                object = qccSubDetailMapper.getQccFinancingConsultationVO(id);
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


}
