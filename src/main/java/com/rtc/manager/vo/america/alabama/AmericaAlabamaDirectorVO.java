package com.rtc.manager.vo.america.alabama;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmericaAlabamaDirectorVO {
    private Integer id;

    private String directorName;
    private String directorStreetAddress;
    private String directorMailingAddress;

    public Integer getId() {
        return id;
    }
    @JsonSetter("pid")
    public void setId(Integer id) {
        this.id = id;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getDirectorStreetAddress() {
        return directorStreetAddress;
    }

    public void setDirectorStreetAddress(String directorStreetAddress) {
        this.directorStreetAddress = directorStreetAddress;
    }

    public String getDirectorMailingAddress() {
        return directorMailingAddress;
    }

    public void setDirectorMailingAddress(String directorMailingAddress) {
        this.directorMailingAddress = directorMailingAddress;
    }
}