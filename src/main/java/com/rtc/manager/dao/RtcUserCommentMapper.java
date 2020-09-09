package com.rtc.manager.dao;

import com.rtc.manager.entity.RtcUserComment;
import com.rtc.manager.vo.RtcUserCommentVO;

import java.util.List;

public interface RtcUserCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RtcUserComment record);

    int insertSelective(RtcUserComment record);

    RtcUserComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RtcUserComment record);

    int updateByPrimaryKey(RtcUserComment record);

    List<RtcUserCommentVO> selectCommentByEnterpriseId(String enterpriseId);
}