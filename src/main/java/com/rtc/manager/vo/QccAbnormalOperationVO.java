package com.rtc.manager.vo;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

/**
 * @author ChenHang
 */
public class QccAbnormalOperationVO {
    @JsonSetter("pid")
    private Integer id;

    private String enterpriseId;

    private List<QccRemoveExceptionVO> qccRemoveExceptionVOList;

    private List<QccSaveExceptionVO> qccSaveExceptionVOList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public List<QccRemoveExceptionVO> getQccRemoveExceptionVOList() {
        return qccRemoveExceptionVOList;
    }

    public void setQccRemoveExceptionVOList(List<QccRemoveExceptionVO> qccRemoveExceptionVOList) {
        this.qccRemoveExceptionVOList = qccRemoveExceptionVOList;
    }

    public List<QccSaveExceptionVO> getQccSaveExceptionVOList() {
        return qccSaveExceptionVOList;
    }

    public void setQccSaveExceptionVOList(List<QccSaveExceptionVO> qccSaveExceptionVOList) {
        this.qccSaveExceptionVOList = qccSaveExceptionVOList;
    }
}
