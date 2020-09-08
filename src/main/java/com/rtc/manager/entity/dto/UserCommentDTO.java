package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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


}
