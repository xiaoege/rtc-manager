package com.rtc.manager.entity.dto;

/**
 * @author ChenHang
 */
public class LoggerDTO {
    private String userPhone;
    private String paramStr;
    private String body;
    private String invoke;

    public LoggerDTO(String userPhone, String paramStr, String body, String invoke) {
        this.userPhone = userPhone;
        this.paramStr = paramStr;
        this.body = body;
        this.invoke = invoke;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getParamStr() {
        return paramStr;
    }

    public void setParamStr(String paramStr) {
        this.paramStr = paramStr;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getInvoke() {
        return invoke;
    }

    public void setInvoke(String invoke) {
        this.invoke = invoke;
    }

    @Override
    public String toString() {
        return "{" +
                "userPhone='" + userPhone + '\'' +
                ", paramStr='" + paramStr + '\'' +
                ", body='" + body + '\'' +
                ", invoke='" + invoke + '\'' +
                '}';
    }
}
