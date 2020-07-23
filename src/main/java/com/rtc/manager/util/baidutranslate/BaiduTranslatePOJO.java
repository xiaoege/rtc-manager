package com.rtc.manager.util.baidutranslate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

/**
 * @author ChenHang
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaiduTranslatePOJO {
    /**
     * 源语言	返回用户指定的语言，或者自动检测出的语种（源语言设为 auto 时）
     */
    private String from;
    /**
     * 目标语言	返回用户指定的目标语言
     */
    private String to;
    /**
     * 翻译结果	返回翻译结果，包括 src 和 dst 字段
     */
    private ArrayList<TransResult> trans_result;
    /**
     * 错误码	仅当出现时错误时显示
     */
    private Integer error_code;
    /**
     * 原文tts链接	mp3格式，暂时无法指定发音
     */
    private String src_tts;

    /**
     * 译文tts链接	mp3格式，暂时无法指定发音
     */
    private String dst_tts;

    /**
     * 中英词典资源	返回中文或英文词典资源，包含音标，简明释义等内容
     */
    private Object dict;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public ArrayList<TransResult> getTrans_result() {
        return trans_result;
    }

    public void setTrans_result(ArrayList<TransResult> trans_result) {
        this.trans_result = trans_result;
    }

    public Integer getError_code() {
        return error_code;
    }

    public void setError_code(Integer error_code) {
        this.error_code = error_code;
    }

    public String getSrc_tts() {
        return src_tts;
    }

    public void setSrc_tts(String src_tts) {
        this.src_tts = src_tts;
    }

    public String getDst_tts() {
        return dst_tts;
    }

    public void setDst_tts(String dst_tts) {
        this.dst_tts = dst_tts;
    }

    public Object getDict() {
        return dict;
    }

    public void setDict(Object dict) {
        this.dict = dict;
    }
}
