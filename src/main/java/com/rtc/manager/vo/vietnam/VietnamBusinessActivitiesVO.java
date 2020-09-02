package com.rtc.manager.vo.vietnam;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

@Data
public class VietnamBusinessActivitiesVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;

    private String code;

    private String name;

}