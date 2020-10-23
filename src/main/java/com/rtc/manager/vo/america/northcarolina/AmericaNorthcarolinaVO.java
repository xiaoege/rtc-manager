package com.rtc.manager.vo.america.northcarolina;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

/**
 * @author ChenHang
 */
public class AmericaNorthcarolinaVO {
    private Integer id;

    private String enterpriseId;

    private String name;

    private String type;

    private String sosId;

    private String enterpriseStatus;

    private String dateFormed;

    private String citizenship;

    private String incorporationState;

    private String annualReportDueDate;

    private String registeredAgent;

    private int favourite;

    private AmericaNorthcarolinaAddressVO northcarolinaAddress;

    private List<AmericaNorthcarolinaCompanyOfficialVO> northcarolinaCompanyOfficialList;

    private List<AmericaNorthcarolinaOfficerVO> northcarolinaOfficerList;

    private AmericaNorthcarolinaStockVO northcarolinaStock;

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

    public AmericaNorthcarolinaAddressVO getNorthcarolinaAddress() {
        return northcarolinaAddress;
    }

    public void setNorthcarolinaAddress(AmericaNorthcarolinaAddressVO northcarolinaAddress) {
        this.northcarolinaAddress = northcarolinaAddress;
    }

    public List<AmericaNorthcarolinaCompanyOfficialVO> getNorthcarolinaCompanyOfficialList() {
        return northcarolinaCompanyOfficialList;
    }

    public void setNorthcarolinaCompanyOfficialList(List<AmericaNorthcarolinaCompanyOfficialVO> northcarolinaCompanyOfficialList) {
        this.northcarolinaCompanyOfficialList = northcarolinaCompanyOfficialList;
    }

    public List<AmericaNorthcarolinaOfficerVO> getNorthcarolinaOfficerList() {
        return northcarolinaOfficerList;
    }

    public void setNorthcarolinaOfficerList(List<AmericaNorthcarolinaOfficerVO> northcarolinaOfficerList) {
        this.northcarolinaOfficerList = northcarolinaOfficerList;
    }

    public AmericaNorthcarolinaStockVO getNorthcarolinaStock() {
        return northcarolinaStock;
    }

    public void setNorthcarolinaStock(AmericaNorthcarolinaStockVO northcarolinaStock) {
        this.northcarolinaStock = northcarolinaStock;
    }

    public int getFavourite() {
        return favourite;
    }

    public void setFavourite(int favourite) {
        this.favourite = favourite;
    }
}
