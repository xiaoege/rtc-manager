package com.rtc.manager.vo;

import lombok.Data;

/**
 * @author ChenHang
 */
@Data
public class EnterpriseListResultData<T> {
    private String message;
    private T data;
    private Integer code;
    private long total;
    private int pageNum;
    private int pageSize;

    public EnterpriseListResultData(T t) {
        this.data = t;
    }

    public EnterpriseListResultData(T t, Integer code, String message) {
        this.message = message;
        this.data = t;
        this.code = code;
    }

    public static <T> EnterpriseListResultData SUCCESS(T t, long total, int pageNum, int pageSize) {
        EnterpriseListResultData<T> resultData = new EnterpriseListResultData<T>(t);
        resultData.message = "请求成功";
        resultData.code = 200;
        resultData.total = total;
        resultData.pageNum = pageNum;
        resultData.pageSize = pageSize;
        return resultData;
    }

    public static <T> EnterpriseListResultData FAIL(T t, Integer code) {
        EnterpriseListResultData<T> resultData = new EnterpriseListResultData<T>(t);
        resultData.message = "请求失败";
        resultData.code = code;
        return resultData;
    }

    public static <T> EnterpriseListResultData FAIL(T t, Integer code, String message) {
        EnterpriseListResultData<T> resultData = new EnterpriseListResultData<T>(t, code, message);
        return resultData;
    }
}
