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

    // 基本信息-start
    Object getQccShareholderThreeVO(Integer id);

    Object getQccQualificationVO(Integer id);

    Object getQccOutInvestmentVO(Integer id);

    Object getQccShareholderInvestmentVO(Integer id);

    Object getQccEquityChangeVO(Integer id);

    Object getQccChangeRecordVO(Integer id);
    // 基本信息-end
    // 经营状况 - 抽查检查
    Object getQccSpotCheckVO(Integer id);
    // 经营风险 - 司法拍卖
    Object getQccJudicialAuctionVO(Integer id);
    // 经营风险 - 环保处罚
    Object getQccEnvironmentalPunishmentVO(Integer id);

    // 经营风险 - 税收违法
    Object getQccTaxViolationVO(Integer id);
}
