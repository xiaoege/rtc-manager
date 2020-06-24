package com.rtc.manager.vo;

/**
 * @author ChenHang
 */
public class ResultData<T> {
    private String message;
    private T data;
    private int code;

    public ResultData(T t) {
        this.data = t;
    }

    public ResultData(String message, T t) {
        this.message = message;
        this.data = t;
    }

    public ResultData(String message, T t, int code) {
        this.message = message;
        this.data = t;
        this.code = code;
    }

    public static <T> ResultData SUCCESS(T t) {
        ResultData<T> resultData = new ResultData<T>(t);
        resultData.message = "请求成功";
        resultData.code = 200;
        return resultData;
    }

    public static <T> ResultData FAIL(T t, int code) {
        ResultData<T> resultData = new ResultData<T>(t);
        resultData.message = "请求失败";
        resultData.code = code;
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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
