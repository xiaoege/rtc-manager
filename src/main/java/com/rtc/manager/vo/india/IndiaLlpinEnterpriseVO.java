package com.rtc.manager.vo.india;

import com.rtc.manager.vo.RtcUserCommentVO;

import java.util.List;

/**
 * @author ChenHang
 */
public class IndiaLlpinEnterpriseVO {
    IndiaLlpinVO indiaLlpinVO;

    private List<IndiaChargeVO> chargeList;

    private List<IndiaSignatoryVO> signatoryList;

    private Integer code;

    private List<RtcUserCommentVO> commentList;

    public IndiaLlpinVO getIndiaLlpinVO() {
        return indiaLlpinVO;
    }

    public void setIndiaLlpinVO(IndiaLlpinVO indiaLlpinVO) {
        this.indiaLlpinVO = indiaLlpinVO;
    }

    public List<IndiaChargeVO> getChargeList() {
        return chargeList;
    }

    public void setChargeList(List<IndiaChargeVO> chargeList) {
        this.chargeList = chargeList;
    }

    public List<IndiaSignatoryVO> getSignatoryList() {
        return signatoryList;
    }

    public void setSignatoryList(List<IndiaSignatoryVO> signatoryList) {
        this.signatoryList = signatoryList;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<RtcUserCommentVO> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<RtcUserCommentVO> commentList) {
        this.commentList = commentList;
    }
}
