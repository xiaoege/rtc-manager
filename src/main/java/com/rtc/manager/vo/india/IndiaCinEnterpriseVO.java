package com.rtc.manager.vo.india;

import com.rtc.manager.vo.RtcUserCommentVO;

import java.util.List;

/**
 * @author ChenHang
 */
public class IndiaCinEnterpriseVO {

    private IndiaCinVO indiaCin;

    private List<IndiaChargeVO> chargeList;

    private List<IndiaSignatoryVO> signatoryList;

    private Integer code;

    private List<RtcUserCommentVO> commentList;

    public IndiaCinVO getIndiaCin() {
        return indiaCin;
    }

    public void setIndiaCin(IndiaCinVO indiaCin) {
        this.indiaCin = indiaCin;
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
