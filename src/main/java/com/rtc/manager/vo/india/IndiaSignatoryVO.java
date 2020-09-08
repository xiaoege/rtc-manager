package com.rtc.manager.vo.india;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

/**
 * @author ChenHang
 */
public class IndiaSignatoryVO {
    @JsonSetter("pid")
    private Integer id;
    private String enterpriseId;
    private String dinPan;
    private String name;
    private String beginDate;
    private String endDate;
    private String surrenderedDin;

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

    public String getDinPan() {
        return dinPan;
    }

    public void setDinPan(String dinPan) {
        this.dinPan = dinPan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSurrenderedDin() {
        return surrenderedDin;
    }

    public void setSurrenderedDin(String surrenderedDin) {
        this.surrenderedDin = surrenderedDin;
    }
}
