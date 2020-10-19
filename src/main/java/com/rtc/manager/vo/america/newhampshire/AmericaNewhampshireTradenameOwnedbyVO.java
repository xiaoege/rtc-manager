package com.rtc.manager.vo.america.newhampshire;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaNewhampshireTradenameOwnedbyVO {
    private Integer id;
    private String name;
    private String title;
    private String address;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}