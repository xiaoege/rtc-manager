package com.rtc.manager.vo.america.alabama;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaAlabamaMemberVO {
    private Integer id;
    private String memberName;
    private String memberStreetAddress;
    private String memberMailingAddress;

    public Integer getId() {
        return id;
    }
    @JsonSetter("pid")
    public void setId(Integer id) {
        this.id = id;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberStreetAddress() {
        return memberStreetAddress;
    }

    public void setMemberStreetAddress(String memberStreetAddress) {
        this.memberStreetAddress = memberStreetAddress;
    }

    public String getMemberMailingAddress() {
        return memberMailingAddress;
    }

    public void setMemberMailingAddress(String memberMailingAddress) {
        this.memberMailingAddress = memberMailingAddress;
    }
}