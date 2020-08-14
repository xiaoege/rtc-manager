package com.rtc.manager.vo.india;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

/**
 * @author ChenHang
 */
@Data
public class IndiaCinVO {
    @JsonSetter("pid")
    private Integer id;
    private String enterpriseId;
    private String cin;
    private String companyName;
    private String rocCode;
    private String registrationNumber;
    private String companyCategory;
    private String companySubCategory;
    private String classOfCompany;
    private String authorisedCapital;
    private String paidUpCapital;
    private String numberOfMembers;
    private String dateOfIncorporation;
    private String emailId;
    private String whetherListedOrNot;
    private String activeCompliant;
    private String suspendedAtStockExchange;
    private String dateOfLastAgm;
    private String dateOfBalanceSheet;
    private String companyStatus;
    private String registeredAddress;
}
