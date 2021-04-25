package com.rtc.manager.util;

/**
 * @author ChenHang
 */
public enum QccCategoryEnum {
    // ============= 法律诉讼 =============
    /**
     * 裁判文书
     */
    JUDGMENTDOCUMENT("qcc_judgment_document"),
    /**
     * 开庭公告
     */
    COURTNOTICE("qcc_court_notice"),
    /**
     * 立案信息
     */
    FILINGINFORMATION("qcc_filing_information"),
    // ============= 法律诉讼 =============
    // ============= 经营状况 =============
    /**
     * 行政许可
     */
    ADMINISTRATIVELICENSE("qcc_administrative_license"),
    /**
     * 税务信用
     */
    TAXCREDIT("qcc_tax_credit"),
    /**
     * 招投标
     */
    BIDDING("qcc_bidding"),
    /**
     * 进出口信用
     */
    IMPORTEXPORTCREDIT("qcc_import_export_credit"),
    /**
     * 购地信息
     */
    LANDPURCHASEINFORMATION("qcc_land_purchase_information"),
    /**
     * 供应商
     */
    SUPPLIER("qcc_supplier"),
    /**
     * 客户
     */
    CLIENT("qcc_client"),
    /**
     * 一般纳税人
     */
    GENERALTAXPAYER("qcc_general_taxpayer"),
    /**
     * 行政许可 [信用中国]
     */
    ADMINISTRATIVELICENSECHINA("qcc_administrative_license_china"),
    /**
     * 抽查检查
     */
    SPOTCHECK("qcc_spot_check"),
    // ========== 经营状况 ==========
    // ========== 经营风险 ==========
    /**
     * 经营异常（移入）
     */
    QCC_SAVE_EXCEPTION("qcc_save_exception"),
    /**
     * 经营异常（移出）
     */
    QCC_REMOVE_EXCEPTION("qcc_remove_exception"),
    /**
     * 行政处罚
     */
    ADMINISTRATIVESANCTION("qcc_administrative_sanction"),
    /**
     * 环保处罚
     */
    ENVIRONMENTALPUNISHMENT("qcc_environmental_punishment"),
    /**
     * 税收违法
     */
    TAXVIOLATION("qcc_tax_violation"),
    /**
     * 股权质押
     */
    EQUITYPLEDGE("qcc_equity_pledge"),
    /**
     * 欠税公告
     */
    TAXARREARSNOTICE("qcc_tax_arrears_notice"),
    /**
     * 司法拍卖
     */
    JUDICIALAUCTION("qcc_judicial_auction"),
    /**
     * 股权出质
     */
    EQUITYOUTPLEDGE("qcc_equity_out_pledge"),
    // ========== 经营风险 ==========
    // ========== 企业发展 ==========
    /**
     * 企业年报
     */
    ANNUALREPORT("qcc_annual_report"),

    //QCC_ANNUAL_REPORT_SHAREHOLDER("qcc_annual_report_shareholder"),
    /**
     * 融资信息
     */
    FINANCINGCONSULTATION("qcc_financing_consultation"),
    /**
     * 核心人员
     */
    KEYMAN("qcc_keyman"),
    // ========== 企业发展 ==========
    // ========== 知识产权 ==========
    /**
     * 资质证书
     */
    QUALIFICATIONCERTIFICATE("qcc_qualification_certificate"),
    /**
     * 软件著作权
     */
    SOFTWARECOPYRIGHT("qcc_software_copyright"),
    /**
     * 网站信息
     */
    WEBSITEINFORMATION("qcc_website_information"),
    /**
     * app
     */
    APP("qcc_app"),
    /**
     * 小程序
     */
    APPLET("qcc_applet"),
    /**
     * 微信公众号
     */
    WECHAT("qcc_wechat"),
    /**
     * 微博
     */
    WEIBO("qcc_weibo"),
    // ========== 知识产权 ==========
    // ========== ohter ==========
    /**
     * 股东信息3
     */
    SHAREHOLDERTHREE("qcc_shareholder_three"),
    /**
     * 资质资格
     */
    QUALIFICATION("qcc_qualification"),
    /**
     * 对外投资
     */
    OUTINVESTMENT("qcc_out_investment"),
    /**
     * 股东及出资信息
     */
    SHAREHOLDERINVESTMENT("qcc_shareholder_investment"),
    /**
     * 股权变更信息
     */
    EQUITYCHANGE("qcc_equity_change"),
    /**
     * 变更记录
     */
    CHANGERECORD("qcc_change_record"),
    // ========== ohter ==========
    ;

    private String tb;

    QccCategoryEnum(String tb) {
        this.tb = tb;
    }

    public static String getTableName(String var0) {
        for (QccCategoryEnum categoryEnum : QccCategoryEnum.values()) {
            if (categoryEnum.name().equalsIgnoreCase(var0)) {
                return categoryEnum.tb;
            }
        }
        return null;
    }

}
