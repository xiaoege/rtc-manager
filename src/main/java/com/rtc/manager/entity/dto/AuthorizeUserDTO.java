package com.rtc.manager.entity.dto;

import java.util.List;

/**
 * @author ChenHang
 */
public class AuthorizeUserDTO {
    private List<Integer> pidList;
    private Integer roleId;

    public List<Integer> getPidList() {
        return pidList;
    }

    public void setPidList(List<Integer> pidList) {
        this.pidList = pidList;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
