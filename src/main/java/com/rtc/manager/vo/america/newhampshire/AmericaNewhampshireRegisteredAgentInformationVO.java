package com.rtc.manager.vo.america.newhampshire;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaNewhampshireRegisteredAgentInformationVO {
    private Integer id;
    private String name;
    private String registeredOfficeAddress;
    private String registeredMailingAddress;

    public Integer getId() {
        return id;
    }
    @JsonSetter("pid")
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegisteredOfficeAddress() {
        return registeredOfficeAddress;
    }

    public void setRegisteredOfficeAddress(String registeredOfficeAddress) {
        this.registeredOfficeAddress = registeredOfficeAddress;
    }

    public String getRegisteredMailingAddress() {
        return registeredMailingAddress;
    }

    public void setRegisteredMailingAddress(String registeredMailingAddress) {
        this.registeredMailingAddress = registeredMailingAddress;
    }
}