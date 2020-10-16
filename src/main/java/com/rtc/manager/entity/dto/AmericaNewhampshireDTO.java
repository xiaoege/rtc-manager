package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rtc.manager.entity.america.newhampshire.*;

import java.util.List;

/**
 * @author ChenHang
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaNewhampshireDTO {
    private Integer id;

    private String enterpriseId;
    @JsonAlias("Business Name")
    private String businessName;
    @JsonAlias("Business ID")
    private String businessId;
    @JsonAlias("Business Type")
    private String businessType;
    @JsonAlias("Business Status")
    private String businessStatus;
    @JsonAlias("Business Creation Date")
    private String businessCreationDate;
    @JsonAlias("Name in State of Incorporation")
    private String nameInStateOfIncorporation;
    @JsonAlias("Date of Formation in Jurisdiction")
    private String dateOfFormationInJurisdiction;
    @JsonAlias("Principal Office Address")
    private String principalOfficeAddress;
    @JsonAlias("Mailing Address")
    private String mailingAddress;
    @JsonAlias("Citizenship / State of Incorporation")
    private String citizenshipStateOfIncorporation;
    @JsonAlias("Last Annual Report Year")
    private String lastAnnualReportYear;
    @JsonAlias("Next Report Year")
    private String nextReportYear;
    @JsonAlias("Duration")
    private String duration;
    @JsonAlias("Business Email")
    private String businessEmail;
    @JsonAlias("Phone #")
    private String phone;
    @JsonAlias("Notification Email")
    private String notificationEmail;
    @JsonAlias("Fiscal Year End Date")
    private String fiscalYearEndDate;
    @JsonAlias("pricipalInfomation")
    private List<AmericaNewhampshirePrincipalInformation> principalInformationList;
    @JsonAlias("principalPurpose")
    private List<AmericaNewhampshirePrincipalPurpose> principalPurposeList;
    @JsonAlias("registeredAgentInformation")
    private AmericaNewhampshireRegisteredAgentInformation registeredAgentInformation;
    @JsonAlias("trademarkInformation")
    private List<AmericaNewhampshireTrademarkInformation> trademarkInformationList;
    @JsonAlias("tradeNameInformation")
    private List<AmericaNewhampshireTradenameInformation> tradenameInformationList;
    @JsonAlias("tradeNameOwnedBy")
    private List<AmericaNewhampshireTradenameOwnedby> tradenameOwnedbyList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(String businessStatus) {
        this.businessStatus = businessStatus;
    }

    public String getBusinessCreationDate() {
        return businessCreationDate;
    }

    public void setBusinessCreationDate(String businessCreationDate) {
        this.businessCreationDate = businessCreationDate;
    }

    public String getNameInStateOfIncorporation() {
        return nameInStateOfIncorporation;
    }

    public void setNameInStateOfIncorporation(String nameInStateOfIncorporation) {
        this.nameInStateOfIncorporation = nameInStateOfIncorporation;
    }

    public String getDateOfFormationInJurisdiction() {
        return dateOfFormationInJurisdiction;
    }

    public void setDateOfFormationInJurisdiction(String dateOfFormationInJurisdiction) {
        this.dateOfFormationInJurisdiction = dateOfFormationInJurisdiction;
    }

    public String getPrincipalOfficeAddress() {
        return principalOfficeAddress;
    }

    public void setPrincipalOfficeAddress(String principalOfficeAddress) {
        this.principalOfficeAddress = principalOfficeAddress;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getCitizenshipStateOfIncorporation() {
        return citizenshipStateOfIncorporation;
    }

    public void setCitizenshipStateOfIncorporation(String citizenshipStateOfIncorporation) {
        this.citizenshipStateOfIncorporation = citizenshipStateOfIncorporation;
    }

    public String getLastAnnualReportYear() {
        return lastAnnualReportYear;
    }

    public void setLastAnnualReportYear(String lastAnnualReportYear) {
        this.lastAnnualReportYear = lastAnnualReportYear;
    }

    public String getNextReportYear() {
        return nextReportYear;
    }

    public void setNextReportYear(String nextReportYear) {
        this.nextReportYear = nextReportYear;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getBusinessEmail() {
        return businessEmail;
    }

    public void setBusinessEmail(String businessEmail) {
        this.businessEmail = businessEmail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNotificationEmail() {
        return notificationEmail;
    }

    public void setNotificationEmail(String notificationEmail) {
        this.notificationEmail = notificationEmail;
    }

    public String getFiscalYearEndDate() {
        return fiscalYearEndDate;
    }

    public void setFiscalYearEndDate(String fiscalYearEndDate) {
        this.fiscalYearEndDate = fiscalYearEndDate;
    }

    public List<AmericaNewhampshirePrincipalInformation> getPrincipalInformationList() {
        return principalInformationList;
    }

    public void setPrincipalInformationList(List<AmericaNewhampshirePrincipalInformation> principalInformationList) {
        this.principalInformationList = principalInformationList;
    }

    public List<AmericaNewhampshirePrincipalPurpose> getPrincipalPurposeList() {
        return principalPurposeList;
    }

    public void setPrincipalPurposeList(List<AmericaNewhampshirePrincipalPurpose> principalPurposeList) {
        this.principalPurposeList = principalPurposeList;
    }

    public AmericaNewhampshireRegisteredAgentInformation getRegisteredAgentInformation() {
        return registeredAgentInformation;
    }

    public void setRegisteredAgentInformation(AmericaNewhampshireRegisteredAgentInformation registeredAgentInformation) {
        this.registeredAgentInformation = registeredAgentInformation;
    }

    public List<AmericaNewhampshireTrademarkInformation> getTrademarkInformationList() {
        return trademarkInformationList;
    }

    public void setTrademarkInformationList(List<AmericaNewhampshireTrademarkInformation> trademarkInformationList) {
        this.trademarkInformationList = trademarkInformationList;
    }

    public List<AmericaNewhampshireTradenameInformation> getTradenameInformationList() {
        return tradenameInformationList;
    }

    public void setTradenameInformationList(List<AmericaNewhampshireTradenameInformation> tradenameInformationList) {
        this.tradenameInformationList = tradenameInformationList;
    }

    public List<AmericaNewhampshireTradenameOwnedby> getTradenameOwnedbyList() {
        return tradenameOwnedbyList;
    }

    public void setTradenameOwnedbyList(List<AmericaNewhampshireTradenameOwnedby> tradenameOwnedbyList) {
        this.tradenameOwnedbyList = tradenameOwnedbyList;
    }
}
