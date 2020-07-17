package com.rtc.manager.dao;

import java.util.List;

/**
 * @author ChenHang
 */
public interface QccSubDetailMapper {
    List listQccJudgmentDocumentVO(Integer id);

    List listQccAdministrativeLicenseVO(Integer id);

    List listQccTaxCreditVO(Integer id);

    List listQccBiddingVO(Integer id);

    List listQccImportExportCreditVO(Integer id);

    List listQccLandPurchaseInformationVO(Integer id);

    List listQccSupplierVO(Integer id);

    List listQccClienttVO(Integer id);

    List listQccGeneralTaxpayerVO(Integer id);

    List listQccAdministrativeSanctionVO(Integer id);

    List listQccAbnormalOperationVO(Integer id);

    List listQccAnnualReportVO(Integer id);

    List listQccFinancingConsultationVO(Integer id);

    List listQccKeymanVO(Integer id);

    List listQccQualificationCertificateVO(Integer id);

    List listQccSoftwareCopyrightVO(Integer id);

    List listQccWebsiteInformationVO(Integer id);

    List listQccAppVO(Integer id);

    List listQccAppletVO(Integer id);

    List listQccWechatVO(Integer id);

    List listQccWeiboVO(Integer id);
}
