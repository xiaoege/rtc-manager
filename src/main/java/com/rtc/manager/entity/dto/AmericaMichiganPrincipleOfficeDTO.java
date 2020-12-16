package com.rtc.manager.entity.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

/**
 * @author ChenHang
 */
public class AmericaMichiganPrincipleOfficeDTO {
    @JsonAlias("PrincipleStreet")
    private String principleStreet;
    @JsonAlias("aptsuiteotherlblpricipal")
    private String aptsuiteotherlblpricipal;
    @JsonAlias("PrincipleCity")
    private String principleCity;
    @JsonAlias("PrincipleState")
    private String principleState;
    @JsonAlias("PrincipleZip")
    private String principleZip;

    public String getPrincipleStreet() {
        return principleStreet;
    }

    public void setPrincipleStreet(String principleStreet) {
        this.principleStreet = principleStreet;
    }

    public String getAptsuiteotherlblpricipal() {
        return aptsuiteotherlblpricipal;
    }

    public void setAptsuiteotherlblpricipal(String aptsuiteotherlblpricipal) {
        this.aptsuiteotherlblpricipal = aptsuiteotherlblpricipal;
    }

    public String getPrincipleCity() {
        return principleCity;
    }

    public void setPrincipleCity(String principleCity) {
        this.principleCity = principleCity;
    }

    public String getPrincipleState() {
        return principleState;
    }

    public void setPrincipleState(String principleState) {
        this.principleState = principleState;
    }

    public String getPrincipleZip() {
        return principleZip;
    }

    public void setPrincipleZip(String principleZip) {
        this.principleZip = principleZip;
    }
}
