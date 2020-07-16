package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

import java.util.List;

@Data
public class QccAnnualReportVO {
    @JsonSetter("pid")
    private Integer id;

    private String uuid;

    private String enterpriseId;

    private String year;

    private String unifiedSocialCreditCode;

    private String registrationNumber;

    private String businessStatus;

    private String businessTelephone;

    private String eMail;

    private String postCode;

    private String staffNumber;

    private String equityTransfer;

    private String purchaseEquity;

    private String postalAddress;

    private String totalAssets;

    private String totalEquity;

    private String totalOperatingIncome;

    private String totalProfit;

    private String netProfit;

    private String mainBusinessIncome;

    private String totalTax;

    private String totalLiabilities;

    private String endowmentInsurance;

    private String medicalInsurance;

    private String maternityInsurance;

    private String unemploymentInsurance;

    private String employmentInjuryInsurance;

    private List<QccAnnualReportShareholderVO> qccAnnualReportShareholderVOList;

}