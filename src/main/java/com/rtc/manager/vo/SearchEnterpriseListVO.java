package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * @author ChenHang
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchEnterpriseListVO {

    @JsonAlias("e_type")
    private String eType;

    @JsonAlias("e_name")
    private String eName;

    private String nation;
    /**
     * mysql表的id
     */
    private Integer pid;

    /**
     * es-document的id
     */
    private String esId;

    @JsonAlias("enterprise_id")
    private String enterpriseId;

    /**
     * 法人代表
     */
    @JsonAlias("legal_representative")
    private String legalRepresentative;
    /**
     * 成立日期
     */
    @JsonAlias({"establishment_date", "date_of_incorporation"})
    private String establishmentDate;
    /**
     * 公司地址
     */
    @JsonAlias({"registered_address", "registrated_address", "principal_address"})
    private String address;

    /**
     * es 文档创建时间
     */
    @JsonAlias("@timestamp")
    private String createTime;

    public String geteType() {
        return eType;
    }

    @JsonSetter("e_type")
    public void seteType(String eType) {
        this.eType = eType;
    }

    public String geteName() {
        return eName;
    }

    @JsonSetter("e_name")
    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(String establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
