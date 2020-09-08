package com.rtc.manager.vo;

/**
 * @author ChenHang
 */
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
