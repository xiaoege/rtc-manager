package com.rtc.manager.dao;

import com.rtc.manager.entity.Qcc;
import com.rtc.manager.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QccMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Qcc record);

    int insertSelective(Qcc record);

    Qcc selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Qcc record);

    int updateByPrimaryKey(Qcc record);

    List<QccListVO> selectByName(@Param("name") String name);

    QccVO selectByEnterpriseId(@Param("enterpriseId") String enterpriseId);

    List<QccAdministrativeLicenseVO> listQccAdministrativeLicenseVO(@Param("enterpriseId") String enterpriseId);
    List<QccAnnualReportVO> listQccAnnualReportVO(@Param("enterpriseId") String enterpriseId);
    List<QccGeneralTaxpayerVO> listQccGeneralTaxpayerVO(@Param("enterpriseId") String enterpriseId);
    List<QccImportExportCreditVO> listQccImportExportCreditVO(@Param("enterpriseId") String enterpriseId);
    List<QccJudgmentDocumentVO> listQccJudgmentDocumentVO(@Param("enterpriseId") String enterpriseId);
    List<QccKeymanVO> listQccKeymanVO(@Param("enterpriseId") String enterpriseId);
    List<QccQualificationCertificateVO> listQccQualificationCertificateVO(@Param("enterpriseId") String enterpriseId);
    List<QccAdministrativeLicenseVO> listQccTaxCreditVO(@Param("enterpriseId") String enterpriseId);
    List<QccAdministrativeLicenseVO> listQccWebsiteInformationVO(@Param("enterpriseId") String enterpriseId);
    List<QccBiddingVO> listQccBiddingVO(String enterpriseId);
    List<QccLandPurchaseInformationVO> listQccLandPurchaseInformationVO(String enterpriseId);
    List<QccSupplierVO> listQccSupplierVO(String enterpriseId);
    List<QccAdministrativeSanctionVO> listQccAdministrativeSanctionVO(String enterpriseId);
    List<QccFinancingConsultationVO> listQccFinancingConsultationVO(String enterpriseId);
    List<QccAppVO> listQccAppVO(String enterpriseId);
    List<QccAppletVO> listQccAppletVO(String enterpriseId);
    List<QccWechatVO> listQccWechatVO(String enterpriseId);
    List<QccWeiboVO> listQccWeiboVO(String enterpriseId);
    List<QccSoftwareCopyrightVO> listQccSoftwareCopyrightVO(String enterpriseId);
    List<QccAbnormalOperationVO> listQccAbnormalOperationVO(String enterpriseId);
    List<QccClientVO> listQccClientVO(String enterpriseId);

    List<QccCourtNoticeVO> listQccCourtNoticeVO(String enterpriseId);
    List<QccFilingInformationVO> listQccFilingInformationVO(String enterpriseId);
    List<QccAdministrativeLicenseChinaVO> listQccAdministrativeLicenseChinaVO(String enterpriseId);
    List<QccTaxArrearsNoticeVO> listQccTaxArrearsNoticeVO(String enterpriseId);

    List<QccEquityPledgeVO> listQccEquityPledgeVO(String enterpriseId);

    List<QccEquityOutPledgeVO> listQccEquityOutPledgeVO(String enterpriseId);

    String checkFavouriteQcc(String enterpriseId);
}