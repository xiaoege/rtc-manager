package com.rtc.manager.vo.america.newhampshire;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaNewhampshirePrincipalPurposeVO {
    private Integer id;
    private String naicsCode;
    private String naicsSubcode;

    public Integer getId() {
        return id;
    }
    @JsonSetter("pid")
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaicsCode() {
        return naicsCode;
    }

    public void setNaicsCode(String naicsCode) {
        this.naicsCode = naicsCode;
    }

    public String getNaicsSubcode() {
        return naicsSubcode;
    }

    public void setNaicsSubcode(String naicsSubcode) {
        this.naicsSubcode = naicsSubcode;
    }
}