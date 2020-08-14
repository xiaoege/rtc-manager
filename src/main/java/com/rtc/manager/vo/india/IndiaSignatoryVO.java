package com.rtc.manager.vo.india;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

/**
 * @author ChenHang
 */
@Data
public class IndiaSignatoryVO {
    @JsonSetter("pid")
    private Integer id;
    private String enterpriseId;
    private String dinPan;
    private String name;
    private String beginDate;
    private String endDate;
    private String surrenderedDin;
}
