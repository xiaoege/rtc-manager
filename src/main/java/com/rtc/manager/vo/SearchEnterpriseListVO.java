package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ApiModelProperty(value = "公司所在国家")
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
    @ApiModelProperty(value = "公司id-内部定义")
    private String enterpriseId;

    /**
     * 法人代表
     */
    @Deprecated
    @JsonIgnore
    @JsonAlias("legal_representative")
    @ApiModelProperty(value = "法人代表")
    private String legalRepresentative;
    /**
     * 成立日期
     */
    @JsonAlias({"establishment_date", "date_of_incorporation"})
    @ApiModelProperty(value = "成立日期")
    private String establishmentDate;
    /**
     * 公司地址
     */
    @JsonAlias({"registered_address", "registrated_address", "principal_address"})
    @ApiModelProperty(value = "公司地址")
    private String address;

    /**
     * 文档创建时间-mysql
     */
    @JsonAlias("create_time")
    @ApiModelProperty(value = "该数据创建时间，内部系统查看，非用户查看")
    private String createTime;

    /**
     * 文档创建时间-es
     */
    @JsonAlias("timestamp")
    @ApiModelProperty(value = "该数据创建时间，内部系统查看，非用户查看")
    private String docCreateTime;

    /**
     * 文档修改时间-es
     */
    @JsonAlias("last_modified")
    @ApiModelProperty(value = "该数据修改时间，内部系统查看，非用户查看")
    private String docLastModified;

    /**
     * 企业编号
     */
    @JsonAlias("enterprise_code")
    private String enterpriseCode;

    /**
     * es的index
     */
    private String idx;

    private String logo;

    private String logoName;

    private String logoColor;

    public SearchEnterpriseListVO() {
    }

    /**
     * @param nation              国家
     * @param eType               类型(国家次一级)
     * @param pid                 mysql-id
     * @param enterpriseId        内部id
     * @param eName               企业名
     * @param address             地址
     * @param establishmentDate   成立日期
     * @param enterpriseCode      企业编号
     * @param legalRepresentative 法人代表
     * @param createTime          创建时间-pattern:yyyy-MM-dd HH:mm:ss
     */
    public SearchEnterpriseListVO(String nation, String eType, Integer pid, String enterpriseId,
                                  String eName, String address, String establishmentDate,
                                  String enterpriseCode, String legalRepresentative, String createTime) {
        this.eType = eType;
        this.eName = eName;
        this.nation = nation;
        this.pid = pid;
        this.enterpriseId = enterpriseId;
        this.legalRepresentative = legalRepresentative;
        this.establishmentDate = establishmentDate;
        this.address = address;
        this.createTime = createTime;
        this.enterpriseCode = enterpriseCode;
    }

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

    public String getDocCreateTime() {
        return docCreateTime;
    }

    public void setDocCreateTime(String docCreateTime) {
        this.docCreateTime = docCreateTime;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getDocLastModified() {
        return docLastModified;
    }

    public void setDocLastModified(String docLastModified) {
        this.docLastModified = docLastModified;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLogoName() {
        return logoName;
    }

    public void setLogoName(String logoName) {
        this.logoName = logoName;
    }

    public String getLogoColor() {
        return logoColor;
    }

    public void setLogoColor(String logoColor) {
        this.logoColor = logoColor;
    }
}
