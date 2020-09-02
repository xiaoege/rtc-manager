package com.rtc.manager.vo.india;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

/**
 * @author ChenHang
 */
@Data
public class IndiaLlpinVO {
    @JsonSetter("pid")
    private Integer id;
    private String enterpriseId;
    private String llpin;
    @JsonSetter("e_name")
    private String llpName;
    private String numberOfPartners;
    private String numberOfDesignatedPartners;
    private String rocCode;
    @JsonSetter("establishmentDate")
    private String dateOfIncorporation;
    @JsonSetter("address")
    private String registratedAddress;
    private String emailId;
    private String previousFirm;
    private String totalObligationOfContribution;
    private String mainDivisionOfBusiness;
    private String descriptionOfMainDivision;
    private String statementDate;
    private String annualDate;
    private String llpStatus;
}
