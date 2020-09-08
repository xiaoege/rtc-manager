package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * @author ChenHang
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchEnterpriseListVO {

    @JsonAlias("e_type")
    private String eType;

    @JsonAlias("e_name")
    private String eName;

    private String nation;
    private Integer pid;
    @JsonAlias("enterprise_id")
    private String enterpriseId;
    // india-cin
    /*private String cin;
    @JsonAlias("roc_code")
    private String rocCode;
    @JsonAlias("registration_number")
    private String registrationNumber;
    @JsonAlias("company_category")
    private String companyCategory;
    @JsonAlias("company_sub_category")
    private String companySubCategory;
    @JsonAlias("class_of_company")
    private String classOfCompany;
    @JsonAlias("authorised_capital")
    private String authorisedCapital;
    @JsonAlias("paid_up_capital")
    private String paidUpCapital;
    @JsonAlias("number_of_members")
    private String numberOfMembers;
    @JsonAlias("date_of_incorporation")
    private String dateOfIncorporation;
    @JsonAlias("email_id")
    private String emailId;
    @JsonAlias("whether_listed_or_not")
    private String whetherListedOrNot;
    @JsonAlias("active_compliant")
    private String activeCompliant;
    @JsonAlias("suspended_at_stock_exchange")
    private String suspendedAtStockExchange;
    @JsonAlias("date_of_last_agm")
    private String dateOfLastAgm;
    @JsonAlias("date_of_balance_sheet")
    private String dateOfBalanceSheet;
    @JsonAlias("company_status")
    private String companyStatus;
    @JsonAlias("registered_address")
    private String registeredAddress;*/

    // india-llpin
    /*private String llpin;
    @JsonAlias("number_of_partners")
    private String numberOfPartners;
    @JsonAlias("number_of_designated_partners")
    private String numberOfDesignatedPartners;
    @JsonAlias("registrated_address")
    private String registratedAddress;
    @JsonAlias("previous_firm")
    private String previousFirm;
    @JsonAlias("total_obligation_of_contribution")
    private String totalObligationOfContribution;
    @JsonAlias("main_division_of_business")
    private String mainDivisionOfBusiness;
    @JsonAlias("description_of_main_division")
    private String descriptionOfMainDivision;
    @JsonAlias("statement_date")
    private String statementDate;
    @JsonAlias("annual_date")
    private String annualDate;
    @JsonAlias("llp_status")
    private String llpStatus;*/

    // China
//    @JsonAlias("registered_capital")
//    private String registeredCapital;
    @JsonAlias("legal_representative")
    private String legalRepresentative;
    @JsonAlias({"establishment_date", "date_of_incorporation"})
    private String establishmentDate;
    @JsonAlias({"registered_address", "registrated_address"})
    private String address;
//    @JsonAlias("country_region")
//    private String countryRegion;


    public String geteType() {
        return eType;
    }
    @JsonSetter("e_type")
    public void seteType(String eType) {
        this.eType = eType;
    }

    public String geteName() {
        return eName;
    }
    @JsonSetter("e_name")
    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(String establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
