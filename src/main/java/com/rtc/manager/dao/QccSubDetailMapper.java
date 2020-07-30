package com.rtc.manager.dao;


/**
 * @author ChenHang
 */
public interface QccSubDetailMapper {
    Object getQccJudgmentDocumentVO(Integer id);

    Object getQccAdministrativeLicenseVO(Integer id);

    Object getQccTaxCreditVO(Integer id);

    Object getQccBiddingVO(Integer id);

    Object getQccImportExportCreditVO(Integer id);

    Object getQccLandPurchaseInformationVO(Integer id);

    Object getQccSupplierVO(Integer id);

    Object getQccClientVO(Integer id);

    Object getQccGeneralTaxpayerVO(Integer id);

    Object getQccAdministrativeSanctionVO(Integer id);

    Object getQccAbnormalOperationVO(Integer id);

    Object getQccAnnualReportVO(Integer id);

    Object getQccFinancingConsultationVO(Integer id);

    Object getQccKeymanVO(Integer id);

    Object getQccQualificationCertificateVO(Integer id);

    Object getQccSoftwareCopyrightVO(Integer id);

    Object getQccWebsiteInformationVO(Integer id);

    Object getQccAppVO(Integer id);

    Object getQccAppletVO(Integer id);

    Object getQccWechatVO(Integer id);

    Object getQccWeiboVO(Integer id);

    Object getQccCourtNoticeVO(Integer id);

    Object getQccFilingInformationVO(Integer id);

    Object getQccAdministrativeLicenseChinaVO(Integer id);

    Object getQccTaxArrearsNoticeVO(Integer id);

    Object getQccEquityPledgeVO(Integer id);

    Object getQccEquityOutPledgeVO(Integer id);
}
