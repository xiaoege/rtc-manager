package com.rtc.manager.vo.america.newhampshire;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaNewhampshireVO {
    private Integer id;

    private String enterpriseId;

    private String businessName;

    private String businessId;

    private String businessType;

    private String businessStatus;

    private String businessCreationDate;

    private String nameInStateOfIncorporation;

    private String dateOfFormationInJurisdiction;

    private String principalOfficeAddress;

    private String mailingAddress;

    private String citizenshipStateOfIncorporation;

    private String lastAnnualReportYear;

    private String nextReportYear;

    private String duration;

    private String businessEmail;

    private String phone;

    private String notificationEmail;

    private String fiscalYearEndDate;

    AmericaNewhampshireRegisteredAgentInformationVO registeredAgentInformationVO;

    List<AmericaNewhampshirePrincipalInformationVO> principalInformationVOList;

    List<AmericaNewhampshirePrincipalPurposeVO> principalPurposeVOList;

    List<AmericaNewhampshireTrademarkInformationVO> trademarkInformationVOList;

    List<AmericaNewhampshireTradenameInformationVO> tradenameInformationVOList;

    List<AmericaNewhampshireTradenameOwnedbyVO> tradenameOwnedbyVOList;

    public Integer getId() {
        return id;
    }
    @JsonSetter("pid")
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

    public AmericaNewhampshireRegisteredAgentInformationVO getRegisteredAgentInformationVO() {
        return registeredAgentInformationVO;
    }

    public void setRegisteredAgentInformationVO(AmericaNewhampshireRegisteredAgentInformationVO registeredAgentInformationVO) {
        this.registeredAgentInformationVO = registeredAgentInformationVO;
    }

    public List<AmericaNewhampshirePrincipalInformationVO> getPrincipalInformationVOList() {
        return principalInformationVOList;
    }

    public void setPrincipalInformationVOList(List<AmericaNewhampshirePrincipalInformationVO> principalInformationVOList) {
        this.principalInformationVOList = principalInformationVOList;
    }

    public List<AmericaNewhampshirePrincipalPurposeVO> getPrincipalPurposeVOList() {
        return principalPurposeVOList;
    }

    public void setPrincipalPurposeVOList(List<AmericaNewhampshirePrincipalPurposeVO> principalPurposeVOList) {
        this.principalPurposeVOList = principalPurposeVOList;
    }

    public List<AmericaNewhampshireTrademarkInformationVO> getTrademarkInformationVOList() {
        return trademarkInformationVOList;
    }

    public void setTrademarkInformationVOList(List<AmericaNewhampshireTrademarkInformationVO> trademarkInformationVOList) {
        this.trademarkInformationVOList = trademarkInformationVOList;
    }

    public List<AmericaNewhampshireTradenameInformationVO> getTradenameInformationVOList() {
        return tradenameInformationVOList;
    }

    public void setTradenameInformationVOList(List<AmericaNewhampshireTradenameInformationVO> tradenameInformationVOList) {
        this.tradenameInformationVOList = tradenameInformationVOList;
    }

    public List<AmericaNewhampshireTradenameOwnedbyVO> getTradenameOwnedbyVOList() {
        return tradenameOwnedbyVOList;
    }

    public void setTradenameOwnedbyVOList(List<AmericaNewhampshireTradenameOwnedbyVO> tradenameOwnedbyVOList) {
        this.tradenameOwnedbyVOList = tradenameOwnedbyVOList;
    }
}