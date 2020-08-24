package com.rtc.manager.dao;

import com.rtc.manager.entity.RtcUser;
import com.rtc.manager.entity.dto.RtcUserDTO;
import org.springframework.security.core.userdetails.UserDetails;

public interface RtcUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RtcUser record);

    int insertSelective(RtcUser record);

    RtcUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RtcUser record);

    int updateByPrimaryKey(RtcUser record);


    Integer checkEmaillRegistered(String emaill);

    Integer checkPhoneRegistered(String phone);

    RtcUserDTO selectByPhoneOrAccount(String account);

    String checkNicknameRegistered(String nickname);

    UserDetails loadUserByUsername(String username);
}