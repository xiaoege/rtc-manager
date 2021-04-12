package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

/**
 * @author ChenHang
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCommentDTO {
    private String comment;

    private String enterpriseId;

    private String nation;

    @JsonAlias("e_type")
    private String eType;

    private BigDecimal stars;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String geteType() {
        return eType;
    }

    public void seteType(String eType) {
        this.eType = eType;
    }

    public BigDecimal getStars() {
        return stars;
    }

    public void setStars(BigDecimal stars) {
        this.stars = stars;
    }
}
