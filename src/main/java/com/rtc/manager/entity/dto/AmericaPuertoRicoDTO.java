package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rtc.manager.entity.america.puertorico.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaPuertoRicoDTO {
    private String enterpriseId;
    @JsonAlias("Name")
    private String name;
    @JsonAlias("Register No.")
    private String registerNumber;
    @JsonAlias("Status")
    private String enterpriseStatus;
    @JsonAlias("Formation Date")
    private String formationDate;
    @JsonAlias("Effective Date")
    private String effectiveDate;
    @JsonAlias("Expiration Date")
    private String expirationDate;
    @JsonAlias("Class")
    private String enterpriseClass;
    @JsonAlias("Type")
    private String type;
    @JsonAlias("Jurisdiction")
    private String jurisdiction;

    private AmericaPuertoRicoDomicileDTO domicile;

    private AmericaPuertoRicoOfficeAddressDTO officeAddress;

    private AmericaPuertoRicoResidentAgentDTO residentAgent;

    private String purpose;
    private String url;
    @JsonAlias("officers")
    private List<AmericaPuertoRicoOfficer> officerList;
    @JsonAlias("incorporators")
    private List<AmericaPuertoRicoIncorporator> incorporatorList;
    @JsonAlias("stocks")
    private List<AmericaPuertoRicoStock> stockList;
    @JsonAlias("administrators")
    private List<AmericaPuertoRicoAdministrator> administratorList;
    @JsonAlias("authorizedPersons")
    private List<AmericaPuertoRicoAuthorizedPerson> authorizedPersonList;
    @JsonAlias("documents")
    private List<AmericaPuertoRicoDocument> documentList;

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public String getFormationDate() {
        return formationDate;
    }

    public void setFormationDate(String formationDate) {
        this.formationDate = formationDate;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getEnterpriseClass() {
        return enterpriseClass;
    }

    public void setEnterpriseClass(String enterpriseClass) {
        this.enterpriseClass = enterpriseClass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public AmericaPuertoRicoDomicileDTO getDomicile() {
        return domicile;
    }

    public void setDomicile(AmericaPuertoRicoDomicileDTO domicile) {
        this.domicile = domicile;
    }

    public AmericaPuertoRicoOfficeAddressDTO getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(AmericaPuertoRicoOfficeAddressDTO officeAddress) {
        this.officeAddress = officeAddress;
    }

    public AmericaPuertoRicoResidentAgentDTO getResidentAgent() {
        return residentAgent;
    }

    public void setResidentAgent(AmericaPuertoRicoResidentAgentDTO residentAgent) {
        this.residentAgent = residentAgent;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<AmericaPuertoRicoOfficer> getOfficerList() {
        return officerList;
    }

    public void setOfficerList(List<AmericaPuertoRicoOfficer> officerList) {
        this.officerList = officerList;
    }

    public List<AmericaPuertoRicoIncorporator> getIncorporatorList() {
        return incorporatorList;
    }

    public void setIncorporatorList(List<AmericaPuertoRicoIncorporator> incorporatorList) {
        this.incorporatorList = incorporatorList;
    }

    public List<AmericaPuertoRicoStock> getStockList() {
        return stockList;
    }

    public void setStockList(List<AmericaPuertoRicoStock> stockList) {
        this.stockList = stockList;
    }

    public List<AmericaPuertoRicoAdministrator> getAdministratorList() {
        return administratorList;
    }

    public void setAdministratorList(List<AmericaPuertoRicoAdministrator> administratorList) {
        this.administratorList = administratorList;
    }

    public List<AmericaPuertoRicoAuthorizedPerson> getAuthorizedPersonList() {
        return authorizedPersonList;
    }

    public void setAuthorizedPersonList(List<AmericaPuertoRicoAuthorizedPerson> authorizedPersonList) {
        this.authorizedPersonList = authorizedPersonList;
    }

    public List<AmericaPuertoRicoDocument> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(List<AmericaPuertoRicoDocument> documentList) {
        this.documentList = documentList;
    }
}