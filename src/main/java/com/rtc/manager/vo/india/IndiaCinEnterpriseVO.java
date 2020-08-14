package com.rtc.manager.vo.india;

import lombok.Data;

import java.util.List;

/**
 * @author ChenHang
 */
@Data
public class IndiaCinEnterpriseVO {

    private IndiaCinVO indiaCin;

    private List<IndiaChargeVO> chargeList;

    private List<IndiaSignatoryVO> signatoryList;

    private Integer code;

}
