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

//    List<QccAnnualReportShareholderVO> listQccAnnualReportShareholderVO(@Param("enterpriseId") String enterpriseId);

    List<QccGeneralTaxpayerVO> listQccGeneralTaxpayerVO(@Param("enterpriseId") String enterpriseId);
    List<QccImportExportCreditVO> listQccImportExportCreditVO(@Param("enterpriseId") String enterpriseId);
    List<QccJudgmentDocumentVO> listQccJudgmentDocumentVO(@Param("enterpriseId") String enterpriseId);
    List<QccKeymanVO> listQccKeymanVO(@Param("enterpriseId") String enterpriseId);
    List<QccQualificationCertificateVO> listQccQualificationCertificateVO(@Param("enterpriseId") String enterpriseId);
    List<QccAdministrativeLicenseVO> listQccTaxCreditVO(@Param("enterpriseId") String enterpriseId);
    List<QccAdministrativeLicenseVO> listQccWebsiteInformationVO(@Param("enterpriseId") String enterpriseId);
}