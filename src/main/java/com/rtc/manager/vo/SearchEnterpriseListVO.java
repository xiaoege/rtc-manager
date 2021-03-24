package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author ChenHang
 */
@ApiModel(value = "企业搜索-列表")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchEnterpriseListVO {

    @JsonAlias("e_type")
    @ApiModelProperty(value = "公司所在地区(国家的次一级，例如美国的肯塔基州)")
    private String eType;

    @JsonAlias("e_name")
    @ApiModelProperty(value = "公司名")
    private String eName;

    @ApiModelProperty(value ="公司所在国家")
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
    @ApiModelProperty(value ="公司id-内部定义")
    private String enterpriseId;

    /**
     * 法人代表
     */
    @JsonAlias("legal_representative")
    @ApiModelProperty(value ="法人代表")
    private String legalRepresentative;
    /**
     * 成立日期
     */
    @JsonAlias({"establishment_date", "date_of_incorporation"})
    @ApiModelProperty(value ="成立日期")
    private String establishmentDate;
    /**
     * 公司地址
     */
    @JsonAlias({"registered_address", "registrated_address", "principal_address"})
    @ApiModelProperty(value ="公司地址")
    private String address;

    /**
     * es 文档创建时间
     */
    @JsonAlias("@timestamp")
    @ApiModelProperty(value ="该数据创建时间，内部系统查看，非用户查看")
    private String createTime;

    /**
     * 企业编号
     */
    @JsonAlias("enterprise_code")
    private String enterpriseCode;

    /**
     * es的index
     */
    private String idx;

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

    public String getEsId() {
        return esId;
    }

    public void setEsId(String esId) {
        this.esId = esId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }

    public String getIdx() {
        return idx;
    }

    public void setIdx(String idx) {
        this.idx = idx;
    }
}
