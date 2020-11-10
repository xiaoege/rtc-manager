package com.rtc.manager.vo.america.alabama;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaAlabamaIncorporatorVO {
    private Integer id;
    private String incorporatorName;
    private String incorporatorStreetAddress;
    private String incorporatorMailingAddress;

    public Integer getId() {
        return id;
    }
    @JsonSetter("pid")
    public void setId(Integer id) {
        this.id = id;
    }

    public String getIncorporatorName() {
        return incorporatorName;
    }

    public void setIncorporatorName(String incorporatorName) {
        this.incorporatorName = incorporatorName;
    }

    public String getIncorporatorStreetAddress() {
        return incorporatorStreetAddress;
    }

    public void setIncorporatorStreetAddress(String incorporatorStreetAddress) {
        this.incorporatorStreetAddress = incorporatorStreetAddress;
    }

    public String getIncorporatorMailingAddress() {
        return incorporatorMailingAddress;
    }

    public void setIncorporatorMailingAddress(String incorporatorMailingAddress) {
        this.incorporatorMailingAddress = incorporatorMailingAddress;
    }
}