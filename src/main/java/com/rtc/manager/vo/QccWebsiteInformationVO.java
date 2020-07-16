package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

@Data
public class QccWebsiteInformationVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;

    private String websiteName;

    private String url;

    private String domainName;

    private String licenseCode;

    private String auditDate;

}