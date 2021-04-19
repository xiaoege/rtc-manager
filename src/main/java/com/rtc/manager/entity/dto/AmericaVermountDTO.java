package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaVermountDTO {
    @JsonAlias("Business Name")
    private String name;

    @JsonAlias("Business ID")
    private String businessId;

    @JsonAlias("Business Type")
    private String businessType;

    @JsonAlias("Business Status")
    private String businessStatus;

    @JsonAlias("Expiration Date")
    private String expirationDate;

    @JsonAlias("Date of Incorporation / Registration Date")
    private String registrationDate;

    @JsonAlias("NAICS Code")
    private String naicsCode;

    @JsonAlias("NAICS sub code")
    private String naicsSubCode;

    @JsonAlias("Principal Office Business Address")
    private String address;

    @JsonAlias("Principal Office Mailing Address")
    private String mailingAddress;

    @JsonAlias("Citizenship / Domestic Jurisdiction")
    private String citizenship;

    @JsonAlias("principalsInformation")
    private List<AmericaVermountPrincipalDTO> principal;

    @JsonAlias("applicantInformation")
    private List<AmericaVermountApplicantDTO> applicant;

    @JsonAlias("businessRegistrant")
    private List<AmericaVermountBusinessRegistrantDTO> registrant;

    @JsonAlias("registeredAgent")
    private AmericaVermountRegisteredAgentDTO registeredAgent;

    @JsonAlias("individualRegistrant")
    private List<AmericaVermountIndvidualRegistrantDTO> individualRegistrant;

    @JsonAlias("otherAddresses")
    private AmericaVermountOtherAddressesDTO otherAddress;

    @JsonAlias("businessPoint")
    private AmericaVermountBusinessPointDTO businessPoint;

    @JsonAlias("assumedBusiness")
    private List<AmericaVermountAssumedBusinessDTO> assumedBusiness;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getNaicsCode() {
        return naicsCode;
    }

    public void setNaicsCode(String naicsCode) {
        this.naicsCode = naicsCode;
    }

    public String getNaicsSubCode() {
        return naicsSubCode;
    }

    public void setNaicsSubCode(String naicsSubCode) {
        this.naicsSubCode = naicsSubCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public List<AmericaVermountPrincipalDTO> getPrincipal() {
        return principal;
    }

    public void setPrincipal(List<AmericaVermountPrincipalDTO> principal) {
        this.principal = principal;
    }

    public List<AmericaVermountApplicantDTO> getApplicant() {
        return applicant;
    }

    public void setApplicant(List<AmericaVermountApplicantDTO> applicant) {
        this.applicant = applicant;
    }

    public List<AmericaVermountBusinessRegistrantDTO> getRegistrant() {
        return registrant;
    }

    public void setRegistrant(List<AmericaVermountBusinessRegistrantDTO> registrant) {
        this.registrant = registrant;
    }

    public AmericaVermountRegisteredAgentDTO getRegisteredAgent() {
        return registeredAgent;
    }

    public void setRegisteredAgent(AmericaVermountRegisteredAgentDTO registeredAgent) {
        this.registeredAgent = registeredAgent;
    }

    public List<AmericaVermountIndvidualRegistrantDTO> getIndividualRegistrant() {
        return individualRegistrant;
    }

    public void setIndividualRegistrant(List<AmericaVermountIndvidualRegistrantDTO> individualRegistrant) {
        this.individualRegistrant = individualRegistrant;
    }

    public AmericaVermountOtherAddressesDTO getOtherAddress() {
        return otherAddress;
    }

    public void setOtherAddress(AmericaVermountOtherAddressesDTO otherAddress) {
        this.otherAddress = otherAddress;
    }

    public AmericaVermountBusinessPointDTO getBusinessPoint() {
        return businessPoint;
    }

    public void setBusinessPoint(AmericaVermountBusinessPointDTO businessPoint) {
        this.businessPoint = businessPoint;
    }

    public List<AmericaVermountAssumedBusinessDTO> getAssumedBusiness() {
        return assumedBusiness;
    }

    public void setAssumedBusiness(List<AmericaVermountAssumedBusinessDTO> assumedBusiness) {
        this.assumedBusiness = assumedBusiness;
    }
}