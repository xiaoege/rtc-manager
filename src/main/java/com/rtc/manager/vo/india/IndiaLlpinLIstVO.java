package com.rtc.manager.vo.india;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author ChenHang
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class IndiaLlpinLIstVO {
    private String e_type;

    @JsonAlias("enterprise_id")
    private String enterpriseId;
    @JsonAlias("llpin")
    private String llpin;
    @JsonAlias("llp_name")
    private String companyName;
    @JsonAlias("roc_code")
    private String rocCode;
}
