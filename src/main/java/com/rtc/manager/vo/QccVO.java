package com.rtc.manager.vo;

import com.rtc.manager.entity.QccShareholder;
import lombok.Data;

import java.util.List;

/**
 * @author ChenHang
 */
@Data
public class QccVO {
    private Integer id;

    private String enterpriseId;

    private String name;

    private String registeredCapital;

    private String legalRepresentative;

    private String establishmentDate;

    private String address;

    private String telephone;

    private String url;

    private List<QccShareholder> shareholderList;

}
