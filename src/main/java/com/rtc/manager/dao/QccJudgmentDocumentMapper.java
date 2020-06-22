package com.rtc.manager.dao;

import com.rtc.manager.entity.QccJudgmentDocument;

public interface QccJudgmentDocumentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QccJudgmentDocument record);

    int insertSelective(QccJudgmentDocument record);

    QccJudgmentDocument selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QccJudgmentDocument record);

    int updateByPrimaryKey(QccJudgmentDocument record);
}