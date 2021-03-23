package com.rtc.manager.service;

import java.util.HashMap;
import java.util.List;

/**
 * @author ChenHang
 */
public interface UtilsService {
    HashMap getAccessKey(String account);

    /**
     * 根据field类型来获得相应field的list
     * @param field 指定字段
     * @return 指定字段的list
     */
    List<String> getRtcRefCountry(String field);

    /**
     * 根据es的index返回mysql表名
     * @return
     */
    String getTb(String index);
}
