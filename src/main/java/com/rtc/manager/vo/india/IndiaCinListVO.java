package com.rtc.manager.vo.india;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author ChenHang
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IndiaCinListVO {

    private String e_type;

    @JsonAlias("enterprise_id")
    private String enterpriseId;
    @JsonAlias("cin")
    private String cin;
    @JsonAlias({"company_name", "llp_name"})
    private String companyName;
    @JsonAlias("roc_code")
    private String rocCode;
//    @JsonAlias("registration_number")
//    private String registrationNumber;
//    @JsonAlias("company_category")
//    private String companyCategory;
//    @JsonAlias("company_sub_category")
//    private String companySubCategory;
//    @JsonAlias("class_of_company")
//    private String classOfCompany;
//    @JsonAlias("authorised_capital")
//    private String authorisedCapital;
//    @JsonAlias("paid_up_capital")
//    private String paidUpCapital;
//    @JsonAlias("number_of_members")
//    private String numberOfMembers;
//    @JsonAlias("date_of_incorporation")
//    private String dateOfIncorporation;
//    @JsonAlias("email_id")
//    private String emailId;
//    @JsonAlias("whether_listed_or_not")
//    private String whetherListedOrNot;
//    @JsonAlias("active_compliant")
//    private String activeCompliant;
//    @JsonAlias("suspended_at_stock_exchange")
//    private String suspendedAtStockExchange;
//    @JsonAlias("date_of_last_agm")
//    private String dateOfLastAgm;
//    @JsonAlias("date_of_balance_sheet")
//    private String dateOfBalanceSheet;
//    @JsonAlias("company_status")
//    private String companyStatus;
//    @JsonAlias("registered_address")
//    private String registeredAddress;


    public String getE_type() {
        return e_type;
    }

    public void setE_type(String e_type) {
        this.e_type = e_type;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRocCode() {
        return rocCode;
    }

    public void setRocCode(String rocCode) {
        this.rocCode = rocCode;
    }
}
