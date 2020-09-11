package com.rtc.manager.service;

import java.util.List;

/**
 * @author ChenHang
 */
public interface India {
    List listIndiaEnterprise(String name, int pageNum, int pageSize) throws Exception;

    Object getIndiaEnterprise(String enterpriseId, String eType, String userId);
}
