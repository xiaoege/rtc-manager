package com.rtc.manager.vo;

import lombok.Data;

import java.util.List;

/**
 * @author ChenHang
 */
@Data
public class QccAbnormalOperationVO {

    private Integer id;

    private String enterpriseId;

    private List<QccRemoveExceptionVO> qccRemoveExceptionVOList;

    private List<QccSaveExceptionVO> qccSaveExceptionVOList;
}