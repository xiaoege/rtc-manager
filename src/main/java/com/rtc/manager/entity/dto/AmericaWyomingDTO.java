package com.rtc.manager.entity.dto;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaWyomingDTO {
    @JsonAlias("enterprise_id")
    private String enterpriseId;
    @JsonAlias("FILING_ID")
    private String filingId;
    @JsonAlias("FILING_TYPE")
    private String filingType;
    @JsonAlias("FILING_SUBTYPE")
    private String filingSubtype;
    @JsonAlias("WORD_DESIGN_TYPE")
    private String wordDesign;
    @JsonAlias("DURATION_TERM_TYPE")
    private String duration;
    @JsonAlias("STATUS")
    private String enterpriseStatus;
    @JsonAlias("SUB_STATUS")
    private String subStatus;
    @JsonAlias("STANDING_TAX")
    private String standingTax;
    @JsonAlias("STANDING_RA")
    private String standingRa;
    @JsonAlias("STANDING_OTHER")
    private String standingOther;
    @JsonAlias("PURPOSE")
    private String purpose;
    @JsonAlias("APPLICANT_TYPE")
    private String applicantType;
    @JsonAlias("FILING_NUM")
    private String filingNum;
    @JsonAlias("FILING_NAME")
    private String filingName;
    @JsonAlias("OLD_NAME")
    private String oldName;
    @JsonAlias("FICTITIOUS_NAME")
    private String fictitiousName;
    @JsonAlias("DOMESTIC_YN")
    private String domesticYn;
    @JsonAlias("FILING_DATE")
    private String filingDate;
    @JsonAlias("DELAYED_EFFECTIVE_DATE")
    private String delayedEffectiveDate;
    @JsonAlias("EXPIRATION_DATE")
    private String expirationDate;
    @JsonAlias("INACTIVE_DATE")
    private String inactiveDate;
    @JsonAlias("RA_RESIGN_CERT_LETTER_DATE")
    private String raResignCertLetterDate;
    @JsonAlias("CONVERTED_YN")
    private String convertedYn;
    @JsonAlias("CONVERTED_FROM")
    private String convertedFrom;
    @JsonAlias("CONVERTED_FROM_NAME")
    private String convertedFromName;
    @JsonAlias("CONVERTED_DATE")
    private String convertedDate;
    @JsonAlias("ISSUE_ON_RECORD_YN")
    private String issueOnRecordYn;
    @JsonAlias("TRANSFERRED_TO")
    private String transferredTo;
    @JsonAlias("TRANSFERRED_DATE")
    private String transferredDate;
    @JsonAlias("FORMATION_LOCALE")
    private String formationLocale;
    @JsonAlias("CONTINUED_FROM_LOCALE")
    private String continuedFromLocale;
    @JsonAlias("DOMESTICATED_FROM_LOCALE")
    private String domesticatedFromLocale;
    @JsonAlias("FORM_HOME_JURIS_DATE")
    private String formHomeJurisDate;
    @JsonAlias("COMMON_SHARES")
    private String commonShares;
    @JsonAlias("COMMON_PAR_VALUE")
    private String commonParValue;
    @JsonAlias("PREFERRED_SHARES")
    private String preferredShares;
    @JsonAlias("PREFERRED_PAR_VALUE")
    private String preferredParValue;
    @JsonAlias("ADDITIONAL_STOCK_YN")
    private String additionStockYn;
    @JsonAlias("PRINCIPLE_ADDR1")
    private String principleAddr1;
    @JsonAlias("PRINCIPLE_ADDR2")
    private String principleAddr2;
    @JsonAlias("PRINCIPLE_ADDR3")
    private String principleAddr3;
    @JsonAlias("PRINCIPLE_CITY")
    private String principleCity;
    @JsonAlias("PRINCIPLE_STATE")
    private String principleState;
    @JsonAlias("PRINCIPLE_POSTAL_CODE")
    private String principlePostalCode;
    @JsonAlias("PRINCIPLE_COUNTRY")
    private String principleCountry;
    @JsonAlias("MAIL_ADDR1")
    private String mailAddr1;
    @JsonAlias("MAIL_ADDR2")
    private String mailAddr2;
    @JsonAlias("MAIL_ADDR3")
    private String mailAddr3;
    @JsonAlias("MAIL_CITY")
    private String mailCity;
    @JsonAlias("MAIL_STATE")
    private String mailState;
    @JsonAlias("MAIL_POSTAL_CODE")
    private String mailPostalCode;
    @JsonAlias("MAIL_COUNTRY")
    private String mailCountry;
    @JsonAlias("STATE_OF_ORG")
    private String stateOfOrg;
    @JsonAlias("ORG_DATE")
    private String orgDate;
    @JsonAlias("REG_US_OFFICE_YN")
    private String regUsOfficeYn;
    @JsonAlias("REG_US_DATE")
    private String regUsDate;
    @JsonAlias("REG_US_SERIAL_NUM")
    private String regUsSerialNum;
    @JsonAlias("REG_US_STATUS")
    private String regUsStatus;
    @JsonAlias("REG_US_APP_REFUSED_YN")
    private String regUsAppRefusedYn;
    @JsonAlias("FIRST_USED_ANYWHERE_DATE")
    private String firstUsedAnywhereDate;
    @JsonAlias("FIRST_USED_WYO_DATE")
    private String firstUsedWyoDate;
    @JsonAlias("AR_EXEMPT_YN")
    private String arExemptYn;
    @JsonAlias("TRADEMARK_KEYWORDS")
    private String trademarkKeywords;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getFilingId() {
        return filingId;
    }

    public void setFilingId(String filingId) {
        this.filingId = filingId;
    }

    public String getFilingType() {
        return filingType;
    }

    public void setFilingType(String filingType) {
        this.filingType = filingType;
    }

    public String getFilingSubtype() {
        return filingSubtype;
    }

    public void setFilingSubtype(String filingSubtype) {
        this.filingSubtype = filingSubtype;
    }

    public String getWordDesign() {
        return wordDesign;
    }

    public void setWordDesign(String wordDesign) {
        this.wordDesign = wordDesign;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public String getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(String subStatus) {
        this.subStatus = subStatus;
    }

    public String getStandingTax() {
        return standingTax;
    }

    public void setStandingTax(String standingTax) {
        this.standingTax = standingTax;
    }

    public String getStandingRa() {
        return standingRa;
    }

    public void setStandingRa(String standingRa) {
        this.standingRa = standingRa;
    }

    public String getStandingOther() {
        return standingOther;
    }

    public void setStandingOther(String standingOther) {
        this.standingOther = standingOther;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getApplicantType() {
        return applicantType;
    }

    public void setApplicantType(String applicantType) {
        this.applicantType = applicantType;
    }

    public String getFilingNum() {
        return filingNum;
    }

    public void setFilingNum(String filingNum) {
        this.filingNum = filingNum;
    }

    public String getFilingName() {
        return filingName;
    }

    public void setFilingName(String filingName) {
        this.filingName = filingName;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getFictitiousName() {
        return fictitiousName;
    }

    public void setFictitiousName(String fictitiousName) {
        this.fictitiousName = fictitiousName;
    }

    public String getDomesticYn() {
        return domesticYn;
    }

    public void setDomesticYn(String domesticYn) {
        this.domesticYn = domesticYn;
    }

    public String getFilingDate() {
        return filingDate;
    }

    public void setFilingDate(String filingDate) {
        this.filingDate = filingDate;
    }

    public String getDelayedEffectiveDate() {
        return delayedEffectiveDate;
    }

    public void setDelayedEffectiveDate(String delayedEffectiveDate) {
        this.delayedEffectiveDate = delayedEffectiveDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getInactiveDate() {
        return inactiveDate;
    }

    public void setInactiveDate(String inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

    public String getRaResignCertLetterDate() {
        return raResignCertLetterDate;
    }

    public void setRaResignCertLetterDate(String raResignCertLetterDate) {
        this.raResignCertLetterDate = raResignCertLetterDate;
    }

    public String getConvertedYn() {
        return convertedYn;
    }

    public void setConvertedYn(String convertedYn) {
        this.convertedYn = convertedYn;
    }

    public String getConvertedFrom() {
        return convertedFrom;
    }

    public void setConvertedFrom(String convertedFrom) {
        this.convertedFrom = convertedFrom;
    }

    public String getConvertedFromName() {
        return convertedFromName;
    }

    public void setConvertedFromName(String convertedFromName) {
        this.convertedFromName = convertedFromName;
    }

    public String getConvertedDate() {
        return convertedDate;
    }

    public void setConvertedDate(String convertedDate) {
        this.convertedDate = convertedDate;
    }

    public String getIssueOnRecordYn() {
        return issueOnRecordYn;
    }

    public void setIssueOnRecordYn(String issueOnRecordYn) {
        this.issueOnRecordYn = issueOnRecordYn;
    }

    public String getTransferredTo() {
        return transferredTo;
    }

    public void setTransferredTo(String transferredTo) {
        this.transferredTo = transferredTo;
    }

    public String getTransferredDate() {
        return transferredDate;
    }

    public void setTransferredDate(String transferredDate) {
        this.transferredDate = transferredDate;
    }

    public String getFormationLocale() {
        return formationLocale;
    }

    public void setFormationLocale(String formationLocale) {
        this.formationLocale = formationLocale;
    }

    public String getContinuedFromLocale() {
        return continuedFromLocale;
    }

    public void setContinuedFromLocale(String continuedFromLocale) {
        this.continuedFromLocale = continuedFromLocale;
    }

    public String getDomesticatedFromLocale() {
        return domesticatedFromLocale;
    }

    public void setDomesticatedFromLocale(String domesticatedFromLocale) {
        this.domesticatedFromLocale = domesticatedFromLocale;
    }

    public String getFormHomeJurisDate() {
        return formHomeJurisDate;
    }

    public void setFormHomeJurisDate(String formHomeJurisDate) {
        this.formHomeJurisDate = formHomeJurisDate;
    }

    public String getCommonShares() {
        return commonShares;
    }

    public void setCommonShares(String commonShares) {
        this.commonShares = commonShares;
    }

    public String getCommonParValue() {
        return commonParValue;
    }

    public void setCommonParValue(String commonParValue) {
        this.commonParValue = commonParValue;
    }

    public String getPreferredShares() {
        return preferredShares;
    }

    public void setPreferredShares(String preferredShares) {
        this.preferredShares = preferredShares;
    }

    public String getPreferredParValue() {
        return preferredParValue;
    }

    public void setPreferredParValue(String preferredParValue) {
        this.preferredParValue = preferredParValue;
    }

    public String getAdditionStockYn() {
        return additionStockYn;
    }

    public void setAdditionStockYn(String additionStockYn) {
        this.additionStockYn = additionStockYn;
    }

    public String getPrincipleAddr1() {
        return principleAddr1;
    }

    public void setPrincipleAddr1(String principleAddr1) {
        this.principleAddr1 = principleAddr1;
    }

    public String getPrincipleAddr2() {
        return principleAddr2;
    }

    public void setPrincipleAddr2(String principleAddr2) {
        this.principleAddr2 = principleAddr2;
    }

    public String getPrincipleAddr3() {
        return principleAddr3;
    }

    public void setPrincipleAddr3(String principleAddr3) {
        this.principleAddr3 = principleAddr3;
    }

    public String getPrincipleCity() {
        return principleCity;
    }

    public void setPrincipleCity(String principleCity) {
        this.principleCity = principleCity;
    }

    public String getPrincipleState() {
        return principleState;
    }

    public void setPrincipleState(String principleState) {
        this.principleState = principleState;
    }

    public String getPrinciplePostalCode() {
        return principlePostalCode;
    }

    public void setPrinciplePostalCode(String principlePostalCode) {
        this.principlePostalCode = principlePostalCode;
    }

    public String getPrincipleCountry() {
        return principleCountry;
    }

    public void setPrincipleCountry(String principleCountry) {
        this.principleCountry = principleCountry;
    }

    public String getMailAddr1() {
        return mailAddr1;
    }

    public void setMailAddr1(String mailAddr1) {
        this.mailAddr1 = mailAddr1;
    }

    public String getMailAddr2() {
        return mailAddr2;
    }

    public void setMailAddr2(String mailAddr2) {
        this.mailAddr2 = mailAddr2;
    }

    public String getMailAddr3() {
        return mailAddr3;
    }

    public void setMailAddr3(String mailAddr3) {
        this.mailAddr3 = mailAddr3;
    }

    public String getMailCity() {
        return mailCity;
    }

    public void setMailCity(String mailCity) {
        this.mailCity = mailCity;
    }

    public String getMailState() {
        return mailState;
    }

    public void setMailState(String mailState) {
        this.mailState = mailState;
    }

    public String getMailPostalCode() {
        return mailPostalCode;
    }

    public void setMailPostalCode(String mailPostalCode) {
        this.mailPostalCode = mailPostalCode;
    }

    public String getMailCountry() {
        return mailCountry;
    }

    public void setMailCountry(String mailCountry) {
        this.mailCountry = mailCountry;
    }

    public String getStateOfOrg() {
        return stateOfOrg;
    }

    public void setStateOfOrg(String stateOfOrg) {
        this.stateOfOrg = stateOfOrg;
    }

    public String getOrgDate() {
        return orgDate;
    }

    public void setOrgDate(String orgDate) {
        this.orgDate = orgDate;
    }

    public String getRegUsOfficeYn() {
        return regUsOfficeYn;
    }

    public void setRegUsOfficeYn(String regUsOfficeYn) {
        this.regUsOfficeYn = regUsOfficeYn;
    }

    public String getRegUsDate() {
        return regUsDate;
    }

    public void setRegUsDate(String regUsDate) {
        this.regUsDate = regUsDate;
    }

    public String getRegUsSerialNum() {
        return regUsSerialNum;
    }

    public void setRegUsSerialNum(String regUsSerialNum) {
        this.regUsSerialNum = regUsSerialNum;
    }

    public String getRegUsStatus() {
        return regUsStatus;
    }

    public void setRegUsStatus(String regUsStatus) {
        this.regUsStatus = regUsStatus;
    }

    public String getRegUsAppRefusedYn() {
        return regUsAppRefusedYn;
    }

    public void setRegUsAppRefusedYn(String regUsAppRefusedYn) {
        this.regUsAppRefusedYn = regUsAppRefusedYn;
    }

    public String getFirstUsedAnywhereDate() {
        return firstUsedAnywhereDate;
    }

    public void setFirstUsedAnywhereDate(String firstUsedAnywhereDate) {
        this.firstUsedAnywhereDate = firstUsedAnywhereDate;
    }

    public String getFirstUsedWyoDate() {
        return firstUsedWyoDate;
    }

    public void setFirstUsedWyoDate(String firstUsedWyoDate) {
        this.firstUsedWyoDate = firstUsedWyoDate;
    }

    public String getArExemptYn() {
        return arExemptYn;
    }

    public void setArExemptYn(String arExemptYn) {
        this.arExemptYn = arExemptYn;
    }

    public String getTrademarkKeywords() {
        return trademarkKeywords;
    }

    public void setTrademarkKeywords(String trademarkKeywords) {
        this.trademarkKeywords = trademarkKeywords;
    }
}