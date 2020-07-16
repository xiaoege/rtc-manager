package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

import java.util.List;

/**
 * @author ChenHang
 */
@Data
public class QccAbnormalOperationVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;

    private List<QccRemoveExceptionVO> qccRemoveExceptionVOList;

    private List<QccSaveExceptionVO> qccSaveExceptionVOList;
}
