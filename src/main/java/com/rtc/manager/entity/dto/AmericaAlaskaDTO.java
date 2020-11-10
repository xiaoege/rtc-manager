package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * @author chenhang
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaAlaskaDTO {
    @JsonAlias("enterprise_id")
    private String enterpriseId;
    @JsonAlias({"Company Name", "LEGALNAME"})
    private String name;
    @JsonAlias({"Company Type", "CORPTYPE"})
    private String type;
    @JsonAlias("Entity Type")
    private String entityType;
    @JsonAlias({"Entity #", "ENTITYNUMBER"})
    private String entityNumber;
    @JsonAlias({"Status","STATUS"})
    private String enterpriseStatus;
    @JsonAlias({"Ak form data","AKFORMEDDATE"})
    private String akFormData;
    @JsonAlias({"Duration/Expiration","DURATIONEXPIRATIONDATE"})
    private String duration;
    @JsonAlias({"Home state","HOMESTATE"})
    private String homeState;
    @JsonAlias({"Entity Mailing Address","ENTITYMAILINGADDRESS1"})
    private String entityMailingAddress;
    @JsonAlias({"Entity Physical Address","ENTITYPHYSADDRESS1"})
    private String entityPhysicalAddress;
    @JsonAlias({"Agent Name","REGISTEREDAGENT"})
    private String agentName;
    @JsonAlias({"Registered mailing address","REGISTEREDMAILADDRESS1"})
    private String registeredMailingAddress;
    @JsonAlias({"Registered physical address","REGISTEREDPHYSADDRESS1"})
    private String registeredPhysicalAddress;
    @JsonAlias("Next Biennial Report Due")
    private List<String> nextBiennialReportDue;
    @JsonAlias("Official Entity")
    private List<String> officialEntity;
    @JsonAlias("Official Name")
    private List<String> officialName;
    @JsonAlias("Official Tite")
    private List<String> officialTite;
    @JsonAlias("Official Owned")
    private List<String> officialOwned;

    @JsonAlias("ASSUMEDNAME")
    private String assumedName;
    @JsonAlias("HOMECOUNTRY")
    private String homeCountry;
    @JsonAlias("NEXTBRDUEDATE")
    private String nextBrdueDate;
    @JsonAlias("ENTITYMAILINGADDRESS2")
    private String entityMailingAddress2;
    @JsonAlias("ENTITYMAILINGCITY")
    private String entityMailingCity;
    @JsonAlias("ENTITYMAILINGSTATEPROVINCE")
    private String entityMailingStateProvince;
    @JsonAlias("ENTITYMAILINGZIP")
    private String entityMailingZip;
    @JsonAlias("ENTITYMAILINGCOUNTRY")
    private String entityMailingCountry;
    @JsonAlias("ENTITYPHYSADDRESS2")
    private String entityPhysAddress2;
    @JsonAlias("ENTITYPHYSCITY")
    private String entityPhysCity;
    @JsonAlias("ENTITYPHYSSTATEPROVINCE")
    private String entityPhysStateProvince;
    @JsonAlias("ENTITYPHYSZIP")
    private String entityPhysZip;
    @JsonAlias("ENTITYPHYSCOUNTRY")
    private String entityPhysCountry;
    @JsonAlias("REGISTEREDMAILADDRESS2")
    private String registeredMailAddress2;
    @JsonAlias("REGISTEREDMAILCITY")
    private String registeredMailCity;
    @JsonAlias("REGISTEREDMAILSTATEPROVINCE")
    private String registeredMailStateProvince;
    @JsonAlias("REGISTEREDMAILZIP")
    private String registeredMailZip;
    @JsonAlias("REGISTEREDMAILCOUNTRY")
    private String registeredMailCountry;
    @JsonAlias("REGISTEREDPHYSADDRESS2")
    private String registeredPhysAddress2;
    @JsonAlias("REGISTEREDPHYSCITY")
    private String registeredPhysCity;
    @JsonAlias("REGISTEREDPHYSSTATEPROVINCE")
    private String registeredPhysStateProvince;
    @JsonAlias("REGISTEREDPHYSZIP")
    private String registeredPhysZip;
    @JsonAlias("REGISTEREDPHYSCOUNTRY")
    private String registeredPhysCountry;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getEntityNumber() {
        return entityNumber;
    }

    public void setEntityNumber(String entityNumber) {
        this.entityNumber = entityNumber;
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public String getAkFormData() {
        return akFormData;
    }

    public void setAkFormData(String akFormData) {
        this.akFormData = akFormData;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getHomeState() {
        return homeState;
    }

    public void setHomeState(String homeState) {
        this.homeState = homeState;
    }

    public String getEntityMailingAddress() {
        return entityMailingAddress;
    }

    public void setEntityMailingAddress(String entityMailingAddress) {
        this.entityMailingAddress = entityMailingAddress;
    }

    public String getEntityPhysicalAddress() {
        return entityPhysicalAddress;
    }

    public void setEntityPhysicalAddress(String entityPhysicalAddress) {
        this.entityPhysicalAddress = entityPhysicalAddress;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getRegisteredMailingAddress() {
        return registeredMailingAddress;
    }

    public void setRegisteredMailingAddress(String registeredMailingAddress) {
        this.registeredMailingAddress = registeredMailingAddress;
    }

    public String getRegisteredPhysicalAddress() {
        return registeredPhysicalAddress;
    }

    public void setRegisteredPhysicalAddress(String registeredPhysicalAddress) {
        this.registeredPhysicalAddress = registeredPhysicalAddress;
    }

    public List<String> getNextBiennialReportDue() {
        return nextBiennialReportDue;
    }

    public void setNextBiennialReportDue(List<String> nextBiennialReportDue) {
        this.nextBiennialReportDue = nextBiennialReportDue;
    }

    public List<String> getOfficialEntity() {
        return officialEntity;
    }

    public void setOfficialEntity(List<String> officialEntity) {
        this.officialEntity = officialEntity;
    }

    public List<String> getOfficialName() {
        return officialName;
    }

    public void setOfficialName(List<String> officialName) {
        this.officialName = officialName;
    }

    public List<String> getOfficialTite() {
        return officialTite;
    }

    public void setOfficialTite(List<String> officialTite) {
        this.officialTite = officialTite;
    }

    public List<String> getOfficialOwned() {
        return officialOwned;
    }

    public void setOfficialOwned(List<String> officialOwned) {
        this.officialOwned = officialOwned;
    }

    public String getAssumedName() {
        return assumedName;
    }

    public void setAssumedName(String assumedName) {
        this.assumedName = assumedName;
    }

    public String getHomeCountry() {
        return homeCountry;
    }

    public void setHomeCountry(String homeCountry) {
        this.homeCountry = homeCountry;
    }

    public String getNextBrdueDate() {
        return nextBrdueDate;
    }

    public void setNextBrdueDate(String nextBrdueDate) {
        this.nextBrdueDate = nextBrdueDate;
    }

    public String getEntityMailingAddress2() {
        return entityMailingAddress2;
    }

    public void setEntityMailingAddress2(String entityMailingAddress2) {
        this.entityMailingAddress2 = entityMailingAddress2;
    }

    public String getEntityMailingCity() {
        return entityMailingCity;
    }

    public void setEntityMailingCity(String entityMailingCity) {
        this.entityMailingCity = entityMailingCity;
    }

    public String getEntityMailingStateProvince() {
        return entityMailingStateProvince;
    }

    public void setEntityMailingStateProvince(String entityMailingStateProvince) {
        this.entityMailingStateProvince = entityMailingStateProvince;
    }

    public String getEntityMailingZip() {
        return entityMailingZip;
    }

    public void setEntityMailingZip(String entityMailingZip) {
        this.entityMailingZip = entityMailingZip;
    }

    public String getEntityMailingCountry() {
        return entityMailingCountry;
    }

    public void setEntityMailingCountry(String entityMailingCountry) {
        this.entityMailingCountry = entityMailingCountry;
    }

    public String getEntityPhysAddress2() {
        return entityPhysAddress2;
    }

    public void setEntityPhysAddress2(String entityPhysAddress2) {
        this.entityPhysAddress2 = entityPhysAddress2;
    }

    public String getEntityPhysCity() {
        return entityPhysCity;
    }

    public void setEntityPhysCity(String entityPhysCity) {
        this.entityPhysCity = entityPhysCity;
    }

    public String getEntityPhysStateProvince() {
        return entityPhysStateProvince;
    }

    public void setEntityPhysStateProvince(String entityPhysStateProvince) {
        this.entityPhysStateProvince = entityPhysStateProvince;
    }

    public String getEntityPhysZip() {
        return entityPhysZip;
    }

    public void setEntityPhysZip(String entityPhysZip) {
        this.entityPhysZip = entityPhysZip;
    }

    public String getEntityPhysCountry() {
        return entityPhysCountry;
    }

    public void setEntityPhysCountry(String entityPhysCountry) {
        this.entityPhysCountry = entityPhysCountry;
    }

    public String getRegisteredMailAddress2() {
        return registeredMailAddress2;
    }

    public void setRegisteredMailAddress2(String registeredMailAddress2) {
        this.registeredMailAddress2 = registeredMailAddress2;
    }

    public String getRegisteredMailCity() {
        return registeredMailCity;
    }

    public void setRegisteredMailCity(String registeredMailCity) {
        this.registeredMailCity = registeredMailCity;
    }

    public String getRegisteredMailStateProvince() {
        return registeredMailStateProvince;
    }

    public void setRegisteredMailStateProvince(String registeredMailStateProvince) {
        this.registeredMailStateProvince = registeredMailStateProvince;
    }

    public String getRegisteredMailZip() {
        return registeredMailZip;
    }

    public void setRegisteredMailZip(String registeredMailZip) {
        this.registeredMailZip = registeredMailZip;
    }

    public String getRegisteredMailCountry() {
        return registeredMailCountry;
    }

    public void setRegisteredMailCountry(String registeredMailCountry) {
        this.registeredMailCountry = registeredMailCountry;
    }

    public String getRegisteredPhysAddress2() {
        return registeredPhysAddress2;
    }

    public void setRegisteredPhysAddress2(String registeredPhysAddress2) {
        this.registeredPhysAddress2 = registeredPhysAddress2;
    }

    public String getRegisteredPhysCity() {
        return registeredPhysCity;
    }

    public void setRegisteredPhysCity(String registeredPhysCity) {
        this.registeredPhysCity = registeredPhysCity;
    }

    public String getRegisteredPhysStateProvince() {
        return registeredPhysStateProvince;
    }

    public void setRegisteredPhysStateProvince(String registeredPhysStateProvince) {
        this.registeredPhysStateProvince = registeredPhysStateProvince;
    }

    public String getRegisteredPhysZip() {
        return registeredPhysZip;
    }

    public void setRegisteredPhysZip(String registeredPhysZip) {
        this.registeredPhysZip = registeredPhysZip;
    }

    public String getRegisteredPhysCountry() {
        return registeredPhysCountry;
    }

    public void setRegisteredPhysCountry(String registeredPhysCountry) {
        this.registeredPhysCountry = registeredPhysCountry;
    }
}