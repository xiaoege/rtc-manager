package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rtc.manager.entity.america.northcarolina.AmericaNorthcarolinaAddress;
import com.rtc.manager.entity.america.northcarolina.AmericaNorthcarolinaCompanyOfficial;
import com.rtc.manager.entity.america.northcarolina.AmericaNorthcarolinaOfficer;
import com.rtc.manager.entity.america.northcarolina.AmericaNorthcarolinaStock;

import java.util.List;

/**
 * @author ChenHang
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaNorthcarolinaDTO {
    private Integer id;

    private String enterpriseId;

    private String name;

    private String type;
    @JsonAlias("SosId")
    private String sosId;
    @JsonAlias("Status")
    private String enterpriseStatus;
    @JsonAlias("Date Formed")
    private String dateFormed;
    @JsonAlias("Citizenship")
    private String citizenship;
    @JsonAlias("State of Incorporation")
    private String incorporationState;
    @JsonAlias("Annual Report Due Date")
    private String annualReportDueDate;
    @JsonAlias("Registered Agent")
    private String registeredAgent;

    @JsonAlias("addresses")
    private AmericaNorthcarolinaAddress northcarolinaAddress;
    @JsonAlias("companyOfficials")
    private List<AmericaNorthcarolinaCompanyOfficial> northcarolinaCompanyOfficialList;
    @JsonAlias("officers")
    private List<AmericaNorthcarolinaOfficer> northcarolinaOfficerList;
    @JsonAlias("stock")
    private AmericaNorthcarolinaStock northcarolinaStock;

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

    public String getSosId() {
        return sosId;
    }

    public void setSosId(String sosId) {
        this.sosId = sosId;
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public String getDateFormed() {
        return dateFormed;
    }

    public void setDateFormed(String dateFormed) {
        this.dateFormed = dateFormed;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getIncorporationState() {
        return incorporationState;
    }

    public void setIncorporationState(String incorporationState) {
        this.incorporationState = incorporationState;
    }

    public String getAnnualReportDueDate() {
        return annualReportDueDate;
    }

    public void setAnnualReportDueDate(String annualReportDueDate) {
        this.annualReportDueDate = annualReportDueDate;
    }

    public String getRegisteredAgent() {
        return registeredAgent;
    }

    public void setRegisteredAgent(String registeredAgent) {
        this.registeredAgent = registeredAgent;
    }

    public AmericaNorthcarolinaAddress getNorthcarolinaAddress() {
        return northcarolinaAddress;
    }

    public void setNorthcarolinaAddress(AmericaNorthcarolinaAddress northcarolinaAddress) {
        this.northcarolinaAddress = northcarolinaAddress;
    }

    public List<AmericaNorthcarolinaCompanyOfficial> getNorthcarolinaCompanyOfficialList() {
        return northcarolinaCompanyOfficialList;
    }

    public void setNorthcarolinaCompanyOfficialList(List<AmericaNorthcarolinaCompanyOfficial> northcarolinaCompanyOfficialList) {
        this.northcarolinaCompanyOfficialList = northcarolinaCompanyOfficialList;
    }

    public List<AmericaNorthcarolinaOfficer> getNorthcarolinaOfficerList() {
        return northcarolinaOfficerList;
    }

    public void setNorthcarolinaOfficerList(List<AmericaNorthcarolinaOfficer> northcarolinaOfficerList) {
        this.northcarolinaOfficerList = northcarolinaOfficerList;
    }

    public AmericaNorthcarolinaStock getNorthcarolinaStock() {
        return northcarolinaStock;
    }

    public void setNorthcarolinaStock(AmericaNorthcarolinaStock northcarolinaStock) {
        this.northcarolinaStock = northcarolinaStock;
    }
}
