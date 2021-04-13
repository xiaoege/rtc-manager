package com.rtc.manager.dao;

import com.rtc.manager.entity.RtcUserOauth;
import com.rtc.manager.vo.RtcUserVO;

public interface RtcUserOauthMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RtcUserOauth record);

    int insertSelective(RtcUserOauth record);

    RtcUserOauth selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RtcUserOauth record);

    int updateByPrimaryKey(RtcUserOauth record);

    /**
     * 根据第三方open_id查询绑定用户的uuid
     * @param openId
     * @return
     */
    String selectUserByOpenId(String openId);

    /**
     * 解绑第三方
     * @param userId
     * @param id
     * @return
     */
    int unbindThirdParty(String userId, Integer id);
}