package com.rtc.manager.vo.canada;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class CanadaVO {

    private Integer id;

    private String enterpriseId;

    private String corporationNumber;

    private String businessNumber;

    private String name;

    private String enterpriseStatus;

    private String governingLegislation;

    private CanadaRegisteredOfficeAddressVO registeredOfficeAddressVO;

    private List<CanadaDirectorVO> directorListVO;

    private List<CanadaAnnualFilingVO> annualFilingListVO;

    private List<CanadaCorporateHistoryVO> corporateHistoryListVO;

    private int favourite;

    public Integer getId() {
        return id;
    }
    @JsonSetter("pid")
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorporationNumber() {
        return corporationNumber;
    }

    public void setCorporationNumber(String corporationNumber) {
        this.corporationNumber = corporationNumber;
    }

    public String getBusinessNumber() {
        return businessNumber;
    }

    public void setBusinessNumber(String businessNumber) {
        this.businessNumber = businessNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnterpriseStatus() {
        return enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public String getGoverningLegislation() {
        return governingLegislation;
    }

    public void setGoverningLegislation(String governingLegislation) {
        this.governingLegislation = governingLegislation;
    }

    public CanadaRegisteredOfficeAddressVO getRegisteredOfficeAddressVO() {
        return registeredOfficeAddressVO;
    }

    public void setRegisteredOfficeAddressVO(CanadaRegisteredOfficeAddressVO registeredOfficeAddressVO) {
        this.registeredOfficeAddressVO = registeredOfficeAddressVO;
    }

    public List<CanadaDirectorVO> getDirectorListVO() {
        return directorListVO;
    }

    public void setDirectorListVO(List<CanadaDirectorVO> directorListVO) {
        this.directorListVO = directorListVO;
    }

    public List<CanadaAnnualFilingVO> getAnnualFilingListVO() {
        return annualFilingListVO;
    }

    public void setAnnualFilingListVO(List<CanadaAnnualFilingVO> annualFilingListVO) {
        this.annualFilingListVO = annualFilingListVO;
    }

    public List<CanadaCorporateHistoryVO> getCorporateHistoryListVO() {
        return corporateHistoryListVO;
    }

    public void setCorporateHistoryListVO(List<CanadaCorporateHistoryVO> corporateHistoryListVO) {
        this.corporateHistoryListVO = corporateHistoryListVO;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public int getFavourite() {
        return favourite;
    }

    public void setFavourite(int favourite) {
        this.favourite = favourite;
    }
}