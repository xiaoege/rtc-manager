package com.rtc.manager.vo;

import lombok.Data;

/**
 * @author ChenHang
 */
@Data
public class QccShareholderVO {
    private Integer id;

    private String enterpriseId;

    private String name;

    private String ratio;

    private String subscribedCapital;

    private String subscribedCapitalDate;
}
