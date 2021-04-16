package com.rtc.manager.entity.dto;

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
public class SearchEnterpriseListDTO {
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
    @JsonIgnore
    private String esId;

    @JsonAlias("enterprise_id")
    private String enterpriseId;

    /**
     * 法人代表
     */
    @Deprecated
    @JsonIgnore
    @JsonAlias("legal_representative")
    private String legalRepresentative;

    /**
     * 成立日期
     */
    @JsonAlias("establishment_date")
    private String establishmentDate;

    /**
     * 公司地址
     */
    private String address;

    /**
     * 文档创建时间-mysql
     */
    @JsonAlias("create_time")
    private String createTime;

    /**
     * 文档创建时间-es
     */
    @JsonIgnore
    @JsonAlias("timestamp")
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
    @JsonIgnore
    private String idx;

    private String logo;

    public SearchEnterpriseListDTO() {
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
//     * @param legalRepresentative 法人代表
     * @param logo              logo本地地址
     * @param createTime          创建时间-pattern:yyyy-MM-dd HH:mm:ss
     */
    public SearchEnterpriseListDTO(String nation, String eType, Integer pid, String enterpriseId,
                                   String eName, String address, String establishmentDate,
                                   String enterpriseCode,String logo, String createTime) {
        this.eType = eType;
        this.eName = eName;
        this.nation = nation;
        this.pid = pid;
        this.enterpriseId = enterpriseId;
        this.establishmentDate = establishmentDate;
        this.address = address;
        this.createTime = createTime;
        this.enterpriseCode = enterpriseCode;
        this.logo = logo;
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

    public String getEsId() {
        return esId;
    }

    public void setEsId(String esId) {
        this.esId = esId;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }
    @JsonAlias("enterprise_id")
    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEstablishmentDate() {
        return establishmentDate;
    }
    @JsonSetter("establishment_date")
    public void setEstablishmentDate(String establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreateTime() {
        return createTime;
    }
    @JsonSetter("create_time")
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDocCreateTime() {
        return docCreateTime;
    }

    public void setDocCreateTime(String docCreateTime) {
        this.docCreateTime = docCreateTime;
    }

    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    @JsonSetter("enterprise_code")
    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }

    public String getIdx() {
        return idx;
    }

    public void setIdx(String idx) {
        this.idx = idx;
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
    @JsonSetter("last_modified")
    public void setDocLastModified(String docLastModified) {
        this.docLastModified = docLastModified;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
